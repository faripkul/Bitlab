package bootcamp.spring.trello.Repository;

import bootcamp.spring.trello.Classes.BitlabFolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FoldersRepository extends JpaRepository<BitlabFolders, Long> {
}
