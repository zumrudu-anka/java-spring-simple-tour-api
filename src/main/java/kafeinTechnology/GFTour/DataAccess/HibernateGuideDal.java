package kafeinTechnology.GFTour.DataAccess;

import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import kafeinTechnology.GFTour.Entities.Models.TourWithoutGuide;
import kafeinTechnology.GFTour.Entities.Tour;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateGuideDal implements IGuideDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateGuideDal(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Guide> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Guide> guides = session.createQuery("from Guide").getResultList();
        return guides;
    }

    @Override
    @Transactional
    public Guide get(int id) {
        Session session = entityManager.unwrap(Session.class);
        Guide guide = session.get(Guide.class, id);
        return guide;
    }

    @Override
    @Transactional
    public GuideWithTours getGuideWithTours(int id) {
        Session session = entityManager.unwrap(Session.class);
        Guide guide = session.get(Guide.class, id);
        List<Tour> tours = session.createQuery("from Tour where guide_id = ?0")
                .setParameter(0, id)
                .getResultList();
        ArrayList<TourWithoutGuide> ToursWithoutGuide = new ArrayList<>();
        for(Tour tour : tours){
            ToursWithoutGuide.add(
                    new TourWithoutGuide(
                            tour.getId(),
                            tour.getName(),
                            tour.getDate(),
                            tour.getPrice(),
                            tour.getRoute()
                    )
            );
        }
        GuideWithTours guideWithTours = new GuideWithTours(guide, ToursWithoutGuide);
        return guideWithTours;
    }

    @Override
    @Transactional
    public void add(Guide guide) {
        Session session = entityManager.unwrap(Session.class);
        session.save(guide);
    }

    @Override
    @Transactional
    public void update(Guide guide) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(guide);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Guide guideForDelete = session.get(Guide.class, id);
        session.delete(guideForDelete);
    }
}
