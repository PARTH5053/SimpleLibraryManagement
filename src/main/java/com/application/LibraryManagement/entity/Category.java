package com.application.LibraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 50, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books = new HashSet<Book>();

    public Category(String name) {
        this.name = name;
    }
}
