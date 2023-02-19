package com.java.hotelmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.LoaiThanhToan;

public interface LoaiThanhToanRepo extends JpaRepository<LoaiThanhToan, Long> {
	@Transactional
	@Modifying
	void deleteLoaiThanhToanById(Long id);
	
	Optional<LoaiThanhToan> findLoaiThanhToanById(Long id);
}
