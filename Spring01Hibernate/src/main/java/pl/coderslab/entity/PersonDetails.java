package pl.coderslab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="people_details")
@Getter
@Setter
@NoArgsConstructor
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    int streetNumber;
    String street;
    String city;

    @OneToOne(mappedBy = "personDetails")
    Person person;

}
