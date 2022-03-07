package Pracownia.Projekt.Spring.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refAuthorId", scope=Books.class)
@Table(name = "Authors")
public class Authors {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(generator="my_seqAuthors")
    @SequenceGenerator(name="my_seqAuthors",sequenceName="myseq_Authors", allocationSize=1)
    int author_id;

    @Column(name = "name")
    String name;

    @Column(name = "last_name")
    String last_name;

    //@Column(name = "death_date")
    //Date death_date;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Books> author_books = new HashSet<Books>();

    //Constructor
    public Authors(){}

    public Authors(String name, String last_name, Date death_day) {
        //this.author_id = author_id;
        this.name = name;
        this.last_name = last_name;
        //this.death_date = death_day;
        //this.author_books = author_books;
    }

    //Getter and Setters


    /*public Date getDeath_date() {
        return death_date;
    }

    public void setDeath_date(Date death_date) {
        this.death_date = death_date;
    }*/

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Books> getAuthor_books() {
        return author_books;
    }

    public void setAuthor_books(Set<Books> auhtor_books) {
        this.author_books = auhtor_books;
    }
}
