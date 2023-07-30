package com.websitedungcuthethao.service;

import java.util.List;

import com.websitedungcuthethao.entity.ThuocTinhSanPham;

public interface IThuocTinhSanPhamService {
	void saveTTSP(ThuocTinhSanPham thuocTinhSanPham);
	void updateTTSP(ThuocTinhSanPham thuocTinhSanPham);
	ThuocTinhSanPham findById(Long id);
	ThuocTinhSanPham findOneByTenThuoctinh(String ten);
	List<ThuocTinhSanPham> findAll();
}
