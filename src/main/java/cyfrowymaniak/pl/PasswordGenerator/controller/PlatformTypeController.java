package cyfrowymaniak.pl.PasswordGenerator.controller;

import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import cyfrowymaniak.pl.PasswordGenerator.service.PlatformTypeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platformTypeApi")
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
    public ResponseEntity<List<PlatformType>> getAllPlatformTypes() {
        List<PlatformType> allPlatformTypes = platformTypeService.getAllPlatformTypes();
        return new ResponseEntity<>(allPlatformTypes, HttpStatus.OK);
    }

    @GetMapping("/platformType/{id}")
    public ResponseEntity<PlatformType> findPlatformTypeById(@PathVariable Long id) {
        PlatformType platformyType = platformTypeService.getPlatformyType(id);
        return new ResponseEntity<>(platformyType, HttpStatus.OK);

    }

    @PutMapping("/platformType/{id}")
    public ResponseEntity<PlatformType> updatePlatformType(@PathVariable Long id, @RequestBody PlatformType platformType) {
        PlatformType oldPlatformType = platformTypeService.updatePlatformType(id, platformType);
        return new ResponseEntity<>(oldPlatformType, HttpStatus.CREATED);
    }
    @DeleteMapping("/platformType/{id}")
    public ResponseEntity<Void> deletePlatformTypeById(@PathVariable Long id) {
        platformTypeService.deletePlatformType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
