package kafeinTechnology.GFTour.Service;

import org.springframework.http.ResponseEntity;

import kafeinTechnology.GFTour.Entities.Guide;

/**
 * ICheckService
 */
public interface ICheckService {

    boolean guideGenderValidity(Guide guide);

}