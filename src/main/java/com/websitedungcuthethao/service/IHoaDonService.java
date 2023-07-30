package com.websitedungcuthethao.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.websitedungcuthethao.dto.GiohangSanphamDTO;
import com.websitedungcuthethao.entity.HoaDon;

public interface IHoaDonService {
	void saveHoaDon(HoaDon hoaDon);
	HoaDon findById(Long id);
	void themDSChiTietHoaDon(Long idHD,HashMap<Long, GiohangSanphamDTO> gioHang);
	List<HoaDon> findAllByTrangThaiAndPaging(boolean tt, Pageable pageable);
	Long getTotalItem();
	void deleteHoaDon(HoaDon hoaDon);
	void setTrangThaiHoaDon(Long id, boolean tt);
	List<HoaDon> findByNguoiDungIDAndTrangThaiXacNhan(Long id);
	void setTrangThaiNguoiMuaXacNhan(@Param("id") Long id);
	
	void updateHoaDon(HoaDon hoaDon);
	
	void setNgayNhan( LocalDate ngayNhan ,Long id);
	List<HoaDon> findListHoaDonDaGiao(Long id);
}
