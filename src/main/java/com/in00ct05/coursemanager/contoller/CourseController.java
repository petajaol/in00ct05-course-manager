package com.in00ct05.coursemanager.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.service.CourseService;

@RestController
public class CourseController {

  private final CourseService courseService;

  public CourseController(final CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping("/courses")
  public List<Course> getCourses() {
    return courseService.getCourses();
  }

  @GetMapping("/courses/{id}")
  public Course getCourse(@PathVariable int id) {
    return courseService.getCourseById(id);
  }

  @GetMapping("/courses/student/{id}")
  public List<Course> getAttendedCourses(@PathVariable int id) {
    return courseService.getAttendedCourses(id);
  }

  @PostMapping("/courses")
  public Course addCourse(@RequestBody Course course) {
    return courseService.addCourse(course);
  }

}
