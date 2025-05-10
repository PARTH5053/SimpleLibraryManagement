package com.application.LibraryManagement.service;

import com.application.LibraryManagement.entity.Publisher;
import com.application.LibraryManagement.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private  PublisherRepository publisherRepository;

    public List<Publisher> findAllPublisher() {
        return  publisherRepository.findAll();
    }

    public Publisher findPublisherById(long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("no Publisher found!"));
        return publisher;
    }

    public void createPublisher(Publisher publisher1){
        publisherRepository.save(publisher1);
    }

    public void deletePublisher(long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("no Publisher found!"));
        publisherRepository.deleteById(publisher.getId());
    }

    public void updatePublisher(long id,Publisher newPublisher){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("no Publisher found!"));
        publisher.setName(newPublisher.getName());
//        publisher.setBooks(newPublisher.getBooks());
        publisherRepository.save(publisher);
    }
}
