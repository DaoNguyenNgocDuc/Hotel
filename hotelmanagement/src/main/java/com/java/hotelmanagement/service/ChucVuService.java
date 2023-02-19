package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.ChucVuNotFoundException;
import com.java.hotelmanagement.model.ChucVu;
import com.java.hotelmanagement.repo.ChucVuRepo;

@Service
public class ChucVuService {
	private final ChucVuRepo chucVuRepo;
	
	@Autowired
	public ChucVuService(ChucVuRepo chucVuRepo) {
		this.chucVuRepo = chucVuRepo;
	}
	
	public ChucVu addChucVu(ChucVu chucVu) {
		return chucVuRepo.save(chucVu);
	}
	
	public List<ChucVu> findAllChucVus() {
		return chucVuRepo.findAll();
	}
	
	public ChucVu findChucVuById(Long id) {
		return chucVuRepo.findChucVuById(id)
				.orElseThrow(() -> new ChucVuNotFoundException("Chuc vu by id " + id + " was not found"));
	}
	
	public ChucVu updateChucVu(ChucVu chucVu) {
		return chucVuRepo.save(chucVu);
	}
	
	public void deleteChucVuById(Long id) {
		chucVuRepo.deleteChucVuById(id);
	}
}
