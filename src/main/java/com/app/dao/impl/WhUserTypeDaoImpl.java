package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType whuser) {
		return (Integer) ht.save(whuser);
	}

	@Override
	public void updateWhUserType(WhUserType whuser) {
		ht.update(whuser);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));
	}

	@Override
	public WhUserType getWhUserById(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUser() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public List<Object[]> getWhUserTypeCount() {
		String hql = "select userType, count(userType) from "+WhUserType.class.getName()+" group by userType";		
		return (List<Object[]>) ht.find(hql);
	}

}
