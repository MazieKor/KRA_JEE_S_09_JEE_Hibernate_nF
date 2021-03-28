package pl.coderslab.service;

import pl.coderslab.entity.Book;

import java.util.List;

public interface BookService {

    public void save (Book book);
    public Book findOneById(Long id);
    public void update(Book book);
    public void delete(Book book);
    public List<Book> findAll();
    public Book findByIdWithAllData(Long id);
    public List<Book> findAllWithPublisher();
    public List<Book> findAllByRating(int rate);

}
