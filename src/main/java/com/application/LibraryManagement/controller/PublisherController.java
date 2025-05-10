package com.application.LibraryManagement.controller;

import com.application.LibraryManagement.entity.Publisher;
import com.application.LibraryManagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String getAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("activePage", "publishers");

        return "publishers";
    }

    @GetMapping("/publisher/{id}")
    public String getPublisher(@PathVariable long id,Model model){
        model.addAttribute("publisher",publisherService.findPublisherById(id));
        model.addAttribute("activePage", "publishers");

        return "list-publisher";
    }

    @GetMapping("/remove-publisher/{id}")
    public String removePublisher(@PathVariable long id,Model model) {
        publisherService.deletePublisher(id);
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("activePage", "publishers");

        return "redirect:/publishers"; //returns publishers.html
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable long id,Model model){
        model.addAttribute("publisher",publisherService.findPublisherById(id));
        model.addAttribute("activePage", "publishers");

        return "update-publisher";
    }

    @PostMapping("/save-update-publisher/{id}")
    public String updatePublisher(@PathVariable long id, Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-publisher";
        }
        publisherService.updatePublisher(id, publisher);
        model.addAttribute("publishers",publisherService.findAllPublisher());
        model.addAttribute("activePage", "publishers");

        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher")
    public String addPublisher(Publisher publisher, Model model){
        return "add-publisher";
    }
    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers",publisherService.findAllPublisher());
        model.addAttribute("activePage", "publishers");

        return "redirect:/publishers";
    }









//
//    @GetMapping("/publishers")
//    public List<Publisher> getAllPublisher() {
//        return publisherService.findAllPublisher();
//    }
//
//    @GetMapping("/publishers/{id}")
//    public Publisher getPublisher(@PathVariable long id) {
//        return publisherService.findPublisherById(id);
//    }
//
//    @PostMapping("/publishers")
//    public void createPublisher(@RequestBody Publisher publisher) {
//        publisherService.createPublisher(publisher);
//    }
//
//    @PutMapping("/publishers/{id}")
//    public void updatePublisher(@PathVariable long id, @RequestBody Publisher publisher) {
//        publisherService.updatePublisher(id, publisher);
//    }
//
//    @DeleteMapping("/publishers/{id}")
//    public void deletePublisher(@PathVariable long id) {
//        publisherService.deletePublisher(id);
//    }

}
