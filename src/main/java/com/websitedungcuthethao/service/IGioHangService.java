package com.websitedungcuthethao.service;

import java.util.HashMap;
import java.util.List;

import com.websitedungcuthethao.dto.GiohangSanphamDTO;
import com.websitedungcuthethao.entity.HoaDon;

public interface IGioHangService {
	public HashMap<Long, GiohangSanphamDTO> themVaoGioHang(Long id, HashMap<Long, GiohangSanphamDTO> gioHang);
	public HashMap<Long, GiohangSanphamDTO> suaSanPhamGioHang(Long id, int soluongMoi, HashMap<Long, GiohangSanphamDTO> gioHang);
	public HashMap<Long, GiohangSanphamDTO> xoaSanPhamGioHang(Long id, HashMap<Long, GiohangSanphamDTO> gioHang);
	public int getTongSoLuongGioHang(HashMap<Long, GiohangSanphamDTO> gioHang);
	public double getTongThanhTienGioHang(HashMap<Long, GiohangSanphamDTO> gioHang);
	
}
