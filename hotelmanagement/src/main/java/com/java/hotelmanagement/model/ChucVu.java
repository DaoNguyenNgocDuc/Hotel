package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chuc_vu")
public class ChucVu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String ten_cv;
		
	public ChucVu() {
	}

	public ChucVu(String ten_cv) {
		this.ten_cv = ten_cv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen_cv() {
		return ten_cv;
	}

	public void setTen_cv(String ten_cv) {
		this.ten_cv = ten_cv;
	}

	@Override
	public String toString() {
		return "ChucVu [id=" + id + ", ten_cv=" + ten_cv + "]";
	}
	
	
}
