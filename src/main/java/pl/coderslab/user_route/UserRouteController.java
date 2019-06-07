package pl.coderslab.user_route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.comment.Comment;
import pl.coderslab.comment.CommentService;
import pl.coderslab.route.Route;
import pl.coderslab.route.RouteService;
import pl.coderslab.user.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/routes")
public class UserRouteController {

    private UserRouteService userRouteService;
    private RouteService routeService;
    private CommentService commentService;

    public UserRouteController(UserRouteService userRouteService, RouteService routeService, CommentService commentService) {
        this.userRouteService = userRouteService;
        this.routeService = routeService;
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String addUserRoute(Model model) {
        model.addAttribute("userRoute", new UserRoute());
        return "addUserRoute";
    }

    @PostMapping("/add")
    public String addUserRoute(HttpSession session, @ModelAttribute @Validated UserRoute userRoute, BindingResult result) {
        User user = (User)session.getAttribute("userSession");
        if (result.hasErrors()) {
            return "addUserRoute";
        }
        userRoute.setUser(user);
        userRouteService.saveUserRoute(userRoute);
        return "redirect:all";
    }

    @GetMapping("/all")
    public String findAllUserRoutes(HttpSession session, Model model) {
        User user = (User)session.getAttribute("userSession");
        Long userId = user.getId();
        model.addAttribute("userRoutes", userRouteService.findAllByUserId(userId));
        return "userRoutesList";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserRoute(@PathVariable Long id) {
        commentService.deleteUserRouteConnection(id);
        userRouteService.deleteUserRouteById(id);
        return "redirect:../all";
    }

    @GetMapping("/edit/{id}")
    public String editUserRoute(Model model, @PathVariable Long id) {
        UserRoute userRoute = userRouteService.findUserRouteById(id);
        model.addAttribute("userRoute", userRoute);
        return "addUserRoute";
    }

    @PostMapping("/edit/{id}")
    public String editUserRoute (HttpSession session, @ModelAttribute UserRoute userRoute, BindingResult result) {
        if (result.hasErrors()) {
            return "addUserRoute";
        }
        User user = (User)session.getAttribute("userSession");
        userRoute.setUser(user);
        userRouteService.saveUserRoute(userRoute);
        return "redirect:../all";
    }

    @GetMapping("/details/{id}")
    public String getPublicUserRouteDetails(Model model, @PathVariable Long id) {
        model.addAttribute("userRoute", userRouteService.findUserRouteById(id));
        model.addAttribute("comments", commentService.findAllByUserRouteIdOrderByCreationDateAsc(id));
        model.addAttribute("comment", new Comment());
        return "userRouteDetails";
    }

    @PostMapping("/details/{userRouteId}")
    public String addComment (Model model, @PathVariable Long userRouteId, HttpSession session, @ModelAttribute @Valid Comment comment, BindingResult result) {
        User user = (User)session.getAttribute("userSession");
        UserRoute userRoute = userRouteService.findUserRouteById(userRouteId);
        if (result.hasErrors()) {
            return "redirect:" + userRouteId;
        }
        comment.setUser(user);
        comment.setUserRoute(userRoute);
        commentService.saveComment(comment);
        return "redirect:" + userRouteId;
    }

    @ModelAttribute("routes")
    public List<Route> getRoutes() {return routeService.findAll();}
}
