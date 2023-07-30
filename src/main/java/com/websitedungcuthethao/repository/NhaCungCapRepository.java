package com.websitedungcuthethao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websitedungcuthethao.entity.NhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long> {
	@Query(value = "SELECT * FROM NHACUNGCAP WHERE tenNhaCungCap = ?1", nativeQuery = true)
	NhaCungCap findOneByTenNhaCungCap(String ten);
}
