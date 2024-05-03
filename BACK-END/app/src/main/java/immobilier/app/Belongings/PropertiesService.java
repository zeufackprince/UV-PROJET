package immobilier.app.Belongings;

import org.springframework.stereotype.Service;

import immobilier.app.Image.Image;
import immobilier.app.Image.ImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertiesService {

    private final PropertiesRepository propertiesRepository;

    private final ImageRepository imageRepository;

    public PropertiesService(PropertiesRepository propertiesRepository, ImageRepository imageRepository) {
        this.propertiesRepository = propertiesRepository;
        this.imageRepository = imageRepository;
    }


    public List<Properties> getProperties() {

        return propertiesRepository.findAll();
    }

    public Properties getAProperty(Long id) {
        Optional<Properties> propertyOptional = propertiesRepository.findById(id);
        if (propertyOptional.isPresent()) {
            Properties properties = propertyOptional.get();
            List<Image> images = imageRepository.findBypropertiesId(properties.getId());
            properties.setImages(images);
            return properties;
        } else {
            return null;
        }
    }
//    public Optional<Properties> getAProperty(Long id) {
//
//        Optional<Properties> properties = propertiesRepository.findPropById(id);
//        if(properties.isEmpty()){
//
//            throw new EntityExistsException("Property not found or don't exist");
//        }else {
//
//            return properties;
//        }
//    }

    public void newProperty(Properties properties) {

        propertiesRepository.save(properties);
    }

    public Properties updateProp(Long id, Properties properties) {
        properties.setId(id);
        return propertiesRepository.save(properties);
    }

//    public void updateProp(Long id, Properties properties) {
//
//        Optional<Properties> prop = propertiesRepository.findPropById(id);
//        if (prop.isPresent()){
//            properties.setProp_Description(String.valueOf(prop));
//        }
//    }


    public void deleteProp(Long id) {
        propertiesRepository.deleteById(id);
    }
}