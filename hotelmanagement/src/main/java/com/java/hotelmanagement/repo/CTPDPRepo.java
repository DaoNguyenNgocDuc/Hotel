package com.java.hotelmanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.hotelmanagement.model.CTPDP;

public interface CTPDPRepo extends JpaRepository<CTPDP, Long> {
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ct_pdp WHERE id_pdp = ?1 AND id_p = ?2", nativeQuery = true)
	void deleteCTPDPById(Long id_pdp, Long id_p);
	
	@Query(value = "SELECT c FROM ct_pdp WHERE id_pdp = ?1 AND id_p = ?2",nativeQuery = true)
	Optional<CTPDP> findCTPDPById(Long id_pdp, Long id_p);
	
	@Query(value = "SELECT c.id_pdp, c.id_p FROM ct_pdp c order by id_pdp",nativeQuery = true)
	List<CTPDP> findAllCTPDPs();
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO ct_pdp(id_pdp,id_p) VALUES (:#{#c.id_pdp},:#{#c.id_p})", nativeQuery = true)
	int insertCTPDP(@Param("c") CTPDP ctpdp);
}
