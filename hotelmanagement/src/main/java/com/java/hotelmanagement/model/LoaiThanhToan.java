package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_thanh_toan")
public class LoaiThanhToan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String ten_ltt;
	
	public LoaiThanhToan() {
	}

	public LoaiThanhToan(String ten_ltt) {
		this.ten_ltt = ten_ltt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen_ltt() {
		return ten_ltt;
	}

	public void setTen_ltt(String ten_ltt) {
		this.ten_ltt = ten_ltt;
	}

	@Override
	public String toString() {
		return "LoaiThanhToan [id=" + id + ", ten_ltt=" + ten_ltt + "]";
	}
	
	
}
