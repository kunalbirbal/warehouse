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
@Table(name="itemtab")
public class Item {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="pkgen")
	@GenericGenerator(name="pkgen", strategy="increment")
	private Integer itemId;
	
	@Column(name="icode")
	private String itemCode;
	
	@Column(name="ilength")
	private double itemLength;
	
	@Column(name="iwidth")
	private double itemWidht;
	
	@Column(name="iheight")
	private double itemHeight;
	
	@Column(name="basecost")
	private double baseCost;
	
	@Column(name="basecurr")
	private String baseCurr;
	
	@Column(name="idesc")
	private String itemDsc;
	
	@ManyToOne
	@JoinColumn(name="uidfk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="oidfk")
	private OrderMethod orderMethod;
	
	public Item() {
		super();
	}

	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getItemLength() {
		return itemLength;
	}

	public void setItemLength(double itemLength) {
		this.itemLength = itemLength;
	}

	public double getItemWidht() {
		return itemWidht;
	}

	public void setItemWidht(double itemWidht) {
		this.itemWidht = itemWidht;
	}

	public double getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(double itemHeight) {
		this.itemHeight = itemHeight;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurr() {
		return baseCurr;
	}

	public void setBaseCurr(String baseCurr) {
		this.baseCurr = baseCurr;
	}

	public String getItemDsc() {
		return itemDsc;
	}

	public void setItemDsc(String itemDsc) {
		this.itemDsc = itemDsc;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}
	
	public OrderMethod getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(OrderMethod orderMethod) {
		this.orderMethod = orderMethod;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemLength=" + itemLength + ", itemWidht="
				+ itemWidht + ", itemHeight=" + itemHeight + ", baseCost=" + baseCost + ", baseCurr=" + baseCurr
				+ ", itemDsc=" + itemDsc + "]";
	}

}
