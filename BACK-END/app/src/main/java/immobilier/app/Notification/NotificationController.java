package immobilier.app.Notification;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor @Getter
public class NotificationController {

    private final NotificationService notificationService;
}
