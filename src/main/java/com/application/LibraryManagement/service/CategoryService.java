package com.application.LibraryManagement.service;


import com.application.LibraryManagement.controller.CategoryController;
import com.application.LibraryManagement.entity.Book;
import com.application.LibraryManagement.entity.Category;
import com.application.LibraryManagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return  categoryRepository.findAll();
    }

    public Category findCategoryById(long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("no category found!"));
        return category;
    }

    public void createCategory(Category category1){
        categoryRepository.save(category1);
    }

    public void deleteCategory(long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("no category found!"));
        categoryRepository.deleteById(category.getId());
    }

    public void updateCategory(long id,Category newCategory){
         Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("no category found!"));
        category.setName(newCategory.getName());
//        category.setBooks(newCategory.getBooks());
        categoryRepository.save(category);
    }

}
