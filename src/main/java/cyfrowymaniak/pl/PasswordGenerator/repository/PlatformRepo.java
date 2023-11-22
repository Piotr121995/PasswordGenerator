package cyfrowymaniak.pl.PasswordGenerator.repository;

import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepo extends JpaRepository<Platform, Long> {


}
