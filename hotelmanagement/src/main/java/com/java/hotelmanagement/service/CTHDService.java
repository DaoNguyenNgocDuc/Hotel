package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.CTHDNotFoundException;
import com.java.hotelmanagement.model.CTHD;
import com.java.hotelmanagement.repo.CTHDRepo;

@Service
public class CTHDService {
	private final CTHDRepo cthdRepo;
	
	@Autowired
	public CTHDService(CTHDRepo cthdRepo) {
		this.cthdRepo = cthdRepo;
	}
	
	public CTHD addCTHD(CTHD cthd) {
		return cthdRepo.save(cthd);
	}
	
	public List<CTHD> findAllCTHDs() {
		return cthdRepo.findAll();
	}
	
	public CTHD findCTHDById(Long id_hd, Long id_pdp, Long id_p) {
		return cthdRepo.findCTHDById(id_hd,id_pdp,id_p)
				.orElseThrow(() -> new CTHDNotFoundException("Chi tiet hoa don by id " + id_hd + " was not found"));
	}
	
//	public int updateCTHD(CTHD cthd) {
//		return cthdRepo.updateCTHD(cthd);
//	}
	
	public void deleteCTHDById(Long id_hd, Long id_pdp, Long id_p) {
		cthdRepo.deleteCTHDById(id_hd,id_pdp,id_p);
	}
	
	public void tinhTienThue(CTHD cthd) {
		cthdRepo.tinhTienThue(cthd);
	}
	
	public void tinhTienDV(CTHD cthd) {
		cthdRepo.tinhTienDV(cthd);
	}
	
	public void tinhTienHD(CTHD cthd) {
		cthdRepo.tinhTienHD(cthd);
	}
}
