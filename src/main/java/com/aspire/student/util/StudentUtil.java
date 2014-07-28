package com.aspire.student.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.aspire.student.model.Student;
import com.aspire.student.vo.StudentVO;

/**
 * A utility class for Student
 * @author aspire20
 * 
 */
public class StudentUtil {

  public static Logger logger = Logger.getLogger(StudentUtil.class);

  /**
   * Load student VO list from the student list
   * 
   * @param studentList
   * @return
   */
  public static List<StudentVO> getStudentVOList(List<Student> studentList) {
    List<StudentVO> studentVOList = new ArrayList<StudentVO>();
    if (studentList != null && !studentList.isEmpty()) {
      logger.info("Student Size is " + studentList.size());
      // Copy list to all student view
      StudentVO studentVO = null;
      for (Student student : studentList) {
        studentVO = new StudentVO();
        BeanUtils.copyProperties(student, studentVO);
        studentVOList.add(studentVO);
      }
      logger.info("Student View list size " + studentVOList.size());
    }
    return studentVOList;
  }
}
