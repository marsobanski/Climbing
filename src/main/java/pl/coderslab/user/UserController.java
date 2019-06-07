package pl.coderslab.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user_route.UserRoute;
import pl.coderslab.user_route.UserRouteService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@SessionAttributes("userSession")
public class UserController {


    private UserService userService;
    private UserRouteService userRouteService;
    private String oldPassword;

    public UserController(UserService userService, UserRouteService userRouteService) {
        this.userService = userService;
        this.userRouteService = userRouteService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "publicUsersList";
    }

    @GetMapping("/all/public")
    public String getAllPublicUsers(Model model) {
        model.addAttribute("users", userService.findAllPublic());
        return "publicUsersList";
    }

    @PostMapping("/all/public")
    public String getSearchedPublicUsers(@RequestParam String search, Model model) {
        model.addAttribute("users", userService.findAllByLoginContains(search));
        return "publicUsersList";
    }

    @GetMapping("/public/profile/{id}")
    public String getPublicUsersRoutes(Model model, @PathVariable Long id) {
        model.addAttribute("publicRoutes", userRouteService.findAllByUserId(id));
        return "userPublicRoutes";
    }

    @GetMapping("/editData")
    public String getUserData (Model model, HttpSession session) {
        User user = (User)session.getAttribute("userSession");

        user = userService.findUserById(user.getId());
        oldPassword = user.getPassword();
        model.addAttribute("user", user);
        return "userProfile";
    }

    @PostMapping("/editData")
    public String getData (@ModelAttribute User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/user/editData";
        }
        if (user.getPassword().equals("00000000000000000000")) {
            user.setPassword(oldPassword);
        } else {
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        }

        userService.saveUser(user);
        session.setAttribute("userSession", user);
        return "redirect:/user/dashboard";
    }
}
