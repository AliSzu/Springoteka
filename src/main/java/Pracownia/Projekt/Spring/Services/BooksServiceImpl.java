//package Pracownia.Projekt.Spring.Services;
//
//import Pracownia.Projekt.Spring.Entities.Books;
//import Pracownia.Projekt.Spring.Repositories.BooksRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BooksServiceImpl implements BooksService{
//
//    @Autowired
//    private BooksRepository booksRepository;
//
//    @Override
//    public Iterable<Books> listAllBooks() {
//        return booksRepository.findAll();
//    }
//
//    @Override
//    public Books saveBook(Books book) {
//        return booksRepository.save(book);
//    }
//
//    @Override
//    public boolean checkIfExist(int id) {
//        if (booksRepository.checkIfExist(id) > 0)
//            return true;
//        else
//            return false;
//    }
//    @Override
//    public void deleteByBookId(int id)
//    {
//
//        Integer personId = booksRepository.FindPerson(id);
//        if(personId != null) {
//            booksRepository.ChangeBookId(personId);
//        }
//        Integer libraryID = booksRepository.findLibraryID(id);
//        if(libraryID != null)
//        {
//            booksRepository.ChangeLibraryId(id);
//        }
//        booksRepository.changeAuthor(id);
//        booksRepository.deleteById(id);
//    }
//
//    @Override
//    public Iterable<Books> listAllBooksPaging(Integer pageNr, Integer howManyOnPage) {
//        return booksRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
//    }
//    //4
//
//    @Override
//    public Iterable<Books> findByISBNNull() {return booksRepository.findByLibraryIdNull();}
//
//    @Override
//    public Optional<Books> getBookById(Integer id) {
//        return booksRepository.findById(id);
//    }
//
//    @Override
//    public Iterable<Books> OldBooks() {return booksRepository.OldBooks();}
//
//
//
//
//
//}
