package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.PhieuNotFoundException;
import com.java.hotelmanagement.model.PhieuDatPhong;
import com.java.hotelmanagement.repo.PhieuDatRepo;


@Service
public class PhieuDatService {
	private final PhieuDatRepo phieuDatRepo;
	
	@Autowired
	public PhieuDatService(PhieuDatRepo phieuDatRepo) {
		this.phieuDatRepo = phieuDatRepo;
	}
	
	public int addPhieuDat(PhieuDatPhong phieuDat) {
		return phieuDatRepo.insertPhieuDat(phieuDat);
	}
	
	public List<PhieuDatPhong> getAllPhieuDats() {
		return phieuDatRepo.findAllPhieuDat();
	}
	
	public PhieuDatPhong findPhieuDatById(Long id) {
		return phieuDatRepo.findPhietDatById(id)
				.orElseThrow(() -> new PhieuNotFoundException("Phieu dat phong by id " + id + " was not found"));
	}
	
	public int updatePhieuDat(PhieuDatPhong phieuDat) {
		return phieuDatRepo.updatePhieuDat(phieuDat);
	}
	
	public void deletePhieuDatById(Long id) {
		phieuDatRepo.deletePhieuDatById(id);
	}
}
