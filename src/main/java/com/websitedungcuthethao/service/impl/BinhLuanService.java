package com.websitedungcuthethao.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.BinhLuan;
import com.websitedungcuthethao.repository.BinhLuanRepository;
import com.websitedungcuthethao.service.IBinhLuanService;

@Service
public class BinhLuanService implements IBinhLuanService{

	@Autowired
	private BinhLuanRepository binhLuanRepository;
	
	@Override
	public BinhLuan save(BinhLuan  binhLuan) {
		return binhLuanRepository.save(binhLuan);
	}
	@Override
	public void deleteById(Long id) {
		 binhLuanRepository.delete(binhLuanRepository.findOne(id));
	}
	@Override
	public List<BinhLuan> findBySanPham(Long id) {
		return binhLuanRepository.findBySanPham(id);
	}
	@Override
	public void themBinhLuan(String anhSanPham, String binhLuan, LocalDate ngayBinhLuan, Long nguoidungID,
			Long sanphamID) {
		binhLuanRepository.themBinhLuan(anhSanPham, binhLuan, ngayBinhLuan, nguoidungID, sanphamID);
	}
	
	
}
