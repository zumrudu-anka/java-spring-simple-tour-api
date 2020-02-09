package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.DataAccess.ITourDal;
import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TourManager implements ITourService {

    private ITourDal tourDal;

    @Autowired
    public TourManager(ITourDal tourDal){
        this.tourDal = tourDal;
    }

    @Override
    @Transactional
    public List<TourWithCityNamesOnRoute> getAll() {
        return tourDal.getAll();
    }

    @Override
    @Transactional
    public TourWithCityNamesOnRoute get(int id) {
        return tourDal.get(id);
    }

    @Override
    @Transactional
    public void add(Tour tour) {
        tourDal.add(tour);
    }

    @Override
    @Transactional
    public void update(Tour tour) {
        tourDal.update(tour);
    }

    @Override
    @Transactional
    public void delete(Tour tour) {
        tourDal.delete(tour);
    }
}
