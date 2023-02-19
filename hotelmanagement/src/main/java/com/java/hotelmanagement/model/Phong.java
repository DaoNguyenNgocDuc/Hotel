package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Phong")
public class Phong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_lp;
	private String ten_lp;
	private int so_phong;
	private int so_nguoi;
	private int don_gia;
	private byte tinh_trang;
	public Phong() {

	}
	public Phong(Long id_lp, String ten_lp, int so_phong, int so_nguoi, int don_gia, byte tinh_trang) {
		this.id_lp = id_lp;
		this.ten_lp = ten_lp;
		this.so_phong = so_phong;
		this.so_nguoi = so_nguoi;
		this.don_gia = don_gia;
		this.tinh_trang = tinh_trang;
	}
	
	public Phong(Long id_lp, int so_phong, int so_nguoi, int don_gia, byte tinh_trang) {
		this.id_lp = id_lp;
		this.so_phong = so_phong;
		this.so_nguoi = so_nguoi;
		this.don_gia = don_gia;
		this.tinh_trang = tinh_trang;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId_lp() {
		return id_lp;
	}
	
	public void setId_lp(Long id_lp) {
		this.id_lp = id_lp;
	}
	
	public String getTen_lp() {
		return ten_lp;
	}
	
	public void setTen_lp(String ten_lp) {
		this.ten_lp = ten_lp;
	}
	
	public int getSo_phong() {
		return so_phong;
	}
	
	public void setSo_phong(int so_phong) {
		this.so_phong = so_phong;
	}
	
	public int getSo_nguoi() {
		return so_nguoi;
	}
	
	public void setSo_nguoi(int so_nguoi) {
		this.so_nguoi = so_nguoi;
	}
	
	public int getDon_gia() {
		return don_gia;
	}
	
	public void setDon_gia(int don_gia) {
		this.don_gia = don_gia;
	}
	
	public byte getTinh_trang() {
		return tinh_trang;
	}
	
	public void setTinh_trang(byte tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
	@Override
	public String toString() {
		return "Phong [id=" + id + ", id_lp=" + id_lp + ", ten_lp=" + ten_lp + ", so_phong=" + so_phong + ", so_nguoi="
				+ so_nguoi + ", don_gia=" + don_gia + ", tinh_trang=" + tinh_trang + "]";
	}
	
	
	
	
	
}
