package com.ecomm.mecaps.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long categoryId;

	private Long image;

	@Column(name="parent_id")
	private Long parentId;

	@Column(name="reward_points")
	private Long rewardPoints;

	private Long title;

	//bi-directional many-to-one association to CategoryDiscount
	@OneToMany(mappedBy="category")
	private List<CategoryDiscount> categoryDiscounts;

	//bi-directional many-to-many association to MasterProduct
	@ManyToMany(mappedBy="categories")
	private List<MasterProduct> masterProducts;

	//bi-directional many-to-one association to Variation
	@OneToMany(mappedBy="category")
	private List<Variation> variations;

	public Category() {
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getImage() {
		return this.image;
	}

	public void setImage(Long image) {
		this.image = image;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Long getTitle() {
		return this.title;
	}

	public void setTitle(Long title) {
		this.title = title;
	}

	public List<CategoryDiscount> getCategoryDiscounts() {
		return this.categoryDiscounts;
	}

	public void setCategoryDiscounts(List<CategoryDiscount> categoryDiscounts) {
		this.categoryDiscounts = categoryDiscounts;
	}

	public CategoryDiscount addCategoryDiscount(CategoryDiscount categoryDiscount) {
		getCategoryDiscounts().add(categoryDiscount);
		categoryDiscount.setCategory(this);

		return categoryDiscount;
	}

	public CategoryDiscount removeCategoryDiscount(CategoryDiscount categoryDiscount) {
		getCategoryDiscounts().remove(categoryDiscount);
		categoryDiscount.setCategory(null);

		return categoryDiscount;
	}

	public List<MasterProduct> getMasterProducts() {
		return this.masterProducts;
	}

	public void setMasterProducts(List<MasterProduct> masterProducts) {
		this.masterProducts = masterProducts;
	}

	public List<Variation> getVariations() {
		return this.variations;
	}

	public void setVariations(List<Variation> variations) {
		this.variations = variations;
	}

	public Variation addVariation(Variation variation) {
		getVariations().add(variation);
		variation.setCategory(this);

		return variation;
	}

	public Variation removeVariation(Variation variation) {
		getVariations().remove(variation);
		variation.setCategory(null);

		return variation;
	}

}