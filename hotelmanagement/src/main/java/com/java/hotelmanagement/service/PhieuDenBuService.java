package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.PhieuNotFoundException;
import com.java.hotelmanagement.model.PhieuDenBu;
import com.java.hotelmanagement.repo.PhieuDenBuRepo;

@Service
public class PhieuDenBuService {
	private final PhieuDenBuRepo phieuDenBuRepo;
	
	@Autowired
	public PhieuDenBuService(PhieuDenBuRepo phieuDenBuRepo) {
		this.phieuDenBuRepo = phieuDenBuRepo;
	}
	
	public int addPhieuDenBu(PhieuDenBu phieuDenBu) {
		return phieuDenBuRepo.insertPhieuDenBu(phieuDenBu);
	}
	
	public List<PhieuDenBu> findAllPhieuDenBus() {
		return phieuDenBuRepo.findAllPhieuDenBus();
	}
	
	public PhieuDenBu findPhieuDenBuById(Long id) {
		return phieuDenBuRepo.findPhieuDenById(id)
				.orElseThrow(() -> new PhieuNotFoundException("Phieu den bu by id " + id + " was not found"));
	}
	
	public int updatePhieuDenBu(PhieuDenBu phieuDenBu) {
		return phieuDenBuRepo.updatePhieuDenBu(phieuDenBu);
	}
	
	public void deletePhieuDenBuById(Long id) {
		phieuDenBuRepo.deletePhieuDenBuById(id);
	}
}
