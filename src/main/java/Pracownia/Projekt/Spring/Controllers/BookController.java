package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Book")
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.listAllBooks();
    }
    @PostMapping
    public Book createBook(@RequestBody @Valid @NonNull Book book) {
        return bookService.createBook(book);
    }

}
