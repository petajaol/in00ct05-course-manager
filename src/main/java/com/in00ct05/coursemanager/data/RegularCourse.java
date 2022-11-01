package com.in00ct05.coursemanager.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegularCourse extends Course {

  @JsonCreator
  public RegularCourse(@JsonProperty("name") String name, @JsonProperty("teacher") String teacher) {
    super(name, teacher, "regular");
  }
  
}
