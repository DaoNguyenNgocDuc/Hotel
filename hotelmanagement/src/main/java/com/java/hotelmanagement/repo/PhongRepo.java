package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.Phong;

public interface PhongRepo extends JpaRepository<Phong, Long>{
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM phong WHERE id = ?1"
	,nativeQuery = true)
	void deletePhongById(Long id);
	
	@Query(value = "SELECT p.id,p.id_lp,lp.ten_lp,p.so_phong,p.so_nguoi,p.don_gia,p.tinh_trang "
			+ "FROM phong p, loai_phong lp "
			+ "WHERE p.id_lp = lp.id AND p.id = ?1", 
			nativeQuery = true)
	Optional<Phong> findPhongById(Long id);
	
	@Query(value = "SELECT p.id,p.id_lp,lp.ten_lp,p.so_phong,p.so_nguoi,p.don_gia,p.tinh_trang "
			+ "FROM phong p, loai_phong lp "
			+ "WHERE p.id_lp = lp.id", 
			nativeQuery = true)
	List<Phong> findAllPhong();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE phong SET id_lp = :#{#c.id_lp},so_phong = :#{#c.so_phong}, so_nguoi = :#{#c.so_nguoi}, don_gia = :#{#c.don_gia}, tinh_trang = :#{#c.tinh_trang} "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updatePhong(@Param("c") Phong phong);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO phong(id_lp,so_phong,so_nguoi,don_gia,tinh_trang) VALUES (:#{#c.id_lp},:#{#c.so_phong},:#{#c.so_nguoi},:#{#c.don_gia},:#{#c.tinh_trang})"
			,nativeQuery = true)
	int insertPhong(@Param("c") Phong phong);

	
}
