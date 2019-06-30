package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		return (Integer) ht.save(purchaseOrder);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		ht.update(purchaseOrder);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));
	}

	@Override
	public PurchaseOrder getPurchaseOrderById(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return ht.loadAll(PurchaseOrder.class);
	}

}
