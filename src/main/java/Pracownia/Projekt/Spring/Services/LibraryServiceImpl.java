//package Pracownia.Projekt.Spring.Services;
//
//import Pracownia.Projekt.Spring.Entities.Books;
//import Pracownia.Projekt.Spring.Entities.Library;
//import Pracownia.Projekt.Spring.Repositories.BooksRepository;
//import Pracownia.Projekt.Spring.Repositories.LibraryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LibraryServiceImpl implements LibraryService{
//
//    @Autowired
//    private LibraryRepository libraryRepository;
//
//    @Override
//    public Iterable<Library> listAllLibraries() {
//        return libraryRepository.findAll();
//    }
//
//    @Override
//    public Library saveLibrary(Library library) {
//        return libraryRepository.save(library);
//    }
//
//    @Override
//    public boolean checkIfExist(int id) {
//        if (libraryRepository.checkIfExist(id) > 0)
//            return true;
//        else
//            return false;
//    }
//
//    @Override
//    public boolean checkIfExistCity(String city) {
//        if (libraryRepository.checkIfExistCity(city) > 0)
//            return true;
//        else
//            return false;
//    }
//
//    @Override
//    public void deleteByLibraryId(int id)
//    {
//        libraryRepository.updateBooks(id);
//        libraryRepository.deleteByLibraryId(id);
//    }
//
//    @Override
//    public Optional<Library> getLibraryByCity(String city) {
//        return libraryRepository.findByCity(city);
//    }
//
//
//
//
//
//}
