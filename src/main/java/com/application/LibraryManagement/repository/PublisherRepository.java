package com.application.LibraryManagement.repository;

import com.application.LibraryManagement.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
