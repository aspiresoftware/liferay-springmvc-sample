package com.aspire.student.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.student.dao.GenericDAO;
import com.aspire.student.model.CourseCategory;

/**
 * Implementation of service layer for course categories
 * 
 * @author aspire
 * 
 */
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

  private Logger logger = Logger.getLogger(CourseCategoryServiceImpl.class);

  /**
   * Reference to the data object
   */
  @Autowired
  private GenericDAO<CourseCategory, Long> courseCategoryDAO;

  /* (non-Javadoc)
   * @see com.aspire.student.service.CourseCategoryService#getCourseCategories()
   */
  @Override
  public List<CourseCategory> getCourseCategories() throws Exception {
    logger.debug("getCourseCategories()");
    return courseCategoryDAO.findAll();
  }
}
