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
@Table(name = "ct_pdp")
@IdClass(CTPDPId.class)
public class CTPDP implements Serializable {
	@Id
	@Column(nullable = false, updatable = false)
	private Long id_pdp;
	@Id
	@Column(nullable = false, updatable = false)
	private Long id_p;
	
	public CTPDP() {
	}

	public CTPDP(Long id_pdp, Long id_p) {
		this.id_pdp = id_pdp;
		this.id_p = id_p;
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

	@Override
	public String toString() {
		return "CTPDP [id_pdp=" + id_pdp + ", id_p=" + id_p + "]";
	}
	
	
}
