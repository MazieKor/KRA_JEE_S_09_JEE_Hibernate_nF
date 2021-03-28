package pl.coderslab.spring01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01.entity.Person;
import pl.coderslab.spring01.service.PersonService;

@Controller
public class MainController {
    private PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public String main(){
        return "mainPage";

    }

    @GetMapping("/createperson/{name}/{surname}")
    @ResponseBody
    public String test(@PathVariable String name, @PathVariable String surname){
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        personService.save(person);
        return "saved";
    }



}
