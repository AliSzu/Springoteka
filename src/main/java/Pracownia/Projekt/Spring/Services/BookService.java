package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
