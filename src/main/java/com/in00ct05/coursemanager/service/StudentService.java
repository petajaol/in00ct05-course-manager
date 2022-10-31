package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.data.Student;

@Service
public class StudentService implements ServiceInterface<Student> {

  private final EnrolmentService enrolmentService;
  private final FileService fileService;
  private static final String FILE_PATH = "database/students.txt";
  private List<Student> students;

  public StudentService(final EnrolmentService enrolmentService, final FileService fileService) {
    this.enrolmentService = enrolmentService;
    this.fileService = fileService;
    this.students = fileService.getFileAsList(Student.class, FILE_PATH);
    this.updateIdCounter();
  }

  public List<Student> getItems() {
    return this.students;
  }

  public Student getById(int id) {
    for (Student student : this.students) {
      if (student.getId() == id) {
        return student;
      }
    }
    return null;
  }

  public Student add(Student student) {
    fileService.writeToFile(student, Student.class, FILE_PATH);
    this.students = fileService.getFileAsList(Student.class, FILE_PATH);
    return student;
  }

  public void updateIdCounter() {
    if (!students.isEmpty()) {
      Student.setCount(this.students.size());
    }
  }

  public List<Student> getAttendees(int courseId) {
    List<Enrolment> enrolments = enrolmentService.getEnrolmentsByCourseId(courseId);
    List<Student> attendees = new ArrayList<>();
    for (Student student : this.students) {
      for (Enrolment enrolment : enrolments) {
        if (student.getId() == enrolment.getStudentId()) {
          attendees.add(student);
        }
      }
    }
    return attendees;
  }

}
