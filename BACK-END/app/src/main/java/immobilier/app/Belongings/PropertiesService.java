package immobilier.app.Belongings;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertiesService {

    private final PropertiesRepository propertiesRepository;

    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    public List<Properties> getProperties() {

        return propertiesRepository.findAll();
    }

    public Optional<Properties> getAProperty(Long id) {

        Optional<Properties> properties = propertiesRepository.findPropById(id);
        if(properties.isEmpty()){

            throw new EntityExistsException("Property not found or don't exist");
        }else {

            return properties;
        }
    }

    public void newProperty(Properties properties) {

        propertiesRepository.save(properties);
    }

    public void updateProp(Long id, Properties properties) {
    }

//    public void updateProp(Long id, Properties properties) {
//
//        Optional<Properties> prop = propertiesRepository.findPropById(id);
//        if (prop.isPresent()){
//            properties.setProp_Description(String.valueOf(prop));
//        }
//    }
}