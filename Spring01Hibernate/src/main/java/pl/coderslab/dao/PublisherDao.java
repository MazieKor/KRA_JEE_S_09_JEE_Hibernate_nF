package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager em;


    public void save(Publisher entity) {
        if (entity.getId() == null) {
            this.em.persist(entity);
        } else {
            this.em.merge(entity);
        }
    }

    public Publisher findOneById(Long id) {
        return this.em.find(Publisher.class, id);
    }

    public void delete(Publisher entity) {
        this.em.remove(this.em.contains(entity) ?
                entity : this.em.merge(entity));
    }

    public void update(Publisher entity){
        this.em.merge(entity);
    }

    public List<Publisher> findAll(){
        Query query = this.em.createQuery("Select publ from Publisher publ");
        List<Publisher> listOfPublishers = query.getResultList();
        return listOfPublishers;
    }

}
