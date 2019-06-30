package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {
	
	public Integer saveOrder(OrderMethod om);
	public void updateOrder(OrderMethod om);
	public void deleteOrder(Integer id);
	public OrderMethod getOrderById(Integer id);
	public List<OrderMethod> getAllOrders();
	
	public List<Object[]> getOrderModeTypeCount();
	
}
