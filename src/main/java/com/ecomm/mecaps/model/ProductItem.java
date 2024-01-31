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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the product_item database table.
 * 
 */
@Entity
@Table(name="product_item")
@NamedQuery(name="ProductItem.findAll", query="SELECT p FROM ProductItem p")
public class ProductItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long itemId;

	private String description;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="reward_points")
	private Long rewardPoints;

	private Long sku;

	private String slug;

	//bi-directional many-to-one association to ItemLog
	@OneToMany(mappedBy="productItem")
	private List<ItemLog> itemLogs;

	//bi-directional many-to-one association to ItemPrice
	@OneToMany(mappedBy="productItem")
	private List<ItemPrice> itemPrices;

	//bi-directional many-to-one association to ItemStock
	@OneToMany(mappedBy="productItem")
	private List<ItemStock> itemStocks;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="productItem")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to MasterProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private MasterProduct masterProduct;

	//bi-directional many-to-one association to VendorFranchisee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VFID")
	private VendorFranchisee vendorFranchisee;

	//bi-directional many-to-many association to VariationOption
	@ManyToMany(mappedBy="productItems")
	private List<VariationOption> variationOptions;

	public ProductItem() {
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Long getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Long getSku() {
		return this.sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<ItemLog> getItemLogs() {
		return this.itemLogs;
	}

	public void setItemLogs(List<ItemLog> itemLogs) {
		this.itemLogs = itemLogs;
	}

	public ItemLog addItemLog(ItemLog itemLog) {
		getItemLogs().add(itemLog);
		itemLog.setProductItem(this);

		return itemLog;
	}

	public ItemLog removeItemLog(ItemLog itemLog) {
		getItemLogs().remove(itemLog);
		itemLog.setProductItem(null);

		return itemLog;
	}

	public List<ItemPrice> getItemPrices() {
		return this.itemPrices;
	}

	public void setItemPrices(List<ItemPrice> itemPrices) {
		this.itemPrices = itemPrices;
	}

	public ItemPrice addItemPrice(ItemPrice itemPrice) {
		getItemPrices().add(itemPrice);
		itemPrice.setProductItem(this);

		return itemPrice;
	}

	public ItemPrice removeItemPrice(ItemPrice itemPrice) {
		getItemPrices().remove(itemPrice);
		itemPrice.setProductItem(null);

		return itemPrice;
	}

	public List<ItemStock> getItemStocks() {
		return this.itemStocks;
	}

	public void setItemStocks(List<ItemStock> itemStocks) {
		this.itemStocks = itemStocks;
	}

	public ItemStock addItemStock(ItemStock itemStock) {
		getItemStocks().add(itemStock);
		itemStock.setProductItem(this);

		return itemStock;
	}

	public ItemStock removeItemStock(ItemStock itemStock) {
		getItemStocks().remove(itemStock);
		itemStock.setProductItem(null);

		return itemStock;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProductItem(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProductItem(null);

		return orderDetail;
	}

	public MasterProduct getMasterProduct() {
		return this.masterProduct;
	}

	public void setMasterProduct(MasterProduct masterProduct) {
		this.masterProduct = masterProduct;
	}

	public VendorFranchisee getVendorFranchisee() {
		return this.vendorFranchisee;
	}

	public void setVendorFranchisee(VendorFranchisee vendorFranchisee) {
		this.vendorFranchisee = vendorFranchisee;
	}

	public List<VariationOption> getVariationOptions() {
		return this.variationOptions;
	}

	public void setVariationOptions(List<VariationOption> variationOptions) {
		this.variationOptions = variationOptions;
	}

}