package com.in00ct05.coursemanager.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.data.Student;
import com.in00ct05.coursemanager.fileservice.CourseFileService;

@Service
public class CourseService {
  private CourseFileService courseFileService;
  private List<Course> courses = new ArrayList<>();

  public CourseService(CourseFileService courseFileService) {
    this.courseFileService = courseFileService;
    this.setCourses();
    this.updateCourseIdCounter();
  }

  public List<Course> getCourses() {
    return this.courses;
  }

  public void setCourses() {
    this.courses = courseFileService.getCoursesAsList();
  }

  public Course getCourseById(int id) {
    for (Course course : this.courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public void addCourse(Course course) throws IOException {
    this.courses.add(course);
    courseFileService.writeCourseToFile(course);
  }

  public void updateCourseIdCounter() {
    if (!courses.isEmpty()) {
      Course.setCount(this.courses.size());
      // List<Integer> ids = new ArrayList<>();
      // for (Course course : courses) {
      // ids.add(course.getId());
      // }
      // Course.setCount(Collections.max(ids));
    }
  }

  public List<Student> getAttendeesByCourseId(int id) {
    for (Course course : this.courses) {
      if (course.getId() == id) {
        return course.getAttendees();
      }
    }
    return null;
  }

  public void addAttendee(int id, Student student) throws IOException {
    for (Course course : this.courses) {
      if (course.getId() == id) {
       course.addAttendee(student);
       courseFileService.editCourseInFile(course);
      }
    }
  }

}
