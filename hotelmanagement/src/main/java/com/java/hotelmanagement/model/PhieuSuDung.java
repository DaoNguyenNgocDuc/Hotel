package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phieu_su_dung")
public class PhieuSuDung implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_nv;
	private String ten_nv;
	private Long id_p;
	private Long id_pdp;
	private Long id_dv;
	private String ten_dv;
	private String ngay_sd;
	private int so_luong;
	public PhieuSuDung() {
	}
	
	public PhieuSuDung(Long id_nv, Long id_p, Long id_pdp, Long id_dv, String ngay_sd, int so_luong) {
		this.id_nv = id_nv;
		this.id_p = id_p;
		this.id_pdp = id_pdp;
		this.id_dv = id_dv;
		this.ngay_sd = ngay_sd;
		this.so_luong = so_luong;
	}

	public PhieuSuDung(Long id_nv, String ten_nv, Long id_p, Long id_pdp, Long id_dv, String ten_dv, String ngay_sd,
			int so_luong) {
		this.id_nv = id_nv;
		this.ten_nv = ten_nv;
		this.id_p = id_p;
		this.id_pdp = id_pdp;
		this.id_dv = id_dv;
		this.ten_dv = ten_dv;
		this.ngay_sd = ngay_sd;
		this.so_luong = so_luong;
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

	public Long getId_p() {
		return id_p;
	}

	public void setId_p(Long id_p) {
		this.id_p = id_p;
	}

	public Long getId_pdp() {
		return id_pdp;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public String getTen_dv() {
		return ten_dv;
	}

	public void setTen_dv(String ten_dv) {
		this.ten_dv = ten_dv;
	}

	public void setId_pdp(Long id_pdp) {
		this.id_pdp = id_pdp;
	}

	public Long getId_dv() {
		return id_dv;
	}

	public void setId_dv(Long id_dv) {
		this.id_dv = id_dv;
	}

	public String getNgay_sd() {
		return ngay_sd;
	}

	public void setNgay_sd(String ngay_sd) {
		this.ngay_sd = ngay_sd;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	@Override
	public String toString() {
		return "PhieuSuDung [id=" + id + ", id_nv=" + id_nv + ", ten_nv=" + ten_nv + ", id_p=" + id_p + ", id_pdp="
				+ id_pdp + ", id_dv=" + id_dv + ", ten_dv=" + ten_dv + ", ngay_sd=" + ngay_sd + ", so_luong=" + so_luong
				+ "]";
	}

	
}
