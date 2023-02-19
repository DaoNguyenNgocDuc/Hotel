package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khach_hang")
public class KhachHang implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String ho_ten;
	private String cccd;
	private String quoc_tich;
	private String sdt;
	private String gioi_tinh;
	private String ngay_sinh;
	private String email;
	
	public KhachHang() {
	}

	public KhachHang(String ho_ten, String cccd, String quoc_tich, String sdt, String gioi_tinh, String ngay_sinh,
			String email) {
		this.ho_ten = ho_ten;
		this.cccd = cccd;
		this.quoc_tich = quoc_tich;
		this.sdt = sdt;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getQuoc_tich() {
		return quoc_tich;
	}

	public void setQuoc_tich(String quoc_tich) {
		this.quoc_tich = quoc_tich;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(String ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", ho_ten=" + ho_ten + ", cccd=" + cccd + ", quoc_tich=" + quoc_tich + ", sdt="
				+ sdt + ", gioi_tinh=" + gioi_tinh + ", ngay_sinh=" + ngay_sinh + ", email=" + email + "]";
	}
	
	
}
