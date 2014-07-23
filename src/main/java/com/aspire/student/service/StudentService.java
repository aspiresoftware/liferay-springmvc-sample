package com.aspire.student.service;

import java.util.List;

import com.aspire.student.model.Student;

/**
 * Interface for service layer of student
 * 
 * @author aspire
 * 
 */
public interface StudentService {

  /**
   * Add new student
   * 
   * @param student
   * @throws Exception
   */
  public Student addStudent(Student student) throws Exception;

  /**
   * Retrieve list of students
   * 
   * @return
   * @throws Exception
   */
  public List<Student> getStudentList() throws Exception;

  /**
   * Remove student by id
   * 
   * @param id
   * @throws Exception
   */
  public void removeStudent(Integer id) throws Exception;
  
  /**
   * Retrieve Student by id
   * @param id
   * @return
   * @throws Exception
   */
  public Student getStudent(Integer id); 
}
