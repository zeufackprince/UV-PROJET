package immobilier.app.Notification;

import java.util.Date;

import immobilier.app.Agent.Agent;
import immobilier.app.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Notification {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String contenu;
        
        private Date date;
        
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
        
        @ManyToOne
        @JoinColumn(name = "agent_id") 
        private Agent agent; 
    }
    
