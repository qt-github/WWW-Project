package com.websitedungcuthethao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websitedungcuthethao.entity.DanhMuc;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Long> {
	List<DanhMuc> findAll();
	
	@Query(value ="SELECT * FROM DANHMUC WHERE ten = ?1",nativeQuery = true )
	DanhMuc findOneByTen(String ten);

	List<DanhMuc> findByDanhMucChaNull();
	
	@Query(value = "SELECT * FROM DANHMUC WHERE danhMucCha = ?1", nativeQuery = true)
	List<DanhMuc> findAllDanhMucConById(Long id);
	
	@Query(value = "SELECT * FROM DANHMUC where danhMucCha IS NOT NULL", nativeQuery = true)
	List<DanhMuc> findAllDanhMucCon();
}
