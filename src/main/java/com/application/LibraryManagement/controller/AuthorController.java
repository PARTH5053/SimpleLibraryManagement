package com.application.LibraryManagement.controller;


import com.application.LibraryManagement.entity.Author;
import com.application.LibraryManagement.service.AuthorService;
import com.application.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("activePage", "authors");
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/author/{id}")
    public String getAuthor(@PathVariable long id,Model model){
        model.addAttribute("activePage", "authors");
        model.addAttribute("author",authorService.findAuthorById(id));
        return "list-author";
    }

    @GetMapping("/remove-author/{id}")
    public String removeAuthor(@PathVariable long id,Model model) {
        authorService.deleteAuthor(id);
        model.addAttribute("activePage", "authors");
        model.addAttribute("authors", authorService.findAllAuthors());
        return "redirect:authors"; //returns authors.html
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable long id,Model model){
        model.addAttribute("author",authorService.findAuthorById(id));
        model.addAttribute("books",bookService.findAllBooks());
        model.addAttribute("activePage", "authors");

        return "update-author";
    }

    @PostMapping("/save-update-author/{id}")
    public String updateAuthor(@PathVariable long id, Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-author";
        }
        authorService.updateAuthor(id, author);
        model.addAttribute("activePage", "authors");
        model.addAttribute("authors",authorService.findAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/add-author")
    public String addAuthor(Author author, Model model){
        return "add-author";
    }
    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("activePage", "authors");
        model.addAttribute("authors",authorService.findAllAuthors());
        return "redirect:/authors";
    }

//    @GetMapping("/authors")
//    public List<Author> getAllAuthors() {
//        return authorService.findAllAuthors();
//    }
//    @GetMapping("/author/{id}")
//    public Author getAuthor(@PathVariable long id) {
//        return authorService.findAuthorById(id);
//    }
//
//    @PostMapping("/author")
//    public void createAuthor(@RequestBody Author author) {
//        authorService.createAuthor(author);
//    }
//
//    @PutMapping("/author/{id}")
//    public void updateAuthor(@PathVariable long id, @RequestBody Author author) {
//        authorService.updateAuthor(id, author);
//    }
//
//    @DeleteMapping("/author/{id}")
//    public void deleteAuthor(@PathVariable long id) {
//        authorService.deleteAuthor(id);
//    }

}
