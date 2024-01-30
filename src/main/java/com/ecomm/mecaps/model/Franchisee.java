
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
 * The persistent class for the franchisee database table.
 * 
 */
@Entity
@NamedQuery(name="Franchisee.findAll", query="SELECT f FROM Franchisee f")
public class Franchisee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="franchisee_id")
	private long franchiseeId;

	private String email;

	@Column(name="phone_no")
	private String phoneNo;

	//bi-directional many-to-one association to FranchiseeLog
	@OneToMany(mappedBy="franchisee")
	private List<FranchiseeLog> franchiseeLogs;

	//bi-directional many-to-one association to VendorFranchisee
	@OneToMany(mappedBy="franchisee")
	private List<VendorFranchisee> vendorFranchisees;

	public Franchisee() {
	}

	public long getFranchiseeId() {
		return this.franchiseeId;
	}

	public void setFranchiseeId(long franchiseeId) {
		this.franchiseeId = franchiseeId;
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

	public List<FranchiseeLog> getFranchiseeLogs() {
		return this.franchiseeLogs;
	}

	public void setFranchiseeLogs(List<FranchiseeLog> franchiseeLogs) {
		this.franchiseeLogs = franchiseeLogs;
	}

	public FranchiseeLog addFranchiseeLog(FranchiseeLog franchiseeLog) {
		getFranchiseeLogs().add(franchiseeLog);
		franchiseeLog.setFranchisee(this);

		return franchiseeLog;
	}

	public FranchiseeLog removeFranchiseeLog(FranchiseeLog franchiseeLog) {
		getFranchiseeLogs().remove(franchiseeLog);
		franchiseeLog.setFranchisee(null);

		return franchiseeLog;
	}

	public List<VendorFranchisee> getVendorFranchisees() {
		return this.vendorFranchisees;
	}

	public void setVendorFranchisees(List<VendorFranchisee> vendorFranchisees) {
		this.vendorFranchisees = vendorFranchisees;
	}

	public VendorFranchisee addVendorFranchisee(VendorFranchisee vendorFranchisee) {
		getVendorFranchisees().add(vendorFranchisee);
		vendorFranchisee.setFranchisee(this);

		return vendorFranchisee;
	}

	public VendorFranchisee removeVendorFranchisee(VendorFranchisee vendorFranchisee) {
		getVendorFranchisees().remove(vendorFranchisee);
		vendorFranchisee.setFranchisee(null);

		return vendorFranchisee;
	}

}