package com.wantao.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wantao.dao.BaseDao;

/*
 *@author:wantao
 *@time:Aug 7, 2018 12:48:41 PM
 *@description:
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void deleteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public T getEntity(Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	public T loadEntity(Serializable id) {
		return sessionFactory.getCurrentSession().load(clazz, id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

	public void executeUpdateByHQL(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i > objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}

}
