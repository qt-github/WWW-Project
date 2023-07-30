package com.websitedungcuthethao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.DanhMuc;
import com.websitedungcuthethao.repository.DanhMucRepository;
import com.websitedungcuthethao.service.IDanhMucService;

@Service
public class DanhMucService implements IDanhMucService {
	
	@Autowired
	DanhMucRepository danhMucRepository;

	public List<DanhMuc> findAll() {
		return danhMucRepository.findAll();
	}

	@Override
	public DanhMuc findByTen(String ten) {
		return danhMucRepository.findOneByTen(ten);
	}

	@Override
	public List<DanhMuc> findAllDanhMucConById(Long id) {
		return danhMucRepository.findAllDanhMucConById(id);
	}

	@Override
	public List<DanhMuc> findAllDanhMucCha() {
		return danhMucRepository.findByDanhMucChaNull();
	}

	@Override
	public void updateDanhMuc(DanhMuc danhMuc) {
		DanhMuc dM= danhMucRepository.findOne(danhMuc.getId());
		if(dM!=null) {
			danhMucRepository.save(danhMuc);
		}		
	}

	@Override
	public List<DanhMuc> findAllAndPaging(Pageable pageable) {
		return danhMucRepository.findAll(pageable).getContent();
	}

	@Override
	public void themDanhMuc(DanhMuc danhMuc) {
		danhMucRepository.save(danhMuc);
	}

	@Override
	public DanhMuc findOne(Long id) {
		// TODO Auto-generated method stub
		return danhMucRepository.findOne(id);
	}

	@Override
	public List<DanhMuc> findAllDanhMucCon() {
		// TODO Auto-generated method stub
		return danhMucRepository.findAllDanhMucCon();
	}


	
}
