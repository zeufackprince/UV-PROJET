package immobilier.app.Post;

import java.util.Date;

import immobilier.app.Agent.Agent;
import immobilier.app.Belongings.PropType;
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
public class PosteImmobilier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;

    private PropType type;

    private double price;

    private String localisation;

    private Date datePost;
    
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
