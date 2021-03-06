package com.app.dao;

import java.util.List;

import com.app.model.Uom;

public interface IUomDao {
	
	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deleteUom(Integer id);
	
	public Uom getUomById(Integer id);
	public List<Uom> getAllUom();
	
	public List<Object[]> getUomTypeCount();
	
	public boolean isUomModelExist(String uomModel);

}
