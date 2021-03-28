package pl.coderslab.service;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

public interface PersonService {
    public void save (Person person);
    public Person findOneById(Long id);
    public void update(Person person);
    public void delete(Person person);



}
