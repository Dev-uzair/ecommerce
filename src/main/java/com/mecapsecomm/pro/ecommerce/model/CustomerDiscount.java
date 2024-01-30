package com.mecapsecomm.pro.ecommerce.model;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the customer_discount database table.
 * 
 */
@Entity
@Table(name="customer_discount")
@NamedQuery(name="CustomerDiscount.findAll", query="SELECT c FROM CustomerDiscount c")
public class CustomerDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="reward_points")
	private BigInteger rewardPoints;

	@Column(name="reward_type")
	private BigInteger rewardType;

	@Column(name="valid_form")
	private BigInteger validForm;

	@Column(name="valid_till")
	private BigInteger validTill;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public CustomerDiscount() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigInteger getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(BigInteger rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public BigInteger getRewardType() {
		return this.rewardType;
	}

	public void setRewardType(BigInteger rewardType) {
		this.rewardType = rewardType;
	}

	public BigInteger getValidForm() {
		return this.validForm;
	}

	public void setValidForm(BigInteger validForm) {
		this.validForm = validForm;
	}

	public BigInteger getValidTill() {
		return this.validTill;
	}

	public void setValidTill(BigInteger validTill) {
		this.validTill = validTill;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}