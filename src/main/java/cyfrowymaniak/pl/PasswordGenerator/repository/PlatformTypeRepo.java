package cyfrowymaniak.pl.PasswordGenerator.repository;

import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformTypeRepo extends JpaRepository<PlatformType,Long> {
}
