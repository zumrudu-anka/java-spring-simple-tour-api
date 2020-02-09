package kafeinTechnology.GFTour.Entities.Models;

import kafeinTechnology.GFTour.Entities.City;
import kafeinTechnology.GFTour.Entities.Guide;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TourWithCityNamesOnRoute {
    private int id;
    private String name;
    private Date date;
    private BigDecimal price;
    private List<City> route;   /// I seperate to city id numbers with comma that in this route ( like this ->>> 4, 9, 1,... )
    private Guide guide;

    public TourWithCityNamesOnRoute(int id, String name, Date date, BigDecimal price, List<City> route, Guide guide) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.route = route;
        this.guide = guide;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<City> getRoute() {
        return route;
    }

    public void setRoute(List<City> route) {
        this.route = route;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}
