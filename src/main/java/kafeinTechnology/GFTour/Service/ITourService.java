package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITourService {
    List<TourWithCityNamesOnRoute> getAll();
    TourWithCityNamesOnRoute get(int id);
    ResponseEntity add(Tour tour);
    ResponseEntity update(Tour tour);
    void delete(int id);
}
