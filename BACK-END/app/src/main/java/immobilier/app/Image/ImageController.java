package immobilier.app.Image;

import lombok.Getter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/images")
@Getter
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @PostMapping
    public Image createImage(@RequestBody Image image) {
        return imageService.createImage(image);
    }


    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Long id,@RequestBody String description, @RequestBody Image image) {
        return imageService.updateImage(id,description, image);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}

