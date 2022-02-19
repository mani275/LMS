package com.Library.demo.Repository;

import com.Library.demo.Controller.BookController;
import com.Library.demo.Model.BookModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookModel, Long> {
    List<BookModel> findByBookTitle(String title);

}
