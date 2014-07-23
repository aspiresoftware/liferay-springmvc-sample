package com.aspire.student.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Implementation of data access layer
 * 
 * @author aspire
 * 
 */
public class GenericDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements
GenericDAO<T, Serializable> {

  private Logger log = Logger.getLogger(GenericDAOImpl.class);
  private Class<? extends T> clazz;
  
  public GenericDAOImpl() {
    log.info("GenericDaoImpl Default Constructor");
  }

  public GenericDAOImpl(Class<? extends T> clazz) {
    this.clazz = clazz;
  }
  
  /* (non-Javadoc)
   * @see com.aspire.student.dao.GenericDAO#create(java.lang.Object)
   */
  @Override
  public T create(T entity) throws Exception {
    log.debug("Executing method : create()");
    getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    return entity;
  }

  /* (non-Javadoc)
   * @see com.aspire.student.dao.GenericDAO#findById(java.lang.Long)
   */
  @SuppressWarnings("unchecked")
  public T findById(Integer id) throws Exception {
    log.debug("Executing method : findById() with id = " + id);
    log.debug("class is " + clazz);
    return (T) getSessionFactory().getCurrentSession().get(clazz, id);
  }

  /* (non-Javadoc)
   * @see com.aspire.student.dao.GenericDAO#merge(java.lang.Object)
   */
  @Override
  public T merge(T transientObject) throws Exception {
    log.debug("Executing method : merge()");
    getSessionFactory().getCurrentSession().merge(transientObject);
    return transientObject;

  }

  /* (non-Javadoc)
   * @see com.aspire.student.dao.GenericDAO#delete(java.lang.Object)
   */
  @Override
  public void delete(T persistentObject) throws Exception {
    log.debug("Executing method : delete()");
    getSessionFactory().getCurrentSession().delete(persistentObject);
  }

  /* (non-Javadoc)
   * @see com.aspire.student.dao.GenericDAO#findAll()
   */
  @SuppressWarnings("unchecked")
  public List<T> findAll() throws Exception {
    log.debug("Executing method : findAll()");
    return (List<T>) getHibernateTemplate().loadAll(this.clazz);
  }
}
