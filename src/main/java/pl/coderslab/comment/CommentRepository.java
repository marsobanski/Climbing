package pl.coderslab.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByUserRouteId(Long id);

    List<Comment> findAllByUserRouteIdOrderByCreationDateAsc(Long id);

    @Modifying
    @Query(value = "update comments set userRoute_id = null where userRoute_id = ?1", nativeQuery = true)
    void deleteUserRouteConnection(Long id);
}
