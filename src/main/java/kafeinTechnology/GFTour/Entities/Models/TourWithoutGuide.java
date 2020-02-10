package kafeinTechnology.GFTour.Entities.Models;
import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "This Model isn't in Database. Created for get Tours without the guide information.")
public class TourWithoutGuide {
    private int id;
    private String name;
    private Date date;
    private BigDecimal price;
    private String route;

    public TourWithoutGuide() {
    }

    public TourWithoutGuide(int id, String name, Date date, BigDecimal price, String route) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.route = route;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
