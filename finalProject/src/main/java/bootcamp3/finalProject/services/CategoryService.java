package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.User;
import bootcamp3.finalProject.repository.CategoryRepository;
import bootcamp3.finalProject.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PlacesRepository placesRepository;

    public List<Category> getAllCategories(){
       return categoryRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }


}
