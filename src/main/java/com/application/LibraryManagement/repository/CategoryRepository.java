package com.application.LibraryManagement.repository;

import com.application.LibraryManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
