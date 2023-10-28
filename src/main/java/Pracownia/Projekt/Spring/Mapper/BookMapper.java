package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.DTO.PostBookDTO;
import Pracownia.Projekt.Spring.Entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapDtoToEntity(PostBookDTO postBookDTO) {
        Book book = new Book();
        book.setTitle(postBookDTO.getTitle());
        book.setAuthor(postBookDTO.getAuthor());
        return book;
    }
}
