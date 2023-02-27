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

//    public List<Places> getAllUserPlaces(){
//        User user = userService.getUser();
//        return placesRepository.findAllByUserId(user.getId());
//    }
    public Places getPlace(Long id){
        return placesRepository.findById(id).orElseThrow();
    }

    public List<Places>getPlaces(Category category){
        return placesRepository.findAllByCategories(category);
     }

//    public List<Places>getSearchPlaces(Category category, String nameParam){
//        return placesRepository.searchPlacesByNameAndCategories(category, nameParam);
//    }



    public Places addPlaces(Places places){
        return placesRepository.save(places);
    }



    public void addPlacesF(MultipartFile file,MultipartFile filetwo,MultipartFile filethree, String name, String description, String history, Long regId, Long catId){
        Places places1 = new Places();
        String fileNAme = StringUtils.cleanPath(file.getOriginalFilename());
        String fileNAmeTwo = StringUtils.cleanPath(filetwo.getOriginalFilename());
        String fileNAmeThree = StringUtils.cleanPath(filethree.getOriginalFilename());
        if(fileNAme.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            places1.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            places1.setImagetwo(Base64.getEncoder().encodeToString(filetwo.getBytes()));
            places1.setImagethree(Base64.getEncoder().encodeToString(filethree.getBytes()));

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


    public void deletePlaces(Long id){
        placesRepository.deleteById(id);
    }

    public void assignPlace(Long placeId){
        Places places1 = new Places();
        places1.setId(placeId);
        placesRepository.save(places1);
      }

//    public void assignPlace2(Long placeId, Long userId){
//        Long userId = userService.getUser().getId();
//
//
//
//
////        User user = userService.getUser();
////        if(user!=null) {
////            Places place = getPlace(placeId);
////            if (place != null) {
////                List<Places> places = user.getPlaces();
////                if (places == null) {
////                    places = new ArrayList<>();
////                }
////                places.add(place);
////                user.setPlaces(places);
////                userRepository.save(user);
////            }
//        }
//    }

    public List<Places>getFinalPlaces(Category category, Region region){
        return placesRepository.findAllByCategoriesAndRegions(category, region);
    }

    public void getPlacesF(String name, String description, String history, Long regId){
        Places places1 = new Places();
        places1.setDescription(description);
        places1.setHistory(history);
        places1.setName(name);
        places1.setRegions(regionService.getRegion(regId));
        placesRepository.save(places1);
    }
}
