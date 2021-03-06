package pl.coderslab.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;

    @ManyToMany(mappedBy = "authors")
    List<Book> books = new ArrayList<>();

    @Transient
    String fullName;  //jakby czasowo wykorzystujemy, żeby zapisać cos na chwilę, ale nie w bazie danych

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}