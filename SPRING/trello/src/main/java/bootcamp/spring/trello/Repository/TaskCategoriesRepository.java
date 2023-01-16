package bootcamp.spring.trello.Repository;

import bootcamp.spring.trello.Classes.BitlabTaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskCategoriesRepository extends JpaRepository<BitlabTaskCategories, Long> {
}
