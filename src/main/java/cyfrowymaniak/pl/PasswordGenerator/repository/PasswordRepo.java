package cyfrowymaniak.pl.PasswordGenerator.repository;

import cyfrowymaniak.pl.PasswordGenerator.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepo extends JpaRepository<Password, Long> {
}
