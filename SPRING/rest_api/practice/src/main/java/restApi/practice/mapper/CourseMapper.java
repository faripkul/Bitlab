package restApi.practice.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import restApi.practice.dto.CourseDTO;
import restApi.practice.model.Course;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseDTO courseDTO);
    CourseDTO toDto(Course course);
    List<Course> toEntityList(List<CourseDTO>courseDTOList);
    List<CourseDTO>toDtoList(List<Course>courseList);
}
