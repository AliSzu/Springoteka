//package Pracownia.Projekt.Spring.Entities;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import javax.persistence.*;
//
//@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
//        property="refPersonId", scope=Books.class)
//@Table(name = "Person")
//public class Person {
//    @Id
//    @Column(name = "person_id")
//    @GeneratedValue(generator="my_seqPerson")
//    @SequenceGenerator(name="my_seqPerson",sequenceName="myseq_Person", allocationSize=1)
//    private int person_id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "second_name")
//    private String second_name;
//
//    @Column(name = "last_name")
//    private String last_name;
//
//    @Column(name = "book_id")
//    private Integer book_id;
//
//    @Column(name = "address_id", updatable=false)
//    private Integer address_id;
//
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id",insertable=false, updatable=false)
//    private Books book;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id",insertable=false, updatable=false)
//    private Address address;
//
//    //Constructors
//    public Person(){};
//
//    public Person(String name, String second_name, String last_name, Integer book_id, Integer address_id)
//    {
//        this.name = name;
//        this.second_name = second_name;
//        this.last_name = last_name;
//        this.book_id = book_id;
//        this.address_id = address_id;
//    }
//
//    //Getters and Setters
//
//
//    public Books getBook() {return book;}
//
//    public void setBook(Books book) {this.book = book;}
//
//    public Address getAddress() {return address;}
//
//    public void setAddress(Address address) {this.address = address;}
//
//    public int getPerson_id() {
//        return person_id;
//    }
//
//    public void setPerson_id(int person_id) {
//        this.person_id = person_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSecond_name() {
//        return second_name;
//    }
//
//    public void setSecond_name(String second_name) {
//        this.second_name = second_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public Integer getBook_id() {
//        return book_id;
//    }
//
//    public void setBook_id(Integer book_id) {
//        this.book_id = book_id;
//    }
//
//    public Integer getAddress_id() {
//        return address_id;
//    }
//
//    public void setAddress_id(Integer address_id) {
//        this.address_id = address_id;
//    }
//}
//
