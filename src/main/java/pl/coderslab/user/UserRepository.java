package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByLogin(String login);

    public List<User> findAllByPublicProfileTrue();

    public List<User> findAllByPublicProfileTrueAndLoginIsLike(String regex);
}
