package pl.coderslab.user_route;

import org.springframework.stereotype.Service;
import pl.coderslab.user.User;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Service
@Transactional
public class UserRouteService {

    private UserRouteRepository userRouteRepository;

    public UserRouteService(UserRouteRepository userRouteRepository) {
        this.userRouteRepository = userRouteRepository;
    }

    public void saveUserRoute(UserRoute userRoute) {
        userRouteRepository.save(userRoute);
    }

    public List<UserRoute> findAll() {return userRouteRepository.findAll(); }

    public List<UserRoute> findAllByUserId(Long id) {return userRouteRepository.findAllByUserId(id); }

    public List<UserRoute> findLastThreeAded() {
        return userRouteRepository.findLastThreeAded();
    }

    public List<UserRoute> findLastThreeAdedOfUser(Long id) {
        return userRouteRepository.findLastThreeAdedOfUser(id);
    }

    public UserRoute findUserRouteById(Long id) {
        return userRouteRepository.findById(id).orElse(null);
    }

    public void updateUserRoute(UserRoute userRoute) {
        userRouteRepository.save(userRoute);
    }

    public void deleteUserRouteById(Long id) {
        userRouteRepository.deleteUserConnection(id);
        userRouteRepository.deleteRouteConnection(id);
        userRouteRepository.deleteById(id);
    }
    public List<UserRoute> sortByName(Long id) {
        return userRouteRepository.findAllByUserIdEqualsOrderByRouteNameAsc(id);
    }
    public List<UserRoute> sortByTime(Long id) {
        return userRouteRepository.findAllByUserIdEqualsOrderByTimeAsc(id);
    }
    public List<UserRoute> sortByDate(Long id) {
        return userRouteRepository.findAllByUserIdEqualsOrderByDateDesc(id);
    }
    public List<UserRoute> sortByDiff(Long id) {
        return userRouteRepository.findAllByUserIdEqualsOrderByRouteDifficultyDesc(id);
    }
    public List<UserRoute> sortByArea(Long id) {
        return userRouteRepository.findAllByUserIdEqualsOrderByRouteRockAreaNameAsc(id);
    }
    public List<UserRoute> sortByRock(Long id) {
        return userRouteRepository.findAllByUserIdEqualsOrderByRouteRockNameAsc(id);
    }

}
