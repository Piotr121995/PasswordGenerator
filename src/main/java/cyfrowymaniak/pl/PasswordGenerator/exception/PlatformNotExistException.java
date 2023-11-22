package cyfrowymaniak.pl.PasswordGenerator.exception;

public class PlatformNotExistException extends RuntimeException {

    public PlatformNotExistException(Long id) {
        super("Platform of Id " + id + " not exist");
    }
}
