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
 * This class is model class for student detail which contains properties
 * 
 * @author aspire
 * 
 */
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 2532989537115595407L;

  @Id
  @Column(name = "ID")
  @GeneratedValue
  private Integer id;

  @Column(name = "FIRSTNAME")
  private String firstName;

  @Column(name = "LASTNAME")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "TELEPHONE")
  private String telephone;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "STREET")
  private String street;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Column(name = "POSTCODE")
  private String postCode;

  @ManyToOne
  @JoinColumn(name = "COURSE_ID")
  private Course course;

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
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the telephone
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * @param telephone the telephone to set
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * @param street the street to set
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @return the postCode
   */
  public String getPostCode() {
    return postCode;
  }

  /**
   * @param postCode the postCode to set
   */
  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  /**
   * @return the course
   */
  public Course getCourse() {
    return course;
  }

  /**
   * @param course the course to set
   */
  public void setCourse(Course course) {
    this.course = course;
  }
}
