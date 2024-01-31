
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the variation database table.
 * 
 */
@Entity
@NamedQuery(name="Variation.findAll", query="SELECT v FROM Variation v")
public class Variation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="variation_id")
	private Long variationId;

	private String name;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;

	//bi-directional many-to-one association to VariationOption
	@OneToMany(mappedBy="variation")
	private List<VariationOption> variationOptions;

	public Variation() {
	}

	public long getVariationId() {
		return this.variationId;
	}

	public void setVariationId(long variationId) {
		this.variationId = variationId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<VariationOption> getVariationOptions() {
		return this.variationOptions;
	}

	public void setVariationOptions(List<VariationOption> variationOptions) {
		this.variationOptions = variationOptions;
	}

	public VariationOption addVariationOption(VariationOption variationOption) {
		getVariationOptions().add(variationOption);
		variationOption.setVariation(this);

		return variationOption;
	}

	public VariationOption removeVariationOption(VariationOption variationOption) {
		getVariationOptions().remove(variationOption);
		variationOption.setVariation(null);

		return variationOption;
	}

}