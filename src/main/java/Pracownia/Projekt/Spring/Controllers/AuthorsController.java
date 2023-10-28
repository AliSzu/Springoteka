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
//
//@RestController
//@Controller
//@RequestMapping("/api")
//public class AuthorsController {
//
//    @Autowired
//    private AuthorsService authorsService;
//
//    /**
//     * Przeglądanie autorów - GET
//     */
//    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Authors> list(Model model) {
//        return authorsService.listAllAuthors();
//    }
//
//    /**
//     * Autorzy z największą liczbą książek - GET
//     */
//    @GetMapping(value = "/bestAuthors", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Authors> list(Authors author) {
//        return authorsService.listBestAuthors();
//    }
//
//    /**
//     Dodawanie autorów - POST
//     **/
//    @PostMapping(value = "/author")
//    public ResponseEntity<?> create(@RequestBody @NonNull @Valid
//                                                Authors author) {
//        if(authorsService.checkIfExist(author.getAuthor_id()))
//            return new ResponseEntity<>("Author with this id already exist", HttpStatus.BAD_REQUEST);
//        else {
//            authorsService.saveAuthor(author);
//            return ResponseEntity.ok().body(author);
//        }
//    }
//
//    /**
//     * Edytowanie autorów - PUT
//     */
//    @CrossOrigin
//    @PutMapping(value = "/author")
//    public ResponseEntity<?> edit(@RequestBody Authors author) {
//        if(!authorsService.checkIfExist(author.getAuthor_id()))
//            return new ResponseEntity<>("Invalid author_id", HttpStatus.BAD_REQUEST);
//        else {authorsService.saveAuthor(author);}
//        return new ResponseEntity<>("Author was successfully edited", HttpStatus.CREATED);
//    }
//
//    /**
//     * Usuwanie autorów po ID - DELETE
//     */
//
//    @CrossOrigin
//    @DeleteMapping(value = "/author/{id}")
//    public ResponseEntity delete(@PathVariable int id) {
//        authorsService.deleteAuthorAndTheirBooksById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//}
