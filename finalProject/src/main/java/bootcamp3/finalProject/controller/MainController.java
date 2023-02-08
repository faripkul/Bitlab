package bootcamp3.finalProject.controller;


import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.services.CategoryService;
import bootcamp3.finalProject.services.PlaceService;
import bootcamp3.finalProject.services.RegionService;
import bootcamp3.finalProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RegionService regionService;


//    @Autowired
//    private NewsService newsService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("categoriez",categoryService.getAllCategories());
        return "/travel/primer";
    }

    @GetMapping(value = "/signin")
    public String signIn(Model model) {
        return "/travel/secondPage";
    }

    @GetMapping(value = "/signup")
    public String signUp(Model model) {
        return "/travel/primer";
    }

    @GetMapping(value = "/updatepassword")
    public String updatePassword(Model model) {
        return "/travel/updatepassword";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model) {
//        List<News> news = newsService.getNews();
//        model.addAttribute("newz", news);
//        model.addAttribute("currentUser", userService.getUser());
        return "/travel/secondPage";
    }

    @GetMapping(value = "/infoMesta")
    public String infoMesta(Model model) {
//        List<News> news = newsService.getNews();
//        model.addAttribute("newz", news);
//        model.addAttribute("currentUser", userService.getUser());
        return "/travel/thirdPage";

    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/adminpanel")
    public String adminPanel(Model model) {
        return "/travel/adminpanel";
    }


    @GetMapping(value = "/forbidden")
    public String forbidden() {
        return "/travel/403";
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


    @PostMapping(value = "/addCategory")
    public String addCategory(Category category){
        categoryService.addCategory(category);
        return "redirect:/home";
    }


//    @PostMapping(value = "/addNews")
//    public String addNews(News news) {
//        newsService.addNews(news);
//        return "redirect:/profile";
//    }


    @GetMapping(value = "/category-places/{id}")
    public String categoryPlaces(@PathVariable("id")Long id, Model model){
        Category category = categoryService.getCategory(id);
        System.out.println(category.getId());

        List<Region> regions = regionService.getAllRegions();
        if(category!=null) {
            model.addAttribute("categoriez", category);
            model.addAttribute("regionz", regions);
            model.addAttribute("catplacez", placeService.getPlaces(category));
//            model.addAttribute("regPlasez", placeService.getFinalPlaces(category, region));
        }
        return "travel/secondPage";
        }

    @PostMapping(value = "/addPlaces")
    public String addPlaces(Places places){
        placeService.addPlaces(places);
        return "redirect:/category-places/"+places.getCategories().getId();
    }

    @PostMapping(value = "/addRegion")
    public  String addRegion(Region region){
        regionService.addRegion(region);
        return "redirect:/category-places/"+region.getId();
    }

    @GetMapping(value = "/category_region_places/{regId}/{catId}")
    public String categoryRegionPlaces(@PathVariable("regId") Long regId,
                                       @PathVariable("catId") Long catId, Model model){
        Category category = categoryService.getCategory(catId);
        Region region = regionService.getRegion(regId);
        if(category!=null && region!=null) {
        model.addAttribute("catRegPlasez", placeService.getFinalPlaces(category, region));
        }
        return "travel/nov";
    }
}

