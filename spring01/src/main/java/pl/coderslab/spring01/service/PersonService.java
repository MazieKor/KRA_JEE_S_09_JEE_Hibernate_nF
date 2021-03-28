package pl.coderslab.spring01.service;

import pl.coderslab.spring01.entity.Person;

import java.util.Set;

public interface PersonService {
    public void save (Person person);
    Set<Person> findAllByName(String name);
}
