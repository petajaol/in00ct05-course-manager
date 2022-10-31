package com.in00ct05.coursemanager.data;

public class RegularCourse extends Course {

  public RegularCourse(String name, String teacher) {
    super(name, teacher, "regular");
  }

  public RegularCourse() {
    super("", "", "regular");
  }
  
}
