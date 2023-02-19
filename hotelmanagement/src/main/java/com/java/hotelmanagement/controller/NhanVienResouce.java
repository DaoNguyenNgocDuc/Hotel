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

import com.java.hotelmanagement.model.NhanVien;
import com.java.hotelmanagement.service.NhanVienService;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienResouce {
	private final NhanVienService nhanVienService;
	
	public NhanVienResouce(NhanVienService nhanVienService) {
		this.nhanVienService = nhanVienService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<NhanVien>> getAllNhanViens() {
		List<NhanVien> nhanViens = nhanVienService.findAllNhanViens();
		return new ResponseEntity<>(nhanViens, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<NhanVien> findNhanVienById(@PathVariable("id") Long id) {
		NhanVien nhanVien = nhanVienService.findNhanVienById(id);
		return new ResponseEntity<>(nhanVien, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addNhanVien(@RequestBody NhanVien nhanVien) {
		int newNhanVien = nhanVienService.addNhanVien(nhanVien);
		return new ResponseEntity<>(newNhanVien, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateNhanVien(@RequestBody NhanVien nhanVien) {
		int updateNhanVien = nhanVienService.updateNhanVien(nhanVien);
		return new ResponseEntity<>(updateNhanVien, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteNhanVienById(@PathVariable("id") Long id) {
		nhanVienService.deleteNhanVienById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody NhanVien nhanVien) {
		System.out.println(nhanVien.toString());
		NhanVien checkNhanVien = nhanVienService.findNhanVienByEmail(nhanVien.getEmail());
		if(checkNhanVien == null) {
			System.out.println(1);
			return new ResponseEntity<>("User not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else if (checkNhanVien.getMat_khau().equals(nhanVien.getMat_khau())) {	
			System.out.println(2);
			return ResponseEntity.ok(checkNhanVien);
		}
		System.out.println(3);
		return new ResponseEntity<>("User not found", HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
}
