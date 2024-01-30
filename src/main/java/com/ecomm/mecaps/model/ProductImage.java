package com.ecomm.mecaps.model;

import java.io.Serializable;

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
 * The persistent class for the product_image database table.
 * 
 */
@Entity
@Table(name="product_image")
@NamedQuery(name="ProductImage.findAll", query="SELECT p FROM ProductImage p")
public class ProductImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String url;

	//bi-directional many-to-one association to MasterProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private MasterProduct masterProduct;

	public ProductImage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MasterProduct getMasterProduct() {
		return this.masterProduct;
	}

	public void setMasterProduct(MasterProduct masterProduct) {
		this.masterProduct = masterProduct;
	}

}