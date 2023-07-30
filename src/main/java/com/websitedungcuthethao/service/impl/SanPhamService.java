package com.websitedungcuthethao.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.repository.SanPhamRepository;
import com.websitedungcuthethao.service.ISanPhamService;

@Service
public class SanPhamService implements ISanPhamService {
	@Autowired
	private SanPhamRepository sanPhamRepository;
	

	
	@Override
	public List<SanPham> findAllAndPaging(Pageable pageable) {
		List<SanPham> list = sanPhamRepository.findAll(pageable).getContent();
		return list;
	}	
	@Override
	public SanPham findById(Long id) {
		return sanPhamRepository.findOne(id);
	}
	@Override
	public List<SanPham> findByTen(String ten) {
		return sanPhamRepository.findByTen(ten);
	}
	@Override
	public void deleteById(Long id) {
		if(sanPhamRepository.findOne(id)!=null) {
			sanPhamRepository.delete(sanPhamRepository.findOne(id));
		}
	}
	@Override
	public void save(SanPham sanPham) {
		 sanPhamRepository.save(sanPham);
		
	}
	
	
	@Override
	public void updateSanPham(SanPham sanPham) {
		if(sanPham!=null) {
			sanPhamRepository.save(sanPham);
		}
	}
	@Override
	public List<SanPham> findTop3SanPhamBySoLuotXem() {
		// TODO Auto-genserated method stub
		return sanPhamRepository.findTop3SanPhamBySoLuotXem();
	}
	@Override
	public List<SanPham> findTop3SanPhamGiamGiaNhieuNhat() {
		// TODO Auto-generated method stub
		return sanPhamRepository.findTop3SanPhamGiamGiaNhieuNhat();
	}
	@Override
	public List<SanPham> findByDanhMucIDAndTrangThai(Long idDM,boolean tt, Pageable pageable) {
		return sanPhamRepository.findByDanhmucIdAndTrangThai(idDM,tt, pageable);
	}
	@Override
	public Long getTotalItem() {
		return  sanPhamRepository.count();
	}
	@Override
	public List<SanPham> findDSSanPhamNoiBat() {
		// TODO Auto-generated method stub
		return sanPhamRepository.findDSSanPhamNoiBat();
	}
	@Override
	public void setTrangThaiSanPham(Long id, boolean tt) {
		sanPhamRepository.setTrangThaiSanPham(id, tt);
	}
	@Override
	public List<SanPham> findAllByTrangThaiAndPaging(boolean tt, Pageable pageable) {
		List<SanPham> list = sanPhamRepository.findByTrangThai(tt, pageable);
		return list;
	}
//	@Override
//	public List<SanPham> findByDanhMucID(Long id, Pageable pageable) {
//		return sanPhamRepository.findByDanhmucID(id, pageable);
//	}
	@Override
	public List<SanPham> search(String keyword , Pageable pageable) {
		return sanPhamRepository.search(keyword, pageable);
	}
}
