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

import com.java.hotelmanagement.model.ChucVu;
import com.java.hotelmanagement.service.ChucVuService;

@RestController
@RequestMapping("/chucvu")
public class ChucVuResouce {
	private final ChucVuService chucVuService;
	
	public ChucVuResouce(ChucVuService chucVuService) {
		this.chucVuService = chucVuService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ChucVu>> getAllChucVus() {
		List<ChucVu> chucVus = chucVuService.findAllChucVus();
		return new ResponseEntity<>(chucVus, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ChucVu> findChucVuByID(@PathVariable("id") Long id) {
		ChucVu chucVu = chucVuService.findChucVuById(id);
		return new ResponseEntity<>(chucVu, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ChucVu> addChucVu(@RequestBody ChucVu chucVu) {
		ChucVu newChucVu = chucVuService.addChucVu(chucVu);
		return new ResponseEntity<>(newChucVu, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ChucVu> updateChucVu(@RequestBody ChucVu chucVu) {
		ChucVu updateChucVu = chucVuService.updateChucVu(chucVu);
		return new ResponseEntity<>(updateChucVu, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteChucVu(@PathVariable("id") Long id) {
		chucVuService.deleteChucVuById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
