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

import com.java.hotelmanagement.model.HoaDon;
import com.java.hotelmanagement.service.HoaDonService;

@RestController
@RequestMapping("/hoadon")
public class HoaDonResouce {
	private final HoaDonService hoaDonService;
	
	public HoaDonResouce(HoaDonService hoaDonService) {
		this.hoaDonService = hoaDonService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<HoaDon>> getAllHoaDons() {
		List<HoaDon> hoaDons = hoaDonService.findAllHoaDons();
		return new ResponseEntity<>(hoaDons, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<HoaDon> findHoaDonById(@PathVariable("id") Long id) {
		HoaDon hoaDon = hoaDonService.findHoaDonById(id);
		return new ResponseEntity<>(hoaDon, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addHoaDon(@RequestBody HoaDon hoaDon) {
		int newHoaDon = hoaDonService.addHoaDon(hoaDon);
		return new ResponseEntity<>(newHoaDon, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateHoaDon(@RequestBody HoaDon hoaDon) {
		int updateHoaDon = hoaDonService.updateHoaDon(hoaDon);
		return new ResponseEntity<>(updateHoaDon, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHoaDonById(@PathVariable("id") Long id) {
		hoaDonService.deleteHoaDonById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
