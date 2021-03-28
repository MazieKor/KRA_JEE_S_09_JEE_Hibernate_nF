package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;


@Service
public class PersonServiceDb implements PersonService {
    PersonDao personDao;

    @Autowired
    public PersonServiceDb (PersonDao personDao){
        this.personDao = personDao;
    }

    @Override
    public void save(Person person) {
        this.personDao.save(person);
    }

    @Override
    public Person findOneById(Long id) {
        return this.personDao.findById(id);
    }

    @Override
    public void update(Person person) {
        this.personDao.update(person);
    }

    @Override
    public void delete(Person person) {
        this.personDao.delete(person);
    }
}
