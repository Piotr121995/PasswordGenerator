package cyfrowymaniak.pl.PasswordGenerator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepo extends JpaRepository<Platform, Long> {


}
