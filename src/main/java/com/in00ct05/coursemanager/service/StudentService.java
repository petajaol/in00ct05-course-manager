package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.data.Student;

@Service
public class StudentService {

  @Autowired
  private EnrolmentService enrolmentService;
  private FileService fileService;
  private List<Student> students;

  public StudentService(FileService fileService) {
    this.fileService = fileService;
    this.students = fileService.getStudentsAsList();
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
    this.students = fileService.writeStudentToFile(student);
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
