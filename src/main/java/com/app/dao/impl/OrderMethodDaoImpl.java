package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrder(OrderMethod om) {
		return (Integer) ht.save(om);
	}

	@Override
	public void updateOrder(OrderMethod om) {
		ht.update(om);
	}

	@Override
	public void deleteOrder(Integer id) {
		ht.delete(new OrderMethod(id));
	}

	@Override
	public OrderMethod getOrderById(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrders() {
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public List<Object[]> getOrderModeTypeCount() {
		
		String hql = "select orderMode, count(orderMode) from "+OrderMethod.class.getName()+" group by orderMode";
		
		return (List<Object[]>) ht.find(hql);
	}

}
