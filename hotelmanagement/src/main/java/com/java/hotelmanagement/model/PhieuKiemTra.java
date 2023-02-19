package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "phieu_kt")
@IdClass(PhieuKTId.class)
public class PhieuKiemTra implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_nv;
	private String ten_nv;
	@Id
	private Long id_pdp;
	private String ngay_lap;
	private String tinh_trang;
	
	public PhieuKiemTra() {
	}

	public PhieuKiemTra(Long id_nv, Long id_pdp, String ngay_lap, String tinh_trang) {
		this.id_nv = id_nv;
		this.id_pdp = id_pdp;
		this.ngay_lap = ngay_lap;
		this.tinh_trang = tinh_trang;
	}

	
	
	public PhieuKiemTra(Long id_nv, String ten_nv, Long id_pdp, String ngay_lap, String tinh_trang) {
		this.id_nv = id_nv;
		this.ten_nv = ten_nv;
		this.id_pdp = id_pdp;
		this.ngay_lap = ngay_lap;
		this.tinh_trang = tinh_trang;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_nv() {
		return id_nv;
	}

	public void setId_nv(Long id_nv) {
		this.id_nv = id_nv;
	}

	public Long getId_pdp() {
		return id_pdp;
	}

	public void setId_pdp(Long id_pdp) {
		this.id_pdp = id_pdp;
	}

	public String getNgay_lap() {
		return ngay_lap;
	}

	public void setNgay_lap(String ngay_lap) {
		this.ngay_lap = ngay_lap;
	}

	public String getTinh_trang() {
		return tinh_trang;
	}

	public void setTinh_trang(String tinh_trang) {
		this.tinh_trang = tinh_trang;
	}

	@Override
	public String toString() {
		return "PhieuKiemTra [id=" + id + ", id_nv=" + id_nv + ", ten_nv=" + ten_nv + ", id_pdp=" + id_pdp
				+ ", ngay_lap=" + ngay_lap + ", tinh_trang=" + tinh_trang + "]";
	}
	
}
