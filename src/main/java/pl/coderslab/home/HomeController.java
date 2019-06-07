package pl.coderslab.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.user_route.UserRouteService;

@Controller
public class HomeController {

    private UserRouteService userRouteService;

    public HomeController(UserRouteService userRouteService) {
        this.userRouteService = userRouteService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/routes")
    public String getUnloggedRoutes(Model model) {
        model.addAttribute("userRoutes", userRouteService.findLastThreeAded());
        return "unloggedUserRoutes";
    }

}
