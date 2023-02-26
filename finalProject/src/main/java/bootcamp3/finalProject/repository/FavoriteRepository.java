package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Comment;
import bootcamp3.finalProject.model.Favorites;
import bootcamp3.finalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface FavoriteRepository extends JpaRepository<Favorites, Long> {
//    @Query(value = "SELECT favorites FROM Favorites favorites WHERE favorites.places.id LIKE :placeId ORDER BY  favorites.places.size ASC")
//    List<Favorites>findAllByComment(@Param("placeId")Long id);

    List<Favorites>findAllByUser(User user);
}
