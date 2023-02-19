package com.java.hotelmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.hotelmanagement.model.CTPDP;
import com.java.hotelmanagement.service.CTPDPService;

@RestController
@RequestMapping("/ctpdp")
public class CTPDPResouce {
	private final CTPDPService ctpdpService;
	
	public CTPDPResouce(CTPDPService ctpdpService) {
		this.ctpdpService = ctpdpService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CTPDP>> getAllCTPDPs() {
		List<CTPDP> ctpdps = ctpdpService.findAllCTPDPs();
		return new ResponseEntity<>(ctpdps, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id_pdp}/{id_p}")
	public ResponseEntity<CTPDP> findCTPDPById(@PathVariable("id_pdp") Long id_pdp,
			@PathVariable("id_p") Long id_p) {
		CTPDP ctpdp = ctpdpService.findCTPDPById(id_pdp,id_p);
		return new ResponseEntity<>(ctpdp, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCTPDP(@RequestBody CTPDP ctpdp) {
		int newCTPDP = ctpdpService.addCTPDP(ctpdp);
		return new ResponseEntity<>(newCTPDP, HttpStatus.CREATED);
	}
	
//	@PutMapping("/update")
//	public ResponseEntity<?> updateCTPDP(@RequestBody CTPDP ctpdp) {
//		int updateCTPDP = ctpdpService.updateCTPDP(ctpdp);
//		return new ResponseEntity<>(updateCTPDP, HttpStatus.OK);
//	}
	
	@DeleteMapping("/delete/{id_pdp}/{id_p}")
	public ResponseEntity<?> deleteCTPDPById(@PathVariable("id_pdp") Long id_pdp,
			@PathVariable("id_p") Long id_p) {
		ctpdpService.deleteCTPDPById(id_pdp,id_p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}	
