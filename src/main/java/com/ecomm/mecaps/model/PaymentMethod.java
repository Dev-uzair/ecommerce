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
 * The persistent class for the payment_method database table.
 * 
 */
@Entity
@Table(name="payment_method")
@NamedQuery(name="PaymentMethod.findAll", query="SELECT p FROM PaymentMethod p")
public class PaymentMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_method_id")
	private Long paymentMethodId;

	@Column(name="method_type")
	private String methodType;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="paymentMethod")
	private List<Payment> payments;

	//bi-directional many-to-one association to PaymentMethod
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_method_id")
	private PaymentMethod paymentMethod;

	//bi-directional many-to-one association to PaymentMethod
	@OneToMany(mappedBy="paymentMethod")
	private List<PaymentMethod> paymentMethods;

	public PaymentMethod() {
	}

	public long getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getMethodType() {
		return this.methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setPaymentMethod(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPaymentMethod(null);

		return payment;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<PaymentMethod> getPaymentMethods() {
		return this.paymentMethods;
	}

	public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod) {
		getPaymentMethods().add(paymentMethod);
		paymentMethod.setPaymentMethod(this);

		return paymentMethod;
	}

	public PaymentMethod removePaymentMethod(PaymentMethod paymentMethod) {
		getPaymentMethods().remove(paymentMethod);
		paymentMethod.setPaymentMethod(null);

		return paymentMethod;
	}

}