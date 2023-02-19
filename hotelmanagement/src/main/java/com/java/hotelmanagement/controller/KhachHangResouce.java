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

import com.java.hotelmanagement.model.KhachHang;
import com.java.hotelmanagement.service.KhachHangService;

@RestController
@RequestMapping("/khachhang")
public class KhachHangResouce {
	private final KhachHangService khachHangService;
	
	public KhachHangResouce(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<KhachHang>> getAllKhachHangs() {
		List<KhachHang> khachHangs = khachHangService.findAllKhachHang();
		return new ResponseEntity<>(khachHangs, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<KhachHang> findKhachHangById(@PathVariable("id") Long id) {
		KhachHang khachHang = khachHangService.findKhachHangbyId(id);
		return new ResponseEntity<>(khachHang, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<KhachHang> addKhachHang(@RequestBody KhachHang khachHang) {
		KhachHang newKhachHang = khachHangService.addKhachHang(khachHang);
		return new ResponseEntity<>(newKhachHang, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<KhachHang> updateKhachHang(@RequestBody KhachHang khachHang) {
		KhachHang updateKhachHang = khachHangService.updateKhachHang(khachHang);
		return new ResponseEntity<>(updateKhachHang, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteKhachHangById(@PathVariable("id") Long id) {
		khachHangService.deleteKhachHangById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
