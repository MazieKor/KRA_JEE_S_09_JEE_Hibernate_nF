package pl.coderslab.controller;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PersonService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

//    @GetMapping("/add/{personName}")
//    @ResponseBody
//    public String add(@PathVariable String personName){
//        Person person = new Person();
//        person.setLogin(personName);
//        publisherService.save(publisher);
//        return "saved at id: "+publisher.getId();
//    }
//
//    @GetMapping("/details/{id}")
//    @ResponseBody
//    @Transactional
//    public String getPublisher(@PathVariable Long id){
//        Publisher publisher = publisherService.findOneById(id);
//
//        Hibernate.initialize(publisher.getBooks());
//        List<Book> books = publisher.getBooks();
//        return books.toString();
//    }
//
//    @GetMapping("/all")
//    public String getAll(Model model){
//        List<Publisher> publisherList = this.publisherService.findAll();
//        model.addAttribute("publishers", publisherList);
//        return "/publisher/list";
//    }
//
//
//
//

}
