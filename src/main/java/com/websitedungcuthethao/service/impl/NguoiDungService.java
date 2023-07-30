package com.websitedungcuthethao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.dto.TaiKhoanDTO;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.repository.NguoiDungRepository;
import com.websitedungcuthethao.service.INguoiDungService;

@Service
public class NguoiDungService  implements INguoiDungService{
	@Autowired
	private NguoiDungRepository nguoiDungRepository;


	@Override
	public void saveNguoiDung(NguoiDung nguoiDung) {
		nguoiDungRepository.save(nguoiDung);
	}

	@Override
	public NguoiDung findById(Long id) {
		return nguoiDungRepository.findOne(id);
	}

	@Override
	public List<NguoiDung> findByTenAndHo(String ten, String ho) {
		return nguoiDungRepository.findByTenAndHo(ten, ho);
	}

	@Override
	public void doiMatKhau(TaiKhoanDTO taiKhoanDTO) {
		NguoiDung nguoiDung= nguoiDungRepository.findOneByTenDangNhap(taiKhoanDTO.getTenDangNhap());
		if(nguoiDung!=null) {
			nguoiDung.setMatKhau(taiKhoanDTO.getMatKhau());
		}
	}

	@Override
	public NguoiDung findOneByTenDangNhap(String tenDangNhap) {
		return nguoiDungRepository.findOneByTenDangNhap(tenDangNhap);
	}

	@Override
	public void UpdateNguoiDung(NguoiDung nguoiDung) {
		if(nguoiDung.getId()!=null) {
			nguoiDungRepository.save(nguoiDung);
		}
	}

	@Override
	public List<NguoiDung> findAllAndPaging(Pageable pageable) {
		List<NguoiDung> list = nguoiDungRepository.findAll(pageable).getContent();
		return list;
	}

	@Override
	public Long getTotalItem() {
		// TODO Auto-generated method stub
		return  nguoiDungRepository.count();
	}

	@Override
	public void setTrangThaiNguoiDung(Long id, boolean tt) {
		// TODO Auto-generated method stub
		nguoiDungRepository.setTrangThaiNguoiDung(id, tt);	
	}

	@Override
	public List<NguoiDung> findAll() {
		return nguoiDungRepository.findAll();
	}

}
