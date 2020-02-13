package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.DataAccess.IGuideDal;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuideManager implements IGuideService {

    private IGuideDal guideDal;
    private ICheckService checkService;

    public GuideManager(IGuideDal guideDal){
        this.guideDal = guideDal;
        this.checkService = new CheckManager();
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
    public ResponseEntity add(Guide guide) {
        if(!checkService.guideGenderValidity(guide)){
            return new ResponseEntity("Gender can only include these values -> Erkek|Kadın", HttpStatus.BAD_REQUEST);
        }
        else if(guide.getExperience() < 0){
            return new ResponseEntity("Experience must be equal or bigger than zero", HttpStatus.BAD_REQUEST);
        }
        guideDal.add(guide);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity update(Guide guide) {
        if(!checkService.guideGenderValidity(guide)){
            return new ResponseEntity("Gender can only include these values -> Erkek|Kadın", HttpStatus.BAD_REQUEST);
        }
        else if(guide.getExperience() < 0){
            return new ResponseEntity("Experience must be equal or bigger than zero", HttpStatus.BAD_REQUEST);
        }
        guideDal.update(guide);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @Transactional
    public void delete(int id) {
        guideDal.delete(id);
    }

    @Transactional
    public GuideWithTours getGuideWithTours(int id) {
        return guideDal.getGuideWithTours(id);
    }
}
