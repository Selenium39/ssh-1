package com.wantao.serviceImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wantao.dao.BaseDao;
import com.wantao.service.BaseService;

/*
 *@author:wantao
 *@time:Aug 7, 2018 9:14:19 PM
 *@description:
 */
@Transactional(readOnly = true)
public class BaseServiceImpl<T> implements BaseService<T> {
	private Class<T> clazz;

	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Transactional(readOnly = false)
	@Override
	public void saveEntity(T t) {
		this.baseDao.saveEntity(t);
	}

	@Override
	public void deleteEntity(T t) {
		this.baseDao.deleteEntity(t);
	}

	@Override
	public void updateEntity(T t) {
		this.baseDao.updateEntity(t);
	}

	@Override
	public T getEntity(Serializable id) {
		return (T) this.baseDao.getEntity(id);
	}

	@Override
	public T loadEntity(Serializable id) {
		return (T) this.baseDao.loadEntity(id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		return this.baseDao.findEntityByHQL(hql, objects);
	}

	@Override
	public void executeUpdateByHQL(String hql, Object... objects) {
		this.baseDao.executeUpdateByHQL(hql, objects);
	}

	@Override
	public List<T> findAll() {
		String hql = "form" + this.clazz.getSimpleName();
		return this.baseDao.findEntityByHQL(hql);
	}

}
