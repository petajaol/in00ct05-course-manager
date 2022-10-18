package com.in00ct05.coursemanager.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
  private static int count;
  private int id;
  private String name, teacher;
  private List<Student> attendees = new ArrayList<>();

  public Course(String name, String teacher) {
    this.id = ++count;
    this.name = name;
    this.teacher = teacher;
  }

  public static void setCount(int count) {
    Course.count = count;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTeacher() {
    return this.teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public List<Student> getAttendees() {
    return this.attendees;
  }

  public void addAttendee(Student student) {
    this.attendees.add(student);
  }

}
