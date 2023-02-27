package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.*;
import bootcamp3.finalProject.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

//    public List<Places> getFavByUserId(Long userId){
//        List<Favorites> favorites = favoriteRepository.findAllByUserId(userId);
//        List<Places> places = new ArrayList<>();
//        for(Favorites f: favorites){
//            places.add(f.getPlaces());
//        }
//        return places;
//    }


    public Favorites addFavPlace(Favorites favorites, Long placeId, String name,String description){
        favorites.setUser(userService.getUser());
        favorites.setLocalDateTime(LocalDateTime.now());
        favorites.setName(name);
        favorites.setDescription(description);
        favorites.setPlaces(placeService.getPlace(placeId));
        return favoriteRepository.save(favorites);
    }

    public List<Favorites> getAllFavPlaces(User user){
        return favoriteRepository.findAllByUser(user);
    }

    public List<Favorites> getAllFavPlaces(){
        return favoriteRepository.findAll();
    }

    public void deleteFavPlace(Long id){
        favoriteRepository.deleteById(id);
    }
}