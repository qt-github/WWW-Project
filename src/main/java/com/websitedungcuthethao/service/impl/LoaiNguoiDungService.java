package com.websitedungcuthethao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.LoaiNguoiDung;
import com.websitedungcuthethao.repository.LoaiNguoiDungReoisitory;
import com.websitedungcuthethao.service.ILoaiNguoiDungService;

@Service
public class LoaiNguoiDungService implements ILoaiNguoiDungService{
	
	@Autowired
	private LoaiNguoiDungReoisitory loaiNguoiDungRepository;

	@Override
	public LoaiNguoiDung findByID(Long id) {
		return loaiNguoiDungRepository.findOne(id);
	}

	@Override
	public LoaiNguoiDung findByTenLoaiNguoiDung(String tenLoai) {
		// TODO Auto-generated method stub
		return loaiNguoiDungRepository.findOneByTenLoai(tenLoai);
	}

}
