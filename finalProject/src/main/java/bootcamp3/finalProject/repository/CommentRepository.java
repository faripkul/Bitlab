package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Category;
import bootcamp3.finalProject.model.Comment;
import bootcamp3.finalProject.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT comment FROM Comment comment WHERE comment.places.id LIKE :placeId ORDER BY  comment.localDateTime ASC")
    List<Comment>findAllByComment(@Param("placeId")Long id);
}
