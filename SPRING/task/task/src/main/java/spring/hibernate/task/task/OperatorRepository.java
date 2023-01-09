package spring.hibernate.task.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OperatorRepository extends JpaRepository<BitlabOperators, Long> {
}
