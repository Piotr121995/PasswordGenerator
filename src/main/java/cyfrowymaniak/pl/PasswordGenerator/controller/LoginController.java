package cyfrowymaniak.pl.PasswordGenerator.controller;

import cyfrowymaniak.pl.PasswordGenerator.entity.Login;
import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import cyfrowymaniak.pl.PasswordGenerator.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loginApi")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login/{id}")
    public ResponseEntity<Login> addLogin(@RequestBody Login newLogin, @PathVariable Long id) {
        Login login = loginService.createLogin(newLogin, id);
        return new ResponseEntity<>(login, HttpStatus.CREATED);
    }

    @PutMapping("/login/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable Long id, @RequestBody Login newLogin) {
        Login login = loginService.updateLogin(id, newLogin);
        return new ResponseEntity<>(login, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> allLogins = loginService.getAllLogins();
        return new ResponseEntity<>(allLogins, HttpStatus.OK);
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<Login> findLoginById(@PathVariable Long id) {
        Login login = loginService.getLogin(id);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<Void> deleteLoginById(@PathVariable Long id) {
        loginService.deleteLogin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
