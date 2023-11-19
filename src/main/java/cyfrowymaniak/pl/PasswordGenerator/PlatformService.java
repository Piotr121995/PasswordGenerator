package cyfrowymaniak.pl.PasswordGenerator;

import cyfrowymaniak.pl.PasswordGenerator.Exceptions.PlatformNotExistException;
import cyfrowymaniak.pl.PasswordGenerator.Exceptions.PlatformNotFoundException;
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

    public void create(Platform platform) {
        platformRepo.save(platform);
    }

    public List<Platform> getAllPlatforms() {
        return platformRepo.findAll();
    }

    public Platform getPlatform(Long id) {
        Optional<Platform> byId = platformRepo.findById(id);
        return byId.orElseThrow(() -> new PlatformNotFoundException(id));
    }

    public Platform updatePlatform(Long id, Platform platform) {
        Optional<Platform> byId = platformRepo.findById(id);
            if(byId.isPresent()){
                Platform oldPlatform = byId.get();
                oldPlatform.setPlatformName(platform.getPlatformName());
                return platformRepo.save(oldPlatform);
            }
        else throw new PlatformNotExistException(id);
    }

    public void deletePlatform(Long id) {
        Optional<Platform> byId = platformRepo.findById(id);
        if (byId.isPresent()) {
            Long id1 = byId.get().getId();
            platformRepo.deleteById(id1);
        } else throw new PlatformNotFoundException(id);
    }
}
