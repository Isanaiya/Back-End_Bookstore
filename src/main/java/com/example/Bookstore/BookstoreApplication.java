package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookListDemo(BookRepository repository) {
		return (args) -> {
			log.info("Save a few books as a test.");
			repository.save(new Book("One Last Question", "Mike Pattenden", 2021, "9781913062866", 17.80));
			repository.save(new Book("A Sword of Storms", "George R. R. Martin", 2000, "0-553-10663-5", 25.50));
		};
	}

}
