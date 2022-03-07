package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PersonService {

    Iterable<Person> listAllPeople();

    Person savePerson(Person person);

    boolean checkIfExist(Integer person_id);

    Optional<Person> getPersonById(Integer person_id);

    boolean checkIfBookIsFree(Integer book_id, Integer person_id);

    boolean checkIfAddressIsFree(Integer address_id);

    void deleteByPersonId(Integer id);

}
