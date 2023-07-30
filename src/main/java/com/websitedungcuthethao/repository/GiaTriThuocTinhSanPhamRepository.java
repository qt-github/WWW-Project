package com.websitedungcuthethao.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.entity.GiaTriThuocTinhSanPham;

public interface GiaTriThuocTinhSanPhamRepository extends JpaRepository<GiaTriThuocTinhSanPham, Long> {
	@Query(value = " SELECT  *  FROM GIATRITHUOCTINHSANPHAM e WHERE e.sanphamID=:iDSanPham AND e.thuoctinhID=:iDThuocTinh", nativeQuery = true)
	GiaTriThuocTinhSanPham findBySanPhamIDAndThuocTinhSanPhamID(@Param("iDSanPham") Long iDSanPham,@Param("iDThuocTinh") Long  iDThuocTinh);

	@Modifying
	@Query(value = "insert into GIATRITHUOCTINHSANPHAM(sanPhamID,thuoctinhID,giaTriThuocTinh) values (:sanPhamID,:thuoctinhID,:giaTriThuocTinh)", nativeQuery = true)
	@Transactional
	void themGTTTSP(@Param("sanPhamID") Long sanPhamID, @Param("thuoctinhID") Long thuoctinhID, @Param("giaTriThuocTinh") String giaTriThuocTinh);
}
