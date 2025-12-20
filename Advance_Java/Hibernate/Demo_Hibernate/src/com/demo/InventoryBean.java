package com.demo;

public class InventoryBean {
	private Integer vend_id;
	private String vend_name;
	//constructor setter getter toString
	public InventoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InventoryBean(Integer vend_id, String vend_name) {
		super();
		this.vend_id = vend_id;
		this.vend_name = vend_name;
	}
	public Integer getVend_id() {
		return vend_id;
	}
	public void setVend_id(Integer vend_id) {
		this.vend_id = vend_id;
	}
	public String getVend_name() {
		return vend_name;
	}
	public void setVend_name(String vend_name) {
		this.vend_name = vend_name;
	}
	@Override
	public String toString() {
		return "InventoryBean [vend_id=" + vend_id + ", vend_name=" + vend_name + "]";
	}

	

}
