package com.java.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.exception.EmployeeNotFoundException;
import com.java.hotelmanagement.model.NhanVien;
import com.java.hotelmanagement.repo.NhanVienRepo;

@Service
public class NhanVienService {
	private final NhanVienRepo nhanVienRepo;
	
	@Autowired
	public NhanVienService(NhanVienRepo nhanVienRepo) {
		this.nhanVienRepo = nhanVienRepo;
	}
	
	public int addNhanVien(NhanVien nhanVien) {
		return nhanVienRepo.insertNhanVien(nhanVien);
	}
	
	public List<NhanVien> findAllNhanViens() {
		return nhanVienRepo.findAllNhanViens();
	}
	
	public NhanVien findNhanVienById(Long id) {
		return nhanVienRepo.findNhanVienById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Nhan vien by id " + id + " was not found"));
	}
	
	public int updateNhanVien(NhanVien nhanVien) {
		return nhanVienRepo.updateNhanVien(nhanVien);
	}
	
	public void deleteNhanVienById(Long id) {
		nhanVienRepo.deleteNhanVienById(id);
	}

	public NhanVien findNhanVienByEmail(String email) {
		return nhanVienRepo.findNhanVienByEmail(email)
				.orElseThrow(() -> new EmployeeNotFoundException("Nhan vien by email " + email + " was not found"));
	}
}
