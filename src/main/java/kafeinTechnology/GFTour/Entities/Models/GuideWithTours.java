package kafeinTechnology.GFTour.Entities.Models;

import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Tour;

import java.util.List;

public class GuideWithTours {
    private int id;
    private String name;
    private String surname;
    private int experience;
    private byte gender; // 0 -> Man  ---- 1 -> Woman
    private List<Tour> tours;

    public GuideWithTours(Guide guide, List<Tour> tours) {
        this.id = guide.getId();
        this.name = guide.getName();
        this.surname = guide.getSurname();
        this.experience = guide.getExperience();
        this.gender = guide.getGender();
        this.tours = tours;
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

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
