package com.websitedungcuthethao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.entity.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung,Long> {
	NguoiDung findOneByTenDangNhapAndTrangThai(String tenDangNhap, boolean trangThai);
	
	List<NguoiDung> findByTenAndHo(String ten,String ho);
	
	NguoiDung findOneByTenDangNhap(String tenDangNhap);
	
	@Query(value = "update NguoiDung set trangThai=:trangThai where id=:id",nativeQuery = true)
	void setTrangThaiNguoiDung(@Param("id") Long id, @Param("trangThai") boolean trangThai);

}
