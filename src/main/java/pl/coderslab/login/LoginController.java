package pl.coderslab.login;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;
import pl.coderslab.user_route.UserRouteService;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userSession")
public class LoginController {

    private UserService userService;
    private UserRouteService userRouteService;

    public LoginController(UserService userService, UserRouteService userRouteService) {
        this.userService = userService;
        this.userRouteService = userRouteService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.findUserByName(login);
        model.addAttribute("isLogged", false);
        if (user == null) {
            return "/login";
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            session.setAttribute("userSession", user);
            model.addAttribute("isLogged", true);
            return "redirect:/user/dashboard";
        }
        return "/login";
    }

    @GetMapping("/user/dashboard")
    public String showUserDashboard(Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");
        model.addAttribute("userRoutes", userRouteService.findLastThreeAdedOfUser(user.getId()));
        return "userDashboard";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session, Model model) {
        model.addAttribute("userSession", null);
        session.invalidate();
        return "redirect:/";
    }
}
