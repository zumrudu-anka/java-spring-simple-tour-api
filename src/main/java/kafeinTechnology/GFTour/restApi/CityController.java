package kafeinTechnology.GFTour.restApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kafeinTechnology.GFTour.Entities.City;
import kafeinTechnology.GFTour.Service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@Api(value = "City Controller")
public class CityController {

    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Cities", notes = "This Method Return All Cities in Database")
    public List<City> getAll(){
        return this.cityService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get City By Id", notes = "This Method Return City By Id")
    public City get(@PathVariable int id){
        return this.cityService.get(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add New City", notes = "This is City Add Method in City Controller")
    public void add(@RequestBody @ApiParam(value = "City") City city){
        this.cityService.add(city);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update The City", notes = "This is City Update Method in City Controller")
    public void update(@RequestBody @ApiParam(value = "City") City city){
        this.cityService.update(city);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete The City", notes = "This is City Delete Method in City Controller")
    public void delete(@RequestBody @ApiParam(value = "City") City city){
        this.cityService.delete(city);
    }

}
