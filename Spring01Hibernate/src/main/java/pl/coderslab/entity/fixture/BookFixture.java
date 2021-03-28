package pl.coderslab.entity.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorServiceDb;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookFixture {
    private PublisherService publisherService;
    private BookService bookService;
    private AuthorServiceDb authorServiceDb;
    private Faker faker;

    @Autowired
    public BookFixture(PublisherService publisherService,
                       BookService bookService, AuthorServiceDb authorServiceDb){
        this.publisherService = publisherService;
        this.bookService = bookService;
        this.authorServiceDb = authorServiceDb;
        this.faker = new Faker();
    }

    public void createDataInDB(){
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {

            Book book = new Book();
            book.setTitle(faker.book().publisher());
            book.setRating(rand.nextInt(10)+1);
            book.setDescription(faker.lorem().fixedString(300));
            book.setPages(rand.nextInt(1000)+2);

            long publisherId = (long) (rand.nextInt(2)+1);
            Publisher publisher = publisherService.findOneById(publisherId);
            book.setPublisher(publisher);

            List<Author> authorList = new ArrayList<>();
            for (int j = 0; j < rand.nextInt(5)+1; j++) {
                long authorId = (long) (rand.nextInt(2)+1);
                authorList.add( authorServiceDb.findOneById(authorId) );
            }
            book.setAuthors(authorList);

            bookService.save(book);
        }

    }
}