package bootcamp3.security.controller;

import bootcamp3.security.model.News;
import bootcamp3.security.model.User;
import bootcamp3.security.services.NewsService;
import bootcamp3.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        return "/security/firstStr";
    }

    @GetMapping(value = "/signin")
    public String signIn(Model model) {
        return "/security/signin";
    }

    @GetMapping(value = "/signup")
    public String signUp(Model model) {
        return "/security/signup";
    }

    @GetMapping(value = "/updatepassword")
    public String updatePassword(Model model) {
        return "/security/updatepassword";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model) {
        List<News> news = newsService.getNews();
        model.addAttribute("newz", news);
        model.addAttribute("currentUser", userService.getUser());
        return "/security/profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/adminpanel")
    public String adminPanel(Model model) {
        return "/security/adminpanel";
    }


    @GetMapping(value = "/forbidden")
    public String forbidden() {
        return "/security/403";
    }

    @PostMapping(value = "/signup")
    public String signup(@RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_re_password") String rePassword,
                         @RequestParam(name = "user_full_name") String fullName) {
        Boolean result = userService.registerUser(email, password, rePassword, fullName);
        if (result != null) {
            if (result.equals(Boolean.TRUE)) {
                return "redirect:/signup?success";
            } else {
                return "redirect:/signup?usererror";
            }
        } else {
            return "redirect:/signup?passworderror";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/updatepassword")
    public String updatePassword(@RequestParam(name = "old_password") String oldPassword,
                                 @RequestParam(name = "new_password") String newPassword,
                                 @RequestParam(name = "new_re_password") String reNewPassword) {
        Boolean result = userService.updatePassword(oldPassword, newPassword, reNewPassword);
        if (result != null) {
            if (result.equals(Boolean.TRUE)) {
                return "redirect:/updatepassword?success";
            } else {
                return "redirect:/updatepassword?passworderror";
            }
        } else {
            return "redirect:/updatepassword?oldpassworderror";
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addNews")
    public String addNews(Model model) {
        return "/security/addnews";

    }

    @PostMapping(value = "/addNews")
    public String addNews(News news) {
        newsService.addNews(news);
        return "redirect:/profile";
    }
}

