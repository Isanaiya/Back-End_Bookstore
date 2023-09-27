package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookListDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Save a few books as a test.");
			crepository.save(new Category("Fictional Reality"));
			crepository.save(new Category("Fantasy"));
			
			repository.save(new Book("One Last Question", "Mike Pattenden", 2021, "9781913062866", 17.80, crepository.findByName("Fictional Reality").get(0)));
			repository.save(new Book("A Sword of Storms", "George R. R. Martin", 2000, "0-553-10663-5", 25.50, crepository.findByName("Fantasy").get(0)));
		};
	}

}