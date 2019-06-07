package pl.coderslab.route;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteService {

    private RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public void saveRoute(Route route) {
        routeRepository.save(route);
    }

    public Route findRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    public void updateRoute(Route route) {
        routeRepository.save(route);
    }

    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);
    }

}
