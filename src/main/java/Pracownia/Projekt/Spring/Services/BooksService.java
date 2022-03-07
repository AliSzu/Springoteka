package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.Authors;
import Pracownia.Projekt.Spring.Entities.Books;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BooksService {

    Iterable<Books> listAllBooks();

    Books saveBook(Books book);

    boolean checkIfExist(int id);

    void deleteByBookId(int id);

    Iterable<Books> listAllBooksPaging(Integer pageNr, Integer howManyOnPage);

    Iterable<Books> findByISBNNull();

    Iterable<Books> OldBooks();

    Optional<Books> getBookById(Integer id);

}