package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.RoomTypeNotFoundException;
import com.java.hotelmanagement.model.LoaiPhong;
import com.java.hotelmanagement.repo.LoaiPhongRepo;

@Service
public class LoaiPhongService {
	private final LoaiPhongRepo loaiPhongRepo;
	
	@Autowired
	public LoaiPhongService(LoaiPhongRepo loaiPhongRepo) {
		this.loaiPhongRepo = loaiPhongRepo;
	}
	
	public LoaiPhong addPhong(LoaiPhong loaiphong) {
		return loaiPhongRepo.save(loaiphong);
	}
	
	public List<LoaiPhong> findAllLoaiPhong() {
		return loaiPhongRepo.findAll();
	}
	
	public LoaiPhong updateLoaiPhong(LoaiPhong loaiphong) {
		return loaiPhongRepo.save(loaiphong);
	}
	
	public LoaiPhong findLoaiPhongById(Long id) {
		return loaiPhongRepo.findLoaiPhongById(id)
							.orElseThrow(() -> new RoomTypeNotFoundException("Loai Phong by id " + id + " was not found"));
	}
	
	public void deleteLoaiPhongById(Long id) {
		loaiPhongRepo.deleteLoaiPhongById(id);
	}
}
