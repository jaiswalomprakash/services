package com.services.cloud.model;

// Generated Jan 4, 2016 5:30:08 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "services", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users implements java.io.Serializable {

	private Integer userId;
	private Users users;
	private String active;
	private String companyAddress;
	private String companyName;
	private Date createDate;
	private String division;
	private String email;
	private String mobilePhoneNumber;
	@JsonIgnore
	private String password;
	private String phoneNumber;
	private String realname;
	private String title;
	private byte[] userImage;
	private String userImageFilename;
	@JsonIgnore	
	private Set<UserRoleMapping> userRoleMappings = new HashSet<UserRoleMapping>(0);
	@JsonIgnore
	private Set<Users> userses = new HashSet<Users>(0);
	@JsonManagedReference("users-userAccesstokens")
	private Set<UserAccesstoken> userAccesstokens = new HashSet<UserAccesstoken>(0);
	@JsonIgnore
	private Set<UserServiceMapping> userServiceMappings = new HashSet<UserServiceMapping>(0);

	public Users() {
	}

	public Users(Date createDate, String email, String password) {
		this.createDate = createDate;
		this.email = email;
		this.password = password;
	}

	public Users(Users users, String active, String companyAddress,
			String companyName, Date createDate, String division, String email,
			String mobilePhoneNumber, String password, String phoneNumber,
			String realname, String title, byte[] userImage,
			String userImageFilename, Set<UserRoleMapping> userRoleMappings,
			Set<Users> userses, Set<UserAccesstoken> userAccesstokens,
			Set<UserServiceMapping> userServiceMappings) {
		this.users = users;
		this.active = active;
		this.companyAddress = companyAddress;
		this.companyName = companyName;
		this.createDate = createDate;
		this.division = division;
		this.email = email;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.realname = realname;
		this.title = title;
		this.userImage = userImage;
		this.userImageFilename = userImageFilename;
		this.userRoleMappings = userRoleMappings;
		this.userses = userses;
		this.userAccesstokens = userAccesstokens;
		this.userServiceMappings = userServiceMappings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentUserID")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "active", length = 1)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(name = "companyAddress")
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Column(name = "companyName")
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "division")
	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobilePhoneNumber")
	public String getMobilePhoneNumber() {
		return this.mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "realname")
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "userImage")
	public byte[] getUserImage() {
		return this.userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	@Column(name = "userImageFilename")
	public String getUserImageFilename() {
		return this.userImageFilename;
	}

	public void setUserImageFilename(String userImageFilename) {
		this.userImageFilename = userImageFilename;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")	
	public Set<UserAccesstoken> getUserAccesstokens() {
		return this.userAccesstokens;
	}

	public void setUserAccesstokens(Set<UserAccesstoken> userAccesstokens) {
		this.userAccesstokens = userAccesstokens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserServiceMapping> getUserServiceMappings() {
		return this.userServiceMappings;
	}

	public void setUserServiceMappings(
			Set<UserServiceMapping> userServiceMappings) {
		this.userServiceMappings = userServiceMappings;
	}

}
