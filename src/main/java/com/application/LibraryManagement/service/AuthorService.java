package com.application.LibraryManagement.service;

import com.application.LibraryManagement.entity.Author;
import com.application.LibraryManagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return  authorRepository.findAll();
    }

    public Author findAuthorById(long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("no Author found!"));
        return author;
    }

    public void createAuthor(Author author1){
        authorRepository.save(author1);
    }

    public void deleteAuthor(long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("no Author found!"));
        authorRepository.deleteById(author.getId());
    }

    public void updateAuthor(long id,Author newAuthor){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("no Author found!"));
        author.setName(newAuthor.getName());
        author.setDescription(newAuthor.getDescription());
//        author.setBooks(newAuthor.getBooks());
        authorRepository.save(author);

    }
}
