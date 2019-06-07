package pl.coderslab.comment;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.user.User;
import pl.coderslab.user_route.UserRoute;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    @Length(max = 255)
    String text;
    @CreatedDate
    LocalDate creationDate = LocalDate.now();
    @ManyToOne
    User user;
    @ManyToOne
    UserRoute userRoute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRoute getUserRoute() {
        return userRoute;
    }

    public void setUserRoute(UserRoute userRoute) {
        this.userRoute = userRoute;
    }
}
