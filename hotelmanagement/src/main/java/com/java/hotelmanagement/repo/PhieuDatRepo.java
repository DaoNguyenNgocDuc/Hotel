package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.PhieuDatPhong;

public interface PhieuDatRepo extends JpaRepository<PhieuDatPhong, Long>{
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM phieu_dat_phong WHERE id = ?1"
	,nativeQuery = true)
	void deletePhieuDatById(Long id);
	
	@Query(value = "SELECT p.id,p.id_kh,kh.ho_ten,p.id_nv,nv.ten_nv,p.ngay_dat,p.ngay_tra_dk,p.tien_coc "
			+ "FROM phieu_dat_phong p, khach_hang kh, nhan_vien nv "
			+ "WHERE p.id =?1 AND p.id_kh = kh.id AND p.id_nv = nv.id", nativeQuery = true)
	Optional<PhieuDatPhong> findPhietDatById(Long id);
	
	@Query(value = "SELECT p.id,p.id_kh,kh.ho_ten,p.id_nv,nv.ten_nv,p.ngay_dat,p.ngay_tra_dk,p.tien_coc FROM phieu_dat_phong p, khach_hang kh, nhan_vien nv WHERE p.id_kh = kh.id AND p.id_nv = nv.id", nativeQuery = true)
	List<PhieuDatPhong> findAllPhieuDat();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE phieu_dat_phong SET id_kh = :#{#c.id_kh}, id_nv = :#{#c.id_nv}, ngay_dat = :#{#c.ngay_dat}, ngay_tra_dk = :#{#c.ngay_tra_dk}, tien_coc = :#{#c.tien_coc}  "
			+ "WHERE id = :#{#c.id}",nativeQuery = true)
	int updatePhieuDat(@Param("c") PhieuDatPhong phieuDatPhong);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO phieu_dat_phong(id_kh,id_nv,ngay_dat,ngay_tra_dk,tien_coc) VALUES (:#{#c.id_kh},:#{#c.id_nv},:#{#c.ngay_dat},:#{#c.ngay_tra_dk},:#{#c.tien_coc})"
			,nativeQuery = true)
	int insertPhieuDat(@Param("c") PhieuDatPhong phieuDatPhong);
}
