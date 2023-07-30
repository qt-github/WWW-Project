package com.websitedungcuthethao.service;

import java.util.List;

import com.websitedungcuthethao.entity.ChiTietHoaDon;

public interface IChiTietHoaDonService {
	void saveCTHD(ChiTietHoaDon chiTietHoaDon);
	ChiTietHoaDon findById(Long id);
	List<ChiTietHoaDon> findByMaHoaDon(Long hoadonID);
	void deleteCTHD(List<ChiTietHoaDon> chiTietHoaDons);
}
