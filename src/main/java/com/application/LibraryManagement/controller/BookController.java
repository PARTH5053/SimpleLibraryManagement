package com.application.LibraryManagement.controller;

import com.application.LibraryManagement.entity.Book;
import com.application.LibraryManagement.service.AuthorService;
import com.application.LibraryManagement.service.BookService;
import com.application.LibraryManagement.service.CategoryService;
import com.application.LibraryManagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("activePage", "books");
        return "books"; //returns books.html
    }

    @GetMapping("")
    public String home(){
        return "home";
    }


    @GetMapping("/book/{id}")
    public String findBook(@PathVariable long id,Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("activePage", "books");
        model.addAttribute("book",book);
        return "list-book";
    }

    @GetMapping("/remove-book/{id}")
    public String removeBook(@PathVariable long id,Model model) {
        bookService.deleteBook(id);
        model.addAttribute("activePage", "books");
        model.addAttribute("books", bookService.findAllBooks());
        return "books"; //returns books.html
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable long id,Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("activePage", "books");
        model.addAttribute("book",book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable long id,Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-book";
        }
        bookService.updateBook(id, book);
        model.addAttribute("activePage", "books");
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book, Model model){
        model.addAttribute("activePage", "books");
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("activePage", "books");
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }


//    @GetMapping("/books")
//    public List<Book> getAllBooks() {
//        return bookService.findAllBooks();
//    }
//
//    @GetMapping("/books/{id}")
//    public Book getBook(@PathVariable long id) {
//        return bookService.findBookById(id);
//    }
//
//    @PostMapping("/books")
//    public void createBook(@RequestBody Book book) {
//        bookService.createBook(book);
//    }
//
//    @PutMapping("/books/{id}")
//    public void updateBook(@PathVariable long id, @RequestBody Book newBook) {
//        bookService.updateBook(id, newBook);
//    }
//
//    @DeleteMapping("/books/{id}")
//    public void deleteBook(@PathVariable long id) {
//        bookService.deleteBook(id);
//    }

}
