package com.java.hotelmanagement.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.java.hotelmanagement.service.PhongService;
import com.java.hotelmanagement.model.Phong;

@RestController
@RequestMapping("/phong")
public class PhongResouce {
	private final PhongService phongService;
	
	public PhongResouce(PhongService phongService) {
		this.phongService = phongService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Phong>> getAllPhongs() {
		List<Phong> phongs = phongService.findAllPhong();
		return new ResponseEntity<>(phongs, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Phong> getPhongById(@PathVariable("id") Long id) {
		Phong phongs = phongService.findPhongById(id);
		return new ResponseEntity<>(phongs, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPhong(@RequestBody Phong phong) {
		int newPhong = phongService.addPhong(phong);
		return new ResponseEntity<>(newPhong, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePhong(@RequestBody Phong phong) {
		int updatePhong = phongService.updatePhong(phong);
		return new ResponseEntity<>(updatePhong, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePhong(@PathVariable("id") Long id) {
		phongService.deletePhong(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
