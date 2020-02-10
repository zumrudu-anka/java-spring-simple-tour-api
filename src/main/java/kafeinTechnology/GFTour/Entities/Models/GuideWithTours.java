package kafeinTechnology.GFTour.Entities.Models;

import io.swagger.annotations.ApiModel;
import kafeinTechnology.GFTour.Entities.Guide;

import java.util.List;

@ApiModel(description = "This Model isn't in Database. Created for get Guide with the all tours.")
public class GuideWithTours {
    private int id;
    private String name;
    private String surname;
    private int experience;
    private String gender;
    private List<TourWithoutGuide> tours;

    public GuideWithTours(Guide guide, List<TourWithoutGuide> tours) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<TourWithoutGuide> getTours() {
        return tours;
    }

    public void setTours(List<TourWithoutGuide> tours) {
        this.tours = tours;
    }
}
