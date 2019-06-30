package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {
	
	@Id
	@GeneratedValue(generator="pkgen")
	@GenericGenerator(name="pkgen", strategy="increment")
	@Column(name="sid")
	private Integer id;
	
	@Column(name="smode")
	private String shipmentMode;
	@Column(name="scode")
	private String shipmentCode;
	@Column(name="senable_ship")
	private String enableShipment;
	@Column(name="sgrd")
	private String shipmentGrade;
	@Column(name="sdsc")
	private String shipDesc;
	
	public ShipmentType() {
		super();
	}

	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public String getEnableShipment() {
		return enableShipment;
	}

	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}

	public String getShipmentGrade() {
		return shipmentGrade;
	}

	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}

	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade + ", shipDesc=" + shipDesc
				+ "]";
	}
	
}
