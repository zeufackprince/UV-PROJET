package immobilier.app.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
    try {
        return 
        httpSecurity.csrf(AbstractHttpConfigurer::disable).
                            authorizeHttpRequests(
                                authotize -> authotize.requestMatchers("/inscription").permitAll()
                                .anyRequest().authenticated() 
                            ).build();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        throw new IllegalAccessError("authentification error");
    }
}

}
