package kafeinTechnology.GFTour.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Guide")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "experience")
    private int experience;

    @Column(name = "gender")
    private byte gender; // 0 -> Man  ---- 1 -> Woman

    @OneToMany(mappedBy = "guide", cascade = CascadeType.REMOVE)
    private List<Tour> tours;

    public Guide() {
    }

    public Guide(int id, String name, String surname, int experience, byte gender) {
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

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }
}
