package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Transactional
@Repository
public interface PlacesRepository extends JpaRepository<Places, Long> {
    List<Places>findAllByCategories(Category category);
    List<Places>findAllByCategoriesAndRegions(Category category, Region region);

//    @Query(value = "SELECT place FROM Places place WHERE LOWER(place.name) LIKE :nameParam")
//    List<Places> searchPlacesByNameAndCategories(Category category,String nameParam);
    @Query("SELECT p FROM Places p WHERE p.name LIKE %?1% OR p.description LIKE %?1%")
     List<Places>findAllK(String keyword);
}
