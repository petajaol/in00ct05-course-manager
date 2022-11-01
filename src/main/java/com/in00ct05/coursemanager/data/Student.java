package com.in00ct05.coursemanager.data;

public class Student {

  private final String id = java.util.UUID.randomUUID().toString();
  private String firstName, lastName;
  
  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Student() {
    this("", "");
  }

  public String getId() {
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
