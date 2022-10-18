package com.in00ct05.coursemanager.fileservice;

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

@Service
public class CourseFileService {
  Gson gson = new Gson();

  public void writeCourseToFile(Course course) throws IOException {
    FileWriter fileWriter = new FileWriter(new File("courses.txt"), true);
    fileWriter.write(gson.toJson(course) + System.lineSeparator());
    fileWriter.close();
  }

  public List<Course> getCoursesAsList() {
    List<Course> courses = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(new File("courses.txt"));
      while (scanner.hasNextLine()) {
        courses.add(gson.fromJson(scanner.nextLine(), Course.class));
      }
      scanner.close();
      return courses;
    } catch (FileNotFoundException e) {
      return courses;
    }
  }

  public void editCourseInFile(Course editedCourse) throws IOException {
    List<Course> courses = getCoursesAsList();
    for (Course course : courses) {
      if (course.getId() == editedCourse.getId()) {
        courses.set(courses.indexOf(course), editedCourse);
      }
    }
    FileWriter fileWriter = new FileWriter(new File("courses.txt"));
    for (Course course : courses) {
      fileWriter.write(gson.toJson(course) + System.lineSeparator());
    }
    fileWriter.close();
  }
}
