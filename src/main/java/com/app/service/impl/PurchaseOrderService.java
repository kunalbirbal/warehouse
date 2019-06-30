package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {
	
	@Autowired
	private IPurchaseOrderDao dao;

	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		return dao.savePurchaseOrder(purchaseOrder);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		dao.updatePurchaseOrder(purchaseOrder);
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);
	}

	@Transactional(readOnly = true)
	public PurchaseOrder getPurchaseOrderById(Integer id) {
		return dao.getPurchaseOrderById(id);
	}

	@Transactional(readOnly = true)
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return dao.getAllPurchaseOrder();
	}

}
