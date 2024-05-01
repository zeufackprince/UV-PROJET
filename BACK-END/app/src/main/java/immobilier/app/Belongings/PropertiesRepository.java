package immobilier.app.Belongings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties ,Long> {
    Optional<Properties> findPropById(Long id);
}
