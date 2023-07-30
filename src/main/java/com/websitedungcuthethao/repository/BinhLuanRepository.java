package com.websitedungcuthethao.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.entity.BinhLuan;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, Long>{
	
	@Query(value = "Select *from BinhLuan where sanPhamID=?1",nativeQuery = true)
	List<BinhLuan> findBySanPham(Long id);
	
	
	@Modifying
	@Query(value = "insert into BinhLuan(anhSanPham,binhLuan,ngayBinhLuan,nguoidungID,sanphamID) values (:anhSanPham,:binhLuan,:ngayBinhLuan,:nguoidungID,:sanphamID)", nativeQuery = true)
	@Transactional
	void themBinhLuan(@Param("anhSanPham") String anhSanPham, @Param("binhLuan") String binhLuan,@Param("ngayBinhLuan") LocalDate ngayBinhLuan,@Param("nguoidungID") Long nguoidungID,@Param("sanphamID") Long sanphamID);
}
