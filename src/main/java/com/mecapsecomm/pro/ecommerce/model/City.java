package com.mecapsecomm.pro.ecommerce.model;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="city_id")
	private BigInteger cityId;

	@Column(name="city_name")
	private String cityName;

	@Column(name="country_id")
	private BigInteger countryId;

	public City() {
	}

	public BigInteger getCityId() {
		return this.cityId;
	}

	public void setCityId(BigInteger cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public BigInteger getCountryId() {
		return this.countryId;
	}

	public void setCountryId(BigInteger countryId) {
		this.countryId = countryId;
	}

}