package kafeinTechnology.GFTour.DataAccess;

import kafeinTechnology.GFTour.Entities.City;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateTourDal implements ITourDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateTourDal(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<TourWithCityNamesOnRoute> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Tour> tours = session.createQuery("from Tour").getResultList();
        ArrayList<TourWithCityNamesOnRoute> tourWithCityNamesOnRoutes = new ArrayList<>();
        List<City> cities = session.createQuery("from City").getResultList();
        for(Tour tour : tours){
            String[] route = tour.getRoute().trim().split(",");
            ArrayList<City> citiesOnRoute = new ArrayList<>();
            for(String city : route){
                citiesOnRoute.add(cities.get(Integer.parseInt(city) - 1));
            }
            tourWithCityNamesOnRoutes.add(
                    new TourWithCityNamesOnRoute(
                            tour.getId(),
                            tour.getName(),
                            tour.getDate(),
                            tour.getPrice(),
                            citiesOnRoute,
                            tour.getGuide()
                    )
            );
        }
        return tourWithCityNamesOnRoutes;
    }

    @Override
    @Transactional
    public TourWithCityNamesOnRoute get(int id) {
        Session session = entityManager.unwrap(Session.class);
        Tour tour = session.get(Tour.class, id);
        String[] route = tour.getRoute().trim().split(",");
        List<City> cities = session.createQuery("from City").getResultList();

        /// Solution 1
        /*String sql = "select name from City where id = " + route[0];
        if(route.length > 1){
            int i = 1;
            do{
                sql += " or id = " + route[i];
                i++;
            }while(route.length > i);
        List<City> cities = session.createQuery(sql).getResultList();
        }*/
        /// Solution 1

        /// Solution 2
        ArrayList<City> citiesOnRoute = new ArrayList<>();
        for(String city : route){
            citiesOnRoute.add(cities.get(Integer.parseInt(city) - 1));
        }
        /// Solution 2
        TourWithCityNamesOnRoute tourWithCityNamesOnRoute = new TourWithCityNamesOnRoute(
                tour.getId(),
                tour.getName(),
                tour.getDate(),
                tour.getPrice(),
                citiesOnRoute,
                tour.getGuide()
        );
        return tourWithCityNamesOnRoute;
    }

    @Override
    @Transactional
    public ResponseEntity add(Tour tour) {
        try {
            Session session = entityManager.unwrap(Session.class);
            List<City> cities = session.createQuery("from City").getResultList();
            String[] route = tour.getRoute().trim().split(",");
            try{
                for (String city : route){
                    cities.get(Integer.parseInt(city));
                }
            }
            catch (Exception ex){
                return new ResponseEntity("Route Values Must Exist in the City Table. Please Check from City Controller", HttpStatus.BAD_REQUEST);
            }
            Guide guide = session.get(Guide.class, tour.getGuide().getId());
            if(guide == null){
                if(tour.getGuide().getName() == null || tour.getGuide().getGender() == null || tour.getGuide().getSurname() == null){
                    return new ResponseEntity("All Guide Information Required", HttpStatus.BAD_REQUEST);
                }
                else if(tour.getGuide().getExperience() < 0){
                    return new ResponseEntity("Experience must be equal or bigger than zero", HttpStatus.BAD_REQUEST);
                }
                else if(!tour.getGuide().getGender().matches("^[Ee][Rr][Kk][Ee][Kk]|[Kk][Aa][Dd][Iı][Nn]$")){
                    return new ResponseEntity("Guide gender can only include these values -> Erkek|Kadın", HttpStatus.BAD_REQUEST);
                }
                session.save(tour.getGuide());
            }
            session.save(tour);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public ResponseEntity update(Tour tour) {
        try {
            Session session = entityManager.unwrap(Session.class);
            List<City> cities = session.createQuery("from City").getResultList();
            String[] route = tour.getRoute().trim().split(",");
            try{
                for (String city : route){
                    cities.get(Integer.parseInt(city));
                }
            }
            catch (Exception ex){
                return new ResponseEntity("Route Values Must Exist in the City Table. Please Check from City Controller", HttpStatus.BAD_REQUEST);
            }
            Guide guide = session.get(Guide.class, tour.getGuide().getId());
            if(guide == null){
                if(tour.getGuide().getName() == null || tour.getGuide().getGender() == null || tour.getGuide().getSurname() == null){
                    return new ResponseEntity("All Guide Information Required", HttpStatus.BAD_REQUEST);
                }
                else if(tour.getGuide().getExperience() < 0){
                    return new ResponseEntity("Experience must be equal or bigger than zero", HttpStatus.BAD_REQUEST);
                }
                else if(!tour.getGuide().getGender().matches("^[Ee][Rr][Kk][Ee][Kk]|[Kk][Aa][Dd][Iı][Nn]$")){
                    return new ResponseEntity("Guide gender can only include these values -> Erkek|Kadın", HttpStatus.BAD_REQUEST);
                }
                session.save(tour.getGuide());
            }
            session.saveOrUpdate(tour);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Tour tourForDelete = session.get(Tour.class, id);
        session.delete(tourForDelete);
    }
}
