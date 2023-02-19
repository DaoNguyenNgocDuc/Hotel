package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.PhieuNotFoundException;
import com.java.hotelmanagement.model.PhieuSuDung;
import com.java.hotelmanagement.repo.PhieuSuDungRepo;

@Service
public class PhieuSuDungService {
	private final PhieuSuDungRepo phieuSuDungRepo;
	
	@Autowired
	public PhieuSuDungService(PhieuSuDungRepo phieuSuDungRepo) {
		this.phieuSuDungRepo = phieuSuDungRepo;
	}
	
	public int addPhieuSuDung(PhieuSuDung phieuSuDung) {
		return phieuSuDungRepo.insertPhieuSuDung(phieuSuDung);
	}
	
	public List<PhieuSuDung> findAllPhieuSuDungs() {
		return phieuSuDungRepo.findAllPhieuSuDung();
	}
	
	public PhieuSuDung findPhieuSuDungById(Long id) {
		return phieuSuDungRepo.findPhieuSuDungById(id)
				.orElseThrow(() -> new PhieuNotFoundException("Phieu su dung by id " + id + " was not found"));
	}
	
	public int updatePhieuSuDung(PhieuSuDung phieuSuDung) {
		return phieuSuDungRepo.updatePhieuSuDung(phieuSuDung);
	}
	
	public void deletePhieuSuDungById(Long id) {
		phieuSuDungRepo.deletePhieuSuDungById(id);
	}
}
