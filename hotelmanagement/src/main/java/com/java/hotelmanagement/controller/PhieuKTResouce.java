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

import com.java.hotelmanagement.model.PhieuKiemTra;
import com.java.hotelmanagement.service.PhieuKTService;

@RestController
@RequestMapping("/phieukt")
public class PhieuKTResouce {
	private final PhieuKTService phieuKTService;
	
	public PhieuKTResouce(PhieuKTService phieuKTService) {
		this.phieuKTService = phieuKTService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PhieuKiemTra>> getAllPhieuKTs() {
		List<PhieuKiemTra> phieuKiemTras = phieuKTService.findAllPhieuKTs();
		return new ResponseEntity<>(phieuKiemTras, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PhieuKiemTra> findPhieuKTById(@PathVariable("id") Long id) {
		PhieuKiemTra phieuKiemTra = phieuKTService.findPhieuKTById(id);
		return new ResponseEntity<>(phieuKiemTra, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPhieuKT(@RequestBody PhieuKiemTra phieuKiemTra) {
		int newPhieuKiemTra = phieuKTService.addPhieuKT(phieuKiemTra);
		return new ResponseEntity<>(newPhieuKiemTra, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePhieuKT(@RequestBody PhieuKiemTra phieuKiemTra) {
		int updatePhieuKiemTra = phieuKTService.updatePhieuKT(phieuKiemTra);
		return new ResponseEntity<>(updatePhieuKiemTra, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePhieuKTById(@PathVariable("id") Long id) {
		phieuKTService.deletePhieuKTById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
