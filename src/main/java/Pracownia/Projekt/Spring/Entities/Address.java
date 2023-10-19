//package Pracownia.Projekt.Spring.Entities;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import javax.persistence.*;
//
//@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
//        property="refAddrId", scope=Books.class)
//@Table(name = "Address")
//public class Address {
//    @Id
//    @Column(name = "address_id")
//    @GeneratedValue(generator="my_seqAddress")
//    @SequenceGenerator(name="my_seqAddress",sequenceName="myseq_Address", allocationSize=1)
//    private int address_id;
//
//    @Column(name = "city")
//    private String city;
//
//    @Column(name = "street")
//    private String street;
//
//    @Column(name = "postal_code")
//    private String postal_code;
//
//    @Column(name = "country")
//    private String country;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
//    private Person person;
//
//    //Constructors
//    public Address(){};
//
//    public Address(String city, String street, String postal_code, String country) {
//        this.city = city;
//        this.street = street;
//        this.postal_code = postal_code;
//        this.country = country;
//    }
//
//    //Getters and Setters
//
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getPostal_code() {
//        return postal_code;
//    }
//
//    public void setPostal_code(String postal_code) {
//        this.postal_code = postal_code;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public int getAddress_id() {
//        return address_id;
//    }
//
//    public void setAddress_id(int address_id) {
//        this.address_id = address_id;
//    }
//}
