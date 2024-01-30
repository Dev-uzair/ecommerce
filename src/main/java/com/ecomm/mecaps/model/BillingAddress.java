package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the billing_address database table.
 * 
 */
@Entity
@Table(name="billing_address")
@NamedQuery(name="BillingAddress.findAll", query="SELECT b FROM BillingAddress b")
public class BillingAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="address_line1")
	private String addressLine1;

	@Column(name="address_type")
	private String addressType;

	@Column(name="city_id")
	private BigInteger cityId;

	@Column(name="customer_id")
	private BigInteger customerId;

	@Column(name="flat_no")
	private BigInteger flatNo;

	@Column(name="house_no")
	private BigInteger houseNo;

	@Column(name="is_default")
	private byte isDefault;

	private String landmark;

	private double latitude;

	private BigInteger longitude;

	private String POC_email;

	private String POC_name;

	private String POC_phone_no;

	@Column(name="postal_code")
	private BigInteger postalCode;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="billingAddress")
	private List<Order> orders;

	public BillingAddress() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public BigInteger getCityId() {
		return this.cityId;
	}

	public void setCityId(BigInteger cityId) {
		this.cityId = cityId;
	}

	public BigInteger getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public BigInteger getFlatNo() {
		return this.flatNo;
	}

	public void setFlatNo(BigInteger flatNo) {
		this.flatNo = flatNo;
	}

	public BigInteger getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(BigInteger houseNo) {
		this.houseNo = houseNo;
	}

	public byte getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(byte isDefault) {
		this.isDefault = isDefault;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public BigInteger getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigInteger longitude) {
		this.longitude = longitude;
	}

	public String getPOC_email() {
		return this.POC_email;
	}

	public void setPOC_email(String POC_email) {
		this.POC_email = POC_email;
	}

	public String getPOC_name() {
		return this.POC_name;
	}

	public void setPOC_name(String POC_name) {
		this.POC_name = POC_name;
	}

	public String getPOC_phone_no() {
		return this.POC_phone_no;
	}

	public void setPOC_phone_no(String POC_phone_no) {
		this.POC_phone_no = POC_phone_no;
	}

	public BigInteger getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(BigInteger postalCode) {
		this.postalCode = postalCode;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setBillingAddress(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setBillingAddress(null);

		return order;
	}

}