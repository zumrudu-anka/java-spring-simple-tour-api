package kafeinTechnology.GFTour.Services.CheckServices;

import kafeinTechnology.GFTour.Entities.Guide;

public class CheckGuideManager {
    public static boolean checker(final ICheckGuideService operation, final Guide guide) {
        return operation.check(guide);
    }

    public static ICheckGuideService isValidGender() {
        return guide -> {
            return guide.getGender().matches("^[Ee][Rr][Kk][Ee][Kk]|[Kk][Aa][Dd][Iı][Nn]$");
        };
    }

    public static ICheckGuideService isValidExperience(){
        return guide -> {
            return guide.getExperience() >= 0;
        };
    }
}
