package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phieu_dat_phong")
public class PhieuDatPhong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_kh;
	private String ho_ten;
	private Long id_nv;
	private String ten_nv;
	private String ngay_dat;
	private String ngay_tra_dk;
	private Long tien_coc;
	public PhieuDatPhong() {
	}
	
	public PhieuDatPhong(Long id_kh, Long id_nv, String ngay_dat, String ngay_tra_dk, Long tien_coc) {
		this.id_kh = id_kh;
		this.id_nv = id_nv;
		this.ngay_dat = ngay_dat;
		this.ngay_tra_dk = ngay_tra_dk;
		this.tien_coc = tien_coc;
	}

	public PhieuDatPhong(Long id_kh, String ho_ten, Long id_nv, String ten_nv, String ngay_dat, String ngay_tra_dk,
			Long tien_coc) {
		this.id_kh = id_kh;
		this.ho_ten = ho_ten;
		this.id_nv = id_nv;
		this.ten_nv = ten_nv;
		this.ngay_dat = ngay_dat;
		this.ngay_tra_dk = ngay_tra_dk;
		this.tien_coc = tien_coc;
	}

	public String getTen_kh() {
		return ho_ten;
	}

	public void setTen_kh(String ho_ten) {
		this.ho_ten = ho_ten;
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

	public Long getId_kh() {
		return id_kh;
	}

	public void setId_kh(Long id_kh) {
		this.id_kh = id_kh;
	}

	public Long getId_nv() {
		return id_nv;
	}

	public void setId_nv(Long id_nv) {
		this.id_nv = id_nv;
	}

	public String getNgay_dat() {
		return ngay_dat;
	}

	public void setNgay_dat(String ngay_dat) {
		this.ngay_dat = ngay_dat;
	}

	public String getNgay_tra_dk() {
		return ngay_tra_dk;
	}

	public void setNgay_tra_dk(String ngay_tra_dk) {
		this.ngay_tra_dk = ngay_tra_dk;
	}

	public Long getTien_coc() {
		return tien_coc;
	}

	public void setTien_coc(Long tien_coc) {
		this.tien_coc = tien_coc;
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [id=" + id + ", id_kh=" + id_kh + ", ho_ten=" + ho_ten + ", id_nv=" + id_nv + ", ten_nv="
				+ ten_nv + ", ngay_dat=" + ngay_dat + ", ngay_tra_dk=" + ngay_tra_dk + ", tien_coc=" + tien_coc + "]";
	}
	
}
