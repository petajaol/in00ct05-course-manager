package com.in00ct05.coursemanager.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Enrolment {

  private static int count;
  private int id, studentId, courseId;

  @JsonCreator
  public Enrolment(@JsonProperty("studentId") int studentId, @JsonProperty("courseid") int courseId) {
    this.id = ++count;
    this.studentId = studentId;
    this.courseId = courseId;
  }

  public static void setCount(int count) {
    Enrolment.count = count;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
}
