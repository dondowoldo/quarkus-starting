package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-i")
    String genre;


    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "title 1", "Daniel", 2020, genre),
                new Book(2, "title 2", "Tomas", 2021, genre),
                new Book(3, "title 3", "Jana", 2022, genre),
                new Book(4, "title 4", "Krystof", 2023, genre)
        );
    }

    public Book getBookById(int id) {
        return getAllBooks().stream()
                .filter(b -> b.id == id)
                .findFirst().orElse(null);
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }
}
