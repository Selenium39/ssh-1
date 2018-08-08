package com.wantao.service;

import java.io.Serializable;
import java.util.List;

/*
 *@author:wantao
 *@time:Aug 7, 2018 9:12:34 PM
 *@description:
 */
public interface BaseService<T> {
	void saveEntity(T t);

	void deleteEntity(T t);

	void updateEntity(T t);

	T getEntity(Serializable id);

	T loadEntity(Serializable id);

	List<T> findEntityByHQL(String hql, Object... objects);

	void executeUpdateByHQL(String hql, Object... objects);
	List<T> findAll();
}
