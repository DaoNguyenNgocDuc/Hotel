package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.CTPDPNotFoundException;
import com.java.hotelmanagement.model.CTPDP;
import com.java.hotelmanagement.repo.CTPDPRepo;

@Service
public class CTPDPService {
	private final CTPDPRepo ctpdpRepo;
	
	@Autowired
	public CTPDPService(CTPDPRepo ctpdpRepo) {
		this.ctpdpRepo = ctpdpRepo;
	}
	
	public int addCTPDP(CTPDP ctpdp) {
		return ctpdpRepo.insertCTPDP(ctpdp);
	}
	
	public List<CTPDP> findAllCTPDPs() {
		System.out.println(ctpdpRepo.findAllCTPDPs().get(0));
		System.out.println(ctpdpRepo.findAllCTPDPs().get(1));
		return ctpdpRepo.findAllCTPDPs();
	}
	
	public CTPDP findCTPDPById(Long id_pdp, Long id_p) {
		return ctpdpRepo.findCTPDPById(id_pdp,id_p)
				.orElseThrow(() -> new CTPDPNotFoundException("Chi tiet phieu dat phong by id " + id_pdp + " was not found"));
	}
	
//	public int updateCTPDP(CTPDP ctpdp) {
//		return ctpdpRepo.updateCTPDP(ctpdp);
//	}
	
	public void deleteCTPDPById(Long id_pdp, Long id_p) {
		ctpdpRepo.deleteCTPDPById(id_pdp,id_p);
	}
}
