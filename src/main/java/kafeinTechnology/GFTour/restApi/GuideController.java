package kafeinTechnology.GFTour.restApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import kafeinTechnology.GFTour.Services.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@Api(tags = {"Guide Controller"})
public class GuideController {

    private IGuideService guideService;

    @Autowired
    public GuideController(IGuideService guideService){
        this.guideService = guideService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Guides", notes = "<strong>This Method Return All Guides in Database</strong><br>" +
                                                    "<ol>" +
                                                    "<li> Click the Try it out button.</li>" +
                                                    "<li> Click the Execute button.</li>" +
                                                    "</ol>")
    public List<Guide> getAll(){
        return guideService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Guide By Id", notes = "<strong>This Method Return Guide By Id</strong><br>" +
                                                     "<ol>" +
                                                     "<li>Click the Try it out button.</li>" +
                                                     "<li>Write the id number of the guide which you want.</li>" +
                                                     "<li>Click the Execute button.</li>" +
                                                     "</ol>")
    public Guide get(@PathVariable int id){
        return guideService.get(id);
    }

    @GetMapping("/getGuideWithTours/{id}")
    @ApiOperation(value = "Get Guide By Id With All Tours", notes = "<strong>This Method Return Guide By Id With All Tours of This Guide</strong><br>" +
                                                                    "<ol>" +
                                                                    "<li>Click the Try it out button.</li>" +
                                                                    "<li>Write the id number of the Guide which you want.</li>" +
                                                                    "<li>Click the Execute button.</li>" +
                                                                    "</ol>")
    public GuideWithTours getGuideWithTours(@PathVariable int id){
        return guideService.getGuideWithTours(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add New Guide",  notes = "<strong>This is Guide Add Method in Guide Controller</strong><br>" +
                                                    "<ol>" +
                                                    "<li> Click the Try it out button.</li>" +
                                                    "<li> Write the guide informations into the text area like this example which you see.</li>" +
                                                    "<li> Click the Execute button.</li>" +
                                                    "</ol>" +
                                                    "<strong>Notes: </strong>" +
                                                    "<ul>" +
                                                    "<li>Id is auto generated value for this object, so it is optional.</li>" +
                                                    "<li>Gender can only include these values -> Erkek|Kadın</li>" +
                                                    "<li>Guide experience must be equal or greater than zero.</li>" +
                                                    "</ul>")
    public ResponseEntity add(@RequestBody Guide guide){
        return guideService.add(guide);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update The Guide",  notes = "<strong>This is Guide Update Method in Guide Controller</strong><br>" +
                                                    "<ol>" +
                                                    "<li> Click the Try it out button.</li>" +
                                                    "<li> Write the guide informations into the text area like this example which you see.</li>" +
                                                    "<li> Click the Execute button.</li>" +
                                                    "</ol>" +
                                                    "<strong>Notes: </strong>" +
                                                    "<ul>" +
                                                    "<li>If you don't write id, this method will create a new Guide.</li>" +
                                                    "<li>Gender can only include these values -> Erkek|Kadın</li>" +
                                                    "<li>Guide experience must be equal or greater than zero.</li>" +
                                                    "</ul>")
    public ResponseEntity update(@RequestBody Guide guide){
        return guideService.update(guide);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete The Guide", notes = "<strong>This is Guide Delete Method in Guide Controller</strong><br>" +
                                                     "<ol>" +
                                                     "<li>Click the Try it out button.</li>" +
                                                     "<li>Write the id of the Guide which you want delete into the text area.</li>" +
                                                     "<li>Click the Execute button.</li>" +
                                                     "</ol>")
    public void delete(@RequestBody int id){
        guideService.delete(id);
    }
}
