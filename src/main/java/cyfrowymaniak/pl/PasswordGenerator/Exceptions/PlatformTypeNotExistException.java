package cyfrowymaniak.pl.PasswordGenerator.Exceptions;

public class PlatformTypeNotExistException extends RuntimeException {

    public PlatformTypeNotExistException(Long id) {
        super("PlatformType of Id " + id + " not exist");
    }
}

