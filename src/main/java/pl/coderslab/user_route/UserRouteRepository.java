package pl.coderslab.user_route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRouteRepository extends JpaRepository<UserRoute,Long> {

    List<UserRoute> findAllByUserId(Long id);

    @Modifying
    @Query(value = "update user_routes set route_id = null where id = ?1", nativeQuery = true)
    void deleteRouteConnection(Long id);

    @Modifying
    @Query(value = "update user_routes set user_id = null where id = ?1", nativeQuery = true)
    void deleteUserConnection(Long id);

    @Query(value = "select * from user_routes order by id desc limit 3", nativeQuery = true)
    List<UserRoute> findLastThreeAded();

    @Query(value = "select * from user_routes where user_id = ?1 order by id desc limit 3", nativeQuery = true)
    List<UserRoute> findLastThreeAdedOfUser(Long id);

    List<UserRoute> findAllByUserIdEqualsOrderByRouteNameAsc(Long id);
    List<UserRoute> findAllByUserIdEqualsOrderByTimeAsc(Long id);
    List<UserRoute> findAllByUserIdEqualsOrderByDateDesc(Long id);
    List<UserRoute> findAllByUserIdEqualsOrderByRouteDifficultyDesc(Long id);
    List<UserRoute> findAllByUserIdEqualsOrderByRouteRockNameAsc(Long id);
    List<UserRoute> findAllByUserIdEqualsOrderByRouteRockAreaNameAsc(Long id);


}
