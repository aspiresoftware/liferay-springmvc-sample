package com.aspire.student.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aspire.student.model.Student;

/**
 * Implementation of data access layer
 * 
 * @author aspire
 * 
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private Logger logger = Logger.getLogger(StudentDAOImpl.class);

 
  /* (non-Javadoc)
   * @see com.aspire.student.dao.StudentDAO#saveStudent(com.aspire.student.model.Student)
   */
  public void saveStudent(Student student) throws Exception {
    logger.debug("In saveStudent()");
    sessionFactory.getCurrentSession().save(student);
  }

  /* (non-Javadoc)
   * @see com.aspire.student.dao.StudentDAO#findStudents()
   */
  public List<Student> findStudents() throws Exception {
    logger.debug("In findStudents()");
    return sessionFactory.getCurrentSession().createQuery("from Student").list();
  }

  /* (non-Javadoc)
   * @see com.aspire.student.dao.StudentDAO#deleteStudent(java.lang.Integer)
   */
  public void deleteStudent(Integer id) throws Exception {
    logger.debug("In deleteStudent()");
    Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, id);
    if (null != student) {
      sessionFactory.getCurrentSession().delete(student);
    }
  }
}
