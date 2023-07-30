package com.websitedungcuthethao.service;

import com.websitedungcuthethao.entity.LoaiNguoiDung;

public interface ILoaiNguoiDungService {
	LoaiNguoiDung findByID(Long id);
	LoaiNguoiDung findByTenLoaiNguoiDung(String tenLoai);
}
