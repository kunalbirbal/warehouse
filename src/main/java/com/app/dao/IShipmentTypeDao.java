package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {
	
	public Integer saveShipmentType(ShipmentType st);
	public void updateShipmentType(ShipmentType st);
	public void deleteShipmentType(Integer id);
	
	public ShipmentType getShipmentTypeById(Integer id);
	public List<ShipmentType> getAllShipmentTypes();
	
	public List<Object []> getShipmentModeTypeCount();

}
