package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.data.RegularCourse;

@Service
public class RegularCourseService extends Course implements ServiceInterface<RegularCourse> {

  private final EnrolmentService enrolmentService;
  private final FileService fileService;
  private static final String FILE_PATH = "database/courses.txt";
  private List<RegularCourse> courses;

  public RegularCourseService(final EnrolmentService enrolmentService, final FileService fileService) {
    this.enrolmentService = enrolmentService;
    this.fileService = fileService;
    this.courses = fileService.getFileAsList(RegularCourse.class, FILE_PATH);
    this.updateIdCounter();
  }

  public List<RegularCourse> getItems() {
    return this.courses;
  }

  public RegularCourse getById(int id) {
    for (RegularCourse course : this.courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public RegularCourse add(RegularCourse course) {
    fileService.writeToFile(course, Course.class, FILE_PATH);
    this.courses = fileService.getFileAsList(RegularCourse.class, FILE_PATH);
    return course;
  }

  public void updateIdCounter() {
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
