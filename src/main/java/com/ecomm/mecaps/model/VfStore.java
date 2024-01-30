package com.ecomm.mecaps.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the vf_store database table.
 * 
 */
@Entity
@Table(name="vf_store")
@NamedQuery(name="VfStore.findAll", query="SELECT v FROM VfStore v")
public class VfStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vf_store_id")
	private long vfStoreId;

	//bi-directional many-to-one association to DarkStore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="store_id")
	private DarkStore darkStore;

	//bi-directional many-to-one association to VendorFranchisee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VFID")
	private VendorFranchisee vendorFranchisee;

	public VfStore() {
	}

	public long getVfStoreId() {
		return this.vfStoreId;
	}

	public void setVfStoreId(long vfStoreId) {
		this.vfStoreId = vfStoreId;
	}

	public DarkStore getDarkStore() {
		return this.darkStore;
	}

	public void setDarkStore(DarkStore darkStore) {
		this.darkStore = darkStore;
	}

	public VendorFranchisee getVendorFranchisee() {
		return this.vendorFranchisee;
	}

	public void setVendorFranchisee(VendorFranchisee vendorFranchisee) {
		this.vendorFranchisee = vendorFranchisee;
	}

}