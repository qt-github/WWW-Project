package com.websitedungcuthethao.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.websitedungcuthethao.entity.NhaCungCap;

public interface INhaCungCapService {
	NhaCungCap saveNCC(NhaCungCap nhaCungCap);
	void updateNCC(NhaCungCap nhaCungCap);
	NhaCungCap findByTenNhaCungCap(String ten);
	NhaCungCap findNCCByID(Long id);
	List<NhaCungCap> findAll();
	void deleteNCC(NhaCungCap nhaCungCap);
	List<NhaCungCap> findAllAndPaging(Pageable pageable);
}
