package com.wantao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wantao.dao.UserDao;
import com.wantao.entity.User;

/*
 *@author:wantao
 *@time:Aug 7, 2018 1:00:48 PM
 *@description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
@Transactional
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void test() {
		String hql = "from User"; // User.hbm.xml
		List<User> users = userDao.findEntityByHQL(hql);
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

}
