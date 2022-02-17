package com.Library.demo.Controller;

import com.Library.demo.Model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Library.demo.Repository.UserRepo;

import javax.xml.transform.OutputKeys;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserModel>> getAllUsers(@RequestParam(required = false) String title){
        try {
            List<UserModel> users = new ArrayList<>();
            if(title == null)
                userRepo.findAll().forEach(users::add);
            if(users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
