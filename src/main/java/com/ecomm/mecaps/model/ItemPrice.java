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
	private Long id;

	private Long price;

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

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public ProductItem getProductItem() {
		return this.productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

}