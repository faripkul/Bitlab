package restApi.practice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restApi.practice.dto.CourseDTO;
import restApi.practice.mapper.CourseMapper;
import restApi.practice.model.Course;
import restApi.practice.repository.CourseRepository;
import restApi.practice.service.CourseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class CourseServiceImpl implements CourseService {
    @Autowired
    private  CourseRepository courseRepository;
    @Autowired
    private  CourseMapper courseMapper;


    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public boolean deleteCourse(Long id) {
        Course course = getCourse(id);
        if(course!=null) {
            courseRepository.delete(course);
            return true;
        }
            return false;
        }

    @Override
    public List<CourseDTO> getAllCourses(){

        return courseMapper.toDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDTO getOneCourse(Long id) {
        return courseMapper.toDto(getCourse(id));
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        return courseMapper.toDto(updateCourse(courseMapper.toEntity(courseDTO)));
    }

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
       Course course = courseMapper.toEntity(courseDTO);
       course.setAddedTime(LocalDateTime.now());
       course.setProfessional(true);
       course=addCourse(course);
       return courseMapper.toDto(course);
    }
}

