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


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long orderId;

	@Column(name="order_date")
	private Long orderDate;

	@Column(name="total_amount")
	private double totalAmount;

	//bi-directional many-to-one association to BillingAddress
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="billing_address_id")
	private BillingAddress billingAddress;

	//bi-directional many-to-one association to Cart
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private Cart cart;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to CustomerAddress
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_address_id")
	private CustomerAddress customerAddress;

	//bi-directional many-to-one association to OrderStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_status_id")
	private OrderStatus orderStatus;

	//bi-directional many-to-one association to Shipping
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shipping_id")
	private Shipping shipping;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to OrdersLog
	@OneToMany(mappedBy="order")
	private List<OrdersLog> ordersLogs;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="order")
	private List<Payment> payments;

	public Order() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BillingAddress getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerAddress getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Shipping getShipping() {
		return this.shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

	public List<OrdersLog> getOrdersLogs() {
		return this.ordersLogs;
	}

	public void setOrdersLogs(List<OrdersLog> ordersLogs) {
		this.ordersLogs = ordersLogs;
	}

	public OrdersLog addOrdersLog(OrdersLog ordersLog) {
		getOrdersLogs().add(ordersLog);
		ordersLog.setOrder(this);

		return ordersLog;
	}

	public OrdersLog removeOrdersLog(OrdersLog ordersLog) {
		getOrdersLogs().remove(ordersLog);
		ordersLog.setOrder(null);

		return ordersLog;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setOrder(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setOrder(null);

		return payment;
	}

}