package cyfrowymaniak.pl.PasswordGenerator.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;


    @ManyToOne
    @JoinColumn(name = "PlatformyType_Id")
    @JsonBackReference
    private PlatformType platformType;

    public Login(Long id, String login, PlatformType platformType, Password password) {
        this.id = id;
        this.login = login;
        this.platformType = platformType;
        this.password = password;
    }

    @OneToOne(mappedBy ="login")
    private Password password;

    public Login() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }

    public void setPlatformType(PlatformType platformType) {
        this.platformType = platformType;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}