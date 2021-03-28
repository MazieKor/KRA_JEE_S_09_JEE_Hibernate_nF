package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.fixture.AuthorFixture;
import pl.coderslab.entity.fixture.BookFixture;
import pl.coderslab.entity.fixture.PublisherFixture;

@Controller
@RequestMapping("/fixtures")
public class FixturesController {
    private PublisherFixture publisherFixture;
    private BookFixture bookFixture;
    private AuthorFixture authorFixture;

    @Autowired
    public FixturesController(
            PublisherFixture publisherFixture,
            BookFixture bookFixture,
            AuthorFixture authorFixture

    ) {
        this.publisherFixture = publisherFixture;
        this.bookFixture = bookFixture;
        this.authorFixture = authorFixture;
    }

    @GetMapping
    @ResponseBody
    public String loadAllDataToDB() {
        publisherFixture.createDataInDB();
        authorFixture.createDataInDB();
        bookFixture.createDataInDB();
        return "Data loaded";
    }


}
