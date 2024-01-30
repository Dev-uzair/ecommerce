package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.util.List;

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
 * The persistent class for the vendor_franchisee database table.
 * 
 */
@Entity
@Table(name="vendor_franchisee")
@NamedQuery(name="VendorFranchisee.findAll", query="SELECT v FROM VendorFranchisee v")
public class VendorFranchisee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vfid;

	//bi-directional many-to-one association to ProductItem
	@OneToMany(mappedBy="vendorFranchisee")
	private List<ProductItem> productItems;

	//bi-directional many-to-one association to Franchisee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="franchisee_id")
	private Franchisee franchisee;

	//bi-directional many-to-one association to Vendor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vendor_id")
	private Vendor vendor;

	//bi-directional many-to-one association to VfStore
	@OneToMany(mappedBy="vendorFranchisee")
	private List<VfStore> vfStores;

	public VendorFranchisee() {
	}

	public long getVfid() {
		return this.vfid;
	}

	public void setVfid(long vfid) {
		this.vfid = vfid;
	}

	public List<ProductItem> getProductItems() {
		return this.productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public ProductItem addProductItem(ProductItem productItem) {
		getProductItems().add(productItem);
		productItem.setVendorFranchisee(this);

		return productItem;
	}

	public ProductItem removeProductItem(ProductItem productItem) {
		getProductItems().remove(productItem);
		productItem.setVendorFranchisee(null);

		return productItem;
	}

	public Franchisee getFranchisee() {
		return this.franchisee;
	}

	public void setFranchisee(Franchisee franchisee) {
		this.franchisee = franchisee;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<VfStore> getVfStores() {
		return this.vfStores;
	}

	public void setVfStores(List<VfStore> vfStores) {
		this.vfStores = vfStores;
	}

	public VfStore addVfStore(VfStore vfStore) {
		getVfStores().add(vfStore);
		vfStore.setVendorFranchisee(this);

		return vfStore;
	}

	public VfStore removeVfStore(VfStore vfStore) {
		getVfStores().remove(vfStore);
		vfStore.setVendorFranchisee(null);

		return vfStore;
	}

}