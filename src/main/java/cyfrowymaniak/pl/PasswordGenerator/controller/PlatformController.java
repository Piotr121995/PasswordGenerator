package cyfrowymaniak.pl.PasswordGenerator.controller;


import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import cyfrowymaniak.pl.PasswordGenerator.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platformApi")
public class PlatformController {

    private final PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping("/platform")
    public ResponseEntity<Platform> addPlatform(@RequestBody Platform newPlatform) {
        platformService.createPlatform(newPlatform);
        return new ResponseEntity<>(newPlatform, HttpStatus.CREATED);

    }

    @PutMapping("/platform/{id}")
    public ResponseEntity<Platform> updatePlatform(@PathVariable Long id, @RequestBody Platform newPlatform) {
        Platform update = platformService.updatePlatform(id, newPlatform);

        return new ResponseEntity<>(update, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Platform>> getAllPlatforms() {
        List<Platform> allPlatforms = platformService.getAllPlatforms();
        return new ResponseEntity<>(allPlatforms, HttpStatus.OK);
    }

    @GetMapping("/platform/{id}")
    public ResponseEntity<Platform> findPlatformById(@PathVariable Long id) {
        Platform platformById = platformService.getPlatform(id);
        return new ResponseEntity<>(platformById, HttpStatus.OK);

    }

    @DeleteMapping("/platform/{id}")
    public ResponseEntity<Void> deletePlatformById(@PathVariable Long id) {
        platformService.deletePlatform(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
