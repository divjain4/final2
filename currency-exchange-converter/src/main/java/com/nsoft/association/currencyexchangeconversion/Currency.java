package com.nsoft.association.currencyexchangeconversion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "CURRENCY")
public class Currency {
	
	@Id
	Integer id;
	
	@Column(name = "COUNTRYCODE")
	private String countryCode;
	
	@Column(name = "CONVERSIONVALUE")
	private double conversionValue;
	
	
	

	public Currency(Integer id, String countryCode, double conversionValue) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.conversionValue = conversionValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public double getConversionValue() {
		return conversionValue;
	}


	public void setConversionValue(double conversionValue) {
		this.conversionValue = conversionValue;
	}
	
	
	
	
	
	
}
