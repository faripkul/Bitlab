package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.model.User;
import bootcamp3.finalProject.repository.CategoryRepository;
import bootcamp3.finalProject.repository.PlacesRepository;
import bootcamp3.finalProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    @Autowired
    PlacesRepository placesRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RegionService regionService;

    @Autowired
    CategoryService categoryService;

    private final UserService userService;


    public List<Places> getAllPlaces(){
        return placesRepository.findAll();
    }

    public Places getPlace(Long id){
        return placesRepository.findById(id).orElseThrow();
    }

    public List<Places>getPlaces(Category category){
        return placesRepository.findAllByCategories(category);
     }

    public Places addPlaces(Places places){
        return placesRepository.save(places);
    }

    public void addPlacesF(MultipartFile file, String name, String description, String history, Long regId, Long catId){
        Places places1 = new Places();
        String fileNAme = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileNAme.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            places1.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){
          e.printStackTrace();
        }
        places1.setDescription(description);
        places1.setHistory(history);
        places1.setName(name);
        places1.setRegions(regionService.getRegion(regId));
        places1.setCategories(categoryService.getCategory(catId));
        placesRepository.save(places1);
    }





    public void assignPlace(Long placeId){
      User user = userService.getUser();
      if(user!=null) {
           Places place = getPlace(placeId);
          if (place != null) {
             List<Places> places = user.getPlaces();
          if (places == null) {
              places = new ArrayList<>();
            }
           places.add(place);
            user.setPlaces(places);
              userRepository.save(user);
            }
        }
    }

    public List<Places>getFinalPlaces(Category category, Region region){
        return placesRepository.findAllByCategoriesAndRegions(category, region);
    }

}
