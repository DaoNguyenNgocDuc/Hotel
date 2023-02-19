package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.HoaDon;

public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM hoa_don WHERE id = ?1"
	,nativeQuery = true)
	void deleteHoaDonById(Long id);
	
	@Query(value = "SELECT hd.id, hd.id_nv, nv.ten_nv, hd.id_ltt, ltt.ten_ltt, hd.ngay_lap, hd.tong_tien "
			+ " FROM hoa_don hd, nhan_vien nv, loai_thanh_toan ltt "
			+ "WHERE hd.id = ?1 AND hd.id_nv = nv.id AND hd.id_ltt = ltt.id",
			nativeQuery = true)
	Optional<HoaDon> findHoaDonById(Long id);
	
	@Query(value = "SELECT hd.id, hd.id_nv, nv.ten_nv, hd.id_ltt, ltt.ten_ltt, hd.ngay_lap, hd.tong_tien "
			+ " FROM hoa_don hd, nhan_vien nv, loai_thanh_toan ltt "
			+ "WHERE hd.id_nv = nv.id AND hd.id_ltt = ltt.id",
			nativeQuery = true)
	List<HoaDon> findAllHoaDons();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE hoa_don SET id_nv = :#{#c.id_nv}, id_ltt = :#{#c.id_ltt}, ngay_lap = :#{#c.ngay_lap}, tong_tien = :#{#c.tong_tien} "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updateHoaDon(@Param("c") HoaDon hoaDon);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO hoa_don(id_nv,id_ltt,ngay_lap,tong_tien) VALUES (:#{#c.id_nv},:#{#c.id_ltt},:#{#c.ngay_lap},:#{#c.tong_tien})"
			,nativeQuery = true)
	int insertHoaDon(@Param("c") HoaDon hoaDon);
}
