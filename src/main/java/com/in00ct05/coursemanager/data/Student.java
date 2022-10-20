package com.in00ct05.coursemanager.data;

public class Student {
  private static int count;
  private int id;
  private String firstName, lastName;

  public Student(String firstName, String lastName) {
    this.id = ++count;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public static void setCount(int count) {
    Student.count = count;
  }

  public int getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
