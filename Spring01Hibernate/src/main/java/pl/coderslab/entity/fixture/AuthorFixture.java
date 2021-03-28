package pl.coderslab.entity.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorServiceDb;

@Component
public class AuthorFixture {

    private AuthorServiceDb authorServiceDb;
    private Faker faker;

    @Autowired
    public AuthorFixture(AuthorServiceDb authorServiceDb) {
        this.authorServiceDb = authorServiceDb;
        this.faker = new Faker();
    }

    public void createDataInDB(){

        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());
            authorServiceDb.save(author);
        }
    }
}