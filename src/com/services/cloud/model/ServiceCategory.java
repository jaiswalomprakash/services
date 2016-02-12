package com.services.cloud.model;

// Generated Jan 4, 2016 5:30:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ServiceCategory generated by hbm2java
 */
@Entity
@Table(name = "service_category", catalog = "services")
public class ServiceCategory implements java.io.Serializable {

	private Long categoryId;
	private String categoryName;
	private Set<ServiceCategoryMapping> serviceCategoryMappings = new HashSet<ServiceCategoryMapping>(
			0);

	public ServiceCategory() {
	}

	public ServiceCategory(String categoryName,
			Set<ServiceCategoryMapping> serviceCategoryMappings) {
		this.categoryName = categoryName;
		this.serviceCategoryMappings = serviceCategoryMappings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "categoryID", unique = true, nullable = false)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "categoryName")
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceCategory")
	public Set<ServiceCategoryMapping> getServiceCategoryMappings() {
		return this.serviceCategoryMappings;
	}

	public void setServiceCategoryMappings(
			Set<ServiceCategoryMapping> serviceCategoryMappings) {
		this.serviceCategoryMappings = serviceCategoryMappings;
	}

}
