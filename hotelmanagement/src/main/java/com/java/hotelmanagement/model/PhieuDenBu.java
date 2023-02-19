package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phieu_den_bu")
public class PhieuDenBu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Long id_nv;
	private String ten_nv;
	private Long id_pkt;
	private Long id_pdp;
	private String ngay_lap;
	private Long tien_phat;
	
	public PhieuDenBu() {
	}

	public PhieuDenBu(Long id_nv, Long id_pkt, Long id_pdp, String ngay_lap, Long tien_phat) {
		this.id_nv = id_nv;
		this.id_pkt = id_pkt;
		this.id_pdp = id_pdp;
		this.ngay_lap = ngay_lap;
		this.tien_phat = tien_phat;
	}

	public PhieuDenBu(Long id_nv, String ten_nv, Long id_pkt, Long id_pdp, String ngay_lap, Long tien_phat) {
		this.id_nv = id_nv;
		this.ten_nv = ten_nv;
		this.id_pkt = id_pkt;
		this.id_pdp = id_pdp;
		this.ngay_lap = ngay_lap;
		this.tien_phat = tien_phat;
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

	public Long getId_pkt() {
		return id_pkt;
	}

	public void setId_pkt(Long id_pkt) {
		this.id_pkt = id_pkt;
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

	public Long getTien_phat() {
		return tien_phat;
	}

	public void setTien_phat(Long tien_phat) {
		this.tien_phat = tien_phat;
	}

	@Override
	public String toString() {
		return "PhieuDenBu [id=" + id + ", id_nv=" + id_nv + ", ten_nv=" + ten_nv + ", id_pkt=" + id_pkt + ", id_pdp="
				+ id_pdp + ", ngay_lap=" + ngay_lap + ", tien_phat=" + tien_phat + "]";
	}
	
}
