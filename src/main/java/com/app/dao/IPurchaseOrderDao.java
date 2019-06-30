package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder);
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);
	public void deletePurchaseOrder(Integer id);
	public PurchaseOrder getPurchaseOrderById(Integer id);
	public List<PurchaseOrder> getAllPurchaseOrder();
	
}
