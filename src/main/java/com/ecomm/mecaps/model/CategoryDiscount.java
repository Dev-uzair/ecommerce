package com.ecomm.mecaps.model;

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
 * The persistent class for the category_discount database table.
 * 
 */
@Entity
@Table(name="category_discount")
@NamedQuery(name="CategoryDiscount.findAll", query="SELECT c FROM CategoryDiscount c")
public class CategoryDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="discount_code")
	private BigInteger discountCode;

	@Column(name="discount_name")
	private BigInteger discountName;

	@Column(name="discount_unit")
	private BigInteger discountUnit;

	@Column(name="discount_value")
	private BigInteger discountValue;

	@Column(name="maximum_discount_amount")
	private BigInteger maximumDiscountAmount;

	@Column(name="valid_from")
	private BigInteger validFrom;

	@Column(name="valid_till")
	private BigInteger validTill;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;

	public CategoryDiscount() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigInteger getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(BigInteger discountCode) {
		this.discountCode = discountCode;
	}

	public BigInteger getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(BigInteger discountName) {
		this.discountName = discountName;
	}

	public BigInteger getDiscountUnit() {
		return this.discountUnit;
	}

	public void setDiscountUnit(BigInteger discountUnit) {
		this.discountUnit = discountUnit;
	}

	public BigInteger getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(BigInteger discountValue) {
		this.discountValue = discountValue;
	}

	public BigInteger getMaximumDiscountAmount() {
		return this.maximumDiscountAmount;
	}

	public void setMaximumDiscountAmount(BigInteger maximumDiscountAmount) {
		this.maximumDiscountAmount = maximumDiscountAmount;
	}

	public BigInteger getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(BigInteger validFrom) {
		this.validFrom = validFrom;
	}

	public BigInteger getValidTill() {
		return this.validTill;
	}

	public void setValidTill(BigInteger validTill) {
		this.validTill = validTill;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}