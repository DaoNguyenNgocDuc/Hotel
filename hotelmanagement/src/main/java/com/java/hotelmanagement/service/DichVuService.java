package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.DichVuNotFoundException;
import com.java.hotelmanagement.model.DichVu;
import com.java.hotelmanagement.repo.DichVuRepo;
import com.java.hotelmanagement.repo.PhongRepo;

@Service
public class DichVuService {
	private final DichVuRepo dichVuRepo;
	
	@Autowired
	public DichVuService(DichVuRepo dichVuRepo) {
		this.dichVuRepo = dichVuRepo;
	}
	
	public DichVu addDichVu(DichVu dichVu) {
		return dichVuRepo.save(dichVu);
	}
	
	public List<DichVu> findAllDichVus() {
		return dichVuRepo.findAll();
	}
	
	public DichVu findDichVuById(Long id) {
		return dichVuRepo.findDichVuById(id)
				.orElseThrow(() -> new DichVuNotFoundException("Dich Vu by id " + id + " was not found"));
	}
	
	public DichVu updateDichVu(DichVu dichVu) {
		return dichVuRepo.save(dichVu);
	}
	
	public void deleteDichVuById(Long id) {
		dichVuRepo.deleteDichVuById(id);
	}
}
