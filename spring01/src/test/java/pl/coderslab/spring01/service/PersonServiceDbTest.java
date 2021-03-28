package pl.coderslab.spring01.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.spring01.entity.Person;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
class PersonServiceDbTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonService personService;

    public PersonServiceDbTest() {
    }

    @Test
    public void shouldFindPersonByName() {
        //given
        List<Person> personList = List.of(
                new Person("Darek", "Luber"),
                new Person("Arek", "Kowalski"),
                new Person("Marek", "Nowak"),
                new Person("Darek", "Nowacki")
        );

        personList.forEach(p -> entityManager.persist(p));
//                when
        Set<Person> persons = personService.findAllByName("Arek");
//        then
        assertEquals(1, persons.size());
        assertTrue(persons.contains(personList.get(1)));
        assertTrue(persons.contains(personList.get(3)));

    }

}