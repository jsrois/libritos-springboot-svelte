package net.jsrois.libritos.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @PostConstruct
    private void loadExampleBooks() {
        bookRepository.saveAll(List.of(
                new Book("Teoría de la Reproducción Social")
        ));
    }
}
