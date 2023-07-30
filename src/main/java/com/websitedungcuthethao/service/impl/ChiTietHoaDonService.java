package com.websitedungcuthethao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.ChiTietHoaDon;
import com.websitedungcuthethao.repository.ChiTietHoaDonRepository;
import com.websitedungcuthethao.service.IChiTietHoaDonService;


@Service
public class ChiTietHoaDonService  implements IChiTietHoaDonService{
	@Autowired 
	ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Override
	public void saveCTHD(ChiTietHoaDon chiTietHoaDon) {
		chiTietHoaDonRepository.save(chiTietHoaDon);
	}

	@Override
	public ChiTietHoaDon findById(Long id) {
		return chiTietHoaDonRepository.findOne(id);
	}

	@Override
	public List<ChiTietHoaDon> findByMaHoaDon(Long hoadonID) {
		return chiTietHoaDonRepository.findByHoaDon(hoadonID);
	}

	@Override
	public void deleteCTHD(List<ChiTietHoaDon> chiTietHoaDons) {
		chiTietHoaDonRepository.delete(chiTietHoaDons);
	}

}
