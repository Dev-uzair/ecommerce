package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

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
 * The persistent class for the item_log database table.
 * 
 */
@Entity
@Table(name="item_log")
@NamedQuery(name="ItemLog.findAll", query="SELECT i FROM ItemLog i")
public class ItemLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int logID;

	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modiefied_Timestamp;

	private BigInteger newPrice;

	private BigInteger oldPrice;

	//bi-directional many-to-one association to ProductItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private ProductItem productItem;

	public ItemLog() {
	}

	public int getLogID() {
		return this.logID;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getModiefied_Timestamp() {
		return this.modiefied_Timestamp;
	}

	public void setModiefied_Timestamp(Date modiefied_Timestamp) {
		this.modiefied_Timestamp = modiefied_Timestamp;
	}

	public BigInteger getNewPrice() {
		return this.newPrice;
	}

	public void setNewPrice(BigInteger newPrice) {
		this.newPrice = newPrice;
	}

	public BigInteger getOldPrice() {
		return this.oldPrice;
	}

	public void setOldPrice(BigInteger oldPrice) {
		this.oldPrice = oldPrice;
	}

	public ProductItem getProductItem() {
		return this.productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

}