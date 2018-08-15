package com.web.customer.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3028309244292199143L;

	private int customer_id;
	private String customer_name; 
	private String customer_address; 
	private String customer_internal_name; 
	private String customer_status; 
	private Date create_date; 
	private Date update_date;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_internal_name() {
		return customer_internal_name;
	}

	public void setCustomer_internal_name(String customer_internal_name) {
		this.customer_internal_name = customer_internal_name;
	}

	public String getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_internal_name=" + customer_internal_name + ", customer_status="
				+ customer_status + ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
}
