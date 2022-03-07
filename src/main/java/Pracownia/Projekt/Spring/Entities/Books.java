package Pracownia.Projekt.Spring.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.joda.time.DateTime;

import javax.persistence.*;
import Pracownia.Projekt.Spring.Entities.Authors;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Books.class)
@Table(name = "Books")
public class Books {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="my_seq")
    @SequenceGenerator(name="my_seq",sequenceName="myseq", allocationSize=1)
    int id;

    //@Id @GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ISBN", unique = true)
    String ISBN;

    @Column(name = "title")
    String title;


   @Column(name = "author_id")
   private Integer authorid;

   @Column(name ="library_id")
   private Integer libraryId;

   @Column(name="publication_date")
   private Date publication_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", insertable=false, updatable=false, nullable = true)
    private Authors author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id",insertable=false, updatable=false)
    private Library library;

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
   private Person person;

    //constructor
    public Books() {
    }

    public Books(Date publication_date,String book_id, String title, int author_id, Integer library_id) {
        this.publication_date = publication_date;
        this.ISBN = book_id;
        this.title = title;
        this.authorid = author_id;
        this.libraryId = library_id;
    }

    //getters and setters


    /*public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

   public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }*/

    /*public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/

    public int getId(){return id;}

    public void setId(int id){ this.id = id;}

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Integer getLibrary_id() {
        return libraryId;
    }

    public void setLibrary_id(Integer library_id) {
        this.libraryId = library_id;
    }

    }

