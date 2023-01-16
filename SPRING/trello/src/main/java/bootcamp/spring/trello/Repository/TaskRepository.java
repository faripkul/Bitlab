package bootcamp.spring.trello.Repository;

import bootcamp.spring.trello.Classes.BitlabFolders;
import bootcamp.spring.trello.Classes.BitlabTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<BitlabTasks,Long> {
    List<BitlabTasks> findAllByFolderOrderByTitleAsc(BitlabFolders folders);
}
