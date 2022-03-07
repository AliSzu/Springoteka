package Pracownia.Projekt.Spring.Repositories;

import Pracownia.Projekt.Spring.Entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>
{
    @Query("Select count(*) from Address where id = :id")
    int checkIfExist(@Param("id") int id);

    @Query(value = "SELECT person_id FROM Person WHERE address_id IN ( SELECT :address_id FROM Address)", nativeQuery = true)
    Integer FindPerson(@Param("address_id") int address_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET book_id = null where person_id = :personId", nativeQuery = true)
    void ChangeBookId(@Param("personId") Integer personId);

    Iterable<Address> findByCountryNot(String Country);


}
