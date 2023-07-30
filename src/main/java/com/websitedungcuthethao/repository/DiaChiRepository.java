package com.websitedungcuthethao.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.entity.DiaChi;

public interface DiaChiRepository extends JpaRepository<DiaChi, Long> {
	
	@Query(value = "SELECT * FROM DIACHI WHERE NGUOIDUNGID = ?1",nativeQuery = true)
	List<DiaChi> findByNguoiDungID(Long nguoidungID);
	
	
	@Modifying
	@Query(value = "insert into DiaChi(quan,soNha,tinhTP,nguoidungID) values(:quan,:soNha,:tinhTP,:nguoidungID)", nativeQuery = true)
	@Transactional
	void themDiaChi(@Param("quan") String quan, @Param("soNha") String soNha,@Param("tinhTP") String tinhTP,@Param("nguoidungID") Long nguoidungID);

}
