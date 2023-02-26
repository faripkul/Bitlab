package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.User;
import bootcamp3.finalProject.repository.CategoryRepository;
import bootcamp3.finalProject.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PlacesRepository placesRepository;

    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category addCategoryF(String name, String description, MultipartFile file){
        Category category = new Category();
        String fileNAme = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileNAme.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            category.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
        category.setName(name);
        category.setDescription(description);
        return categoryRepository.save(category);
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }


}
