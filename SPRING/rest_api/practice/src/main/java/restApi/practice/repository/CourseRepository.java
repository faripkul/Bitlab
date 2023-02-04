package restApi.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restApi.practice.model.Course;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
