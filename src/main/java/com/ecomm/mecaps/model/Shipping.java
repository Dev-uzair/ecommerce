package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the shipping database table.
 * 
 */
@Entity
@NamedQuery(name="Shipping.findAll", query="SELECT s FROM Shipping s")
public class Shipping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shipping_id")
	private Long shippingId;

	@Column(name="estimated_delivery")
	private Long estimatedDelivery;

	@Column(name="shipping_cost")
	private Long shippingCost;

	@Column(name="shipping_method")
	private String shippingMethod;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="shipping")
	private List<Order> orders;

	//bi-directional many-to-one association to ShippingLog
	@OneToMany(mappedBy="shipping")
	private List<ShippingLog> shippingLogs;

	public Shipping() {
	}

	public long getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(long shippingId) {
		this.shippingId = shippingId;
	}

	public Long getEstimatedDelivery() {
		return this.estimatedDelivery;
	}

	public void setEstimatedDelivery(Long estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	public Long getShippingCost() {
		return this.shippingCost;
	}

	public void setShippingCost(Long shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getShippingMethod() {
		return this.shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setShipping(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setShipping(null);

		return order;
	}

	public List<ShippingLog> getShippingLogs() {
		return this.shippingLogs;
	}

	public void setShippingLogs(List<ShippingLog> shippingLogs) {
		this.shippingLogs = shippingLogs;
	}

	public ShippingLog addShippingLog(ShippingLog shippingLog) {
		getShippingLogs().add(shippingLog);
		shippingLog.setShipping(this);

		return shippingLog;
	}

	public ShippingLog removeShippingLog(ShippingLog shippingLog) {
		getShippingLogs().remove(shippingLog);
		shippingLog.setShipping(null);

		return shippingLog;
	}

}