package com.in00ct05.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in00ct05.coursemanager.data.Enrolment;

@Service
public class EnrolmentService {

  private final FileService fileService;
  private static final String FILE_PATH = "database/enrolments.txt";
  private List<Enrolment> enrolments;

  public EnrolmentService(final FileService fileService) {
    this.fileService = fileService;
    this.enrolments = fileService.getFileAsList(Enrolment.class, FILE_PATH);
    this.updateEnrolmentIdCounter();
  }

  public void updateEnrolmentIdCounter() {
    if (!enrolments.isEmpty()) {
      Enrolment.setCount(this.enrolments.size());
    }
  }

  public void enrolStudent(Enrolment enrolment) {
    fileService.writeToFile(enrolment, Enrolment.class, FILE_PATH);
    this.enrolments = fileService.getFileAsList(Enrolment.class, FILE_PATH);
  }

  public List<Enrolment> getEnrolmentsByStudentId(int studentId) {
    List<Enrolment> enrolments = new ArrayList<>();
    for (Enrolment enrolment : this.enrolments) {
      if (enrolment.getStudentId() == studentId) {
        enrolments.add(enrolment);
      }
    }
    return enrolments;
  }

  public List<Enrolment> getEnrolmentsByCourseId(int courseId) {
    List<Enrolment> enrolments = new ArrayList<>();
    for (Enrolment enrolment : this.enrolments) {
      if (enrolment.getCourseId() == courseId) {
        enrolments.add(enrolment);
      }
    }
    return enrolments;
  }

}
