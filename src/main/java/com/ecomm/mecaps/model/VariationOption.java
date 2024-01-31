package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the variation_option database table.
 * 
 */
@Entity
@Table(name="variation_option")
@NamedQuery(name="VariationOption.findAll", query="SELECT v FROM VariationOption v")
public class VariationOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VOID")
	private Long void_;

	private String value;

	//bi-directional many-to-many association to ProductItem
	@ManyToMany
	@JoinTable(
		name="product_variation"
		, joinColumns={
			@JoinColumn(name="VOID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="item_id")
			}
		)
	private List<ProductItem> productItems;

	//bi-directional many-to-one association to Variation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="variation_id")
	private Variation variation;

	public VariationOption() {
	}

	public long getVoid_() {
		return this.void_;
	}

	public void setVoid_(long void_) {
		this.void_ = void_;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<ProductItem> getProductItems() {
		return this.productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public Variation getVariation() {
		return this.variation;
	}

	public void setVariation(Variation variation) {
		this.variation = variation;
	}

}