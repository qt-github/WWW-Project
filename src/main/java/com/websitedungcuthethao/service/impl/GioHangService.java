package com.websitedungcuthethao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.dto.GiohangSanphamDTO;
import com.websitedungcuthethao.entity.HoaDon;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.mapper.MapperSanPhamToSanPhamDTO;
import com.websitedungcuthethao.repository.SanPhamRepository;
import com.websitedungcuthethao.service.IGioHangService;

@Service
public class GioHangService implements IGioHangService {
	@Autowired
	SanPhamRepository sanPhamRepository;

	@Override
	public HashMap<Long, GiohangSanphamDTO> themVaoGioHang(Long id, HashMap<Long, GiohangSanphamDTO> gioHang) {
		GiohangSanphamDTO item = new GiohangSanphamDTO();
		SanPham sp = sanPhamRepository.findById(id);
		if (sp != null && gioHang.containsKey(id)) {
			item = gioHang.get(id);
			item.setSoLuong(item.getSoLuong() + 1);
			item.setTongGia(item.getGiaBanThucTe() * item.getSoLuong());
		} else {
			item.setSanPham(MapperSanPhamToSanPhamDTO.covertSanPhamToSanPhamDTO(sp));
			item.setSoLuong(1);
			item.setTongGia(item.getGiaBanThucTe());
		}
		gioHang.put(id, item);
		return gioHang;
	}

	@Override
	public int getTongSoLuongGioHang(HashMap<Long, GiohangSanphamDTO> gioHang) {
		int soluong = 0;
		for (Map.Entry<Long, GiohangSanphamDTO> item : gioHang.entrySet()) {
			soluong += item.getValue().getSoLuong();
		}
		return soluong;
	}

	@Override
	public double getTongThanhTienGioHang(HashMap<Long, GiohangSanphamDTO> gioHang) {
		double sum = 0;
		for (Map.Entry<Long, GiohangSanphamDTO> item : gioHang.entrySet()) {
			sum += item.getValue().getTongGia();
		}
		return sum;
	}

	@Override
	public HashMap<Long, GiohangSanphamDTO> suaSanPhamGioHang(Long id, int soluongMoi,
			HashMap<Long, GiohangSanphamDTO> gioHang) {
		if(gioHang == null) {
			return gioHang;
		}
		GiohangSanphamDTO item = new GiohangSanphamDTO();
		if (gioHang.containsKey(id)) {
			item = gioHang.get(id);
			item.setSoLuong(soluongMoi);
			item.setTongGia(soluongMoi * item.getGiaBanThucTe());
		}
		gioHang.put(id, item);
		return gioHang;
	}

	@Override
	public HashMap<Long, GiohangSanphamDTO> xoaSanPhamGioHang(Long id, HashMap<Long, GiohangSanphamDTO> gioHang) {
		if(gioHang == null) {
			return gioHang;
		}
		if (gioHang.containsKey(id)) {
			gioHang.remove(id);
		}
		return gioHang;
	}

	

}
