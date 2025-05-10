package com.application.LibraryManagement;

import com.application.LibraryManagement.entity.Author;
import com.application.LibraryManagement.entity.Book;
import com.application.LibraryManagement.entity.Category;
import com.application.LibraryManagement.entity.Publisher;
import com.application.LibraryManagement.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return(args -> {
			Book book1 = new Book("0001","Book1","My first book");
			Author author1 = new Author("Author1","Author Desctiption1");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("Publisher 1");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("0002","Book2","My Second book");
			Author author2 = new Author("Author2","Author Desctiption2");
			Category category2 = new Category("Science Fiction books");
			Publisher publisher2 = new Publisher("Publisher 2");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("0003","Book3","My Third book");
			Author author3 = new Author("Author3","Author Desctiption3");
			Category category3 = new Category("Maths books");
			Publisher publisher3 = new Publisher("Publisher 3");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);
		});
	}

}
