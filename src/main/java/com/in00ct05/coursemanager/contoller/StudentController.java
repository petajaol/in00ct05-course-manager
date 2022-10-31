package com.in00ct05.coursemanager.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.in00ct05.coursemanager.data.Student;
import com.in00ct05.coursemanager.service.StudentService;

@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(final StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @GetMapping("/students/{id}")
  public Student getStudent(@PathVariable int id) {
    return studentService.getStudentById(id);
  }

  @GetMapping("/students/course/{id}")
  public List<Student> getAttendees(@PathVariable int id) {
    return studentService.getAttendees(id);
  }

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
  }

}
