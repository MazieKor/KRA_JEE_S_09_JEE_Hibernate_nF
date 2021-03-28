package pl.coderslab.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorServiceDb;
import pl.coderslab.service.BookService;
import pl.coderslab.service.BookServiceDb;
import pl.coderslab.service.PublisherService;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorServiceDb authorServiceDb;
    private Validator validator;

    private Faker faker;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService,
                          AuthorServiceDb authorServiceDb, Validator validator){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorServiceDb = authorServiceDb;
        this.validator = validator;

        this.faker = new Faker();       // genralinie powinniśmy unikać wstrzykiwać nowe elementy w konstruktorze
    }

    @GetMapping("/new")
    public String bookForm (Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/form";
    }

    @GetMapping("edit/{id}")
    public String bookForm(@PathVariable long id, Model model){
        Book book = this.bookService.findByIdWithAllData(id);
        model.addAttribute("book", book);
        return "book/list";
    }
    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable long id, Model model,
                             @RequestParam(required=false, defaultValue="false") boolean accept){
        Book book = this.bookService.findOneById(id);
        if(!accept) {
            model.addAttribute("book", book);
            return "book/deletePrompt";
        }
        bookService.delete(book);
        return "redirect:/book/list";
    }

//    @PostMapping("/save")
//    public String saveBook(@ModelAttribute Book book, Model model){
//        Set<ConstraintViolation<Book>> errors = validator.validate(book);
//        if(!errors.isEmpty()){
//            model.addAttribute("errors", errors);
//            return "book/form";
//        }
//
//        bookService.save(book);
//        return "redirect:/book";
//    }


    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult validation){
        if(validation.hasErrors()){
            return "book/form";
        }

        bookService.save(book);
        return "redirect:/book";
    }


    @ModelAttribute("publishers")
    public List<Publisher> publisherList(){
        return this.publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authorList(){
        return this.authorServiceDb.findAll();
    }

    @GetMapping()
    public String allBooks(Model model){
        List<Book> booklist = this.bookService.findAll();
        model.addAttribute("books", booklist);
        return "book/list";
    }

    @GetMapping("/test/{publisherName}")
    public String testRepo(Model model, @PathVariable String publisherName){
        BookServiceDb svc = (BookServiceDb) this.bookService;
        Set<Book> bookList = svc.testRepo(publisherName);
        model.addAttribute("books", bookList);
        return "book/list";
    }

    @GetMapping("/rating/{rate}")
    public String getByRating(@PathVariable int rate, Model model){
        List<Book> booklist = this.bookService.findAllByRating(rate);
        model.addAttribute("books", booklist);
        return "book/list";
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveBook(){

        Publisher publisher = publisherService.findOneById(1L);

        Book book = new Book();
        book.setTitle(this.faker.superhero().name());
        Random random = new Random();
        book.setRating(random.nextInt());
        book.setDescription("some description");
        book.setPublisher(publisher);
        book.setPages(random.nextInt(1000)+2);

        this.bookService.save(book);

        return "Book added"+book.getId();
    }

    //    @PostMapping
//    public String saveBook(@RequestBody Book book){
//
//    }
}