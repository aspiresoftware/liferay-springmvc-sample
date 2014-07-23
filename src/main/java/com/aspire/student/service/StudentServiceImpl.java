package com.aspire.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspire.student.dao.GenericDAO;
import com.aspire.student.model.Student;


/**
 * Implementation of service layer for student
 * 
 * @author aspire
 * 
 */
@Service
public class StudentServiceImpl implements StudentService {

  private Logger logger = Logger.getLogger(StudentServiceImpl.class);

  /**
   * Reference to the data object
   */
  @Autowired
  private GenericDAO<Student, Long> studentDAO;
  
  /* (non-Javadoc)
   * @see com.aspire.student.service.StudentService#addStudent(com.aspire.student.model.Student)
   */
  @Transactional
  public Student addStudent(Student student) throws Exception {
    logger.debug("In addStudent()");
    logger.info("Adding student details for student email - " + student.getEmail());
    try {
      return studentDAO.create(student);
    } catch (Exception e) {
      logger.error("Error adding student details", e);
    }
    return null;
  }

  /* (non-Javadoc)
   * @see com.aspire.student.service.StudentService#getStudentList()
   */
  @Transactional
  public List<Student> getStudentList() throws Exception {
    logger.debug("In getStudentList()");
    try {
      return studentDAO.findAll();
    } catch (Exception e) {
      logger.error("Error getting student list.", e);
    }
    return null;
  }

  /* (non-Javadoc)
   * @see com.aspire.student.service.StudentService#removeStudent(java.lang.Integer)
   */
  @Transactional
  public void removeStudent(Integer id) throws Exception {
    logger.debug("In removeStudent()");
    try {
      Student student = studentDAO.findById(id);
      if(student != null) {
        studentDAO.delete(student);
      }
    } catch (Exception e) {
      logger.error("Error removing student by id - " + id, e);
    }
  }

  
  /* (non-Javadoc)
   * @see com.aspire.student.service.StudentService#getStudent(java.lang.Integer)
   */
  @Transactional
  public Student getStudent(Integer id) {
    try {
      return studentDAO.findById(id);
    } catch (Exception e) {
      logger.error("Error while fetching student by id ",e);
    }
    return null;
  }

  /* (non-Javadoc)
   * @see com.aspire.student.service.StudentService#searchStudents(java.lang.String)
   */
  @Transactional
  public List<Student> searchStudents(String string) {
    Map<String,Object> queryParameter = new HashMap<String, Object>();
    queryParameter.put("queryString", "%"+string+"%");
    try {
      return studentDAO.findByQueryParams("fetchStudentsByQueryString", queryParameter);
    } catch (Exception e) {
      logger.error("Error while fetching student by id ",e);
    }
    return null;
  }
  
  
}
