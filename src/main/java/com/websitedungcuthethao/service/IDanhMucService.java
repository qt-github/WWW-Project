package com.websitedungcuthethao.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.websitedungcuthethao.entity.DanhMuc;

public interface IDanhMucService {
	List<DanhMuc> findAll();
	DanhMuc findByTen(String ten);
	List<DanhMuc> findAllDanhMucConById(Long id);
	List<DanhMuc> findAllDanhMucCha();
	void updateDanhMuc(DanhMuc danhMuc);
	void themDanhMuc(DanhMuc danhMuc);
	List<DanhMuc> findAllAndPaging(Pageable pageable);
	DanhMuc findOne(Long id);
	List<DanhMuc> findAllDanhMucCon();
}
