package immobilier.app.Belongings;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/properties")
@RestController
public class PropertiesController {

    private final PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping
    public List<Properties> getProperties(){

      return  propertiesService.getProperties();
    }

    @GetMapping("/{id}")
    public Optional<Properties> getAProperty(Long id){
         return propertiesService.getAProperty(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProperty(@RequestBody Properties properties){

        propertiesService.newProperty(properties);
    }

    @PutMapping(path = "{id}")
    public void updateProperty(@PathVariable Long id,@RequestBody Properties properties){
        propertiesService.updateProp(id, properties);
    }

}
