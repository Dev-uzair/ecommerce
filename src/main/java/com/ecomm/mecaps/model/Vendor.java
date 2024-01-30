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
 * The persistent class for the vendor database table.
 * 
 */
@Entity
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_id")
	private long vendorId;

	private String email;

	@Column(name="phone_no")
	private String phoneNo;

	//bi-directional many-to-one association to VendorFranchisee
	@OneToMany(mappedBy="vendor")
	private List<VendorFranchisee> vendorFranchisees;

	//bi-directional many-to-one association to VendorLog
	@OneToMany(mappedBy="vendor")
	private List<VendorLog> vendorLogs;

	public Vendor() {
	}

	public long getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<VendorFranchisee> getVendorFranchisees() {
		return this.vendorFranchisees;
	}

	public void setVendorFranchisees(List<VendorFranchisee> vendorFranchisees) {
		this.vendorFranchisees = vendorFranchisees;
	}

	public VendorFranchisee addVendorFranchisee(VendorFranchisee vendorFranchisee) {
		getVendorFranchisees().add(vendorFranchisee);
		vendorFranchisee.setVendor(this);

		return vendorFranchisee;
	}

	public VendorFranchisee removeVendorFranchisee(VendorFranchisee vendorFranchisee) {
		getVendorFranchisees().remove(vendorFranchisee);
		vendorFranchisee.setVendor(null);

		return vendorFranchisee;
	}

	public List<VendorLog> getVendorLogs() {
		return this.vendorLogs;
	}

	public void setVendorLogs(List<VendorLog> vendorLogs) {
		this.vendorLogs = vendorLogs;
	}

	public VendorLog addVendorLog(VendorLog vendorLog) {
		getVendorLogs().add(vendorLog);
		vendorLog.setVendor(this);

		return vendorLog;
	}

	public VendorLog removeVendorLog(VendorLog vendorLog) {
		getVendorLogs().remove(vendorLog);
		vendorLog.setVendor(null);

		return vendorLog;
	}

}