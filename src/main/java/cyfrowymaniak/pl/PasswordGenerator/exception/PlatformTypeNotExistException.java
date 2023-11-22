package cyfrowymaniak.pl.PasswordGenerator.exception;

public class PlatformTypeNotExistException extends RuntimeException {

    public PlatformTypeNotExistException(Long id) {
        super("PlatformType of Id " + id + " not exist");
    }
}

