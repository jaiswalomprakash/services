package com.services.cloud.model;

// Generated Jan 4, 2016 5:30:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Expense generated by hbm2java
 */
@Entity
@Table(name = "expense", catalog = "services")
public class Expense implements java.io.Serializable {

	private Long id;
	private Account account;
	private String accountNo;
	private Float amount;
	private String bankName;
	private String checkNo;
	private Date date;
	private String givenTo;
	private Long itemName;
	private String other;
	private String paymentMode;
	private String status;

	public Expense() {
	}

	public Expense(Account account) {
		this.account = account;
	}

	public Expense(Account account, String accountNo, Float amount,
			String bankName, String checkNo, Date date, String givenTo,
			Long itemName, String other, String paymentMode, String status) {
		this.account = account;
		this.accountNo = accountNo;
		this.amount = amount;
		this.bankName = bankName;
		this.checkNo = checkNo;
		this.date = date;
		this.givenTo = givenTo;
		this.itemName = itemName;
		this.other = other;
		this.paymentMode = paymentMode;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "account_no", length = 100)
	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Column(name = "amount", precision = 12, scale = 0)
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Column(name = "bank_name", length = 100)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "check_no", length = 100)
	public String getCheckNo() {
		return this.checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "given_to", length = 100)
	public String getGivenTo() {
		return this.givenTo;
	}

	public void setGivenTo(String givenTo) {
		this.givenTo = givenTo;
	}

	@Column(name = "item_name")
	public Long getItemName() {
		return this.itemName;
	}

	public void setItemName(Long itemName) {
		this.itemName = itemName;
	}

	@Column(name = "other")
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "payment_mode", length = 100)
	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}