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

import com.java.hotelmanagement.model.PhieuDatPhong;
import com.java.hotelmanagement.service.PhieuDatService;

@RestController
@RequestMapping("/phieudat")
public class PhieuDatResouce {
	private final PhieuDatService phieuDatService;
	
	public PhieuDatResouce(PhieuDatService phieuDatService) {
		this.phieuDatService = phieuDatService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PhieuDatPhong>> getAllPhieuDat() {
		List<PhieuDatPhong> phieuDats = phieuDatService.getAllPhieuDats();
		return new ResponseEntity<>(phieuDats, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PhieuDatPhong> findPhieuDatById(@PathVariable("id") Long id) {
		PhieuDatPhong phieuDat = phieuDatService.findPhieuDatById(id);
		return new ResponseEntity<>(phieuDat, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPhieuDat(@RequestBody PhieuDatPhong phieuDat) {
		int newPhieuDat = phieuDatService.addPhieuDat(phieuDat);
		return new ResponseEntity<>(newPhieuDat, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePhieuDat(@RequestBody PhieuDatPhong phieuDat) {
		int updatePhieuDat = phieuDatService.updatePhieuDat(phieuDat);
		return new ResponseEntity<>(updatePhieuDat, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePhieuDatById(@PathVariable("id") Long id) {
		phieuDatService.deletePhieuDatById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
