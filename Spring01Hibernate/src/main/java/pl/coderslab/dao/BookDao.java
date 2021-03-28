package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

//    public BookDao(EntityManager em) {
//        this.em = em;
//    }

    public void save(Book book){
        if(book.getId() == null) {
            this.em.persist(book);
        } else
            this.em.merge(book);
    }

    public void update(Book book) {this.em.merge(book); }

    public Book findById(Long id){
        return this.em.find(Book.class, id);
    }
    public Book findByIdWithAllData(Long id) {
        Query query = em.createQuery("select b From Book b Join fetch b.authors a where b.id = :id");
        query.setParameter("id", id);
        return (Book)query.getSingleResult();
    }

    public void delete(Book book){
        this.em.remove( this.em.contains(book) ? book : this.em.merge(book) );
    }

    public List<Book> findAll() {
//      Query query = this.em.createQuery("select b from Book b Order by b.title asc");   - wersja pierwotna
        Query query = this.em.createQuery("Select DISTINCT b from Book b left Join fetch b.publisher left Join fetch b.authors Order by b.title asc");
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> findAllWithPublisher() {
        Query query = this.em.createQuery("select b from Book b Join fetch b.publisher Order by b.title asc");
        return (List<Book>) query.getResultList();
    }

    public List<Book> findAllByRating(int rating){
        Query query = this.em.createQuery("Select b from Book b Where b.rating = :rating");
                query.setParameter("rating", rating);
                return  (List<Book>) query.getResultList();
    }


}
