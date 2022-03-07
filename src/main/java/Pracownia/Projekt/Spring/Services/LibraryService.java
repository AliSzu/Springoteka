package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.Books;
import Pracownia.Projekt.Spring.Entities.Library;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LibraryService {

    Iterable<Library> listAllLibraries();

    Library saveLibrary(Library library);

    boolean checkIfExist(int id);

    boolean checkIfExistCity(String city);

    void deleteByLibraryId(int id);

    Optional<Library> getLibraryByCity(String city);

}