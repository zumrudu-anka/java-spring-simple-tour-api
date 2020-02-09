package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;

import java.util.List;

public interface IGuideService {
    List<Guide> getAll();
    Guide get(int id);
    GuideWithTours getGuideWithTours(int id);
    void add(Guide guide);
    void update(Guide guide);
    void delete(Guide guide);
}
