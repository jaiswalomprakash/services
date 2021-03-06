package com.services.cloud.model;

// Generated Jan 4, 2016 5:30:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRoleMappingId generated by hbm2java
 */
@Embeddable
public class UserRoleMappingId implements java.io.Serializable {

	private Date createDate;
	private int roleId;
	private int userId;

	public UserRoleMappingId() {
	}

	public UserRoleMappingId(Date createDate, int roleId, int userId) {
		this.createDate = createDate;
		this.roleId = roleId;
		this.userId = userId;
	}

	@Column(name = "createDate", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "roleID", nullable = false)
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "userID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleMappingId))
			return false;
		UserRoleMappingId castOther = (UserRoleMappingId) other;

		return ((this.getCreateDate() == castOther.getCreateDate()) || (this
				.getCreateDate() != null && castOther.getCreateDate() != null && this
				.getCreateDate().equals(castOther.getCreateDate())))
				&& (this.getRoleId() == castOther.getRoleId())
				&& (this.getUserId() == castOther.getUserId());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCreateDate() == null ? 0 : this.getCreateDate()
						.hashCode());
		result = 37 * result + this.getRoleId();
		result = 37 * result + this.getUserId();
		return result;
	}

}
