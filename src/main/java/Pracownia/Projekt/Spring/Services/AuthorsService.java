package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.Authors;
import org.springframework.stereotype.Service;

@Service
public interface AuthorsService {

    Iterable<Authors> listAllAuthors();

    Iterable<Authors> listBestAuthors();

    Authors saveAuthor(Authors author);

    void deleteAuthorAndTheirBooksById(int id);

    boolean checkIfExist(int author_id);

}