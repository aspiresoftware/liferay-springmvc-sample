package com.aspire.student.dao;

import java.util.List;

import com.aspire.student.model.Student;

/**
 * Interface for manage data access layer for student
 * 
 * @author aspire
 * 
 */
public interface StudentDAO {

  /**
   * Save student detail in database
   * 
   * @param student
   * @throws Exception
   */
  public void saveStudent(Student student) throws Exception;

  /**
   * Retrieves all students from database
   * 
   * @return
   * @throws Exception 
   */
  public List<Student> findStudents() throws Exception;

  /**
   * Removes student detail from database
   * 
   * @param id
   * @throws Exception
   */
  public void deleteStudent(Integer id) throws Exception;
}