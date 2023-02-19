package com.java.hotelmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.ChucVu;

public interface ChucVuRepo extends JpaRepository<ChucVu, Long> {
	@Transactional
	@Modifying
	void deleteChucVuById(Long id);
	
	Optional<ChucVu> findChucVuById(Long id);
}
