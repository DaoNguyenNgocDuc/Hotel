package com.java.hotelmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ct_hd")
@IdClass(CTHDId.class)
public class CTHD implements Serializable {
	@Id
	private Long id_hd;
	@Id
	private Long id_pdp;
	@Id
	private Long id_p;
	private Long tien_thue;
	private Long tien_dv;
	
	public CTHD() {
	}

	public CTHD(Long id_hd, Long id_pdp, Long id_p, Long tien_thue, Long tien_dv) {
		this.id_hd = id_hd;
		this.id_pdp = id_pdp;
		this.id_p = id_p;
		this.tien_thue = tien_thue;
		this.tien_dv = tien_dv;
	}

	public Long getId_hd() {
		return id_hd;
	}

	public void setId_hd(Long id_hd) {
		this.id_hd = id_hd;
	}

	public Long getId_pdp() {
		return id_pdp;
	}

	public void setId_pdp(Long id_pdp) {
		this.id_pdp = id_pdp;
	}

	public Long getId_p() {
		return id_p;
	}

	public void setId_p(Long id_p) {
		this.id_p = id_p;
	}

	public Long getTien_thue() {
		return tien_thue;
	}

	public void setTien_thue(Long tien_thue) {
		this.tien_thue = tien_thue;
	}

	public Long getTien_dv() {
		return tien_dv;
	}

	public void setTien_dv(Long tien_dv) {
		this.tien_dv = tien_dv;
	}

	@Override
	public String toString() {
		return "CTHD [id_hd=" + id_hd + ", id_pdp=" + id_pdp + ", id_p=" + id_p + ", tien_thue=" + tien_thue
				+ ", tien_dv=" + tien_dv + "]";
	}
	
	
}
