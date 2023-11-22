package cyfrowymaniak.pl.PasswordGenerator.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlatformType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String platformTypeName;

    @ManyToOne
    @JoinColumn(name = "Platform_id")
    @JsonBackReference
    private Platform platform;

    @OneToMany(mappedBy = "platformType")
    private List<Login> loginList;

    public PlatformType(Long id, String platformTypeName, Platform platform, List<Login> loginList) {
        this.id = id;
        this.platformTypeName = platformTypeName;
        this.platform = platform;
        this.loginList = loginList;
    }

    public PlatformType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformTypeName() {
        return platformTypeName;
    }

    public void setPlatformTypeName(String platformTypeName) {
        this.platformTypeName = platformTypeName;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public List<Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Login> loginList) {
        this.loginList = loginList;
    }
}
