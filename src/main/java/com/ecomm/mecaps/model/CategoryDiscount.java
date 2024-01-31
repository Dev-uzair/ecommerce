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
	private Long id;

	@Column(name="discount_code")
	private Long discountCode;

	@Column(name="discount_name")
	private Long discountName;

	@Column(name="discount_unit")
	private Long discountUnit;

	@Column(name="discount_value")
	private Long discountValue;

	@Column(name="maximum_discount_amount")
	private Long maximumDiscountAmount;

	@Column(name="valid_from")
	private Long validFrom;

	@Column(name="valid_till")
	private Long validTill;

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

	public Long getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(Long discountCode) {
		this.discountCode = discountCode;
	}

	public Long getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(Long discountName) {
		this.discountName = discountName;
	}

	public Long getDiscountUnit() {
		return this.discountUnit;
	}

	public void setDiscountUnit(Long discountUnit) {
		this.discountUnit = discountUnit;
	}

	public Long getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(Long discountValue) {
		this.discountValue = discountValue;
	}

	public Long getMaximumDiscountAmount() {
		return this.maximumDiscountAmount;
	}

	public void setMaximumDiscountAmount(Long maximumDiscountAmount) {
		this.maximumDiscountAmount = maximumDiscountAmount;
	}

	public Long getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Long validFrom) {
		this.validFrom = validFrom;
	}

	public Long getValidTill() {
		return this.validTill;
	}

	public void setValidTill(Long validTill) {
		this.validTill = validTill;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}