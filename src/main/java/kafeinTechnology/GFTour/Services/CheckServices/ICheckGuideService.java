package kafeinTechnology.GFTour.Services.CheckServices;

import kafeinTechnology.GFTour.Entities.Guide;

@FunctionalInterface
public interface ICheckGuideService {
    boolean check(Guide guide);
}
