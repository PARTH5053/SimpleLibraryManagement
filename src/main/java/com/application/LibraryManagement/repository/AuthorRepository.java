package com.application.LibraryManagement.repository;

import com.application.LibraryManagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
