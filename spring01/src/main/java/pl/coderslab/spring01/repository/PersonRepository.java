package pl.coderslab.spring01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01.entity.Person;

import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {
    public Set<Person> findAllByName(String name);

}
