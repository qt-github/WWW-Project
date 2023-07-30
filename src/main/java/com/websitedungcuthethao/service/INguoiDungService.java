package com.websitedungcuthethao.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.websitedungcuthethao.dto.TaiKhoanDTO;
import com.websitedungcuthethao.entity.NguoiDung;

public interface INguoiDungService {
	List<NguoiDung> findAllAndPaging(Pageable pageable);
	void saveNguoiDung(NguoiDung nguoiDung);
	void UpdateNguoiDung(NguoiDung nguoiDung);
	NguoiDung findById(Long id);
	List<NguoiDung> findByTenAndHo(String ten,String ho);
	
	void doiMatKhau(TaiKhoanDTO taiKhoanDTO);
	
	NguoiDung findOneByTenDangNhap(String tenDangNhap);
	Long getTotalItem();
	void setTrangThaiNguoiDung(Long id, boolean tt);
	 List<NguoiDung> findAll();
		
}
