package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Set;

@Service
@Primary
public class BookServiceDb implements BookService {
    private BookDao bookDao;
    private BookRepository bookRepository;

    @Autowired
    public BookServiceDb(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save (Book book) {
        this.bookDao.save(book);
    }

    public Book findOneById(Long id){
        return this.bookDao.findById(id);
    }

    public Book findByIdWithAllData(Long id){
        return this.bookDao.findByIdWithAllData(id);
    }

    public void update(Book book) {this.bookDao.update(book); }

    public void delete(Book book){
        this.bookDao.delete(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookDao.findAll();
    }

    @Override
    public List<Book> findAllWithPublisher() {
        return this.bookDao.findAllWithPublisher();
    }

    public List<Book> findAllByRating(int rate) {return  bookDao.findAllByRating(rate); };

    public Set<Book> testRepo(String publisherName){
        return this.bookRepository.findAllByPublisherName(publisherName);
    }

}
