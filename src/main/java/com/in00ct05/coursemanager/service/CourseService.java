package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.data.Enrolment;

@Service
public class CourseService {

  @Autowired
  private EnrolmentService enrolmentService;
  private FileService fileService;
  private List<Course> courses;

  public CourseService(FileService fileService) {
    this.fileService = fileService;
    this.courses = fileService.getCoursesAsList();
    this.updateCourseIdCounter();
  }

  public List<Course> getCourses() {
    return this.courses;
  }

  public Course getCourseById(int id) {
    for (Course course : this.courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public void addCourse(Course course) {
    this.courses = fileService.writeCourseToFile(course);
  }

  public void updateCourseIdCounter() {
    if (!courses.isEmpty()) {
      Course.setCount(this.courses.size());
    }
  }

  public List<Course> getAttendedCourses(int courseId) {
    List<Enrolment> enrolments = enrolmentService.getEnrolmentsByStudentId(courseId);
    List<Course> attendedCourses = new ArrayList<>();
    for (Course course : this.courses) {
      for (Enrolment enrolment : enrolments) {
        if (course.getId() == enrolment.getCourseId()) {
          attendedCourses.add(course);
        }
      }
    }
    return attendedCourses;
  }

}
