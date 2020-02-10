package kafeinTechnology.GFTour.Entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "auto generated")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "route", nullable = false)
    private String route;   /// I seperate to city id numbers with comma that in this route ( like this ->>> 4, 9, 1,... )
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guideId", nullable = false)
    private Guide guide;

    public Tour() {
    }

    public Tour(int id, String name, Date date, BigDecimal price, String route, Guide guide) {
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}
