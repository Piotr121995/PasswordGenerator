package cyfrowymaniak.pl.PasswordGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cyfrowymaniak.pl.PasswordGenerator.PlatformType.PlatformType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MyPlatform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PlatformName;


    @OneToMany(mappedBy = "platform")

    private List<PlatformType> platformTypeList;

    public Platform(Long id, String platformName, List<PlatformType> platformTypeList) {
        this.id = id;
        PlatformName = platformName;
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
        return PlatformName;
    }

    public void setPlatformName(String platformName) {
        PlatformName = platformName;
    }

    public List<PlatformType> getPlatformTypeList() {
        return platformTypeList;
    }

    public void setPlatformTypeList(List<PlatformType> platformTypeList) {
        this.platformTypeList = platformTypeList;
    }
}

