package restApi.practice.service;

import restApi.practice.dto.CourseDTO;
import restApi.practice.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();
    Course getCourse(Long id);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    boolean deleteCourse(Long id);


    List<CourseDTO> getAllCourses();
    CourseDTO getOneCourse(Long id);
    CourseDTO updateCourse(CourseDTO courseDTO);
    CourseDTO addCourse(CourseDTO courseDTO);
}
