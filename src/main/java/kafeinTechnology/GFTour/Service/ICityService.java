package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.Entities.City;

import java.util.List;

public interface ICityService {
    List<City> getAll();
    City get(int id);
    void add(City city);
    void update(City city);
    void delete(City city);
}
