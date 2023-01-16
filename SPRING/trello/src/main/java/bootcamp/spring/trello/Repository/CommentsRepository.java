package bootcamp.spring.trello.Repository;

import bootcamp.spring.trello.Classes.BitlabComments;
import bootcamp.spring.trello.Classes.BitlabTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CommentsRepository extends JpaRepository<BitlabComments,Long> {
    List<BitlabComments>findAllByTaskOrderByIdDesc(BitlabTasks tasks);
}
