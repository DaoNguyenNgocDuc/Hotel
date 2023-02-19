package com.java.hotelmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.KhachHang;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long>{
	@Transactional
	@Modifying
	void deleteKhachHangById(Long id);
	
	Optional<KhachHang> findKhachHangById(Long id);
}
