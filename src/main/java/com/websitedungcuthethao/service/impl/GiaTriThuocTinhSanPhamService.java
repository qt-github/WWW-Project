package com.websitedungcuthethao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.GiaTriThuocTinhSanPham;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.repository.GiaTriThuocTinhSanPhamRepository;
import com.websitedungcuthethao.service.IGiaTriThuocTinhSanPhamService;

@Service
public class GiaTriThuocTinhSanPhamService implements IGiaTriThuocTinhSanPhamService{


	@Autowired
	private GiaTriThuocTinhSanPhamRepository giaTriThuocTinhSanPhamRepository;

	

	

	@Override
	public void updateGTTTSP(SanPham sanPham) {
	
	}

	@Override
	public GiaTriThuocTinhSanPham findByIdSanPhamAndIDThuocTinh(Long idSP, Long idTT) {
		return giaTriThuocTinhSanPhamRepository.findBySanPhamIDAndThuocTinhSanPhamID(idSP, idTT);
	}

	@Override
	public void saveGTTTSP(Long sanPhamID, Long thuocTinhID, String giaTri) {
		giaTriThuocTinhSanPhamRepository.themGTTTSP(sanPhamID, thuocTinhID, giaTri);
	}

}
