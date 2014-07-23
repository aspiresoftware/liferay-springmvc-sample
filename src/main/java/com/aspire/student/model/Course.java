package com.aspire.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * It is master table of course category and related course name
 * 
 * @author aspire20
 * 
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1872011675486750426L;

  @Id
  @Column(name = "ID")
  @GeneratedValue
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  private CourseCategory courseCategory;

  @Column(name = "COURSE_NAME")
  private String courseName;

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the courseName
   */
  public String getCourseName() {
    return courseName;
  }

  /**
   * @param courseName the courseName to set
   */
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  /**
   * @return the courseCategory
   */
  public CourseCategory getCourseCategory() {
    return courseCategory;
  }

  /**
   * @param courseCategory the courseCategory to set
   */
  public void setCourseCategory(CourseCategory courseCategory) {
    this.courseCategory = courseCategory;
  }
}
