package immobilier.app.Post;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import immobilier.app.Agent.Agent;
import immobilier.app.Agent.AgentService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
@Getter
public class PostImmobilierController {

    private final PostImmobillierService postImmobillierService;

    private final AgentService agentService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<PosteImmobilier> createPosteImmobilier(@RequestBody PosteImmobilier posteImmobilier, @RequestParam("agentId") Long agentId) {
        Agent agent = agentService.getAgentById(agentId); // Récupérer l'agent par ID
        if (agent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Agent non trouvé
        }
        
        PosteImmobilier savedPosteImmobilier = postImmobillierService.createPosteImmobilier(posteImmobilier, agent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPosteImmobilier);
    }

    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PosteImmobilier>> getPosteImmobilierById(@PathVariable Long id) {
        Optional<PosteImmobilier> posteImmobilier = postImmobillierService.getPosteImmobilierById(id);
        if (posteImmobilier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(posteImmobilier);
    }
    
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<PosteImmobilier> updatePosteImmobilier(@PathVariable Long id, @RequestBody PosteImmobilier updatedPosteImmobilier) {
        Optional<PosteImmobilier> existingPosteImmobilier = postImmobillierService.getPosteImmobilierById(id);
        if (existingPosteImmobilier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
        updatedPosteImmobilier.setId(id);
        PosteImmobilier savedPosteImmobilier = postImmobillierService.updatePosteImmobilier(updatedPosteImmobilier);
        return ResponseEntity.ok(savedPosteImmobilier);
    }
    
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosteImmobilier(@PathVariable Long id) {
        Optional<PosteImmobilier> existingPosteImmobilier = postImmobillierService.getPosteImmobilierById(id);
        if (existingPosteImmobilier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        postImmobillierService.updatePosteImmobilier(existingPosteImmobilier, id);
        return ResponseEntity.noContent().build();
    }
}
