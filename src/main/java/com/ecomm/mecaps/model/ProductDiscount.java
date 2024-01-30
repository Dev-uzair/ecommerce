package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.util.Date;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the product_discount database table.
 * 
 */
@Entity
@Table(name="product_discount")
@NamedQuery(name="ProductDiscount.findAll", query="SELECT p FROM ProductDiscount p")
public class ProductDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="discount_code")
	private String discountCode;

	@Column(name="discount_name")
	private String discountName;

	@Column(name="discount_unit")
	private String discountUnit;

	@Column(name="discount_value")
	private double discountValue;

	@Column(name="maximum_discount_amount")
	private double maximumDiscountAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_from")
	private Date validFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_till")
	private Date validTill;

	//bi-directional many-to-one association to MasterProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private MasterProduct masterProduct;

	public ProductDiscount() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getDiscountUnit() {
		return this.discountUnit;
	}

	public void setDiscountUnit(String discountUnit) {
		this.discountUnit = discountUnit;
	}

	public double getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public double getMaximumDiscountAmount() {
		return this.maximumDiscountAmount;
	}

	public void setMaximumDiscountAmount(double maximumDiscountAmount) {
		this.maximumDiscountAmount = maximumDiscountAmount;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTill() {
		return this.validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public MasterProduct getMasterProduct() {
		return this.masterProduct;
	}

	public void setMasterProduct(MasterProduct masterProduct) {
		this.masterProduct = masterProduct;
	}

}