package immobilier.app.Image;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Image getImageById(Long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        return imageOptional.orElse(null);
    }

    public Image updateImage(Long id,String desscription, Image image) {
        image.setId(id);
        image.setDescription(desscription);
        return imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
