package com.in00ct05.coursemanager.contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.data.Student;
import com.in00ct05.coursemanager.service.CourseService;

@RestController
public class CourseController {

  @Autowired
  private CourseService courseService;

  @GetMapping("/courses")
  public List<Course> getCourses() {
    return courseService.getCourses();
  }

  @GetMapping("/courses/{id}")
  public Course getCourse(@PathVariable int id) {
    return courseService.getCourseById(id);
  }

  @PostMapping("/courses")
  public void addCourse(@RequestBody Course course) throws IOException {
    courseService.addCourse(course);
  }

  @GetMapping("/courses/{id}/attendees")
  public List<Student> getAttendees(@PathVariable int id) {
    return courseService.getAttendeesByCourseId(id);
  }

  @PostMapping("/courses/{id}/attendees")
  public void addAttendee(@PathVariable int id, @RequestBody Student student) {
    courseService.addAttendee(id, student);
  }
}
