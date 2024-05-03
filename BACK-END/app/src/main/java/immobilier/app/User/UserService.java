package immobilier.app.User;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
