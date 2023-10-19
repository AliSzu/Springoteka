//package Pracownia.Projekt.Spring.Controllers;
//
//import Pracownia.Projekt.Spring.Entities.*;
//import Pracownia.Projekt.Spring.Services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.NonNull;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@Controller
//@RequestMapping("/api")
//public class LibraryController {
//
//    @Autowired
//    private LibraryService libraryService;
//
//    /**
//     * Przeglądanie bibliotek - GET
//     */
//    @PreAuthorize("hasRole('USER')")
//    @GetMapping(value = "/libraries", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Library> list(Model model) {
//        return libraryService.listAllLibraries();
//    }
//
//
//    @GetMapping(value = "/library/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getByCity(@PathVariable("city") String publicCity) {
//        if (libraryService.checkIfExistCity(publicCity)) {
//            return ResponseEntity.ok().body(libraryService.getLibraryByCity(publicCity).orElseGet(null));
//        } else {
//            return new ResponseEntity<>("Library in this City doesn't exist", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    /**
//     Dodawanie bibliotek - POST
//     **/
//    @PreAuthorize("hasRole('USER')")
//    @CrossOrigin
//    @PostMapping(value = "/library")
//    public ResponseEntity<?> create(@RequestBody @NonNull @Valid
//                                                Library library) {
//        if(libraryService.checkIfExist(library.getLibrary_id()))
//        {
//            return new ResponseEntity<>("Library with this id already exists",HttpStatus.BAD_REQUEST);
//        }
//        else {
//            libraryService.saveLibrary(library);
//            return ResponseEntity.ok().body(library);
//        }
//    }
//
//    /**
//     * Edytowanie bibliotek - PUT
//     */
//    @CrossOrigin
//    @PutMapping(value = "/library")
//    public ResponseEntity<?> edit(@RequestBody Library library) {
//        if(!libraryService.checkIfExist(library.getLibrary_id()))
//            return new ResponseEntity<>("Library with this id doesn't exist",HttpStatus.BAD_REQUEST);
//        else {
//            libraryService.saveLibrary(library);
//        }
//        return new ResponseEntity<>("Library was successfully edited",HttpStatus.CREATED);
//    }
//
//    /**
//     * Usuwanie po id
//     */
//    @PreAuthorize("hasRole('USER')")
//    @CrossOrigin
//    @DeleteMapping(value = "/library/{id}")
//    public ResponseEntity delete(@PathVariable int id) {
//        libraryService.deleteByLibraryId(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
