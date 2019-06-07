package pl.coderslab.user_route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.user.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/routes/sort")
public class UserRouteSortController {

    private UserRouteService userRouteService;

    public UserRouteSortController(UserRouteService userRouteService) {
        this.userRouteService = userRouteService;
    }

    @GetMapping("/name")
    public String sortByName(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.sortByName(user.getId()));
        return"userRoutesList";
    }

    @GetMapping("/time")
    public String sortByTime(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.sortByTime(user.getId()));
        return"userRoutesList";
    }

    @GetMapping("/date")
    public String sortByDate(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.sortByDate(user.getId()));
        return"userRoutesList";
    }

    @GetMapping("/diff")
    public String sortByDiff(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.sortByDiff(user.getId()));
        return"userRoutesList";
    }

    @GetMapping("/rock")
    public String sortByRock(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.sortByRock(user.getId()));
        return"userRoutesList";
    }

    @GetMapping("/area")
    public String sortByArea(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.sortByArea(user.getId()));
        return"userRoutesList";
    }
}
