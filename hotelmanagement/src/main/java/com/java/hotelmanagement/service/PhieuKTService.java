package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.PhieuNotFoundException;
import com.java.hotelmanagement.model.PhieuKiemTra;
import com.java.hotelmanagement.repo.PhieuKTRepo;

@Service
public class PhieuKTService {
	private final PhieuKTRepo phieuKTRepo;
	
	@Autowired
	public PhieuKTService(PhieuKTRepo phieuKTRepo) {
		this.phieuKTRepo = phieuKTRepo;
	}
	
	public int addPhieuKT(PhieuKiemTra phieuKiemTra) {
		return phieuKTRepo.insertPhieuKT(phieuKiemTra);
	}
	
	public List<PhieuKiemTra> findAllPhieuKTs() {
		return phieuKTRepo.findAllPhieuKTs();
	}
	
	public PhieuKiemTra findPhieuKTById(Long id) {
		return phieuKTRepo.findPhieuKTById(id)
				.orElseThrow(() -> new PhieuNotFoundException("Phieu dat phong by id " + id + " was not found"));
	}
	
	public int updatePhieuKT(PhieuKiemTra phieuKiemTra) {
		return phieuKTRepo.updatePhieuKT(phieuKiemTra);
	}
	
	public void deletePhieuKTById(Long id) {
		phieuKTRepo.deletePhieuKTById(id);
	}
}
