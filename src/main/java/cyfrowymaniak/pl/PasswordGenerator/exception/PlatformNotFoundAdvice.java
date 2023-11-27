package cyfrowymaniak.pl.PasswordGenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlatformNotFoundAdvice {

    @ExceptionHandler(PlatformNotExistException.class)
    public ResponseEntity<String> platformNotExistHandler(PlatformNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PlatformTypeNotExistException.class)
    public ResponseEntity<String> platformTypeNotFoundHandler(PlatformTypeNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(LoginNotExistException.class)
    public ResponseEntity<String> platformNotExistHandler(LoginNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(PasswordNotExistException.class)
    public ResponseEntity<String> passwordNotExistHandler(PasswordNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
