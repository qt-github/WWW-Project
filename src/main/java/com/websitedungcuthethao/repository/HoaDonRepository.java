package com.websitedungcuthethao.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
	List<HoaDon> findByTrangThai(boolean tt, Pageable pageable);
	
	@Query(value = "update HoaDon set trangThai=:trangThai where id=:id",nativeQuery = true)
	void setTrangThaiHoaDon(@Param("id") Long id, @Param("trangThai") boolean trangThai);
	
	
	@Query(value = "select * from HoaDon Where nguoidungID=?1 AND nguoiDungXacNhan='false' AND trangThai='true'",nativeQuery = true)
	List<HoaDon> findByNguoiDungIDAndTrangThaiXacNhan(Long id);
	
	@Query(value = "update HoaDon set nguoiDungXacNhan='true' where id=:id",nativeQuery = true)
	void setTrangThaiNguoiMuaXacNhan(@Param("id") Long id);
	
	@Query(value = "update HoaDon set ngayNhan=:ngayNhan where id=:id",nativeQuery = true)
	void setNgayNhan( @Param("ngayNhan") LocalDate ngayNhan , @Param("id") Long id);
	
	
	@Query(value = "select * from HoaDon Where  nguoiDungXacNhan='true' AND trangThai='true' And nguoidungID=?1",nativeQuery = true)
	List<HoaDon> findListHoaDonDaGiao(Long id);
}
