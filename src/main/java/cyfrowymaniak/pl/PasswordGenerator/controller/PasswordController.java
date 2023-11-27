package cyfrowymaniak.pl.PasswordGenerator.controller;


import cyfrowymaniak.pl.PasswordGenerator.entity.Login;
import cyfrowymaniak.pl.PasswordGenerator.entity.Password;
import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import cyfrowymaniak.pl.PasswordGenerator.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginApi")
public class PasswordController {

    private final PasswordService passwordService;


    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/generate/{id}")
    public ResponseEntity<Password> generatePassword(@PathVariable Long id) {
        Password password = passwordService.generatePassword(id);
        return new ResponseEntity<>(password, HttpStatus.CREATED);
    }

    @GetMapping("/password/{id}")
    public ResponseEntity<Password> findPassword(@PathVariable Long id) {
        Password password = passwordService.getPassword(id);
        return new ResponseEntity<>(password, HttpStatus.OK);
    }

}
