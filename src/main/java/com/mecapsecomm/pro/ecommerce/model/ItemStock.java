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
 * The persistent class for the item_stock database table.
 * 
 */
@Entity
@Table(name="item_stock")
@NamedQuery(name="ItemStock.findAll", query="SELECT i FROM ItemStock i")
public class ItemStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stock_id")
	private long stockId;

	private BigInteger stock;

	//bi-directional many-to-one association to DarkStore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="store_id")
	private DarkStore darkStore;

	//bi-directional many-to-one association to ProductItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private ProductItem productItem;

	public ItemStock() {
	}

	public long getStockId() {
		return this.stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public BigInteger getStock() {
		return this.stock;
	}

	public void setStock(BigInteger stock) {
		this.stock = stock;
	}

	public DarkStore getDarkStore() {
		return this.darkStore;
	}

	public void setDarkStore(DarkStore darkStore) {
		this.darkStore = darkStore;
	}

	public ProductItem getProductItem() {
		return this.productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

}