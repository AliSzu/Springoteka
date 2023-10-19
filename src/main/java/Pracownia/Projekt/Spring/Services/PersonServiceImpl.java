//package Pracownia.Projekt.Spring.Services;
//
//import Pracownia.Projekt.Spring.Entities.Person;
//import Pracownia.Projekt.Spring.Repositories.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class PersonServiceImpl implements PersonService{
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Override
//    public Iterable<Person> listAllPeople() {
//        return personRepository.findAll();
//    }
//
//    @Override
//    public Person savePerson(Person person) {
//        return personRepository.save(person);
//    }
//
//    @Override
//    public boolean checkIfExist(Integer id) {
//        if (personRepository.checkIfExist(id) > 0)
//            return true;
//        else
//            return false;
//    }
//
//    @Override
//    public Optional<Person> getPersonById(Integer id) {
//        return personRepository.findById(id);
//    }
//
//    @Override
//    public boolean checkIfBookIsFree(Integer book_id, Integer person_id)
//    {
//        Integer currentBook = personRepository.currentBook(person_id);
//        if(book_id == currentBook)
//        {
//            return false;
//        }
//        else {
//            if (personRepository.checkBooks().contains(book_id))
//                return true;
//            else
//                return false;
//        }
//    }
//
//    @Override
//    public boolean checkIfAddressIsFree(Integer address_id)
//    {
//        if(personRepository.checkAddresses().contains(address_id))
//            return true;
//        else
//            return false;
//    }
//
//    @Override
//    public void deleteByPersonId(Integer id)
//    {
//        personRepository.ChangeAddressId(id);
//        personRepository.ChangeBookId(id);
//        personRepository.deleteById(id);
//    }
//}
