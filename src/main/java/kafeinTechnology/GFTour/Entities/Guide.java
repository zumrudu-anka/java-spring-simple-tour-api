package kafeinTechnology.GFTour.Entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Guide")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "auto generated")
    private int id;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(required = true)
    private String name;

    @Column(name = "surname", nullable = false)
    @ApiModelProperty(required = true)
    private String surname;

    @Column(name = "experience", nullable = false)
    @ApiModelProperty(notes = "Must be equal or bigger than zero")
    private int experience;

    @Column(name = "gender", nullable = false)
    @ApiModelProperty(required = true, notes = "Can only include these values -> Erkek|Kadın")
    private String gender;

    @OneToMany(mappedBy = "guide", cascade = CascadeType.REMOVE)
    private List<Tour> tours;

    public Guide() {
    }

    public Guide(int id, String name, String surname, int experience, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
