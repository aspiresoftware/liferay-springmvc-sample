package com.aspire.student.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.student.dao.GenericDAO;
import com.aspire.student.model.Course;

/**
 * Implementation of service layer for course
 * 
 * @author aspire
 * 
 */
@Service
public class CourseServiceImpl implements CourseService {

  private Logger logger = Logger.getLogger(CourseServiceImpl.class);

  /**
   * Reference to the data object
   */
  @Autowired
  private GenericDAO<Course, Long> courseDAO;

  /* (non-Javadoc)
   * @see com.aspire.student.service.CourserService#getCourseList()
   */
  @Override
  public List<Course> getCourseList() throws Exception {
    logger.debug("getCourseList()");
    return courseDAO.findAll();
  }
}
