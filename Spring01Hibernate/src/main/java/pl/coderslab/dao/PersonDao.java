package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Person person) {
        if (person.getId() == null) {
            this.entityManager.persist(person);
        } else {
            this.entityManager.merge(person);
        }
    }

    public Person findById(Long id) {
        return this.entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        this.entityManager.merge(person);
    }

    public void delete(Person person) {
        this.entityManager.remove(this.entityManager.contains(person) ?
                person : this.entityManager.merge(person));
    }

}
