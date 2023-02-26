package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
//    List<Places> findAllByUserPlaces();
}
