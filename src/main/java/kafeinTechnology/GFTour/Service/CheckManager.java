package kafeinTechnology.GFTour.Service;

import kafeinTechnology.GFTour.Entities.Guide;

/**
 * CheckManager
 */
public class CheckManager implements ICheckService{
    
    @Override
    public boolean guideGenderValidity(Guide guide) {
        if(guide.getGender().matches("^[Ee][Rr][Kk][Ee][Kk]|[Kk][Aa][Dd][Iı][Nn]$")){
            return true;
        }
        return false;
    }
}