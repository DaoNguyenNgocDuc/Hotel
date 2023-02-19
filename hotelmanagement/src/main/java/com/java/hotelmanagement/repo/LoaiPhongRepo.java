package com.java.hotelmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.LoaiPhong;

public interface LoaiPhongRepo extends JpaRepository<LoaiPhong, Long>{
	@Transactional
	@Modifying
	void deleteLoaiPhongById(Long id);
	
	Optional<LoaiPhong> findLoaiPhongById(Long id);
}
