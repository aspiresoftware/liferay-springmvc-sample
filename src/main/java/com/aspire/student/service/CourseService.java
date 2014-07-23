package com.aspire.student.service;

import java.util.List;

import com.aspire.student.model.Course;

/**
 * Interface for service layer of course details
 * 
 * @author aspire
 * 
 */
public interface CourseService {

  /**
   * Retrieve list of course
   * 
   * @return
   * @throws Exception
   */
  public List<Course> getCourseList() throws Exception;
}
