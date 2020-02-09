package kafeinTechnology.GFTour.DataAccess;

import kafeinTechnology.GFTour.Entities.City;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void add(Tour tour) {
        Session session = entityManager.unwrap(Session.class);
        Guide guide = session.get(Guide.class, tour.getGuide().getId());
        if(guide == null){
            session.save(tour.getGuide());
        }
        session.save(tour);
    }

    @Override
    @Transactional
    public void update(Tour tour) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(tour);
    }

    @Override
    @Transactional
    public void delete(Tour tour) {
        Session session = entityManager.unwrap(Session.class);
        Tour tourForDelete = session.get(Tour.class, tour.getId());
        session.delete(tourForDelete);
    }
}
