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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the order_detail database table.
 * 
 */
@Entity
@Table(name="order_detail")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_detail_id")
	private Long orderDetailId;

	@Column(name="is_active")
	private byte isActive;

	private Double price;

	private Long quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;

	//bi-directional many-to-one association to ProductItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private ProductItem productItem;

	//bi-directional many-to-one association to ReturnedItem
	@OneToMany(mappedBy="orderDetail")
	private List<ReturnedItem> returnedItems;

	public OrderDetail() {
	}

	public long getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ProductItem getProductItem() {
		return this.productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public List<ReturnedItem> getReturnedItems() {
		return this.returnedItems;
	}

	public void setReturnedItems(List<ReturnedItem> returnedItems) {
		this.returnedItems = returnedItems;
	}

	public ReturnedItem addReturnedItem(ReturnedItem returnedItem) {
		getReturnedItems().add(returnedItem);
		returnedItem.setOrderDetail(this);

		return returnedItem;
	}

	public ReturnedItem removeReturnedItem(ReturnedItem returnedItem) {
		getReturnedItems().remove(returnedItem);
		returnedItem.setOrderDetail(null);

		return returnedItem;
	}

}