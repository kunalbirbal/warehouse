package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchase_order")
public class PurchaseOrder {
	
	@Id
	@Column(name="oid")
	@GeneratedValue(generator="pkgen")
	@GenericGenerator(name="pkgen", strategy="increment")
	private Integer orderId;
	
	@Column(name="ocode")
	private String orderCode;
		
	@Column(name="oref_num")
	private String refNum;
	
	@Column(name="oquality_check")
	private String qualityCheck;
	
	@Column(name="ostatus")
	private String orderStatus;
	
	@Column(name="odsc")
	private String orderDesc;
	
	@ManyToOne
	@JoinColumn(name="widfk")
	private WhUserType whUserType;
	
	@ManyToOne
	@JoinColumn(name="sidfk")
	private ShipmentType shipmentType;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public WhUserType getWhUserType() {
		return whUserType;
	}

	public void setWhUserType(WhUserType whUserType) {
		this.whUserType = whUserType;
	}

	public ShipmentType getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [orderId=" + orderId + ", orderCode=" + orderCode + ", refNum=" + refNum
				+ ", qualityCheck=" + qualityCheck + ", orderStatus=" + orderStatus + ", orderDesc=" + orderDesc
				+ ", whUserType=" + whUserType + ", shipmentType=" + shipmentType + "]";
	}

	
}
