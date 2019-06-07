package pl.coderslab.rock;

import pl.coderslab.area.Area;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "rocks")
public class Rock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @ManyToOne
    @NotBlank
    private Area area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
