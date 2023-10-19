//package Pracownia.Projekt.Spring.Services;
//
//import Pracownia.Projekt.Spring.Entities.Authors;
//import Pracownia.Projekt.Spring.Entities.Books;
//import Pracownia.Projekt.Spring.Repositories.AuthorsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class AuthorsServiceImpl implements AuthorsService{
//
//    @Autowired
//    private AuthorsRepository authorsRepository;
//
//    @Override
//    public Iterable<Authors> listAllAuthors() {
//        return authorsRepository.findAll();
//    }
//
//    @Override
//    public Iterable<Authors> listBestAuthors() {return authorsRepository.listBestAuthors();
//    }
//
//    @Override
//    public Authors saveAuthor(Authors author) {
//        return authorsRepository.save(author);
//    }
//
//    @Override
//    public void deleteAuthorAndTheirBooksById(int id)
//    {
//        List<Integer> booksId = authorsRepository.deleteAuthorAndTheirBooksById(id);
//        for(int bookId : booksId)
//        {
//            if(authorsRepository.checkIfExistBook(bookId) > 0)
//            {
//                Integer personId = authorsRepository.FindPerson(bookId);
//                if(personId != null) {
//                    authorsRepository.ChangeBookId(personId);
//                }
//                authorsRepository.DeletePerson(bookId);
//            }
//            authorsRepository.deleteBook(bookId);
//        }
//        authorsRepository.deleteById(id);
//    }
//
//    @Override
//    public boolean checkIfExist(int id) {
//        System.out.println(id);
//        System.out.println(authorsRepository.checkIfExist(id));
//        if (authorsRepository.checkIfExist(id) > 0)
//            return true;
//        else
//            return false;
//    }
//}
