package com.mecapsecomm.pro.ecommerce.model;

import java.io.Serializable;
import java.math.BigInteger;

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
 * The persistent class for the item_price database table.
 * 
 */
@Entity
@Table(name="item_price")
@NamedQuery(name="ItemPrice.findAll", query="SELECT i FROM ItemPrice i")
public class ItemPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private BigInteger price;

	//bi-directional many-to-one association to ProductItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private ProductItem productItem;

	public ItemPrice() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigInteger getPrice() {
		return this.price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public ProductItem getProductItem() {
		return this.productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

}