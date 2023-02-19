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

import com.java.hotelmanagement.model.LoaiThanhToan;
import com.java.hotelmanagement.service.LoaiThanhToanService;

@RestController
@RequestMapping("/loaithanhtoan")
public class LoaiThanhToanResouce {
	private final LoaiThanhToanService loaiThanhToanService;
	
	public LoaiThanhToanResouce(LoaiThanhToanService loaiThanhToanService) {
		this.loaiThanhToanService = loaiThanhToanService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<LoaiThanhToan>> getAllLoaiThanhToans() {
		List<LoaiThanhToan> loaiThanhToans = loaiThanhToanService.findAllLoaiThanhToans();
		return new ResponseEntity<>(loaiThanhToans, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<LoaiThanhToan> findLoaiThanhToanById(@PathVariable("id") Long id) {
		LoaiThanhToan loaiThanhToan = loaiThanhToanService.findLoaiThanhToanById(id);
		return new ResponseEntity<>(loaiThanhToan, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<LoaiThanhToan> addLoaiThanhToan(@RequestBody LoaiThanhToan loaiThanhToan) {
		LoaiThanhToan newLtt = loaiThanhToanService.addLoaiThanhToan(loaiThanhToan);
		return new ResponseEntity<>(newLtt, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<LoaiThanhToan> updateLoaiThanhToan(@RequestBody LoaiThanhToan loaiThanhToan) {
		LoaiThanhToan updateLoaiThanhToan = loaiThanhToanService.updateLoaiThanhToan(loaiThanhToan);
		return new ResponseEntity<>(updateLoaiThanhToan, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteLoaiThanhToanById(@PathVariable("id") Long id) {
		loaiThanhToanService.deleteLoaiThanhToanById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
