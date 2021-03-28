package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.List;


@Service
public class AuthorServiceDb{
    private AuthorDao authorDao;

    @Autowired
    public AuthorServiceDb(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    public void save (Author author) {
        this.authorDao.save(author);
    }

    public Author findOneById(Long id){
        return this.authorDao.findById(id);
    }

    public List<Author> findAll(){
        return this.authorDao.findAll();
    }

    public void update(Author author) {
        this.authorDao.update(author); }

    public void delete(Author author) {
        this.authorDao.delete(author); }

}