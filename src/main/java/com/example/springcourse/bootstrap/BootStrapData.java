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
        Publisher publisher = new Publisher("foo", "12th Street", "LA", "CA", "42900");
        publisherRepository.save(publisher);

        Author herman = new Author("Herman", "Hesse");
        Set<Author> authors = new HashSet<>();
        authors.add(herman);
        Book siddartha = new Book("Siddartha", "1", authors);
        siddartha.setPublisher(publisher);
        Set<Book> books = new HashSet<>();
        books.add(siddartha);
        herman.setBooks(books);
//        Set<Book> publisherBooks = publisher.getBooks();
//        publisherBooks.add(siddartha);
//        publisher.setBooks(publisherBooks);
        publisher.getBooks().add(siddartha);

        authorRepository.save(herman);
        bookRepository.save(siddartha);
        publisherRepository.save(publisher);

        Author johnGreen = new Author("John", "Green");
        authors = new HashSet<>();
        authors.add(johnGreen);
        Book okayOkay = new Book("The Fault in our start", "2", authors);
        books = new HashSet<>();
        okayOkay.setPublisher(publisher);
        books.add(okayOkay);
        johnGreen.setBooks(books);
        publisher.getBooks().add(okayOkay);
//        publisherBooks = publisher.getBooks();
//        publisherBooks.add(okayOkay);
//        publisher.setBooks(publisherBooks);

        authorRepository.save(johnGreen);
        bookRepository.save(okayOkay);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of publisher's books: " + publisher.getBooks().size());
    }
}
