package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhan_vien")
public class NhanVien implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_cv;
	private String ten_cv;
	private String ten_nv;
	private String ngay_sinh;
	private String gioi_tinh;
	private String mat_khau;
	private String email;
	public NhanVien() {
	}
	
	public NhanVien(Long id_cv, String ten_nv, String ngay_sinh, String gioi_tinh, String mat_khau,
			String email) {
		this.id_cv = id_cv;
		this.ten_nv = ten_nv;
		this.ngay_sinh = ngay_sinh;
		this.gioi_tinh = gioi_tinh;
		this.mat_khau = mat_khau;
		this.email = email;
	}
	
	

	public NhanVien(Long id_cv, String ten_cv, String ten_nv, String ngay_sinh, String gioi_tinh,
			String mat_khau, String email) {
		this.id_cv = id_cv;
		this.ten_cv = ten_cv;
		this.ten_nv = ten_nv;
		this.ngay_sinh = ngay_sinh;
		this.gioi_tinh = gioi_tinh;
		this.mat_khau = mat_khau;
		this.email = email;
	}

	public String getTen_cv() {
		return ten_cv;
	}

	public void setTen_cv(String ten_cv) {
		this.ten_cv = ten_cv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_cv() {
		return id_cv;
	}

	public void setId_cv(Long id_cv) {
		this.id_cv = id_cv;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public String getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(String ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getMat_khau() {
		return mat_khau;
	}

	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", id_cv=" + id_cv + ", ten_cv=" + ten_cv + ", ten_nv=" + ten_nv + ", ngay_sinh="
				+ ngay_sinh + ", gioi_tinh=" + gioi_tinh + ", mat_khau=" + mat_khau
				+ ", email=" + email + "]";
	}
}
