package com.cust;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cust_Bean {
	@Id
	private Integer custId;
	@Column
	private String custName;
	public Cust_Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cust_Bean(Integer custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@Override
	public String toString() {
		return "Cust_Bean [custId=" + custId + ", custName=" + custName + "]";
	}
	
	

}
