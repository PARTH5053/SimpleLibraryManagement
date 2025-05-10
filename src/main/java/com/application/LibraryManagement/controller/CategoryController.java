package com.application.LibraryManagement.controller;

import com.application.LibraryManagement.entity.Category;
import com.application.LibraryManagement.entity.Publisher;
import com.application.LibraryManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        model.addAttribute("activePage", "categories");
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable long id, Model model){
        model.addAttribute("category",categoryService.findCategoryById(id));
        model.addAttribute("activePage", "categories");

        return "list-category";
    }

    @GetMapping("/remove-category/{id}")
    public String removeCategory(@PathVariable long id,Model model) {
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("activePage", "categories");

        return "redirect:/categories"; //returns categories.html
    }

    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable long id,Model model){
        model.addAttribute("category",categoryService.findCategoryById(id));
        model.addAttribute("activePage", "categories");

        return "update-category";
    }

    @PostMapping("/save-update-category/{id}")
    public String updateCategory(@PathVariable long id, Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-category";
        }
        categoryService.updateCategory(id, category);
        model.addAttribute("categories",categoryService.findAllCategories());
        model.addAttribute("activePage", "categories");
        return "redirect:/categories";
    }

    @GetMapping("/add-category")
    public String addCategory(Category category, Model model){
        return "add-category";
    }
    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("activePage", "categories");
        model.addAttribute("categories",categoryService.findAllCategories());
        return "redirect:/categories";
    }







//    public CategoryController(CategoryService categoryService1){
//        this.categoryService = categoryService1;
//    }
//
//    @GetMapping("/categories")
//    public List<Category> getAllCategories(){
//        return categoryService.findAllCategories();
//    }
//
//    @GetMapping("/categories/{id}")
//    public Category getCategory(@PathVariable long id) {
//        return categoryService.findCategoryById(id);
//    }
//
//    @PostMapping("/categories")
//    public void createCategory(@RequestBody Category category) {
//        categoryService.createCategory(category);
//    }
//
//    @PutMapping("/categories/{id}")
//    public void updateCategory(@PathVariable long id, @RequestBody Category category) {
//        categoryService.updateCategory(id, category);
//    }
//
//    @DeleteMapping("/categories/{id}")
//    public void deleteCategory(@PathVariable long id) {
//        categoryService.deleteCategory(id);
//    }
}
