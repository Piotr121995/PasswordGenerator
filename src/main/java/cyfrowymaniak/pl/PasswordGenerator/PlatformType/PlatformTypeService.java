package cyfrowymaniak.pl.PasswordGenerator.PlatformType;

import cyfrowymaniak.pl.PasswordGenerator.Exceptions.PlatformTypeNotExistException;
import cyfrowymaniak.pl.PasswordGenerator.Platform;
import cyfrowymaniak.pl.PasswordGenerator.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformTypeService {

    private final PlatformService platformService;
    private final PlatformTypeRepo platformTypeRepo;

    @Autowired
    public PlatformTypeService(PlatformService platformService, PlatformTypeRepo platformTypeRepo) {
        this.platformService = platformService;
        this.platformTypeRepo = platformTypeRepo;
    }

    public PlatformType createPlatformType(PlatformType platformType, Long id) {
        Platform platform = platformService.getPlatform(id);
        platformType.setPlatform(platform);
      return platformTypeRepo.save(platformType);

    }

    public List<PlatformType> getAllPlatformTypes() {
        return platformTypeRepo.findAll();
    }

    public PlatformType getPlatformyType(Long id) {
        Optional<PlatformType> byId = platformTypeRepo.findById(id);
        return byId.orElseThrow(() -> new PlatformTypeNotExistException(id));


 /*   public Platform update(Long id, Platform platform) {
        Optional<Platform> byId = platformRepo.findById(id);
        if (byId.isPresent()) {
            Platform oldPlatform = byId.get();
            oldPlatform.setName(platform.getName());
            return platformRepo.save(oldPlatform);
        } else throw new PlatformNotExistException(id);*/
 /*   }

    public void delete(Long id) {
        Optional<Platform> byId = platformRepo.findById(id);
        if (byId.isPresent()) {
            Long id1 = byId.get().getId();
            platformRepo.deleteById(id1);
        } else throw new PlatformNotFoundException(id);
    }
*/
    }
}




