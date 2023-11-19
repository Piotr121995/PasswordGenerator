package cyfrowymaniak.pl.PasswordGenerator.Exceptions;

public class PlatformNotFoundException extends RuntimeException {

    public PlatformNotFoundException(Long id) {
        super("Could not find Id " + id);
    }
}
