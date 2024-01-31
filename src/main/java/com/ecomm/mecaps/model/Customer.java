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
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;

	@Column(name="customer_type")
	private Long customerType;

	private String email;

	private String password;

	@Column(name="phone_no")
	private String phoneNo;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="customer")
	private List<Cart> carts;

	//bi-directional many-to-one association to CustomerDiscount
	@OneToMany(mappedBy="customer")
	private List<CustomerDiscount> customerDiscounts;

	//bi-directional many-to-one association to CustomerLog
	@OneToMany(mappedBy="customer")
	private List<CustomerLog> customerLogs;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private List<Order> orders;

	public Customer() {
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Long getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(Long customerType) {
		this.customerType = customerType;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setCustomer(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setCustomer(null);

		return cart;
	}

	public List<CustomerDiscount> getCustomerDiscounts() {
		return this.customerDiscounts;
	}

	public void setCustomerDiscounts(List<CustomerDiscount> customerDiscounts) {
		this.customerDiscounts = customerDiscounts;
	}

	public CustomerDiscount addCustomerDiscount(CustomerDiscount customerDiscount) {
		getCustomerDiscounts().add(customerDiscount);
		customerDiscount.setCustomer(this);

		return customerDiscount;
	}

	public CustomerDiscount removeCustomerDiscount(CustomerDiscount customerDiscount) {
		getCustomerDiscounts().remove(customerDiscount);
		customerDiscount.setCustomer(null);

		return customerDiscount;
	}

	public List<CustomerLog> getCustomerLogs() {
		return this.customerLogs;
	}

	public void setCustomerLogs(List<CustomerLog> customerLogs) {
		this.customerLogs = customerLogs;
	}

	public CustomerLog addCustomerLog(CustomerLog customerLog) {
		getCustomerLogs().add(customerLog);
		customerLog.setCustomer(this);

		return customerLog;
	}

	public CustomerLog removeCustomerLog(CustomerLog customerLog) {
		getCustomerLogs().remove(customerLog);
		customerLog.setCustomer(null);

		return customerLog;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

}