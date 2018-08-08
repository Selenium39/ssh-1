package com.wantao.dao;

import org.springframework.stereotype.Repository;

import com.wantao.daoImpl.BaseDaoImpl;
import com.wantao.entity.User;

/*
 *@author:wantao
 *@time:Aug 7, 2018 12:56:33 PM
 *@description:
 */
@Repository
public class UserDao extends BaseDaoImpl<User> {//注意这里UserDao是类并且继承BaseDaoImpl

}
