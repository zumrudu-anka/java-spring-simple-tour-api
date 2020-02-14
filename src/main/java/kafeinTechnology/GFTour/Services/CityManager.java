package kafeinTechnology.GFTour.Services;

import kafeinTechnology.GFTour.DataAccess.ICityDal;
import kafeinTechnology.GFTour.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityManager implements ICityService {

    private ICityDal cityDal;

    @Autowired
    public CityManager(ICityDal cityDal){
        this.cityDal = cityDal;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        return cityDal.getAll();
    }

    @Override
    @Transactional
    public City get(int id) {
        return cityDal.get(id);
    }

    @Override
    @Transactional
    public void add(City city) {
        cityDal.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        cityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(int id) {
        cityDal.delete(id);
    }
}
