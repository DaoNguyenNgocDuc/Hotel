package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.model.KhachHang;
import com.java.hotelmanagement.repo.KhachHangRepo;
import com.java.hotelmanagement.exception.CustomerNotFoundException;

@Service
public class KhachHangService {
	private final KhachHangRepo khachHangRepo;
	
	@Autowired
	public KhachHangService(KhachHangRepo khachHangRepo) {
		this.khachHangRepo = khachHangRepo;
	}
	
	public KhachHang addKhachHang(KhachHang khachHang) {
		return khachHangRepo.save(khachHang);
	}
	
	public List<KhachHang> findAllKhachHang() {
		return khachHangRepo.findAll();
	}
	
	public KhachHang updateKhachHang(KhachHang khachHang) {
		return khachHangRepo.save(khachHang);
	}
	
	public KhachHang findKhachHangbyId(Long id) {
		return khachHangRepo.findKhachHangById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer by id " + id + " was not found"));
	}
	
	public void deleteKhachHangById(Long id) {
		khachHangRepo.deleteKhachHangById(id);
	}
} 
