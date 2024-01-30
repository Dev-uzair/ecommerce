package com.ecomm.mecaps.model;

import java.io.Serializable;
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
 * The persistent class for the customer_log database table.
 * 
 */
@Entity
@Table(name="customer_log")
@NamedQuery(name="CustomerLog.findAll", query="SELECT c FROM CustomerLog c")
public class CustomerLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int logID;

	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modiefied_Timestamp;

	private String newValues;

	private String oldValues;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public CustomerLog() {
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

	public String getNewValues() {
		return this.newValues;
	}

	public void setNewValues(String newValues) {
		this.newValues = newValues;
	}

	public String getOldValues() {
		return this.oldValues;
	}

	public void setOldValues(String oldValues) {
		this.oldValues = oldValues;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}