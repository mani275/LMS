package com.Library.demo.Controller;

import com.Library.demo.Model.BookModel;
import com.Library.demo.Repository.BookRepo;
//import com.Library.demo.Repository.UserRepo;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/check")
    public HttpStatus check() {
        return HttpStatus.OK;
    }
    @GetMapping("/bookDetail")
    public ResponseEntity<List<BookModel>> getAllBook(@RequestParam(required = false) String title){
        try {
            List<BookModel> books = new ArrayList<>();
            if (title == null)
                books.addAll(bookRepo.findAll());
            else
                books.addAll(bookRepo.findByBookTitle(title));
            if (books.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bookDetail/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable("bookID") long id){
        Optional<BookModel> bookDetails = bookRepo.findById((id));
        return bookDetails.map(bookModel -> new ResponseEntity<>(bookModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/addBooks")
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel){
        try{
            BookModel bookmodel = bookRepo
                    .save(new BookModel(bookModel.getBookTitle(), bookModel.getPublisher(), bookModel.isStatus()));
            return new ResponseEntity<>(bookmodel, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/bookDetail")
    public ResponseEntity<HttpStatus> deleteAllBooks(){
        try{
            bookRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
