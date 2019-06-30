package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uomtab")
public class Uom {
	
	@Id
	@GeneratedValue(generator="pkgen")
	@GenericGenerator(name="pkgen", strategy="increment")
	@Column(name="uomid")
	private Integer uomId;
	
	@Column(name="utype")
	private String uomType;
	
	@Column(name="umodel")
	private String uomModel;
	
	@Column(name="udsc")
	private String uomDsc;

	public Uom() {
		super();
	}

	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getUomDsc() {
		return uomDsc;
	}

	public void setUomDsc(String uomDsc) {
		this.uomDsc = uomDsc;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDsc=" + uomDsc + "]";
	}
	
}
