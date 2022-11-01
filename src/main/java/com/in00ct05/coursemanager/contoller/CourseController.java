package com.in00ct05.coursemanager.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.data.RegularCourse;
import com.in00ct05.coursemanager.service.RegularCourseService;

@RestController
public class CourseController {

  private final RegularCourseService courseService;

  public CourseController(final RegularCourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping("/courses")
  public List<RegularCourse> getCourses() {
    return courseService.getItems();
  }

  @GetMapping("/courses/{id}")
  public Course getCourse(@PathVariable String id) {
    return courseService.getById(id);
  }

  @GetMapping("/courses/student/{id}")
  public List<Course> getAttendedCourses(@PathVariable String id) {
    return courseService.getAttendedCourses(id);
  }

  @PostMapping("/courses")
  public Course addCourse(@RequestBody RegularCourse course) {
    return courseService.add(course);
  }

}
