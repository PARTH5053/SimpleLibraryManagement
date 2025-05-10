package com.application.LibraryManagement.service;

import com.application.LibraryManagement.entity.Book;
import com.application.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public  Book findBookById(long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("no book found!"));
        return book;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("no book found!"));
        bookRepository.deleteById(book.getId());
    }

    public void updateBook(long id,Book newBook){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("no book found!"));
        book.setName(newBook.getName());
        book.setIsbn(newBook.getIsbn());
        book.setDescription(newBook.getDescription());
        book.setAuthors(newBook.getAuthors());
        book.setPublishers(newBook.getPublishers());
        book.setCategories(newBook.getCategories());
        bookRepository.save(book);
    }
}
