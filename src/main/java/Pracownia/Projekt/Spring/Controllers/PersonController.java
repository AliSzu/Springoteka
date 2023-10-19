//package Pracownia.Projekt.Spring.Controllers;
//
//import Pracownia.Projekt.Spring.Entities.*;
//import Pracownia.Projekt.Spring.Services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.NonNull;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@RestController
//@Controller
//@RequestMapping("/api")
//public class PersonController {
//
//    @Autowired
//    private PersonService personService;
//
//    @Autowired
//    private BooksService booksService;
//
//    @Autowired
//    private AddressService addressService;
//
//    /**
//     * Przeglądanie osób - GET
//     */
//    @CrossOrigin
//    @GetMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Person> list(Model model) {
//        return personService.listAllPeople();
//    }
//
//    /**
//     * Przeglądanie osób po ID - GET
//     */
//    @GetMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getByPublicId(@PathVariable("id") Integer publicId) {
//        System.out.println(publicId);
//        if (personService.checkIfExist(publicId)) {
//            return ResponseEntity.ok().body(personService.getPersonById(publicId).orElseGet(null));
//        } else {
//            return new ResponseEntity<>("Person with this id doesn't exist", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    /**
//     * Dodawanie ludzi - POST
//     **/
//    @CrossOrigin
//    @PostMapping(value = "/person")
//    public ResponseEntity<?> create(@RequestBody @NonNull @Valid
//                                            Person person) {
//        if (personService.checkIfExist(person.getPerson_id())) {
//            return new ResponseEntity<>("Person with this id already exists", HttpStatus.BAD_REQUEST);
//        } else {
//            //sprawdzic id adresu - człowiek nie moze zyć na ulicy!!
//            if(personService.checkIfAddressIsFree(person.getAddress_id()) || !addressService.checkIfExist(person.getAddress_id()))
//                return new ResponseEntity<>("Invalid address_id", HttpStatus.BAD_REQUEST);
//            else
//                if(person.getBook_id() != null)
//                    if(personService.checkIfBookIsFree(person.getBook_id(), person.getPerson_id()) || !booksService.checkIfExist(person.getBook_id()))
//                        return new ResponseEntity<>("Invalid book_id", HttpStatus.BAD_REQUEST);
//                    else
//                    {
//                        personService.savePerson(person);
//                        return ResponseEntity.ok().body(person);
//                    }
//            }
//        personService.savePerson(person);
//        return ResponseEntity.ok().body(person);
//        }
//
//    /**
//     * Edytowanie ludzi - PUT
//     */
//    @CrossOrigin
//    @PutMapping(value = "/person")
//    public ResponseEntity<?> edit(@RequestBody Person person) {
//        if(!personService.checkIfExist(person.getPerson_id()))
//            return new ResponseEntity<>("Person with this id doesn't exist",HttpStatus.BAD_REQUEST);
//        else
//            if(person.getBook_id() != null)
//                if(personService.checkIfBookIsFree(person.getBook_id(), person.getPerson_id()) || !booksService.checkIfExist(person.getBook_id()))
//                    return new ResponseEntity<>("Invalid book_id", HttpStatus.BAD_REQUEST);
//            else
//            {
//                personService.savePerson(person);
//                return new ResponseEntity<>("Person was successfully edited",HttpStatus.CREATED);
//            }
//        personService.savePerson(person);
//        return new ResponseEntity<>("Person was successfully edited",HttpStatus.CREATED);
//}
//
//    /**
//     * Usuwanie po id - DELETE
//     */
//
//    @CrossOrigin
//    @DeleteMapping(value = "/person/{id}")
//    public ResponseEntity delete(@PathVariable Integer id) {
//        personService.deleteByPersonId(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    }
//
//
