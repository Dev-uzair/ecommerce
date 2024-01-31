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
import jakarta.persistence.Table;


/**
 * The persistent class for the dark_store database table.
 * 
 */
@Entity
@Table(name="dark_store")
@NamedQuery(name="DarkStore.findAll", query="SELECT d FROM DarkStore d")
public class DarkStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private Long storeId;

	@Column(name="city_id")
	private Long cityId;

	private Double latitude;

	private Double longitude;

	@Column(name="store_name")
	private String storeName;

	private Long vfid;

	//bi-directional many-to-one association to ItemStock
	@OneToMany(mappedBy="darkStore")
	private List<ItemStock> itemStocks;

	//bi-directional many-to-one association to VfStore
	@OneToMany(mappedBy="darkStore")
	private List<VfStore> vfStores;

	public DarkStore() {
	}

	public long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getVfid() {
		return this.vfid;
	}

	public void setVfid(Long vfid) {
		this.vfid = vfid;
	}

	public List<ItemStock> getItemStocks() {
		return this.itemStocks;
	}

	public void setItemStocks(List<ItemStock> itemStocks) {
		this.itemStocks = itemStocks;
	}

	public ItemStock addItemStock(ItemStock itemStock) {
		getItemStocks().add(itemStock);
		itemStock.setDarkStore(this);

		return itemStock;
	}

	public ItemStock removeItemStock(ItemStock itemStock) {
		getItemStocks().remove(itemStock);
		itemStock.setDarkStore(null);

		return itemStock;
	}

	public List<VfStore> getVfStores() {
		return this.vfStores;
	}

	public void setVfStores(List<VfStore> vfStores) {
		this.vfStores = vfStores;
	}

	public VfStore addVfStore(VfStore vfStore) {
		getVfStores().add(vfStore);
		vfStore.setDarkStore(this);

		return vfStore;
	}

	public VfStore removeVfStore(VfStore vfStore) {
		getVfStores().remove(vfStore);
		vfStore.setDarkStore(null);

		return vfStore;
	}

}