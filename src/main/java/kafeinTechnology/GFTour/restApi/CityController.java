package kafeinTechnology.GFTour.restApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kafeinTechnology.GFTour.Entities.City;
import kafeinTechnology.GFTour.Services.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@Api(tags={"City Controller"})
public class CityController {

    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Cities", notes = "<strong>This Method Return All Cities in Database</strong><br>" +
                                                    "<ol>" +
                                                    "<li> Click the Try it out button.</li>" +
                                                    "<li> Click the Execute button.</li>" +
                                                    "</ol>")
    public List<City> getAll(){
        return this.cityService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get City By Id", notes = "<strong>This Method Return City By Id</strong><br>" +
                                                    "<ol>" +
                                                    "<li>Click the Try it out button.</li>" +
                                                    "<li>Write the id number of the city which you want.</li>" +
                                                    "<li>Click the Execute button.</li>" +
                                                    "</ol>")
    public City get(@PathVariable int id){
        return this.cityService.get(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add New City", notes = "<strong>This is City Add Method in City Controller</strong><br>" +
                                                  "<ol>" +
                                                  "<li> Click the Try it out button.</li>" +
                                                  "<li> Write the city id and city name into the text area like this example which you see.</li>" +
                                                  "<li> Click the Execute button.</li>" +
                                                  "</ol>" +
                                                  "<strong>Note: </strong>Id is auto generated value for this object, so it is optional.")
    public void add(@RequestBody @ApiParam(value = "City") City city){
        this.cityService.add(city);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update The City", notes = "<strong>This is City Update Method in City Controller</strong><br>" +
                                                     "<ol>" +
                                                     "<li> Click the Try it out button.</li>" +
                                                     "<li> Write the city id and city name into the text area like this example which you see.</li>" +
                                                     "<li> Click the Execute button.</li>" +
                                                     "</ol>" +
                                                     "<strong>Note: </strong>If you don't write id, this method will create a new city.")
    public void update(@RequestBody @ApiParam(value = "City") City city){
        this.cityService.update(city);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete The City", notes = "<strong>This is City Delete Method in City Controller</strong><br>" +
                                                     "<ol>" +
                                                     "<li>Click the Try it out button.</li>" +
                                                     "<li>Write the id of the City which you want delete into the text area.</li>" +
                                                     "<li>Click the Execute button.</li>" +
                                                     "</ol>")
    public void delete(@RequestBody @ApiParam(value = "City Id") int id){
        this.cityService.delete(id);
    }

}
