package com.in00ct05.coursemanager.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.service.EnrolmentService;

@RestController
public class EnrolmentController {
  @Autowired
  private EnrolmentService enrolmentService;

  @PostMapping("/enrolment")
  public void enrolStudent(@RequestBody Enrolment enrolment) {
    enrolmentService.enrolStudent(enrolment);
  }
}
