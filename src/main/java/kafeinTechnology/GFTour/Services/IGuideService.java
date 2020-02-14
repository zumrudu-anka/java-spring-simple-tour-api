package kafeinTechnology.GFTour.Services;

import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGuideService {
    List<Guide> getAll();
    Guide get(int id);
    GuideWithTours getGuideWithTours(int id);
    ResponseEntity add(Guide guide);
    ResponseEntity update(Guide guide);
    void delete(int id);
}
