package com.services.cloud.model;

// Generated Jan 4, 2016 5:30:08 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ServiceCategoryMappingId generated by hbm2java
 */
@Embeddable
public class ServiceCategoryMappingId implements java.io.Serializable {

	private Long categoryId;
	private Integer serviceId;

	public ServiceCategoryMappingId() {
	}

	public ServiceCategoryMappingId(Long categoryId, Integer serviceId) {
		this.categoryId = categoryId;
		this.serviceId = serviceId;
	}

	@Column(name = "categoryID")
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "serviceID")
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ServiceCategoryMappingId))
			return false;
		ServiceCategoryMappingId castOther = (ServiceCategoryMappingId) other;

		return ((this.getCategoryId() == castOther.getCategoryId()) || (this
				.getCategoryId() != null && castOther.getCategoryId() != null && this
				.getCategoryId().equals(castOther.getCategoryId())))
				&& ((this.getServiceId() == castOther.getServiceId()) || (this
						.getServiceId() != null
						&& castOther.getServiceId() != null && this
						.getServiceId().equals(castOther.getServiceId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCategoryId() == null ? 0 : this.getCategoryId()
						.hashCode());
		result = 37 * result
				+ (getServiceId() == null ? 0 : this.getServiceId().hashCode());
		return result;
	}

}
