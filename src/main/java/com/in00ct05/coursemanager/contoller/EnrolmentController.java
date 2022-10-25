package com.in00ct05.coursemanager.contoller;

import org.springframework.web.bind.annotation.*;

import com.in00ct05.coursemanager.data.Enrolment;
import com.in00ct05.coursemanager.service.EnrolmentService;

@RestController
public class EnrolmentController {

  private final EnrolmentService enrolmentService;

  public EnrolmentController(final EnrolmentService enrolmentService) {
    this.enrolmentService = enrolmentService;
  }

  @PostMapping("/enrolment")
  public void enrolStudent(@RequestBody Enrolment enrolment) {
    enrolmentService.enrolStudent(enrolment);
  }
}
