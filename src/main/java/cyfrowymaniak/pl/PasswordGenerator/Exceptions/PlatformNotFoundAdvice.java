package cyfrowymaniak.pl.PasswordGenerator.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlatformNotFoundAdvice {

    @ExceptionHandler(PlatformNotFoundException.class)
    public ResponseEntity<String> platformNotFoundHandler(PlatformNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }

    @ExceptionHandler(PlatformNotExistException.class)
    public ResponseEntity<String> platformNotExistHandler(PlatformNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PlatformTypeNotExistException.class)
    public ResponseEntity<String> platformTypeNotFoundHandler(PlatformTypeNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
