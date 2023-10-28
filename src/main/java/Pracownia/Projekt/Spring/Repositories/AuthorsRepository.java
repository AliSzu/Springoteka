//package Pracownia.Projekt.Spring.Repositories;
//
//import Pracownia.Projekt.Spring.Entities.Authors;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//public interface AuthorsRepository extends CrudRepository<Authors, Integer> {
//
//    @Query(value= "SELECT id FROM Books where author_id IN ( SELECT author_id from Authors where author_id = :id);", nativeQuery = true)
//    List<Integer> deleteAuthorAndTheirBooksById(@Param("id") int id);
//
//    @Transactional
//    @Modifying
//    @Query( value="DELETE FROM Books WHERE id = :id")
//    void deleteBook(@Param("id") int id);
//
//    @Query("Select count(*) from Authors where id = :id")
//    int checkIfExist(@Param("id") int id);
//
//    @Query(value= "SELECT * FROM Authors where author_id IN (SELECT author_id From(SELECT author_id, COUNT(author_id) FROM Books  GROUP BY author_id HAVING COUNT (author_id)=( SELECT MAX(mycount) FROM ( SELECT author_id, COUNT(author_id) mycount FROM Books GROUP BY author_id) AS foo )) AS foo);", nativeQuery = true)
//    Iterable<Authors> listBestAuthors();
//    //1
//
//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM Person WHERE person_id in (SELECT person_id From Person where book_id = :book_id)", nativeQuery = false)
//    void DeletePerson(@Param("book_id") int book_id);
//
//    @Query("Select count(*) from Person where book_id = :id")
//    int checkIfExistBook(@Param("id") int id);
//
//    @Query(value = "SELECT person_id from Person WHERE book_id = :id", nativeQuery = true)
//    Integer FindPerson(@Param("id") int id);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE Person SET book_id = null where person_id = :personId", nativeQuery = true)
//    void ChangeBookId(@Param("personId") Integer personId);
//}
//
