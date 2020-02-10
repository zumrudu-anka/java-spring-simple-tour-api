package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.DataAccess.ITourDal;
import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity add(Tour tour) {
        try{
            String[] arrayForTryRouteSplitAndParseInt = tour.getRoute().trim().split(",");
            for (String route : arrayForTryRouteSplitAndParseInt){
                Integer.parseInt(route);
            }
            return tourDal.add(tour);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity("Route Must Include City Ids Which Seperated By Comma", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public ResponseEntity update(Tour tour) {
        try{
            String[] arrayForTryRouteSplitAndParseInt = tour.getRoute().trim().split(",");
            for (String route : arrayForTryRouteSplitAndParseInt){
                Integer.parseInt(route);
            }
            return tourDal.update(tour);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity("Route Must Include City Ids Which Seperated By Comma", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        tourDal.delete(id);
    }
}
