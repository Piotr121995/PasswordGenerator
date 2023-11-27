package cyfrowymaniak.pl.PasswordGenerator.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String encodedPassword;

    @OneToOne
    @JoinColumn(name = "login_id")
    @JsonBackReference
    private Login login;

    public Password(Long id, String encodedPassword, Login login) {
        this.id = id;
        this.encodedPassword = encodedPassword;
        this.login = login;
    }

    public Password() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
