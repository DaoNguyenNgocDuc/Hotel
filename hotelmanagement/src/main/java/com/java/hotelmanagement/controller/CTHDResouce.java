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

import com.java.hotelmanagement.model.CTHD;
import com.java.hotelmanagement.service.CTHDService;

@RestController
@RequestMapping("/cthd")
public class CTHDResouce {
	private final CTHDService cthdService;
	
	public CTHDResouce(CTHDService cthdService) {
		this.cthdService = cthdService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CTHD>> getAllCTHDs() {
		List<CTHD> cthds = cthdService.findAllCTHDs();
		return new ResponseEntity<>(cthds, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id_hd}/{id_pdp}/{id_p}")
	public ResponseEntity<CTHD> findCTHDById(@PathVariable("id_hd") Long id_hd,
			@PathVariable("id_pdp") Long id_pdp,
			@PathVariable("id_p") Long id_p) {
		CTHD cthd = cthdService.findCTHDById(id_hd,id_pdp,id_p);
		return new ResponseEntity<>(cthd, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CTHD> addCTHD(@RequestBody CTHD cthd) {
		CTHD newCTHD = cthdService.addCTHD(cthd);
		cthdService.tinhTienThue(newCTHD);
		cthdService.tinhTienDV(newCTHD);
		cthdService.tinhTienHD(newCTHD);
		return new ResponseEntity<>(newCTHD, HttpStatus.CREATED);
	}
	
//	@PutMapping("/update")
//	public ResponseEntity<?> updateCTHD(@RequestBody CTHD cthd) {
//		int updateCTHD = cthdService.updateCTHD(cthd);
//		return new ResponseEntity<>(updateCTHD, HttpStatus.OK);
//	}
	
	@DeleteMapping("/delete/{id_hd}/{id_pdp}/{id_p}")
	public ResponseEntity<?> deleteCTHDById(@PathVariable("id_hd") Long id_hd,
			@PathVariable("id_pdp") Long id_pdp,
			@PathVariable("id_p") Long id_p) {
		cthdService.deleteCTHDById(id_hd,id_pdp,id_p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
