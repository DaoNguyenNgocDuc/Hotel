package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hoa_don")
public class HoaDon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_nv;
	private String ten_nv;
	private Long id_ltt;
	private String ten_ltt;
	private String ngay_lap;
	private Long tong_tien;
	public HoaDon() {
	}
	
	public HoaDon(Long id_nv, Long id_ltt, String ngay_lap, Long tong_tien) {
		this.id_nv = id_nv;
		this.id_ltt = id_ltt;
		this.ngay_lap = ngay_lap;
		this.tong_tien = tong_tien;
	}

	
	public HoaDon(Long id_nv, String ten_nv, Long id_ltt, String ten_ltt, String ngay_lap, Long tong_tien) {
		this.id_nv = id_nv;
		this.ten_nv = ten_nv;
		this.id_ltt = id_ltt;
		this.ten_ltt = ten_ltt;
		this.ngay_lap = ngay_lap;
		this.tong_tien = tong_tien;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public String getTen_ltt() {
		return ten_ltt;
	}

	public void setTen_ltt(String ten_ltt) {
		this.ten_ltt = ten_ltt;
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

	public Long getId_ltt() {
		return id_ltt;
	}

	public void setId_ltt(Long id_ltt) {
		this.id_ltt = id_ltt;
	}

	public String getNgay_lap() {
		return ngay_lap;
	}

	public void setNgay_lap(String ngay_lap) {
		this.ngay_lap = ngay_lap;
	}

	public Long getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(Long tong_tien) {
		this.tong_tien = tong_tien;
	}

	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", id_nv=" + id_nv + ", ten_nv=" + ten_nv + ", id_ltt=" + id_ltt + ", ten_ltt="
				+ ten_ltt + ", ngay_lap=" + ngay_lap + ", tong_tien=" + tong_tien + "]";
	}

	
	
}
