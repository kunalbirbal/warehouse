package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUser(User usr) {
		return (Integer) ht.save(usr);
	}

	@Override
	public void updateUser(User usr) {
		ht.update(usr);
	}

	@Override
	public void deleteUser(Integer id) {
		ht.delete(new User(id));
	}

	@Override
	public User getUserById(Integer id) {
		return ht.get(User.class, id);
	}

	@Override
	public List<User> getAllUser() {
		return ht.loadAll(User.class);
	}

}
