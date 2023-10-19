//package Pracownia.Projekt.Spring.Controllers;
//
//import Pracownia.Projekt.Spring.Entities.*;
//import Pracownia.Projekt.Spring.Services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.*;
//
///**
// * Homepage controller.
// */
//@RestController
//@RequestMapping("/")
//public class IndexController {
//
//    //Date date = java.util.Calendar.getInstance().getTime();
//    Date myDate = new Date();
//    @Autowired
//    private BooksService booksService;
//
//    @Autowired
//    private AuthorsService authorsService;
//
//    @Autowired
//    private LibraryService libraryService;
//
//    @Autowired
//    private PersonService personService;
//
//    @Autowired
//    private AddressService addressService;
//
//    @GetMapping(value = "")
//    String index() {
//        return "Działa! Zapraszam do Postamana na testy";
//    }
//
//
//    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
//    public String generateModel() {
//        long millis=System.currentTimeMillis();
//        java.sql.Date date=new java.sql.Date(millis);
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate = new Date(System.currentTimeMillis());
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(myDate);
//        cal.add(Calendar.YEAR, -199);
//        cal.add(Calendar.MONTH, -10);
//
//        Authors a0 = new Authors("Adam","Mickiewicz", date);
//        Authors a1 = new Authors("Nikołaj","Gogol", date);
//        Authors a2 = new Authors("Fiodor","Dostojewski", date);
//        authorsService.saveAuthor(a0);
//        authorsService.saveAuthor(a1);
//        authorsService.saveAuthor(a2);
//
//
//        Library l0 = new Library("Poznań", "Biblioteka Uniwersytecka");
//        Library l1 = new Library("Szczecin", "Biblioteka Szczecińska");
//        Library l2 = new Library("Wrocław", "Miejska Biblioteka Publiczna");
//        Library l3 = new Library("Warszawa", "Magazyn Książek");
//        libraryService.saveLibrary(l0);
//        libraryService.saveLibrary(l1);
//        libraryService.saveLibrary(l2);
//        libraryService.saveLibrary(l3);
//
//        Date date2 = null;
//        try {
//            date2= dateFormat.parse ( "2009-12-31" );
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        Books b0 = new Books(cal.getTime(),UUID.randomUUID().toString(),"Dziady", a0.getAuthor_id(), l0.getLibrary_id());
//        cal.setTime(myDate);
//        cal.add(Calendar.YEAR, -188);
//        cal.add(Calendar.MONTH, 5);
//        Books b1 = new Books(cal.getTime(),UUID.randomUUID().toString(),"Pan Taduesz", a0.getAuthor_id(), l0.getLibrary_id());
//        cal.setTime(myDate);
//        cal.add(Calendar.YEAR, -182);
//        cal.add(Calendar.DATE, 10);
//        Books b2 = new Books(cal.getTime(),UUID.randomUUID().toString(),"Martwe Dusze", a1.getAuthor_id(), l1.getLibrary_id());
//        cal.setTime(myDate);
//        cal.add(Calendar.YEAR, -161);
//        Books b3 = new Books(cal.getTime(),null,"Wspomnienia z Domu Umarłych", a2.getAuthor_id(), l1.getLibrary_id());
//        cal.setTime(myDate);
//        cal.add(Calendar.YEAR, -3);
//        cal.add(Calendar.MONTH, 9);
//        Books b4 = new Books(cal.getTime(),UUID.randomUUID().toString(),"Idiota ver. 150", a2.getAuthor_id(), l2.getLibrary_id());
//
//        a0.getAuthor_books().add(b0);
//        a0.getAuthor_books().add(b1);
//        a1.getAuthor_books().add(b2);
//        a2.getAuthor_books().add(b3);
//        a2.getAuthor_books().add(b4);
//
//        l0.getBooks_in_library().add(b0);
//        l0.getBooks_in_library().add(b1);
//        l1.getBooks_in_library().add(b2);
//        l1.getBooks_in_library().add(b3);
//        l2.getBooks_in_library().add(b4);
//
//        booksService.saveBook(b0);
//        booksService.saveBook(b1);
//        booksService.saveBook(b2);
//        booksService.saveBook(b3);
//        booksService.saveBook(b4);
//
//        System.out.println(b1.getId());
//
//        Address ad0 = new Address("Pozań","Kurpińskiego", "11-111","Polska");
//        Address ad1 = new Address("Szczecin","Sowińskiego", "22-222","Polska");
//        Address ad2 = new Address("Madryt","C. de la Montera", "33-333","Hiszpania");
//
//        addressService.saveAddress(ad0);
//        addressService.saveAddress(ad1);
//        addressService.saveAddress(ad2);
//
//
//        //Person p0 = new Person("Jan",null,"Kowalski",b0.getId());
//        Person p1 = new Person("Adam","Henryk","Nowak",b1.getId(), ad0.getAddress_id());
//        Person p2 = new Person("Joanna","Patrycja","Jankowska",b3.getId(), ad1.getAddress_id());
//
//        p1.setBook(b1);
//        p2.setBook(b3);
//        p1.setAddress(ad0);
//        p2.setAddress(ad1);
//
//        //personService.savePerson(p0);
//        personService.savePerson(p1);
//        personService.savePerson(p2);
//
//
//        return "Model Generated";
//    }
//}
