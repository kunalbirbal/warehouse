package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDao {
	
	public Integer saveUser(User usr);
	public void updateUser(User usr);
	public void deleteUser(Integer id);
	public User getUserById(Integer id);
	public List<User> getAllUser();

}
