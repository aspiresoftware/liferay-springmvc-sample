package com.aspire.student.service;

import java.util.List;

import com.aspire.student.model.CourseCategory;

/**
 * Interface for service layer of course category
 * 
 * @author aspire
 * 
 */
public interface CourseCategoryService {

  /**
   * Retrieve list of category
   * 
   * @return
   * @throws Exception
   */
  public List<CourseCategory> getCourseCategories() throws Exception;
}
