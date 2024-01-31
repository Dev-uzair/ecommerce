package com.ecomm.mecaps.model;

import java.io.Serializable;

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
	private Long id;

	@Column(name="reward_points")
	private Long rewardPoints;

	@Column(name="reward_type")
	private Long rewardType;

	@Column(name="valid_form")
	private Long validForm;

	@Column(name="valid_till")
	private Long validTill;

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

	public Long getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Long getRewardType() {
		return this.rewardType;
	}

	public void setRewardType(Long rewardType) {
		this.rewardType = rewardType;
	}

	public Long getValidForm() {
		return this.validForm;
	}

	public void setValidForm(Long validForm) {
		this.validForm = validForm;
	}

	public Long getValidTill() {
		return this.validTill;
	}

	public void setValidTill(Long validTill) {
		this.validTill = validTill;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}