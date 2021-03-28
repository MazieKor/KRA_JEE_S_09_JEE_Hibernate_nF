package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    AuthorDao authorDao;

//

    @Override
    public Author convert (String value) {
        System.out.println("Publisher converter for " + value);
        try {
            long id = Long.parseLong(value);
            return authorDao.findById(id);
        } catch(Exception e){
            return null;
        }
    }
}
