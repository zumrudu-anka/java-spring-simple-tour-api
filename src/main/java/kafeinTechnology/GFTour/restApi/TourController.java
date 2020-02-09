package kafeinTechnology.GFTour.restApi;

import io.swagger.annotations.Api;
import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import kafeinTechnology.GFTour.Service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@Api(value = "Tour Controller")
public class TourController {

    private ITourService tourService;

    @Autowired
    public TourController(ITourService tourService){
        this.tourService = tourService;
    }

    @GetMapping("")
    public List<TourWithCityNamesOnRoute> getAll(){
        return tourService.getAll();
    }

    @GetMapping("/{id}")
    public TourWithCityNamesOnRoute get(@PathVariable int id){
        return tourService.get(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Tour tour){
        tourService.add(tour);
    }

    @PostMapping("/update")
    public void update(@RequestBody Tour tour){
        tourService.update(tour);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Tour tour){
        tourService.delete(tour);
    }

}
