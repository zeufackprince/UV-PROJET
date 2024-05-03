package immobilier.app.Agent;

import lombok.Getter;
import org.springframework.stereotype.Service;


@Service
@Getter
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

}
