package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Author author){
        if(author.getId() == null) {
            this.em.persist(author);
        } else
            this.em.merge(author);
    }

    public Author findById(Long id){
        return this.em.find(Author.class, id);
    }

    public List<Author> findAll(){
        Query query = this.em.createQuery("Select author from Author author");
        return (List<Author>) query.getResultList();

    }

    public void update(Author author) {
        this.em.merge(author);
    }

    public void delete(Author author) { this.em.remove( this.em.contains(author) ?
                                        author : this.em.merge(author));}


}
