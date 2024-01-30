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
 * The persistent class for the orders_log database table.
 * 
 */
@Entity
@Table(name="orders_log")
@NamedQuery(name="OrdersLog.findAll", query="SELECT o FROM OrdersLog o")
public class OrdersLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int logID;

	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modiefied_Timestamp;

	private String newValues;

	private String oldValues;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;

	public OrdersLog() {
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

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}