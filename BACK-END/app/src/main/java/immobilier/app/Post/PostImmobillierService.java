package immobilier.app.Post;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import immobilier.app.Agent.Agent;
import immobilier.app.Notification.Notification;
import immobilier.app.Notification.NotificationService;
// import immobilier.app.User.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Service
@Getter
@AllArgsConstructor 
public class PostImmobillierService {

    private final PostImmobillierRepository postImmobillierRepository;
    private final NotificationService notificationService;

    public PosteImmobilier createPosteImmobilier(PosteImmobilier posteImmobilier, Agent agent) {
        PosteImmobilier savedPosteImmobilier = postImmobillierRepository.save(posteImmobilier);
        
        // Création de la notification et association avec l'agent auteur du post et le client concerné
        Notification notification = new Notification();
        notification.setContenu("Nouveau poste immobilier créé");//on doit dinamiser selon celui du user
        notification.setDate(new Date());
        notification.setAgent(agent);
        // notification.setUser(user); // Définition du client concerné
        notificationService.createNotification(notification); // Création de la notification
        
        return savedPosteImmobilier;
    }
    

    public Optional<PosteImmobilier> getPosteImmobilierById(Long id) {

        return this.postImmobillierRepository.findById(id);

    }

    public PosteImmobilier updatePosteImmobilier(Optional<PosteImmobilier> existingPosteImmobilier, Long id) {

        throw new EntityNotFoundException("pas disponible");
    }


    public PosteImmobilier updatePosteImmobilier(PosteImmobilier updatedPosteImmobilier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePosteImmobilier'");
    }

    
}
