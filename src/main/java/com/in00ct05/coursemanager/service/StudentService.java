package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.in00ct05.coursemanager.data.Course;

@Service
public class StudentService {
  private List<Course> attendedCourses = new ArrayList<>();

  public List<Course> getCourses() {
    return this.attendedCourses;
  }

}
