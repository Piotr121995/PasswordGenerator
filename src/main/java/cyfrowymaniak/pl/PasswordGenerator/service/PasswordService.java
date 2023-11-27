package cyfrowymaniak.pl.PasswordGenerator.service;

import cyfrowymaniak.pl.PasswordGenerator.entity.Login;
import cyfrowymaniak.pl.PasswordGenerator.entity.Password;
import cyfrowymaniak.pl.PasswordGenerator.entity.Platform;
import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import cyfrowymaniak.pl.PasswordGenerator.exception.PasswordNotExistException;
import cyfrowymaniak.pl.PasswordGenerator.repository.PasswordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PasswordService {

    private final PasswordRepo passwordRepo;
    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public PasswordService(PasswordRepo passwordRepo, LoginService loginService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordRepo = passwordRepo;
        this.loginService = loginService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Password generatePassword(Long id) {

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        Login login = loginService.getLogin(id);
        Password password = new Password();
        String login1 = login.getLogin();
        PlatformType platformType = login.getPlatformType();
        String platformTypeName = platformType.getPlatformTypeName();
        Platform platform = platformType.getPlatform();
        String platformName = platform.getPlatformName();

        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(9);
            stringBuilder.append(randomNumber);
        }

        String numbers = stringBuilder.toString();
        String newPassword = platformTypeName + numbers + platformName;
        String encode = bCryptPasswordEncoder.encode(newPassword);
        password.setEncodedPassword(encode);
        password.setLogin(login);
        return passwordRepo.save(password);
    }

    public Password getPassword(Long id) {
        Login login = loginService.getLogin(id);
        Password password = login.getPassword();
        return Optional.ofNullable(password).orElseThrow(()-> new PasswordNotExistException("Password not exist"));

    }

/*    public Password changePassword(Long id) {
        Login login = loginService.getLogin(id);
        Long loginId = login.getId();
        Password password1 = getPassword(loginId);
        Password password = login.getPassword();

        password.setEncodedPassword();

        PlatformType oldPlatformyType = getPlatformyType(id);
        oldPlatformyType.setPlatformTypeName(platformType.getPlatformTypeName());
        return platformTypeRepo.save(oldPlatformyType);
    }*/

}
