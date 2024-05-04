package immobilier.app.Notification;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@AllArgsConstructor @Getter
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void createNotification(Notification notification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNotification'");
    }


}
