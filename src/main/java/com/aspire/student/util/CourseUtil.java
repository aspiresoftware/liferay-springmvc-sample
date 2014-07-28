package com.aspire.student.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.aspire.student.model.Course;
import com.aspire.student.service.CourseService;

/**
 * A Utility class for course
 * @author aspire20
 * 
 */
public class CourseUtil {

  public static Logger logger = Logger.getLogger(CourseUtil.class);

  /**
   * Use to load courses and set in map
   * @param courseService
   * @param map
   */
  public static void loadCourseList(CourseService courseService, Map<String, Object> map) {
    List<Course> courseList = null;
    try {
      courseList = courseService.getCourseList();
    } catch (Exception e) {
      logger.error("Error getting course category list.", e);
    }
    if (courseList != null)
      map.put("courses", courseList);
  }
}
