package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.PhieuDenBu;

public interface PhieuDenBuRepo extends JpaRepository<PhieuDenBu, Long> {
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM phieu_den_bu WHERE id = ?1"
	,nativeQuery = true)
	void deletePhieuDenBuById(Long id);
	
	@Query(value = "SELECT p.id, p.id_pkt, p.id_nv, nv.ten_nv, p.id_pdp, p.ngay_lap, p.tien_phat "
			+ "FROM phieu_den_bu p, nhan_vien nv "
			+ "WHERE p.id = ?1 AND p.id_nv = nv.id ", 
			nativeQuery = true)
	Optional<PhieuDenBu> findPhieuDenById(Long id);
	
	@Query(value = "SELECT p.id, p.id_pkt, p.id_nv, nv.ten_nv, p.id_pdp, p.ngay_lap, p.tien_phat "
			+ "FROM phieu_den_bu p, nhan_vien nv "
			+ "WHERE p.id_nv = nv.id ", 
			nativeQuery = true)
	List<PhieuDenBu> findAllPhieuDenBus();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE phieu_den_bu SET id_pkt = :#{#c.id_pkt}, id_nv = :#{#c.id_nv}, id_pdp = :#{#c.id_pdp}, ngay_lap = :#{#c.ngay_lap}, tien_phat = :#{#c.tien_phat} "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updatePhieuDenBu(@Param("c") PhieuDenBu phieuDenBu);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO phieu_den_bu(id_pkt,id_nv,id_pdp,ngay_lap,tien_phat) VALUES (:#{#c.id_pkt},:#{#c.id_nv},:#{#c.id_pdp},:#{#c.ngay_lap},:#{#c.tien_phat})"
			,nativeQuery = true)
	int insertPhieuDenBu(@Param("c") PhieuDenBu phieuDenBu);
}
