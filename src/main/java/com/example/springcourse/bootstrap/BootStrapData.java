package com.example.springcourse.bootstrap;

import com.example.springcourse.models.Author;
import com.example.springcourse.models.Book;
import com.example.springcourse.models.Publisher;
import com.example.springcourse.repositories.IAuthorRepository;
import com.example.springcourse.repositories.IBookRepository;
import com.example.springcourse.repositories.IPublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {
    private final IAuthorRepository authorRepository;
    private final IBookRepository bookRepository;
    private final IPublisherRepository publisherRepository;

    public BootStrapData(IAuthorRepository authorRepository,
                         IBookRepository bookRepository,
                         IPublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author herman = new Author("Herman", "Hesse");
        Set<Author> authors = new HashSet<>();
        authors.add(herman);
        Book siddartha = new Book("Siddartha", "1", authors);
        Set<Book> books = new HashSet<>();
        books.add(siddartha);
        herman.setBooks(books);

        authorRepository.save(herman);
        bookRepository.save(siddartha);

        Author johnGreen = new Author("John", "Green");
        authors = new HashSet<>();
        authors.add(johnGreen);
        Book okayOkay = new Book("The Fault in our start", "2", authors);
        books = new HashSet<>();
        books.add(okayOkay);
        johnGreen.setBooks(books);

        authorRepository.save(johnGreen);
        bookRepository.save(okayOkay);
        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        Publisher publisher = new Publisher("foo", "12th Street", "LA", "CA", "42900");
        publisherRepository.save(publisher);
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
