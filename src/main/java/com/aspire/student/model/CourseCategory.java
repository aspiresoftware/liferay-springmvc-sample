package com.aspire.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * It is master entity contains category of different courses
 * @author aspire20
 *
 */
@Entity
@Table(name="COURSE_CATEGORY")
public class CourseCategory implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = -5304732623292892791L;
  
  @Id
  @Column(name = "ID")
  @GeneratedValue
  private Integer id;
  
  @Column(name = "CATEGORY")
  private String category;

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
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(String category) {
    this.category = category;
  }
}
