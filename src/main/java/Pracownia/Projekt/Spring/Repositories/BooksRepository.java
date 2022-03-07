package Pracownia.Projekt.Spring.Repositories;

import Pracownia.Projekt.Spring.Entities.Books;
import org.hamcrest.core.Is;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>, PagingAndSortingRepository<Books, Integer> {
    @Query("Select count(*) from Books where id = :id")
    int checkIfExist(@Param("id") int id);

    Iterable<Books> findByLibraryIdNull();
    //2

    @Query("Select libraryId from Books where id = :id")
    Integer findLibraryID(@Param("id") int id);


    @Query(value = "SELECT * FROM Books WHERE publication_date < now() - '100 years' :: interval;", nativeQuery = true)
    Iterable<Books> OldBooks();

    @Query(value = "SELECT person_id from Person WHERE book_id = :id", nativeQuery = true)
    Integer FindPerson(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET book_id = null where person_id = :personId", nativeQuery = true)
    void ChangeBookId(@Param("personId") Integer personId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Books SET library_id = null where id = :id", nativeQuery = true)
    void ChangeLibraryId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Books SET author_id = null where id = :id", nativeQuery = true)
    void changeAuthor(@Param("id") int id);
}
