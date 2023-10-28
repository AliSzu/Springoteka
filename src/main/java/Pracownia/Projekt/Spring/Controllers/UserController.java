//package Pracownia.Projekt.Spring.Controllers;
//
//
//import Pracownia.Projekt.Spring.Entities.Library;
//import Pracownia.Projekt.Spring.Entities.User;
//import Pracownia.Projekt.Spring.Entities.UserPrincipal;
//import Pracownia.Projekt.Spring.Exception.ResourceNotFoundException;
//import Pracownia.Projekt.Spring.Repositories.UserRepository;
//import Pracownia.Projekt.Spring.Services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @GetMapping("/user/me")
//    @PreAuthorize("hasRole('USER')")
//    public User getCurrentUser(Authentication authentication) {
//        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
//        return userRepository.findById(userDetails.getId())
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userDetails.getId()));
//    }
//
//    @GetMapping(value = "/data", produces = "application/json")
//    @PreAuthorize("hasRole('USER')")
//    public String getUserSecretData(Authentication authentication) {
//        return "Now server can reveal user's secret data";
//    }
//
//    @CrossOrigin
//    @PutMapping(value = "/data/avatar")
//    public ResponseEntity<?> edit(@RequestBody User user) {
//        userService.saveUser(user);
//        return new ResponseEntity<>("Library was successfully edited",HttpStatus.CREATED);
//    }
//
//
//
//}