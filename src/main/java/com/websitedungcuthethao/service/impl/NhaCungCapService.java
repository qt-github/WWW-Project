package com.websitedungcuthethao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.NhaCungCap;
import com.websitedungcuthethao.repository.NhaCungCapRepository;
import com.websitedungcuthethao.service.INhaCungCapService;

@Service
public class NhaCungCapService implements INhaCungCapService{
	@Autowired
	private NhaCungCapRepository  nhaCungCapRepository;

	@Override
	public NhaCungCap saveNCC(NhaCungCap nhaCungCap) {
		return nhaCungCapRepository.save(nhaCungCap);
	}


	@Override
	public NhaCungCap findByTenNhaCungCap(String ten) {
		return nhaCungCapRepository.findOneByTenNhaCungCap(ten);
	}

	@Override
	public NhaCungCap findNCCByID(Long id) {
		return nhaCungCapRepository.findOne(id);
	}


	@Override
	public void updateNCC(NhaCungCap nhaCungCap) {
		if(nhaCungCap.getId()!=null) {
			nhaCungCapRepository.save(nhaCungCap);
		}
	}

	@Override
	public List<NhaCungCap> findAll() {
		return nhaCungCapRepository.findAll();
	}


	@Override
	public List<NhaCungCap> findAllAndPaging(Pageable pageable) {
		return nhaCungCapRepository.findAll(pageable).getContent();
	}


	@Override
	public void deleteNCC(NhaCungCap nhaCungCap) {
		nhaCungCapRepository.delete(nhaCungCap);
	}
}
