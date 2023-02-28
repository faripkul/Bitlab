package bootcamp3.finalProject.controller;


import bootcamp3.finalProject.model.*;
import bootcamp3.finalProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteService favoriteService;


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("categoriez", categoryService.getAllCategories());
        return "/travel/primer";
    }

    @GetMapping(value = "/test")
    public String test(Model model) {
        return "/travel/test2";
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
        String keyword = "Almaty";
        Category category = categoryService.getCategory(id);
        List<Region> regions = regionService.getAllRegions();
        if (category != null) {
            model.addAttribute("categoriez", category);
            model.addAttribute("regionz", regions);
            model.addAttribute("catplacez", placeService.getPlaces(category));
            model.addAttribute("catplacezz", placeService.listAll(keyword));
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

    @PostMapping(value = "/deletePlace")
    public String deletePlace(@RequestParam(name = "placId")Long placeId,
                              @RequestParam(name = "categId")Long catId){
        placeService.deletePlaces(placeId);
        return "redirect:/category-places/"+catId;
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
        List<Region> regions = regionService.getAllRegions();
        Region region = regionService.getRegion(regId);
        if (category != null && region != null) {
            model.addAttribute("categoriez", category);
            model.addAttribute("regionz", regions);
            model.addAttribute("catRegPlasez", placeService.getFinalPlaces(category, region));
        }
        return "/travel/lastPlacePage";
    }

    @GetMapping(value = "/infoMesta/{id}")
    public String infoMesta(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("onePlace", placeService.getPlace(id));
        return "/travel/thirdPage";

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/adminPanel")
    public String adminPanel(Model model) {
        model.addAttribute("offerz", offerService.getOffers()) ;
        model.addAttribute("regionzz", regionService.getAllRegions());
        model.addAttribute("categoriez", categoryService.getAllCategories());
        return "/travel/adminPanel";
    }

//    @GetMapping(value = "/wantVisit")
//    public String wantVisit(Model model, @PathVariable(name = "id") Long id) {
//        model.addAttribute("favplacez",favoriteService.getFavByUserId(id));
//        return "/travel/wantVisit";
//    }
//
//     @PostMapping(value = "/addVisit")
//     public String addVisitPlaces(@RequestParam(name="place_id") Long placeId){
//        User user = userService.getUser();
//        userService.assignPlaces(user, placeId);
//        return "redirect:/wantVisit";
//    }


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
                             @RequestParam(name = "filetwo") MultipartFile fileTwo,
                             @RequestParam(name = "filethree") MultipartFile fileThree,
                            @RequestParam(name = "region_id") Long regId,
                            @RequestParam(name = "category_id") Long catId) {

        placeService.addPlacesF(file,fileTwo,fileThree, name, description, history,regId, catId);
        return "redirect:/adminPanel";

    }


    @PostMapping(value = "/addFavPlaces")
    public String addFavPlaces(Favorites favorites, @RequestParam(name = "placeId") Long placeId,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "description") String description) {
        favoriteService.addFavPlace(favorites, placeId, name,description);
        return "redirect:/wantVisit";
    }

    @PostMapping(value = "/delFavPlaces")
    public String delFavPlaces(@RequestParam(name = "favPlaceId") Long placeId) {
        favoriteService.deleteFavPlace(placeId);
        return "redirect:/adminPanel";
    }



    @GetMapping(value = "/wantVisit")
    public String getAllFavPlaces(Model model){
        model.addAttribute("favoritez",favoriteService.getAllFavPlaces(userService.getUser()));
        return "/travel/wantVisit";
    }

    @PostMapping(value = "/addOffer")
    public String addOffer(Offer offer) {
        regionService.addOffer(offer);
        return "redirect:/adminPanel";
    }

    @PostMapping(value = "/deleteOffer")
    public String delOffer(@RequestParam(name = "offId") Long offerId) {
        offerService.delOffer(offerId);
        return "redirect:/adminPanel";
    }
    @GetMapping(value = "/search")
        public String searchPlaces(Model model, @RequestParam(name = "keyword") String keyword) {
        List<Region> regions = regionService.getAllRegions();
            model.addAttribute("regionz", regions);
            model.addAttribute("placez", placeService.listAll(keyword));
            return "travel/searchPage";
    }
}

