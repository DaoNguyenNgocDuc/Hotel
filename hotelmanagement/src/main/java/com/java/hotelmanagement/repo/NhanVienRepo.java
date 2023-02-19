package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.NhanVien;

public interface NhanVienRepo extends JpaRepository<NhanVien, Long> {
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM nhan_vien WHERE id = ?1"
	,nativeQuery = true)
	void deleteNhanVienById(Long id);
	
	@Query(value = "SELECT nv.id, nv.id_cv, cv.ten_cv, nv.ten_nv, nv.ngay_sinh, nv.gioi_tinh, nv.mat_khau, nv.email "
			+ "FROM nhan_vien nv, chuc_vu cv "
			+ "WHERE nv.id = ?1 AND nv.id_cv = cv.id ",
			nativeQuery = true)
	Optional<NhanVien> findNhanVienById(Long id);
	
	@Query(value = "SELECT nv.id, nv.id_cv, cv.ten_cv, nv.ten_nv, nv.ngay_sinh, nv.gioi_tinh, nv.mat_khau, nv.email "
			+ "FROM nhan_vien nv, chuc_vu cv "
			+ "WHERE nv.id_cv = cv.id ",
			nativeQuery = true)
	List<NhanVien> findAllNhanViens();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE nhan_vien SET id_cv = :#{#c.id_cv}, ten_nv = :#{#c.ten_nv}, ngay_sinh = :#{#c.ngay_sinh}, gioi_tinh = :#{#c.gioi_tinh}, mat_khau = :#{#c.mat_khau}, email = :#{#c.email}   "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updateNhanVien(@Param("c") NhanVien nhanVien);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO nhan_vien(id_cv,ten_nv,ngay_sinh,gioi_tinh,mat_khau,email) VALUES (:#{#c.id_cv},:#{#c.ten_nv},:#{#c.ngay_sinh},:#{#c.gioi_tinh},:#{#c.mat_khau},:#{#c.email})"
			,nativeQuery = true)
	int insertNhanVien(@Param("c") NhanVien nhanVien);
	
	@Query(value = "SELECT nv.id, nv.id_cv, cv.ten_cv, nv.ten_nv, nv.ngay_sinh, nv.gioi_tinh, nv.mat_khau, nv.email "
			+ "FROM nhan_vien nv, chuc_vu cv "
			+ "WHERE nv.email = ?1 AND nv.id_cv = cv.id ",
			nativeQuery = true)
	NhanVien findNhanVienByEmail(String email);
}
