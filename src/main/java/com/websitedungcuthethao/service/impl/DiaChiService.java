package com.websitedungcuthethao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.dto.NguoiDungDTONew;
import com.websitedungcuthethao.entity.DiaChi;
import com.websitedungcuthethao.repository.DiaChiRepository;
import com.websitedungcuthethao.service.IDiaChiService;

@Service
public class DiaChiService implements IDiaChiService{
	@Autowired
	private DiaChiRepository diaChiRepository;
	@Override
	public void saveDiaChi(DiaChi diaChi) {
		 diaChiRepository.save(diaChi);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void updateDiaChi(NguoiDungDTONew nguoiDungDTONew) {
		List<DiaChi> list = (List<DiaChi>) nguoiDungDTONew.getDsDiaChi();
		for (DiaChi diaChi : list) {
			diaChiRepository.save(diaChi);
		}		
	}
	@Override
	public List<DiaChi> findByNguoiDungID(Long id) {
		return diaChiRepository.findByNguoiDungID(id);
	}
	@Override
	public void themDiaChi(String quan, String soNha, String tinhTP, Long nguoidungID) {
		diaChiRepository.themDiaChi(quan, soNha, tinhTP, nguoidungID);
	}
	

}
