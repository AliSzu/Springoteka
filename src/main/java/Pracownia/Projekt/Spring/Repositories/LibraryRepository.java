//package Pracownia.Projekt.Spring.Repositories;
//
//import Pracownia.Projekt.Spring.Entities.Library;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//
//@Repository
//public interface LibraryRepository extends CrudRepository<Library, Integer>
//{
//    @Query("Select count(*) from Library where id = :id")
//    int checkIfExist(@Param("id") int id);
//
//    @Query("Select count(*) from Library where city = :city")
//    int checkIfExistCity(@Param("city") String city);
//
//    @Query("Select id From Books WHERE libraryId = :id")
//    List<Integer> findLibraryBooks(@Param("id") int id);
//
//    Optional<Library> findByCity(String City);
//    //3
//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM Library WHERE library_id = :id", nativeQuery = true)
//    void deleteByLibraryId(@Param("id") int id);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE Books SET library_id = null WHERE library_id = :library_id ", nativeQuery = true)
//    void updateBooks(@Param("library_id") Integer library_id);
//
//
//}
