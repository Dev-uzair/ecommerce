package com.mecapsecomm.pro.ecommerce.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the master_product database table.
 * 
 */
@Entity
@Table(name="master_product")
@NamedQuery(name="MasterProduct.findAll", query="SELECT m FROM MasterProduct m")
public class MasterProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productId;

	private String description;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="product_name")
	private String productName;

	@Column(name="reward_points")
	private BigInteger rewardPoints;

	private String slug;

	//bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(
		name="product_categories"
		, joinColumns={
			@JoinColumn(name="product_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="category_id")
			}
		)
	private List<Category> categories;

	//bi-directional many-to-one association to ProductDiscount
	@OneToMany(mappedBy="masterProduct")
	private List<ProductDiscount> productDiscounts;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="masterProduct")
	private List<ProductImage> productImages;

	//bi-directional many-to-one association to ProductItem
	@OneToMany(mappedBy="masterProduct")
	private List<ProductItem> productItems;

	//bi-directional many-to-one association to ProductLog
	@OneToMany(mappedBy="masterProduct")
	private List<ProductLog> productLogs;

	public MasterProduct() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigInteger getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(BigInteger rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<ProductDiscount> getProductDiscounts() {
		return this.productDiscounts;
	}

	public void setProductDiscounts(List<ProductDiscount> productDiscounts) {
		this.productDiscounts = productDiscounts;
	}

	public ProductDiscount addProductDiscount(ProductDiscount productDiscount) {
		getProductDiscounts().add(productDiscount);
		productDiscount.setMasterProduct(this);

		return productDiscount;
	}

	public ProductDiscount removeProductDiscount(ProductDiscount productDiscount) {
		getProductDiscounts().remove(productDiscount);
		productDiscount.setMasterProduct(null);

		return productDiscount;
	}

	public List<ProductImage> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public ProductImage addProductImage(ProductImage productImage) {
		getProductImages().add(productImage);
		productImage.setMasterProduct(this);

		return productImage;
	}

	public ProductImage removeProductImage(ProductImage productImage) {
		getProductImages().remove(productImage);
		productImage.setMasterProduct(null);

		return productImage;
	}

	public List<ProductItem> getProductItems() {
		return this.productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public ProductItem addProductItem(ProductItem productItem) {
		getProductItems().add(productItem);
		productItem.setMasterProduct(this);

		return productItem;
	}

	public ProductItem removeProductItem(ProductItem productItem) {
		getProductItems().remove(productItem);
		productItem.setMasterProduct(null);

		return productItem;
	}

	public List<ProductLog> getProductLogs() {
		return this.productLogs;
	}

	public void setProductLogs(List<ProductLog> productLogs) {
		this.productLogs = productLogs;
	}

	public ProductLog addProductLog(ProductLog productLog) {
		getProductLogs().add(productLog);
		productLog.setMasterProduct(this);

		return productLog;
	}

	public ProductLog removeProductLog(ProductLog productLog) {
		getProductLogs().remove(productLog);
		productLog.setMasterProduct(null);

		return productLog;
	}

}