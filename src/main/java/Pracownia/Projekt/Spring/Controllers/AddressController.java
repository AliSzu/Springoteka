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
//public class AddressController {
//
//    @Autowired
//    private AddressService addressService;
//
//    /**
//     * Przeglądanie adresów - GET
//     */
//    @GetMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Address> list(Model model) {
//        return addressService.listAllAddresses();
//    }
//
//    /**
//     * Przeglądanie adresów nie z Polski - GET
//     */
//    @GetMapping(value = "/addressForeign", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Address> list(Address address) {
//        return addressService.listAllForeignAddresses();
//    }
//
//    /**
//     Dodawanie adresów - POST
//     **/
//    @PostMapping(value = "/address")
//    public ResponseEntity<?> create(@RequestBody @NonNull @Valid
//                                            Address address) {
//        if(addressService.checkIfExist(address.getAddress_id()))
//        {
//            return new ResponseEntity<>("Address with this id already exists", HttpStatus.BAD_REQUEST);
//        }
//        else {
//            addressService.saveAddress(address);
//            return ResponseEntity.ok().body(address);
//        }
//    }
//
//    /**
//     * Edytowanie adresów - PUT
//     */
//    @CrossOrigin
//    @PutMapping(value = "/address")
//    public ResponseEntity<?> edit(@RequestBody Address address) {
//        if(!addressService.checkIfExist(address.getAddress_id()))
//            return new ResponseEntity<>("Address with this id doesn't exist",HttpStatus.BAD_REQUEST);
//        else {
//            addressService.saveAddress(address);
//        }
//        return new ResponseEntity<>("Address was successfully edited",HttpStatus.CREATED);
//    }
//
//    /**
//     * Usuwanie po id - DELETE
//     */
//
//    @CrossOrigin
//    @DeleteMapping(value = "/address/{id}")
//    public ResponseEntity delete(@PathVariable int id) {
//        addressService.deleteByAddressId(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
