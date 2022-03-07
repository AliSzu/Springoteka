package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.Entities.*;
import Pracownia.Projekt.Spring.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@Controller
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private LibraryService libraryService;

    /**
     * Przeglądanie książek - GET
     */
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Books> list(Model model) {
        return booksService.listAllBooks();
    }

    /**
     * Przeglądanie książek po ID - GET
     */
    @CrossOrigin
    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByPublicId(@PathVariable("id") Integer publicId) {
        if (booksService.checkIfExist(publicId)) {
            return ResponseEntity.ok().body(booksService.getBookById(publicId).orElseGet(null));
        } else {
            return new ResponseEntity<>("Book with this id doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Książki, które nie są w żadnej bibliotece - GET
     */
    @GetMapping(value = "/incorrectBooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Books> list(Books book) {
        return booksService.findByISBNNull();
    }

    /**
     * Dodawanie książek - POST
     **/
    @PostMapping(value = "/book")
    public ResponseEntity<?> create(@RequestBody @NonNull @Valid
                                                Books book) {
        if (booksService.checkIfExist(book.getId()))
            return new ResponseEntity<>("Book with this id already exist", HttpStatus.BAD_REQUEST);
        else {
            if (!authorsService.checkIfExist(book.getAuthorid()))
                return new ResponseEntity<>("invalid author_id", HttpStatus.BAD_REQUEST);
            else {
                if (book.getLibrary_id() != null)
                    if (!libraryService.checkIfExist(book.getLibrary_id()))
                        return new ResponseEntity<>("invalid library_id", HttpStatus.BAD_REQUEST);
                    else
                    {
                        book.setISBN((UUID.randomUUID().toString()));
                        booksService.saveBook(book);
                        return ResponseEntity.ok().body(book);}
            }
                   // book.setISBN((UUID.randomUUID().toString()));
                    booksService.saveBook(book);
                    return ResponseEntity.ok().body(book);}
    }

    /**
     * Edytowanie książek - PUT
     */
    @CrossOrigin
    @PutMapping(value = "/book")
    public ResponseEntity<?> edit(@RequestBody Books book) {
        if (!booksService.checkIfExist(book.getId()))
            return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
        else {
            if (!authorsService.checkIfExist(book.getAuthorid()))
                return new ResponseEntity<>("invalid author_id", HttpStatus.BAD_REQUEST);
            else {
                if (book.getLibrary_id() != null)
                    if (!libraryService.checkIfExist(book.getLibrary_id()))
                        return new ResponseEntity<>("invalid library_id", HttpStatus.BAD_REQUEST);
                    else {
                        booksService.saveBook(book);
                        return new ResponseEntity<>("Book was successfully edited", HttpStatus.CREATED);
                    }
                booksService.saveBook(book);
                return new ResponseEntity<>("Book was successfully edited", HttpStatus.CREATED);
            }
        }
    }

    /**
     * Usuwanie książek po ID - DELETE
     */
    @CrossOrigin
    @DeleteMapping(value = "/book/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        booksService.deleteByBookId(id);
        return new ResponseEntity<>("Book was successfully deleted",HttpStatus.OK);
    }

    /**
     * Stronicowanie książek
     */

    @GetMapping(value = "/books/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Books> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return booksService.listAllBooksPaging(pageNr, howManyOnPage.orElse(2));
    }
}
