package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	
	public Integer saveWhUserType(WhUserType whuser);
	public void updateWhUserType(WhUserType whuser);
	public void deleteWhUserType(Integer id);
	public WhUserType getWhUserById(Integer id);
	public List<WhUserType> getAllWhUser();
	
	public List<Object[]> getWhUserTypeCount();

}
