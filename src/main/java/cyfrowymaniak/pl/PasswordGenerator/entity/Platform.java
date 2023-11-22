package cyfrowymaniak.pl.PasswordGenerator.entity;

import cyfrowymaniak.pl.PasswordGenerator.entity.PlatformType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MyPlatform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String platformName;


    @OneToMany(mappedBy = "platform")
    private List<PlatformType> platformTypeList;

    public Platform(Long id, String platformName, List<PlatformType> platformTypeList) {
        this.id = id;
        this.platformName = platformName;
        this.platformTypeList = platformTypeList;
    }

    public Platform() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public List<PlatformType> getPlatformTypeList() {
        return platformTypeList;
    }

    public void setPlatformTypeList(List<PlatformType> platformTypeList) {
        this.platformTypeList = platformTypeList;
    }
}

