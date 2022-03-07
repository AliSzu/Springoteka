package Pracownia.Projekt.Spring.Entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refLibraryId", scope=Books.class)
@Table(name = "Library")
public class Library {
    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator="my_seqLibraries")
    @SequenceGenerator(name="my_seqLibraries",sequenceName="myseq_Libraries", allocationSize=1)
    int library_id;

    @Column(name = "city")
    String city;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    private Set<Books> books_in_library = new HashSet<Books>();

    //Constructor
    public Library(String city, String name)
    {
        this.city = city;
        this.name = name;
    }

    public Library(){};

    //Getter and Setters
    private void removeAssociationsWithChilds() {
        for (Books b: books_in_library) {
            b.setLibrary_id(null);
        }}


    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooks_in_library() {
        return books_in_library;
    }

    public void setBooks_in_library(Set<Books> books_in_library) {
        this.books_in_library = books_in_library;
    }
}
