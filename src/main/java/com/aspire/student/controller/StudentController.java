package com.aspire.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.aspire.student.constant.Constants;
import com.aspire.student.model.Student;
import com.aspire.student.service.CourseCategoryService;
import com.aspire.student.service.CourseService;
import com.aspire.student.service.StudentService;
import com.aspire.student.util.CourseCategoryUtil;
import com.aspire.student.util.CourseUtil;
import com.aspire.student.util.JsonServiceUtil;
import com.aspire.student.util.StudentUtil;
import com.aspire.student.vo.StudentVO;

/**
 * Controller for manages student
 * 
 * @author aspire
 * 
 */
@Controller("studentController")
@RequestMapping("VIEW")
public class StudentController {

  @Autowired
  private StudentService studentService;
  @Autowired
  private CourseService courseService;
  @Autowired
  private CourseCategoryService courseCategoryService;
  @Autowired
  private MessageSource messageSource;
  private Logger logger = Logger.getLogger(StudentController.class);
  
  // Constants
  private static final String JSP_STUDENTLIST = "studentList";
  private static final String JSP_STUDENTFORM = "studentForm";
  private static final String JSP_STUDENTVIEW = "viewStudent";

  /**
   * Default render method when page is load
   * 
   * @param map
   * @return
   */
  @RenderMapping
  public String defaultRender(Map<String, Object> map) {
    logger.debug("in defaultRender()");
    return JSP_STUDENTLIST;
  }

  /**
   * Render and set required objects for student form
   * 
   * @param map
   * @return
   */
  @RenderMapping(params = "render=studentForm")
  public String studentForm(@RequestParam(value = "studentId", required = false) Integer studentId,
      Map<String, Object> map) {
    logger.debug("in addStudent()");
    Student student = null;
    if (studentId != null) {
      // Get student details to edit
      logger.info("student id is " + studentId);
      student = studentService.getStudent(studentId);
    }
    if (student == null) {
      student = new Student();
    }
    // Load student form details
    map.put("student", student);
    CourseCategoryUtil.loadCourseCategoryList(courseCategoryService, map);
    CourseUtil.loadCourseList(courseService, map);
    return JSP_STUDENTFORM;
  }

  /**
   * View student data
   * 
   * @param studentId
   * @param map
   * @return
   */
  @RenderMapping(params = "render=viewStudent")
  public String viewStudent(@RequestParam(value = "studentId", required = false) Integer studentId,
      Map<String, Object> map) {
    logger.debug("in viewStudent()");
    StudentVO studentVO = null;
    if (studentId != null) {
      logger.info("student id is " + studentId);
      Student student = studentService.getStudent(studentId);
      studentVO = new StudentVO();
      BeanUtils.copyProperties(student, studentVO);
    }
    if (studentVO != null) {
      map.put("student", studentVO);
    }
    return JSP_STUDENTVIEW;
  }

  /**
   * Create a new student
   * 
   * @param actionRequest
   * @param actionResponse
   * @param model
   * @param student
   * @param result
   * @throws IOException
   * @throws PortletException
   */
  @ActionMapping(params = "action=save")
  public void saveStudent(ActionRequest actionRequest, ActionResponse actionResponse, Model model,
      @ModelAttribute("student") Student student, BindingResult result) throws IOException,
      PortletException {
    logger.debug("In adddStudent()");
    if (student.getCourse().getId() == null) {
      logger.info("Cource is null");
      student.setCourse(null);
    }

    try {
      student = studentService.saveStudent(student);
    } catch (Exception e) {
      logger.error("Error while saving student", e);
    }

    if (student != null) {
      actionRequest.setAttribute(Constants.SUCCESS,
          messageSource.getMessage("student.save.success", null, null));
    } else {
      actionRequest.setAttribute(Constants.ERROR,
          messageSource.getMessage("student.error.success", null, null));
    }
  }

  /**
   * Delete Student
   * 
   * @param studentId
   * @param request
   * @param response
   * @param model
   * @throws IOException
   * @throws PortletException
   */
  @ResourceMapping("deleteStudent")
  public void deleteStudent(@RequestParam("studentId") Integer studentId, ResourceRequest request,
      ResourceResponse response, Model model) throws IOException, PortletException {
    logger.debug("In deleteStudent()");
    logger.info("Student Id=" + studentId);
    PrintWriter writer = null;
    Map<String, Object> map = new HashMap<String, Object>();
    String actionMessage = null;
    try {
      writer = response.getWriter();
      studentService.removeStudent(studentId);
      actionMessage = messageSource.getMessage("student.delete.success", null, null);
      map.put("status", Constants.SUCCESS);
    } catch (Exception e) {
      logger.error("Error while deleting student", e);
      actionMessage = messageSource.getMessage("student.delete.error", null, null);
      map.put("status", Constants.ERROR);
    }
    map.put("actionMessage", actionMessage);
    JsonServiceUtil.writeJson(writer, map);
  }

  /**
   * Retrieve all students and set in view object
   * 
   * @param request
   * @param response
   */
  @ResourceMapping("getAllStudents")
  public void getAllStudents(ResourceRequest request, ResourceResponse response) {
    logger.info("getAllStudents()");
    PrintWriter writer = null;
    List<Student> studentList = null;
    try {
      writer = response.getWriter();
      // Fetch students
      logger.info("Getting all student list");
      studentList = studentService.getStudentList();
    } catch (Exception e) {
      logger.error("Error while getting all students", e);
    }
    Map<String, Object> map = new HashMap<String, Object>();
    List<StudentVO> studentVOList = StudentUtil.getStudentVOList(studentList);
    map.put("aaData", studentVOList);
    JsonServiceUtil.writeJson(writer, map);
  }

  /**
   * Search students by query string
   * 
   * @param request
   * @param response
   */
  @ResourceMapping("searchStudents")
  public void searchStudents(@RequestParam("quertString") String queryString,
      ResourceRequest request, ResourceResponse response) {
    logger.info("searchStudents()");
    PrintWriter writer = null;
    List<Student> studentList = null;
    try {
      writer = response.getWriter();
      // Fetch students
      studentList = studentService.searchStudents(queryString);
    } catch (Exception e) {
      logger.error("Error while getting all students", e);
    }
    Map<String, Object> map = new HashMap<String, Object>();
    List<StudentVO> listStudentVO = StudentUtil.getStudentVOList(studentList);
    map.put("studentList", listStudentVO);
    JsonServiceUtil.writeJson(writer, map);
  }
}
