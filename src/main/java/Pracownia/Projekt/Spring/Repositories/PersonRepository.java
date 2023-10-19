//package Pracownia.Projekt.Spring.Repositories;
//
//import Pracownia.Projekt.Spring.Entities.Person;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@Repository
//public interface PersonRepository extends CrudRepository<Person, Integer>
//{
//    @Query("Select count(*) from Person where person_id = :id")
//    int checkIfExist(@Param("id") int id);
//
//    @Query("Select book_id from Person where person_id = :id")
//    Integer currentBook(@Param("id") Integer id);
//
//    @Query("Select book_id From Person")
//    List<Integer> checkBooks();
//
//    @Query("Select address_id From Person")
//    List<Integer> checkAddresses();
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE Person SET book_id = null where person_id = :personId", nativeQuery = true)
//    void ChangeBookId(@Param("personId") Integer personId);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE Person SET address_id = null where person_id = :personId", nativeQuery = true)
//    void ChangeAddressId(@Param("personId") Integer personId);
//
//
//}
