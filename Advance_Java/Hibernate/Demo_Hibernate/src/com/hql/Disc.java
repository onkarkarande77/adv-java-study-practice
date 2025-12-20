package com.hql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="disc")
public class Disc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer disc_id;
	@Column
	private String disc_name;
	@Column
	private Integer disc_price;
	@Column
	private String disc_type;
	
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Disc(Integer disc_id, String disc_name, Integer disc_price, String disc_type) {
		super();
		this.disc_id = disc_id;
		this.disc_name = disc_name;
		this.disc_price = disc_price;
		this.disc_type = disc_type;
	}
	public Integer getDisc_id() {
		return disc_id;
	}
	public void setDisc_id(Integer disc_id) {
		this.disc_id = disc_id;
	}
	public String getDisc_name() {
		return disc_name;
	}
	public void setDisc_name(String disc_name) {
		this.disc_name = disc_name;
	}
	public Integer getDisc_price() {
		return disc_price;
	}
	public void setDisc_price(Integer disc_price) {
		this.disc_price = disc_price;
	}
	public String getDisc_type() {
		return disc_type;
	}
	public void setDisc_type(String disc_type) {
		this.disc_type = disc_type;
	}
	@Override
	public String toString() {
		return "Disc [disc_id=" + disc_id + ", disc_name=" + disc_name + ", disc_price=" + disc_price + ", disc_type="
				+ disc_type + "]";
	}

	
}
