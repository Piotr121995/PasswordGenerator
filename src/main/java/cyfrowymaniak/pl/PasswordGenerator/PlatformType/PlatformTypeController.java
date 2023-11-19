package cyfrowymaniak.pl.PasswordGenerator.PlatformType;

import cyfrowymaniak.pl.PasswordGenerator.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class PlatformTypeController {

    private final PlatformTypeService platformTypeService;

    @Autowired
    public PlatformTypeController(PlatformTypeService platformTypeService) {
        this.platformTypeService = platformTypeService;
    }

    @PostMapping("/platformType/{id}")
    public ResponseEntity<PlatformType> addPlatformType(@RequestBody PlatformType newPlatformType, @PathVariable Long id) {
        PlatformType platformType = platformTypeService.createPlatformType(newPlatformType, id);
        return new ResponseEntity<>(platformType, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<PlatformType> getAllPlatformTypes() {
        return platformTypeService.getAllPlatformTypes();
    }

    @GetMapping("/platformType/{id}")
    public ResponseEntity<PlatformType> findPlatformTypeById(@PathVariable Long id) {
        PlatformType platformyType = platformTypeService.getPlatformyType(id);
        return new ResponseEntity<>(platformyType, HttpStatus.OK);

    }
}
