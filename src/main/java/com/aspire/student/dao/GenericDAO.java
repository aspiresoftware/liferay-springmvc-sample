package com.aspire.student.dao;

import java.io.Serializable;
import java.util.List;

/**
 * GenericDAO interface define all basic methods of DAO class related operation.
 * 
 * @author aspire
 * 
 */
public interface GenericDAO<T, ID extends Serializable> {

  /**
   * Persist the newInstance object into database
   * 
   * @throws Exception
   */
  public T create(T entity) throws Exception;

  /**
   * Retrieve an object that was previously persisted to the database using the indicated id as
   * primary key
   */
  public T findById(Integer id) throws Exception;

  /** Save changes made to a persistent object. */
  public T merge(T transientObject) throws Exception;

  /** Remove an object from persistent storage in the database */
  public void delete(T persistentObject) throws Exception;

  /** Retrieve a list of objects */
  public List<T> findAll() throws Exception;
}
