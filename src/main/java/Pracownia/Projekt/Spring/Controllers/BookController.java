package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.DTO.PatchBookDTO;
import Pracownia.Projekt.Spring.DTO.PostBookDTO;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Mapper.BookMapper;
import Pracownia.Projekt.Spring.Services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Book")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;
    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getById(@PathVariable Integer id) {
        Optional<Book> book = bookService.getBookById(id);
        if(book.isEmpty()) {
            throw new EntityNotFoundException("Book with ID " + id + " not found");
        }
        return book;
    }

    @PostMapping
    public Book createBook(@RequestBody @Valid @NonNull PostBookDTO postBookDTO) {
        Book book = bookMapper.mapDtoToEntity(postBookDTO);
        return bookService.createBook(book);
    }

    @PatchMapping("/{id}")
    public Book patchBook(@RequestBody @Valid PatchBookDTO patchBookDTO, @PathVariable Integer id) {
        if(!bookService.existsById(id)) {
            throw new EntityNotFoundException("Book with ID " + id + " not found");
        }
        return bookService.patchBook(patchBookDTO, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Integer id) {
        if (!bookService.existsById(id)) {
            throw new EntityNotFoundException("Book with ID " + id + " not found");
        }
        bookService.deleteById(id);
    }



}
