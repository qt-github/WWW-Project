package com.websitedungcuthethao.service;

import java.util.List;

import com.websitedungcuthethao.dto.NguoiDungDTONew;
import com.websitedungcuthethao.entity.DiaChi;

public interface IDiaChiService {
	void saveDiaChi(DiaChi diaChi);
	void updateDiaChi(NguoiDungDTONew nguoiDungDTONew);
	List<DiaChi> findByNguoiDungID(Long id);
	
	void themDiaChi(String quan,String soNha,String tinhTP,Long nguoidungID);
}
