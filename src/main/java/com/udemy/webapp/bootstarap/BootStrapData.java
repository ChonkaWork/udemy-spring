package com.udemy.webapp.bootstarap;

import com.udemy.webapp.domain.Author;
import com.udemy.webapp.domain.Book;
import com.udemy.webapp.domain.Publisher;
import com.udemy.webapp.repositories.AuthorRepository;
import com.udemy.webapp.repositories.BookRepository;
import com.udemy.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher john = new Publisher("John", "Long ln.", "Philadelphia", "Pennsylvania", "123");
        Publisher peter = new Publisher("Peter", "Short ln.", "New-York", "New-York", "321");
        Publisher lisa = new Publisher("Lisa", "First ln.", "Los Angeles", "California", "432");

        publisherRepository.save(john);
        publisherRepository.save(peter);
        publisherRepository.save(lisa);

        Author eric = new Author("Eric", "Hamon");
        Book ddd = new Book("Welcome to the jungle", "12324");
        ddd.getAuthors().add(eric);
        ddd.setPublisher(john);
        john.getBooks().add(ddd);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Stevens");
        Book sss = new Book("Loren upsum", "43211");
        sss.getAuthors().add(rob);
        sss.setPublisher(peter);
        peter.getBooks().add(sss);
        eric.getBooks().add(sss);

        authorRepository.save(rob);
        bookRepository.save(sss);

        publisherRepository.save(john);
        publisherRepository.save(peter);
        publisherRepository.save(lisa);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of the books: " + bookRepository.count());

        System.out.println("Number of the publishers: " + publisherRepository.count());
        System.out.println("Number of the Peter books: " + peter.getBooks().size());
    }
}
