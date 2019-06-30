package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserSerivceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Transactional
	public Integer saveUser(User usr) {
		return dao.saveUser(usr);
	}

	@Transactional
	public void updateUser(User usr) {
		dao.updateUser(usr);
	}

	@Transactional
	public void deleteUser(Integer id) {
		dao.deleteUser(id);
	}

	@Transactional(readOnly=true)
	public User getUserById(Integer id) {
		return dao.getUserById(id);
	}

	@Transactional(readOnly=true)
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

}
