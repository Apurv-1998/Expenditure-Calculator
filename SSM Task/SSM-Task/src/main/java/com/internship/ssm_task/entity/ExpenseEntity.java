package com.internship.ssm_task.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "expense")
@Table(name = "expense")
public class ExpenseEntity implements Serializable {

	
	private static final long serialVersionUID = 2421024776745927242L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = true)
	private double amount;
	@Column(nullable = true)
	private Date date;
	@Column(nullable = true)
	private String expense;
	@Column(nullable = true)
	private String type;
	@Column(nullable = true)
	private String category;
	@Column(nullable = true)
	private String paymentMode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "ExpenseEntity [id=" + id + ", amount=" + amount + ", date=" + date + ", expense=" + expense + ", type="
				+ type + ", category=" + category + ", paymentMode=" + paymentMode + "]";
	}

}
