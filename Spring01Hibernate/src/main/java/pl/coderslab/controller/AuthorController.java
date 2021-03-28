package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.service.AuthorServiceDb;
import pl.coderslab.service.BookService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    AuthorServiceDb authorServiceDb;

    @Autowired
    public AuthorController(AuthorServiceDb authorServiceDb){
        this.authorServiceDb = authorServiceDb;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveBook(){

        Author author = new Author();
        author.setFirstName("Tomasz");
        author.setLastName("Kowalski");

        this.authorServiceDb.save(author);

        return "Author added" + author.getFirstName() ;
    }


}
