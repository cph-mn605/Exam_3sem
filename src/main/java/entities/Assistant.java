package entities;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "Assistant.getAllRows", query = "SELECT a from Assistant a")
})

@Table(name = "assistant")
@Entity
public class Assistant implements Serializable {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="language")
    private String language;

    @Column(name="yearExperience")
    private int yearExperience;

    @Column(name="priceHour")
    private int priceHour;

    //constructor
    public Assistant() {
    }

    public Assistant(String name, String language, int yearExperience, int priceHour) {
        this.name = name;
        this.language = language;
        this.yearExperience = yearExperience;
        this.priceHour = priceHour;
    }

    //GETTER/SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }
}