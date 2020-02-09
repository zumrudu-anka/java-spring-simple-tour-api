package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;

import java.util.List;

public interface ITourService {
    List<TourWithCityNamesOnRoute> getAll();
    TourWithCityNamesOnRoute get(int id);
    void add(Tour tour);
    void update(Tour tour);
    void delete(Tour tour);
}
