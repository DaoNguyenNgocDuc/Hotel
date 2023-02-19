package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.RoomNotFoundException;
import com.java.hotelmanagement.model.Phong;
import com.java.hotelmanagement.repo.PhongRepo;

@Service
public class PhongService {
	private final PhongRepo phongRepo;
	
	@Autowired
	public PhongService(PhongRepo phongRepo) {
		this.phongRepo = phongRepo;
	}
	
	public int addPhong(Phong phong) {
		return phongRepo.insertPhong(phong);
	}
	
	public List<Phong> findAllPhong() {
		System.out.println(phongRepo.findAllPhong().get(0).toString());
		return phongRepo.findAllPhong();
	}
	
	public int updatePhong(Phong phong) {
		System.out.println(phong.toString());
		return phongRepo.updatePhong(phong);
	}
	
	public Phong findPhongById(Long id) {
		return phongRepo.findPhongById(id)
				.orElseThrow(() -> new RoomNotFoundException("Phong by id " + id + " was not found"));
	}
	
	public void deletePhong(Long id) {
		phongRepo.deletePhongById(id);
	}
}
