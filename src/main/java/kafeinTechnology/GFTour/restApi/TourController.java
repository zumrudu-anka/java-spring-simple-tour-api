package kafeinTechnology.GFTour.restApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kafeinTechnology.GFTour.Entities.Models.TourWithCityNamesOnRoute;
import kafeinTechnology.GFTour.Entities.Tour;
import kafeinTechnology.GFTour.Service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@Api(tags = {"Tour Controller"})
public class TourController {

    private ITourService tourService;

    @Autowired
    public TourController(ITourService tourService){
        this.tourService = tourService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Tours", notes = "<strong>This Method Return All Tours in Database</strong><br>" +
                                                    "<ol>" +
                                                    "<li> Click the Try it out button.</li>" +
                                                    "<li> Click the Execute button.</li>" +
                                                    "</ol>")
    public List<TourWithCityNamesOnRoute> getAll(){
        return tourService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Tour By Id", notes = "<strong>This Method Return Tour By Id</strong><br>" +
                                                    "<ol>" +
                                                    "<li>Click the Try it out button.</li>" +
                                                    "<li>Write the id number of the Tour which you want.</li>" +
                                                    "<li>Click the Execute button.</li>" +
                                                    "</ol>")
    public TourWithCityNamesOnRoute get(@PathVariable int id){
        return tourService.get(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add New Tour",  notes = "<strong>This is Tour Add Method in Tour Controller</strong><br>" +
                                                    "<ol>" +
                                                    "<li> Click the Try it out button.</li>" +
                                                    "<li> Write the Tour informations into the text area like this example which you see.</li>" +
                                                    "<li> Click the Execute button.</li>" +
                                                    "</ol>" +
                                                    "<strong>Notes: </strong>" +
                                                    "<ul>" +
                                                    "<li>Id is auto generated value for this object, so it is optional.</li>" +
                                                    "<li>Guide gender can only include these values -> Erkek|Kadın</li>" +
                                                    "<li>You can write only guide id on the guide information. If there is no guide with this id in the database you must write guide name, surname and gender.</li>" +
                                                    "<li>Guide experience must be equal or greater than zero.</li>" +
                                                    "<li>Route Must Include City Ids Which Seperated By Comma.</li>" +
                                                    "<li>Route values must exist in city table.</li>" +
                                                    "</ul>")
    public ResponseEntity add(@RequestBody Tour tour){
        return tourService.add(tour);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update The Tour",  notes =   "<strong>This is Tour Update Method in Tour Controller</strong><br>" +
                                                        "<ol>" +
                                                        "<li> Click the Try it out button.</li>" +
                                                        "<li> Write the Tour informations into the text area like this example which you see.</li>" +
                                                        "<li> Click the Execute button.</li>" +
                                                        "</ol>" +
                                                        "<strong>Notes: </strong>" +
                                                        "<ul>" +
                                                        "<li>If you don't write id, this method will create a new Tour.</li>" +
                                                        "<li>Guide gender can only include these values -> Erkek|Kadın</li>" +
                                                        "<li>You can write only guide id on the guide information. If there is no guide with this id in the database you must write guide name, surname and gender.</li>" +
                                                        "<li>Guide experience must be equal or greater than zero.</li>" +
                                                        "<li>Route Must Include City Ids Which Seperated By Comma.</li>" +
                                                        "<li>Route values must exist in city table.</li>" +
                                                        "</ul>")
    public ResponseEntity update(@RequestBody Tour tour){
        return tourService.update(tour);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete The Tour", notes =   "<strong>This is Tour Delete Method in Tour Controller</strong><br>" +
                                                        "<ol>" +
                                                        "<li>Click the Try it out button.</li>" +
                                                        "<li>Write the id of the Tour which you want delete into the text area.</li>" +
                                                        "<li>Click the Execute button.</li>" +
                                                        "</ol>")
    public void delete(@RequestBody int id){
        tourService.delete(id);
    }

}
