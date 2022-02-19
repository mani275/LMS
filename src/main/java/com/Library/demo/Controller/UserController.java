package com.Library.demo.Controller;

import com.Library.demo.Model.UserModel;
import com.Library.demo.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Library.demo.Repository.UserRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookRepo bookRepo;
    @GetMapping("/check")
    public HttpStatus status() {
        return HttpStatus.OK;
    }
    @GetMapping("/userDetail")
    public ResponseEntity<List<UserModel>> getAllUsers(@RequestParam(required = false) String title){
        try {
            //            if(title == null)
            List<UserModel> users = new ArrayList<>(userRepo.findAll());
            if(users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("userDetail/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable long id){
        Optional<UserModel> userData = userRepo.findById(id);
        return userData.map(userModel -> new ResponseEntity<>(userModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/newUser")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel){
        try{
            UserModel usermodel = userRepo
                    .save(new UserModel(userModel.getUserName(), userModel.getBookIssue1(), userModel.getBookIssue2()));
            return new ResponseEntity<>(usermodel, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/userDetail")
    public ResponseEntity<HttpStatus> deleteAllUsers(){
        try{
            userRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
