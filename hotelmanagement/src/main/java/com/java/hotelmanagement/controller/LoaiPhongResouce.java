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

import com.java.hotelmanagement.model.LoaiPhong;
import com.java.hotelmanagement.service.LoaiPhongService;

@RestController
@RequestMapping("/loaiphong")
public class LoaiPhongResouce {
	private final LoaiPhongService loaiPhongService;
	
	public LoaiPhongResouce(LoaiPhongService loaiPhongService) {
		this.loaiPhongService = loaiPhongService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<LoaiPhong>> getAllLoaiPhong() {
		List<LoaiPhong> loaiPhong = loaiPhongService.findAllLoaiPhong();
		return new ResponseEntity<>(loaiPhong, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<LoaiPhong> findLoaiPhongById(@PathVariable("id") Long id) {
		LoaiPhong loaiPhong = loaiPhongService.findLoaiPhongById(id);
		return new ResponseEntity<>(loaiPhong, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<LoaiPhong> addLoaiPhong(@RequestBody LoaiPhong loaiPhong) {
		LoaiPhong newLoaiPhong = loaiPhongService.addPhong(loaiPhong);
		return new ResponseEntity<>(newLoaiPhong, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<LoaiPhong> updateLoaiPhong(@RequestBody LoaiPhong loaiPhong) {
		LoaiPhong updateLoaiPhong = loaiPhongService.updateLoaiPhong(loaiPhong);
		return new ResponseEntity<>(updateLoaiPhong, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteLoaiPhong(@PathVariable("id") Long id) {
		loaiPhongService.deleteLoaiPhongById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
