package kafeinTechnology.GFTour.Services;

import kafeinTechnology.GFTour.DataAccess.IGuideDal;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import kafeinTechnology.GFTour.Services.CheckServices.CheckGuideManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuideManager implements IGuideService {

    private IGuideDal guideDal;
    private CheckGuideManager checkGuideManager;

    public GuideManager(IGuideDal guideDal){
        this.guideDal = guideDal;
        this.checkGuideManager = new CheckGuideManager();
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
        if(!checkGuideManager.checker(checkGuideManager.isValidGender(), guide)){
            return new ResponseEntity("Gender can only include these values -> Erkek|Kadın", HttpStatus.BAD_REQUEST);
        }
        else if(!checkGuideManager.checker(checkGuideManager.isValidExperience(), guide)){
            return new ResponseEntity("Experience must be equal or bigger than zero", HttpStatus.BAD_REQUEST);
        }
        guideDal.add(guide);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity update(Guide guide) {
        if(!checkGuideManager.checker(checkGuideManager.isValidGender(), guide)){
            return new ResponseEntity("Gender can only include these values -> Erkek|Kadın", HttpStatus.BAD_REQUEST);
        }
        else if(!checkGuideManager.checker(checkGuideManager.isValidExperience(), guide)){
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
