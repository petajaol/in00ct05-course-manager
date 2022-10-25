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
      return list;
    }
  }

  public <T> List<T> writeToFile(T object, Class<T> type, String path) {
    try (FileWriter fileWriter = new FileWriter(new File(path), true)) {
      // if (checkIfObjectExists(type, object, path)) {
      fileWriter.write(gson.toJson(object) + System.lineSeparator());
      return this.getFileAsList(type, path);
      // }
      // System.out.println("course or student doesn't exist");
      // return this.getFileAsList(type, path);
    } catch (IOException e) {
      System.out.println("cannot write to file");
      return this.getFileAsList(type, path);
    }
  }

  // public <T> boolean checkIfObjectExists(Class<T> type, T object, String path)
  // {
  // List<T> list = this.getFileAsList(type, path);
  // return courses.stream().anyMatch(course -> enrolment.getCourseId() ==
  // course.getId());
  // }

}
