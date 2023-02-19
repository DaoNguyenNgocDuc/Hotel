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

import com.java.hotelmanagement.model.PhieuSuDung;
import com.java.hotelmanagement.service.PhieuSuDungService;

@RestController
@RequestMapping("/phieusudung")
public class PhieuSuDungResouce {
	private final PhieuSuDungService phieuSuDungService;
	
	public PhieuSuDungResouce(PhieuSuDungService phieuSuDungService) {
		this.phieuSuDungService = phieuSuDungService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PhieuSuDung>> getAllPhieuSuDung() {
		List<PhieuSuDung> phieuSuDungs = phieuSuDungService.findAllPhieuSuDungs();
		return new ResponseEntity<>(phieuSuDungs, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PhieuSuDung> findPhieuSuDungById(@PathVariable("id") Long id) {
		PhieuSuDung phieuSuDung = phieuSuDungService.findPhieuSuDungById(id);
		return new ResponseEntity<>(phieuSuDung, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPhieuSuDung(@RequestBody PhieuSuDung phieuSuDung) {
		int newPhieuSuDung = phieuSuDungService.addPhieuSuDung(phieuSuDung);
		return new ResponseEntity<>(newPhieuSuDung, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePhieuSuDung(@RequestBody PhieuSuDung phieuSuDung) {
		int updatePhieuSuDung = phieuSuDungService.updatePhieuSuDung(phieuSuDung);
		return new ResponseEntity<>(updatePhieuSuDung, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePhieuSuDungById(@PathVariable("id") Long id) {
		phieuSuDungService.deletePhieuSuDungById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

