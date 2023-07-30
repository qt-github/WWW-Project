package com.websitedungcuthethao.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.entity.ChiTietHoaDon;

public interface ChiTietHoaDonRepository extends CrudRepository<ChiTietHoaDon, Long>{
	
	@Modifying
	@Query(value = "insert into chitiethoadon(hoadonID,sanphamID,soLuong) values (:hoadonID,:sanphamID,:soLuong)", nativeQuery = true)
	@Transactional
	void themCTHD(@Param("hoadonID") Long hoadonID, @Param("sanphamID") Long sanphamID,@Param("soLuong") int soLuong);

	
	@Query(value = "SELECT * FROM CHITIETHOADON WHERE HOADONID = ?1", nativeQuery = true)
	List<ChiTietHoaDon> findByHoaDon(Long hoadonID);
}
