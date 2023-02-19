package com.java.hotelmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.DichVu;

public interface DichVuRepo extends JpaRepository<DichVu, Long> {
	@Transactional
	@Modifying
	void deleteDichVuById(Long id);
	
	Optional<DichVu> findDichVuById(Long id);
}
