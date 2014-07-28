package com.aspire.student.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.aspire.student.model.CourseCategory;
import com.aspire.student.service.CourseCategoryService;

/**
 * A Utility class for course category 
 * @author aspire20
 * 
 */
public class CourseCategoryUtil {

  public static Logger logger = Logger.getLogger(CourseCategoryUtil.class);

  /**
   * Use to load course category and set in map
   * @param courseCategoryService
   * @param map
   */
  public static void loadCourseCategoryList(CourseCategoryService courseCategoryService,
      Map<String, Object> map) {
    List<CourseCategory> courseCategoryList = null;
    try {
      courseCategoryList = courseCategoryService.getCourseCategories();
    } catch (Exception e) {
      logger.error("Error getting course category list.", e);
    }
    if (courseCategoryList != null)
      map.put("courseCategory", courseCategoryList);
  }
}
