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

import com.java.hotelmanagement.model.DichVu;
import com.java.hotelmanagement.service.DichVuService;

@RestController
@RequestMapping("/dichvu")
public class DichVuResouce {
	private final DichVuService dichVuService;
	
	public DichVuResouce(DichVuService dichVuService) {
		this.dichVuService = dichVuService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DichVu>> getAllDichVus() {
		List<DichVu> dichVus = dichVuService.findAllDichVus();
		return new ResponseEntity<>(dichVus, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<DichVu> findDichVuById(@PathVariable("id") Long id) {
		DichVu dichVu = dichVuService.findDichVuById(id);
		return new ResponseEntity<>(dichVu, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<DichVu> addDichVu(@RequestBody DichVu dichVu) {
		DichVu newDichVu = dichVuService.addDichVu(dichVu);
		return new ResponseEntity<>(newDichVu, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<DichVu> updateDichVu(@RequestBody DichVu dichVu) {
		DichVu updateDichVu = dichVuService.updateDichVu(dichVu);
		return new ResponseEntity<>(updateDichVu, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDichVuById(@PathVariable("id") Long id) {
		dichVuService.deleteDichVuById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
