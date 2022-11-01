package com.in00ct05.coursemanager.data;

public abstract class Course {

  private final String id = java.util.UUID.randomUUID().toString();
  private String name, teacher, type;

  public Course(String name, String teacher, String type) {
    this.name = name;
    this.teacher = teacher;
    this.type = type;
  }

  public Course() {
    this("", "", "");
  }

  public String getId() {
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
