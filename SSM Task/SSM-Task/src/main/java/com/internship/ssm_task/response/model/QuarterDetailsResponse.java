package com.internship.ssm_task.response.model;

import java.io.Serializable;

public class QuarterDetailsResponse implements Serializable {

	private static final long serialVersionUID = -7784575358640835778L;

	private String type;
	private double amount;
	private int quarter;
	private String month;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
