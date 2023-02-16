package bootcamp3.finalProject.controller;


import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
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


    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("categoriez", categoryService.getAllCategories());
        return "/travel/primer";
    }

    @GetMapping(value = "/signin")
    public String signIn(Model model) {
        return "/travel/signin";
    }

    @GetMapping(value = "/signup")
    public String signUp(Model model) {
        return "/travel/registr";
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
        return "/travel/primer";
    }


//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
//    @GetMapping(value = "/adminpanel")
//    public String adminPanel(Model model) {
//        return "/travel/adminpanel";
//    }


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
    public String addCategory(Category category) {
        categoryService.addCategory(category);
        return "redirect:/adminPanel";
    }


    @GetMapping(value = "/category-places/{id}")
    public String categoryPlaces(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategory(id);
        List<Region> regions = regionService.getAllRegions();
        if (category != null) {
            model.addAttribute("categoriez", category);
            model.addAttribute("regionz", regions);
            model.addAttribute("catplacez", placeService.getPlaces(category));
        }
        return "travel/secondPage";
    }

    @PostMapping(value = "/addPlace")
    public String addPlaces(Places places,
                            @RequestParam(name = "region_id") Long regId,
                            @RequestParam(name = "category_id") Long catId) {
        places.setRegions(regionService.getRegion(regId));
        places.setLocalDate(LocalDate.from(LocalDateTime.now()));
        places.setCategories(categoryService.getCategory(catId));
        placeService.addPlaces(places);
        return "redirect:/adminPanel";
    }

    @PostMapping(value = "/addRegion")
    public String addRegion(Region region) {
        regionService.addRegion(region);
        return "redirect:/adminPanel";
    }

    @GetMapping(value = "/category_region_places/{regId}/{catId}")
    public String categoryRegionPlaces(@PathVariable("regId") Long regId,
                                       @PathVariable("catId") Long catId, Model model) {
        Category category = categoryService.getCategory(catId);
        Region region = regionService.getRegion(regId);
        if (category != null && region != null) {
            model.addAttribute("categoriez", category);
            model.addAttribute("catRegPlasez", placeService.getFinalPlaces(category, region));
        }
        return "travel/finishFilterPage";
    }

    @GetMapping(value = "/infoMesta/{id}")
    public String infoMesta(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("onePlace", placeService.getPlace(id));
        return "/travel/thirdPage";

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/adminPanel")
    public String adminPanel(Model model) {
        model.addAttribute("regionzz", regionService.getAllRegions());
        model.addAttribute("categoriez", categoryService.getAllCategories());
        return "/travel/adminPanel";
    }

    @GetMapping(value = "/wantVisit/{place_id}")
    public String wantVisit(@PathVariable(name = "place_id") Long id, Model model) {
     model.addAttribute("plasez",placeService.getPlace(id));
     model.addAttribute("userz", userService.getUser());
     return "/travel/wantVisit";
    }

     @PostMapping(value = "/addVisit")
     public String addVisitPlaces(@RequestParam(name="place_id") Long placeId){
        placeService.assignPlace(placeId);
        return "redirect:/wantVisit/"+placeId;
    }


    @PostMapping(value = "/uploadpicture")
    public String uploadAvatar(@RequestParam(name = "avatar")MultipartFile file){
        fileUploadService.uploadAvatar(file);
        return "redirect:/primer";
    }

    @PostMapping(value = "/addPlaceF")
    public String addPlaces( @RequestParam(name = "name") String name,
                             @RequestParam(name = "description") String description,
                             @RequestParam(name = "history") String history,
                             @RequestParam(name = "file") MultipartFile file,
                            @RequestParam(name = "region_id") Long regId,
                            @RequestParam(name = "category_id") Long catId) {

        placeService.addPlacesF(file, name, description, history,regId, catId);
        return "redirect:/adminPanel";

    }
}

