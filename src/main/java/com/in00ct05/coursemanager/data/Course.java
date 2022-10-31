package com.in00ct05.coursemanager.data;

public abstract class Course {

  private static int count;
  private int id;
  private String name, teacher, type;

  public Course(String name, String teacher, String type) {
    this.id = ++count;
    this.name = name;
    this.teacher = teacher;
    this.type = type;
  }

  public Course() {
    this("", "", "");
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
