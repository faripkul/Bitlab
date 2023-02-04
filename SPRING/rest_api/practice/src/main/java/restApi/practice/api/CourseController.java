package restApi.practice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restApi.practice.dto.CourseDTO;
import restApi.practice.model.Course;
import restApi.practice.service.CourseService;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(value = "{id}")
    public CourseDTO getCourse(@PathVariable Long id) {
        return courseService.getOneCourse(id);
    }

    @GetMapping(value = "{id}/{name}")
    public String getTest(@PathVariable Long id, @PathVariable String name) {
        return "You entered " + name + " " + id;
    }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO course) {
        return courseService.addCourse(course);
    }

    @PutMapping
    public CourseDTO editCourse(@RequestBody CourseDTO course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("{id}")
    public Boolean deleteCourse(Long id) {
        return courseService.deleteCourse(id);
    }
}