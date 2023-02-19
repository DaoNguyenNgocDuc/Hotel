package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.PhieuKiemTra;

public interface PhieuKTRepo extends JpaRepository<PhieuKiemTra, Long>{
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM phieu_kt WHERE id = ?1"
	,nativeQuery = true)
	void deletePhieuKTById(Long id);
	
	@Query(value = "SELECT p.id, p.id_pdp, p.id_nv, nv.ten_nv, p.ngay_lap, p.tinh_trang "
			+ "FROM phieu_kt p, nhan_vien nv "
			+ "WHERE p.id = ?1 AND p.id_nv = nv.id",
			nativeQuery = true)
	Optional<PhieuKiemTra> findPhieuKTById(Long id);
	
	@Query(value = "SELECT p.id, p.id_pdp, p.id_nv, nv.ten_nv, p.ngay_lap, p.tinh_trang "
			+ "FROM phieu_kt p, nhan_vien nv "
			+ "WHERE p.id_nv = nv.id",
			nativeQuery = true)
	List<PhieuKiemTra> findAllPhieuKTs();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE phieu_kt SET id_pdp = :#{#c.id_pdp}, id_nv = :#{#c.id_nv}, ngay_lap = :#{#c.ngay_lap}, tinh_trang = :#{#c.tinh_trang} "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updatePhieuKT(@Param("c") PhieuKiemTra phieuKiemTra);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO phieu_kt(id_pdp,id_nv,ngay_lap,tinh_trang) VALUES (:#{#c.id_pdp},:#{#c.id_nv},:#{#c.ngay_lap},:#{#c.tinh_trang})"
			,nativeQuery = true)
	int insertPhieuKT(@Param("c") PhieuKiemTra phieuKiemTra);
}
