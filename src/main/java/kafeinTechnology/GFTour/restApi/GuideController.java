package kafeinTechnology.GFTour.restApi;

import io.swagger.annotations.Api;
import kafeinTechnology.GFTour.Entities.Guide;
import kafeinTechnology.GFTour.Entities.Models.GuideWithTours;
import kafeinTechnology.GFTour.Service.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@Api(value = "Guide Controller")
public class GuideController {

    private IGuideService guideService;

    @Autowired
    public GuideController(IGuideService guideService){
        this.guideService = guideService;
    }

    @GetMapping("")
    public List<Guide> getAll(){
        return guideService.getAll();
    }

    @GetMapping("/{id}")
    public Guide get(@PathVariable int id){
        return guideService.get(id);
    }

    @GetMapping("/getGuideWithTours/{id}")
    public GuideWithTours getGuideWithTours(@PathVariable int id){
        return guideService.getGuideWithTours(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Guide guide){
        guideService.add(guide);
    }

    @PostMapping("/update")
    public void update(@RequestBody Guide guide){
        guideService.update(guide);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Guide guide){
        guideService.delete(guide);
    }
}
