package com.Library.demo.Repository;

//import com.Library.demo.Controller.BookController;
import com.Library.demo.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@Component
public interface BookRepo extends JpaRepository<BookModel, Long> {
    List<BookModel> findBybookTitle(String title);

}
