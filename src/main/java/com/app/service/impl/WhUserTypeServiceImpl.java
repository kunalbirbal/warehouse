package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	
	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType whuser) {
		return dao.saveWhUserType(whuser);
	}

	@Transactional
	public void updateWhUserType(WhUserType whuser) {
		dao.updateWhUserType(whuser);
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}

	@Transactional(readOnly=true)
	public WhUserType getWhUserById(Integer id) {
		return dao.getWhUserById(id);
	}

	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUser() {
		return dao.getAllWhUser();
	}

	@Transactional(readOnly=true)
	public List<Object[]> getWhUserTypeCount() {
		return dao.getWhUserTypeCount();
	}

}
