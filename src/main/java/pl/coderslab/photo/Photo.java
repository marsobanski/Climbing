package pl.coderslab.photo;

import org.hibernate.validator.constraints.Length;
import pl.coderslab.route.Route;
import pl.coderslab.user_route.UserRoute;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String path;
    @ManyToOne
    UserRoute userRoute;
    @ManyToOne
    Route route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
