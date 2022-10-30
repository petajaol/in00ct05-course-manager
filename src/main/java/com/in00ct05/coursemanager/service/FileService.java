package com.in00ct05.coursemanager.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.in00ct05.coursemanager.data.Course;
import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.data.Student;

@Service
public class FileService {

  private final Gson gson = new Gson();

  public <T> List<T> getFileAsList(Class<T> type, String path) {
    List<T> list = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(path))) {
      while (scanner.hasNextLine()) {
        list.add(gson.fromJson(scanner.nextLine(), type));
      }
      return list;
    } catch (FileNotFoundException e) {
      System.out.println("cannot read from file");
      return list;
    }
  }

  public <T> void writeToFile(T object, Class<T> type, String path) {
    try (FileWriter fileWriter = new FileWriter(new File(path), true)) {
      if (object instanceof Enrolment && !checkIfCourseOrStudentExists((Enrolment) object)) {
        System.out.println("course or student doesn't exist");
      }
      fileWriter.write(gson.toJson(object) + System.lineSeparator());
    } catch (IOException e) {
      System.out.println("cannot write to file");
    }
  }

  public boolean checkIfCourseOrStudentExists(Enrolment enrolment) {
    List<Course> courses = this.getFileAsList(Course.class, "database/courses.txt");
    List<Student> students = this.getFileAsList(Student.class, "database/students.txt");
    boolean courseExists = courses.stream().anyMatch(course -> enrolment.getCourseId() == course.getId());
    boolean studentExists = students.stream().anyMatch(student -> enrolment.getStudentId() == student.getId());
    return courseExists && studentExists;
  }

}
