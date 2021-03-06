package com.services.cloud.model;

// Generated Jan 4, 2016 5:30:08 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserRoleMapping generated by hbm2java
 */
@Entity
@Table(name = "user_role_mapping", catalog = "services")
public class UserRoleMapping implements java.io.Serializable {

	private UserRoleMappingId id;
	private Users users;
	private UserRoles userRoles;

	public UserRoleMapping() {
	}

	public UserRoleMapping(UserRoleMappingId id, Users users,
			UserRoles userRoles) {
		this.id = id;
		this.users = users;
		this.userRoles = userRoles;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "createDate", column = @Column(name = "createDate", nullable = false, length = 19)),
			@AttributeOverride(name = "roleId", column = @Column(name = "roleID", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "userID", nullable = false)) })
	public UserRoleMappingId getId() {
		return this.id;
	}

	public void setId(UserRoleMappingId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleID", nullable = false, insertable = false, updatable = false)
	public UserRoles getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

}
