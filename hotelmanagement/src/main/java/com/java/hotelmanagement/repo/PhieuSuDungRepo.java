package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.PhieuSuDung;

public interface PhieuSuDungRepo extends JpaRepository<PhieuSuDung, Long> {
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM phieu_su_dung WHERE id = ?1"
	,nativeQuery = true)
	void deletePhieuSuDungById(Long id);
	
	@Query(value = "SELECT p.id, p.id_dv, dv.ten_dv, p.id_nv, nv.ten_nv, p.id_pdp, p.id_p, p.ngay_sd, p.so_luong "
			+ "FROM phieu_su_dung p, dich_vu dv, nhan_vien nv "
			+ "WHERE p.id = ?1 AND p.id_dv = dv.id AND p.id_nv = nv.id", 
			nativeQuery = true)
	Optional<PhieuSuDung> findPhieuSuDungById(Long id);
	
	@Query(value = "SELECT p.id, p.id_dv, dv.ten_dv, p.id_nv, nv.ten_nv, p.id_pdp, p.id_p, p.ngay_sd, p.so_luong "
			+ "FROM phieu_su_dung p, dich_vu dv, nhan_vien nv "
			+ "WHERE p.id_dv = dv.id AND p.id_nv = nv.id", 
			nativeQuery = true)
	List<PhieuSuDung> findAllPhieuSuDung();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE phieu_su_dung SET id_dv = :#{#c.id_dv}, id_p = :#{#c.id_p}, id_pdp = :#{#c.id_pdp}, id_nv = :#{#c.id_nv}, ngay_sd = :#{#c.ngay_sd}, so_luong = :#{#c.so_luong} "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updatePhieuSuDung(@Param("c") PhieuSuDung phieuSuDung);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO phieu_su_dung(id_dv,id_p,id_pdp,id_nv,ngay_sd,so_luong) VALUES (:#{#c.id_dv},:#{#c.id_p},:#{#c.id_pdp},:#{#c.id_nv},:#{#c.ngay_sd},:#{#c.so_luong})"
			,nativeQuery = true)
	int insertPhieuSuDung(@Param("c") PhieuSuDung phieuSuDung);

}
