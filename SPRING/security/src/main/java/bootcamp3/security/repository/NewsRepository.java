package bootcamp3.security.repository;

import bootcamp3.security.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
   List<News>findAllByOrderByPostDateDesc();
}
