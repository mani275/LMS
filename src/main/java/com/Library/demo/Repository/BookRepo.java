package com.Library.demo.Repository;

//import com.Library.demo.Controller.BookController;
import com.Library.demo.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface BookRepo extends JpaRepository<BookModel, Long> {
    List<BookModel> findByTitleContaining(String title);
}
