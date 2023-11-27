package cyfrowymaniak.pl.PasswordGenerator.service;

import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import cyfrowymaniak.pl.PasswordGenerator.exception.PlatformTypeNotExistException;
import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import cyfrowymaniak.pl.PasswordGenerator.repository.PlatformTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    }

    public PlatformType updatePlatformType(Long id, PlatformType platformType) {
        PlatformType oldPlatformyType = getPlatformyType(id);
        oldPlatformyType.setPlatformTypeName(platformType.getPlatformTypeName());
        return platformTypeRepo.save(oldPlatformyType);
    }

    public void deletePlatformType(Long id) {
        PlatformType platformyType = getPlatformyType(id);
        Long id1 = platformyType.getId();
        platformTypeRepo.deleteById(id1);
    }
}







