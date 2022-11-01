package com.in00ct05.coursemanager.data;

public class Enrolment {

  private static int count;
  private int id;
  private String studentId, courseId;

  public Enrolment(String studentId, String courseId) {
    this.id = ++count;
    this.studentId = studentId;
    this.courseId = courseId;
  }

  public Enrolment() {
    this("", "");
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

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }
}
