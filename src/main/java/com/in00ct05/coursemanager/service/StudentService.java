package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.data.Student;

@Service
public class StudentService {

  private final EnrolmentService enrolmentService;
  private final FileService fileService;
  private static final String FILE_PATH = "database/students.txt";
  private List<Student> students;

  public StudentService(final EnrolmentService enrolmentService, final FileService fileService) {
    this.enrolmentService = enrolmentService;
    this.fileService = fileService;
    this.students = fileService.getFileAsList(Student.class, FILE_PATH);
    this.updateStudentIdCounter();
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public Student getStudentById(int id) {
    for (Student student : this.students) {
      if (student.getId() == id) {
        return student;
      }
    }
    return null;
  }

  public void addStudent(Student student) {
    this.students = fileService.writeToFile(student, Student.class, FILE_PATH);
  }

  public void updateStudentIdCounter() {
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
