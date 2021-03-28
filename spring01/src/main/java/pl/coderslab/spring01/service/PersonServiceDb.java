package pl.coderslab.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.spring01.entity.Person;
import pl.coderslab.spring01.repository.PersonRepository;

import java.util.Set;


@Service
public class PersonServiceDb implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceDb(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void save(Person person){
        this.personRepository.save(person);
    }

    @Override
    public Set<Person> findAllByName(String name) {
        return this.personRepository.findAllByName(name);
    }

}
