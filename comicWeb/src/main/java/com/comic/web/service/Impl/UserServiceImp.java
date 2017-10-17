package com.comic.web.service.Impl;

import com.comic.web.base.dao.BaseDao;
import com.comic.web.base.serviceImpl.BaseServiceImpl;
import com.comic.web.bean.User;
import com.comic.web.dao.UserDao;
import com.comic.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp extends BaseServiceImpl<User> implements UserService
{
	@Autowired
	private UserDao userDao;

	@Override
	protected BaseDao<User> getDao() {
		return userDao;
	}
	
	/**
	 * 校验用户名唯一性
	 */
	public User getUserByUserName(int id, String userName)
	{
		User user=new User();
		user.setId(id);
		user.setUserName(userName);
		
		return userDao.getUserByUserName(user);
	}
    
	
	/**
	 * 根据用户名获取当前登录用户
	 * @param userName  ??为什么只有一个用户
	 */
	public User getLoginUser(String userName)
	{
		return userDao.getLoginUser(userName);
	}
}





