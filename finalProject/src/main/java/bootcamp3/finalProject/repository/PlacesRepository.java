package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.Region;
import bootcamp3.finalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PlacesRepository extends JpaRepository<Places, Long> {
    List<Places>findAllByCategories(Category category);
    List<Places>findAllByCategoriesAndRegions(Category category, Region region);

}
