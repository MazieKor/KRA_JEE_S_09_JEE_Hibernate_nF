package pl.coderslab.service;

import pl.coderslab.entity.Publisher;

import java.util.List;

public interface PublisherService {

    public void save(Publisher entity);
    public Publisher findOneById(Long id);
    public void update(Publisher entity);
    public void delete(Publisher publisher);
    public Publisher findOneByIdWithBooks(Long id);
    public List<Publisher> findAll();
}
