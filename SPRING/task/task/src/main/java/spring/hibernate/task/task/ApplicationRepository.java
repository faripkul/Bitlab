package spring.hibernate.task.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<BitlabApplications, Long> {
    List<BitlabApplications>findAllByHandledIsTrue();
    List<BitlabApplications>findAllByHandledIsFalse();
}
