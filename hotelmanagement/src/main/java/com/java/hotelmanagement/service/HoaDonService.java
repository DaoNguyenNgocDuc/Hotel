package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.BillNotFoundException;
import com.java.hotelmanagement.model.HoaDon;
import com.java.hotelmanagement.repo.HoaDonRepo;

@Service
public class HoaDonService {
	private final HoaDonRepo hoaDonRepo;
	
	@Autowired
	public HoaDonService(HoaDonRepo hoaDonRepo) {
		this.hoaDonRepo = hoaDonRepo;
	}
	
	public int addHoaDon(HoaDon hoaDon) {
		return hoaDonRepo.insertHoaDon(hoaDon);
	}
	
	public List<HoaDon> findAllHoaDons() {
		return hoaDonRepo.findAllHoaDons();
	}
	
	public HoaDon findHoaDonById(Long id) {
		return hoaDonRepo.findHoaDonById(id)
				.orElseThrow(() -> new BillNotFoundException("Hoa Don by id " + id + " was not found"));
	}
	
	public int updateHoaDon(HoaDon hoaDon) {
		return hoaDonRepo.updateHoaDon(hoaDon);
	}
	
	public void deleteHoaDonById(Long id) {
		hoaDonRepo.deleteHoaDonById(id);
	}
}
