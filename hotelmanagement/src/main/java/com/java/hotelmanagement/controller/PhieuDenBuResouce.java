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

import com.java.hotelmanagement.model.PhieuDenBu;
import com.java.hotelmanagement.service.PhieuDenBuService;

@RestController
@RequestMapping("/phieudenbu")
public class PhieuDenBuResouce {
	private final PhieuDenBuService phieuDenBuService;
	
	public PhieuDenBuResouce(PhieuDenBuService phieuDenBuService) {
		this.phieuDenBuService = phieuDenBuService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PhieuDenBu>> getAllPhieuDenBus() {
		List<PhieuDenBu> phieuDenBus = phieuDenBuService.findAllPhieuDenBus();
		return new ResponseEntity<>(phieuDenBus, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PhieuDenBu> findPhieuDenBuById(@PathVariable("id") Long id) {
		PhieuDenBu phieuDenBu = phieuDenBuService.findPhieuDenBuById(id);
		return new ResponseEntity<>(phieuDenBu, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPhieuDenBu(@RequestBody PhieuDenBu phieuDenBu) {
		int newPhieuDenBu = phieuDenBuService.addPhieuDenBu(phieuDenBu);
		return new ResponseEntity<>(newPhieuDenBu, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePhieuDenBu(@RequestBody PhieuDenBu phieuDenBu) {
		int updatePhieuDenBu = phieuDenBuService.updatePhieuDenBu(phieuDenBu);
		return new ResponseEntity<>(updatePhieuDenBu, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePhieuDenBu(@PathVariable("id") Long id) {
		phieuDenBuService.deletePhieuDenBuById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
