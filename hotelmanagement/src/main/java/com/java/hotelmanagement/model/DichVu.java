package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dich_vu")
public class DichVu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String ten_dv;
	private String don_vi;
	private Long don_gia;
	
	public DichVu() {
	}

	public DichVu(String ten_dv, String don_vi, Long don_gia) {
		this.ten_dv = ten_dv;
		this.don_vi = don_vi;
		this.don_gia = don_gia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen_dv() {
		return ten_dv;
	}

	public void setTen_dv(String ten_dv) {
		this.ten_dv = ten_dv;
	}

	public String getDon_vi() {
		return don_vi;
	}

	public void setDon_vi(String don_vi) {
		this.don_vi = don_vi;
	}

	public Long getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(Long don_gia) {
		this.don_gia = don_gia;
	}

	@Override
	public String toString() {
		return "DichVu [id=" + id + ", ten_dv=" + ten_dv + ", don_vi=" + don_vi + ", don_gia=" + don_gia + "]";
	}
	
	
}
