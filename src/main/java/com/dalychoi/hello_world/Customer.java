package com.dalychoi.hello_world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
	
	private Long customer_id;
	private String cust_first_name;
	private String cust_last_name;
	private Long credit_limit;
	private Date customer_since;
	
	public Customer() {
	}
	
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCust_first_name() {
		return cust_first_name;
	}
	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}
	public String getCust_last_name() {
		return cust_last_name;
	}
	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}
	public Long getCredit_limit() {
		return credit_limit;
	}
	public void setCredit_limit(Long credit_limit) {
		this.credit_limit = credit_limit;
	}
	public Date getCustomer_since() {
		return customer_since;
	}
	public void setCustomer_since(Date customer_since) {
		this.customer_since = customer_since;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", cust_first_name=" + cust_first_name + ", cust_last_name="
				+ cust_last_name + ", credit_limit=" + credit_limit + ", customer_since=" + customer_since + "]";
	}
}
