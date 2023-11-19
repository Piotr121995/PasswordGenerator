package cyfrowymaniak.pl.PasswordGenerator.PlatformType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cyfrowymaniak.pl.PasswordGenerator.Platform;
import jakarta.persistence.*;

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


    public PlatformType(Long id, String platformTypeName, Platform platform) {
        this.id = id;
        this.platformTypeName = platformTypeName;
        this.platform = platform;
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
}
