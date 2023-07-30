package com.websitedungcuthethao.mapper;

import com.websitedungcuthethao.dto.SanPhamDTO;
import com.websitedungcuthethao.entity.SanPham;

public class MapperSanPhamToSanPhamDTO {
	public static SanPhamDTO covertSanPhamToSanPhamDTO(SanPham sp) {
		SanPhamDTO spDTO = new SanPhamDTO();
		spDTO.setId(sp.getId());
		spDTO.setTen(sp.getTen());
		spDTO.setTenDanhMuc(sp.getDanhmuc().getTen());
		spDTO.setTenNhaCungCap(sp.getNhacungcap().getTenNhaCungCap());
		spDTO.setMoTa(sp.getMoTa());
		spDTO.setThuongHieu(sp.getThuongHieu());
		spDTO.setNoiDung(sp.getNoiDung());
		spDTO.setGia(sp.getGia());
		spDTO.setPhanTramGiamGia(sp.getPhanTramGiamGia());
		spDTO.setSoLuong(sp.getSoLuong());
		spDTO.setAnhDaiDien(sp.getAnhDaiDien());
		spDTO.setSoLuotXem(sp.getSoLuotXem());
		spDTO.setSoLuotMua(sp.getSoLuotMua());
		spDTO.setThoiGianBaoHanh(sp.getThoiGianBaoHanh());
		spDTO.setTrangThai(sp.isTrangThai());
		return spDTO;
	}
}
