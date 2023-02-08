package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    PlacesRepository placesRepository;


    public List<Places> getAllPlaces(){
        return placesRepository.findAll();
    }

    public List<Places>getPlaces(Category category){
        return placesRepository.findAllByCategories(category);
     }

    public Places addPlaces(Places places){
        return placesRepository.save(places);
    }

    public List<Places>getFinalPlaces(Category category, Region region){
        return placesRepository.findAllByCategoriesAndRegions(category, region);
    }
}
