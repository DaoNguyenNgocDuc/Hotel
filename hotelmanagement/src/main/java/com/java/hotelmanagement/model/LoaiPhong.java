package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class LoaiPhong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String ten_lp;
	private String mo_ta;
	public LoaiPhong() {
	}
	
	public LoaiPhong(String ten_lp, String mo_ta) {
		this.ten_lp = ten_lp;
		this.mo_ta = mo_ta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen_lp() {
		return ten_lp;
	}

	public void setTen_lp(String ten_lp) {
		this.ten_lp = ten_lp;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	@Override
	public String toString() {
		return "LoaiPhong [id=" + id + ", ten_lp=" + ten_lp + ", mo_ta=" + mo_ta + "]";
	}
	
	
}
