package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.PatchBookDTO;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.beans.FeatureDescriptor;

import java.util.*;
import java.util.stream.Stream;


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
    public boolean existsById(Integer id) {
        return bookRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(Integer id) {return bookRepository.findById(id);}

    public Book mergeBooks( Book aCurrentBook, Book aNewBook) {
        return Book.builder()
                .author(aNewBook.getAuthor() != null ? aNewBook.getAuthor() : aCurrentBook.getAuthor())
                .title(aNewBook.getTitle() != null ? aNewBook.getTitle() : aCurrentBook.getTitle())
                .build();
    }

    public Book patchBook(PatchBookDTO newBook, Integer id) {

        final BeanWrapper wrappedSource = new BeanWrapperImpl(newBook);
        String[] nulls = Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);

        Book bookToUpdate = bookRepository.getReferenceById(id);
        BeanUtils.copyProperties(newBook, bookToUpdate, nulls);

        return bookRepository.save(bookToUpdate);
    }

}
