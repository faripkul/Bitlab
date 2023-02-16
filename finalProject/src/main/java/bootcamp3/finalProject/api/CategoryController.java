package bootcamp3.finalProject.api;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category>getCategories(){
        return categoryService.getAllCategories();
    }
    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
}
