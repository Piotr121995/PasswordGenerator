package cyfrowymaniak.pl.PasswordGenerator.exception;

public class LoginNotExistException extends RuntimeException {

    public LoginNotExistException(Long id) {
        super("Login of id " + id + " not exist");
    }
}
