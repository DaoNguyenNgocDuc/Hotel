package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.CTHD;

public interface CTHDRepo extends JpaRepository<CTHD, Long> {
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ct_hd WHERE id_hd = ?1 AND id_pdp = ?2 AND id_p = ?3", nativeQuery = true)
	void deleteCTHDById(Long id_hd, Long id_pdp, Long id_p);
	
	@Query(value = "SELECT c FROM ct_hd WHERE id_hd = ?1 AND id_pdp = ?2 AND id_p = ?3",nativeQuery = true)
	Optional<CTHD> findCTHDById(Long id_hd, Long id_pdp, Long id_p);
	
//	@Query("SELECT c FROM CTHD")
//	List<CTHD> findALLCTHD();
//	@Transactional
//	@Modifying
//	@Query(value ="UPDATE ct_hd SET tien_thue = :#{#c.tien_thue}, tien_dv = :#{#c.tien_dv} "
//			+ " WHERE id_hd = :#{#c.id_hd} AND id_pdp = :#{#c.id_pdp} AND id_p = :#{#c.id_p} ",nativeQuery = true)
//	int updateCTHD(@Param("c") CTHD cthd);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE ct_hd SET tien_thue = (SELECT COALESCE(SUM(P.don_gia * DATEDIFF(HD.ngay_lap,PD.ngay_dat)),0) "
			+ " FROM hoa_don HD, (SELECT * FROM ct_hd) AS CT, phong P, phieu_dat_phong PD "
			+ " WHERE CT.id_hd = :#{#c.id_hd}  AND CT.id_pdp = :#{#c.id_pdp} AND CT.id_p = :#{#c.id_p} "
			+ " AND HD.id=CT.id_hd AND CT.id_p=P.id AND CT.id_pdp = PD.id ) "
			+ "WHERE id_hd = :#{#c.id_hd}  AND id_pdp = :#{#c.id_pdp} AND id_p = :#{#c.id_p}"
			,nativeQuery = true)
	void tinhTienThue(@Param("c") CTHD cthd);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE ct_hd SET tien_dv = (SELECT COALESCE(SUM(DV.don_gia * PSD.so_luong),0) "
			+ " FROM phieu_su_dung PSD, (SELECT * FROM ct_hd) AS CT, dich_vu DV "
			+ " WHERE CT.id_hd = :#{#c.id_hd}  AND CT.id_pdp = :#{#c.id_pdp} AND CT.id_p = :#{#c.id_p} "
			+ " AND CT.id_p=PSD.id_p AND CT.id_pdp = PSD.id_pdp AND PSD.id_dv=DV.id) "
			+ " WHERE id_hd = :#{#c.id_hd}  AND id_pdp = :#{#c.id_pdp} AND id_p = :#{#c.id_p}"
			,nativeQuery = true)
	void tinhTienDV(@Param("c") CTHD cthd);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE hoa_don SET tong_tien = (SELECT COALESCE(SUM(ct.tien_thue + ct.tien_dv),0) "
			+ " FROM ct_hd ct "
			+ " WHERE ct.id_hd = :#{#c.id_hd}) "
			+ "WHERE id = :#{#c.id_hd} "
			,nativeQuery = true)
	void tinhTienHD(@Param("c") CTHD cthd);
	
}
