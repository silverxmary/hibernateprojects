/**
 * 
 */
package ar.com.eduit.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import ar.com.eduit.dao.GenericDao;





public abstract class GenericDaoImpl<T extends Serializable , ID extends Serializable> implements GenericDao<T, ID> {

	protected HibernateTemplate hibernateTemplate;
	protected SessionFactory sessionFactory;
	private Class<T> persistentClass;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * getPersistentClass
	 * 
	 * @return Class<T>
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T loadById(ID id, boolean lock) {
		
		T entity;
		
		if (lock)
			entity = (T) hibernateTemplate.load(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) hibernateTemplate.load(getPersistentClass(), id);

		return entity;
	}


	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) hibernateTemplate.find("from " +getPersistentClass().getName());
	}

	public T getById(ID id) {
		return hibernateTemplate.get(getPersistentClass(), id);
	}
	
	
	@Transactional(readOnly = false)
	public ID save(T entity) {
		ID id =(ID) hibernateTemplate.save(entity);
		return id;
	}
	

	@Transactional(readOnly = false)
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);;
	}

	@Transactional(readOnly = false)
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	
	// ----------------- //
	
	public void flush() {
		hibernateTemplate.flush();
	}

	public void clear() {
		hibernateTemplate.clear();
	}
	
	//---------------//
	public String[] getParams(List<String> array) {
		String[] ret = new String[array.size()];
		for(int i = 0; i < ret.length; ++i) {
			ret[i] = array.get(i);
		}
		
		return ret;
	}
	
	public void saveAll(List<T> entities){
		hibernateTemplate.saveOrUpdateAll(entities);	
	}

}//
