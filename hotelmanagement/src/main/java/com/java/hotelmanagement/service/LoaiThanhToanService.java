package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.LoaiThanhToanNotFoundException;
import com.java.hotelmanagement.model.LoaiThanhToan;
import com.java.hotelmanagement.repo.LoaiThanhToanRepo;

@Service
public class LoaiThanhToanService {
	private final LoaiThanhToanRepo loaiThanhToanRepo;
	
	@Autowired
	public LoaiThanhToanService(LoaiThanhToanRepo loaiThanhToanRepo) {
		this.loaiThanhToanRepo = loaiThanhToanRepo;
	}
	
	public LoaiThanhToan addLoaiThanhToan(LoaiThanhToan loaiThanhToan) {
		return loaiThanhToanRepo.save(loaiThanhToan);
	}
	
	public List<LoaiThanhToan> findAllLoaiThanhToans() {
		return loaiThanhToanRepo.findAll();
	}
	
	public LoaiThanhToan findLoaiThanhToanById(Long id) {
		return loaiThanhToanRepo.findLoaiThanhToanById(id)
				.orElseThrow(() -> new LoaiThanhToanNotFoundException("Loai thanh toan by id " + id + " was not found"));
	}
	
	public LoaiThanhToan updateLoaiThanhToan(LoaiThanhToan loaiThanhToan) {
		return loaiThanhToanRepo.save(loaiThanhToan);
	}
	
	public void deleteLoaiThanhToanById(Long id) {
		loaiThanhToanRepo.deleteLoaiThanhToanById(id);
	}
}
