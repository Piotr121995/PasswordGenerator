package cyfrowymaniak.pl.PasswordGenerator.service;

import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import cyfrowymaniak.pl.PasswordGenerator.exception.PlatformNotExistException;
import cyfrowymaniak.pl.PasswordGenerator.repository.PlatformRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {

    private final PlatformRepo platformRepo;

    @Autowired
    public PlatformService(PlatformRepo platformRepo) {
        this.platformRepo = platformRepo;
    }

    public void createPlatform(Platform platform) {
        platformRepo.save(platform);
    }

    public List<Platform> getAllPlatforms() {
        return platformRepo.findAll();
    }

    public Platform getPlatform(Long id) {
        Optional<Platform> byId = platformRepo.findById(id);
        return byId.orElseThrow(() -> new PlatformNotExistException(id));
    }

    public Platform updatePlatform(Long id, Platform platform) {
        Platform oldPlatform = getPlatform(id);
        oldPlatform.setPlatformName(platform.getPlatformName());
        return platformRepo.save(oldPlatform);
    }

    public void deletePlatform(Long id) {
        Platform platform = getPlatform(id);
        Long id1 = platform.getId();
        platformRepo.deleteById(id1);
    }
}
