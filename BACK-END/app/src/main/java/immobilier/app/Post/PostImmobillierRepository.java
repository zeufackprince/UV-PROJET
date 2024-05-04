package immobilier.app.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImmobillierRepository extends JpaRepository<PosteImmobilier, Long>{

}
