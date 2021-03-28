package pl.coderslab.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublisherServiceDb implements PublisherService {
    private PublisherDao publisherDao;

    @Autowired
    public PublisherServiceDb(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public void save(Publisher entity) {
        publisherDao.save(entity);
    }

    @Override
    public Publisher findOneById(Long id) {
        return publisherDao.findOneById(id);
    }

    @Override
    @Transactional
    public Publisher findOneByIdWithBooks(Long id) {
        Publisher publisher = publisherDao.findOneById(id);
        Hibernate.initialize(publisher.getBooks());
        return publisher;
    }

    public List<Publisher> findAll(){
        return this.publisherDao.findAll();
    }

    public void update(Publisher entity) { this.publisherDao.update(entity);}

    @Override
    public void delete(Publisher entity) {
        publisherDao.delete(entity);
    }
}
