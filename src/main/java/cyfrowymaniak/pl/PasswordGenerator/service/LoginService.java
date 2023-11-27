package cyfrowymaniak.pl.PasswordGenerator.service;

import cyfrowymaniak.pl.PasswordGenerator.entity.Login;
import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import cyfrowymaniak.pl.PasswordGenerator.exception.LoginNotExistException;
import cyfrowymaniak.pl.PasswordGenerator.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final PlatformTypeService platformTypeService;
    private final LoginRepo loginRepo;


    @Autowired
    public LoginService(PlatformTypeService platformTypeService, LoginRepo loginRepo) {
        this.platformTypeService = platformTypeService;
        this.loginRepo = loginRepo;
    }




    public Login createLogin(Login login, Long id) {
        PlatformType platformType = platformTypeService.getPlatformyType(id);
        login.setPlatformType(platformType);
        return loginRepo.save(login);
    }

    public List<Login> getAllLogins() {
        return loginRepo.findAll();
    }

    public Login getLogin(Long id) {
        Optional<Login> byId = loginRepo.findById(id);
        return byId.orElseThrow(() -> new LoginNotExistException(id));
    }

    public Login updateLogin(Long id, Login login) {
        Login login1 = getLogin(id);
        login1.setLogin(login.getLogin());
        return loginRepo.save(login1);
    }

    public void deleteLogin(Long id) {
        Login login = getLogin(id);
        Long id1 = login.getId();
        loginRepo.deleteById(id1);
    }
}
