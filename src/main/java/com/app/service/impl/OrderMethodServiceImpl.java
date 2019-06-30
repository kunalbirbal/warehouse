package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	public Integer saveOrder(OrderMethod om) {
		return dao.saveOrder(om);
	}

	@Transactional
	public void updateOrder(OrderMethod om) {
		dao.updateOrder(om);
	}

	@Transactional
	public void deleteOrder(Integer id) {
		dao.deleteOrder(id);
	}

	@Transactional(readOnly = true)
	public OrderMethod getOrderById(Integer id) {
		return dao.getOrderById(id);
	}

	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getOrderModeTypeCount() {
		return dao.getOrderModeTypeCount();
	}

}
