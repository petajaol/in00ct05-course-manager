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
  Gson gson = new Gson();

  public void writeCourseToFile(Course course) {
    try {
      FileWriter fileWriter = new FileWriter(new File("database/courses.txt"), true);
      fileWriter.write(gson.toJson(course) + System.lineSeparator());
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("cannot write to file");
    }
  }

  public void writeCoursesToFile(List<Course> courses) {
    try {
      FileWriter fileWriter = new FileWriter(new File("database/courses.txt"), false);
      for (Course course : courses) {
        fileWriter.write(gson.toJson(course) + System.lineSeparator());
      }
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("cannot write to file");
    }
  }

  public List<Course> getCoursesAsList() {
    List<Course> courses = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(new File("database/courses.txt"));
      while (scanner.hasNextLine()) {
        courses.add(gson.fromJson(scanner.nextLine(), Course.class));
      }
      scanner.close();
      return courses;
    } catch (FileNotFoundException e) {
      return courses;
    }
  }

  public void writeStudentToFile(Student student) {
    try {
      FileWriter fileWriter = new FileWriter(new File("database/students.txt"), true);
      fileWriter.write(gson.toJson(student) + System.lineSeparator());
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("cannot write to file");
    }
  }

  public void writeStudentsToFile(List<Student> students) {
    try {
      FileWriter fileWriter = new FileWriter(new File("database/students.txt"), false);
      for (Student student : students) {
        fileWriter.write(gson.toJson(student) + System.lineSeparator());
      }
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("cannot write to file");
    }
  }

  public List<Student> getStudentsAsList() {
    List<Student> students = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(new File("database/students.txt"));
      while (scanner.hasNextLine()) {
        students.add(gson.fromJson(scanner.nextLine(), Student.class));
      }
      scanner.close();
      return students;
    } catch (FileNotFoundException e) {
      return students;
    }
  }

  public void writeEnrolmentToFile(Enrolment enrolment) {
    try {
      FileWriter fileWriter = new FileWriter(new File("database/enrolments.txt"), true);
      fileWriter.write(gson.toJson(enrolment) + System.lineSeparator());
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("cannot write to file");
    }
  }

  public List<Enrolment> getEnrolmentsAsList() {
    List<Enrolment> enrolments = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(new File("database/enrolments.txt"));
      while (scanner.hasNextLine()) {
        enrolments.add(gson.fromJson(scanner.nextLine(), Enrolment.class));
      }
      scanner.close();
      return enrolments;
    } catch (FileNotFoundException e) {
      return enrolments;
    }
  }

}
