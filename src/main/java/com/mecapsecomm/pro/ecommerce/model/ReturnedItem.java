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
 * The persistent class for the returned_item database table.
 * 
 */
@Entity
@Table(name="returned_item")
@NamedQuery(name="ReturnedItem.findAll", query="SELECT r FROM ReturnedItem r")
public class ReturnedItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigInteger quantity;

	//bi-directional many-to-one association to OrderDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_detail_id")
	private OrderDetail orderDetail;

	public ReturnedItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

	public OrderDetail getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}