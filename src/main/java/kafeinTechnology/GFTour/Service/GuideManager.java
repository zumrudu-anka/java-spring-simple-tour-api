package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.DataAccess.IGuideDal;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuideManager implements IGuideService {

    private IGuideDal guideDal;

    @Autowired
    public GuideManager(IGuideDal guideDal){
        this.guideDal = guideDal;
    }

    @Override
    @Transactional
    public List<Guide> getAll() {
        return guideDal.getAll();
    }

    @Override
    @Transactional
    public Guide get(int id) {
        return guideDal.get(id);
    }

    @Override
    @Transactional
    public void add(Guide guide) {
        guideDal.add(guide);
    }

    @Override
    @Transactional
    public void update(Guide guide) {
        guideDal.update(guide);
    }

    @Override
    @Transactional
    public void delete(Guide guide) {
        guideDal.delete(guide);
    }

    @Transactional
    public GuideWithTours getGuideWithTours(int id) {
        return guideDal.getGuideWithTours(id);
    }
}
