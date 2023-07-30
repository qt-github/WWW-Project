package com.websitedungcuthethao.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitedungcuthethao.dto.GiohangSanphamDTO;
import com.websitedungcuthethao.entity.HoaDon;
import com.websitedungcuthethao.repository.ChiTietHoaDonRepository;
import com.websitedungcuthethao.repository.HoaDonRepository;
import com.websitedungcuthethao.repository.SanPhamRepository;
import com.websitedungcuthethao.service.IHoaDonService;

@Service
public class HoaDonService implements IHoaDonService {
	@Autowired
	private HoaDonRepository hoaDonRepository;
	
	@Autowired
	SanPhamRepository sanPhamRepository;
	
	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Override
	public void saveHoaDon(HoaDon hoaDon) {
		hoaDonRepository.save(hoaDon);
	}

	@Override
	public HoaDon findById(Long id) {
		return hoaDonRepository.findOne(id);
	}

	@Override
	public void themDSChiTietHoaDon(Long idHD, HashMap<Long, GiohangSanphamDTO> gioHang) {
		// TODO Auto-generated method stub
		for(Map.Entry<Long, GiohangSanphamDTO> item : gioHang.entrySet()) {
//			ChiTietHoaDon ct = new ChiTietHoaDon();
//			ct.setHoadon(hoaDonRepository.findOne(idHD));
//			ct.setSanpham(sanPhamRepository.findById(item.getValue().getSanPham().getId()));
//			ct.setSoLuong(item.getValue().getSoLuong());
//			System.out.println(ct.toString());
			chiTietHoaDonRepository.themCTHD(idHD, item.getKey(), item.getValue().getSoLuong());
		}
	}

	@Override
	public List<HoaDon> findAllByTrangThaiAndPaging(boolean tt, Pageable pageable) {
		List<HoaDon> list = hoaDonRepository.findByTrangThai(tt, pageable);
		return list;
	}

	@Override
	public Long getTotalItem() {
		// TODO Auto-generated method stub
		return hoaDonRepository.count();
	}

	@Override
	public void setTrangThaiHoaDon(Long id, boolean tt) {
		hoaDonRepository.setTrangThaiHoaDon(id, tt);
	}

	@Override
	public void deleteHoaDon(HoaDon hoaDon) {
		hoaDonRepository.delete(hoaDon);
	}

	@Override
	public List<HoaDon> findByNguoiDungIDAndTrangThaiXacNhan(Long id) {
		return hoaDonRepository.findByNguoiDungIDAndTrangThaiXacNhan(id);
	}

	@Override
	public void setTrangThaiNguoiMuaXacNhan(Long id) {
		hoaDonRepository.setTrangThaiNguoiMuaXacNhan(id);
	}

	@Override
	public void updateHoaDon(HoaDon hoaDon) {
		hoaDonRepository.save(hoaDon);
	}

	@Override
	public void setNgayNhan(LocalDate ngayNhan, Long id) {
		hoaDonRepository.setNgayNhan(ngayNhan, id);
	}

	@Override
	public List<HoaDon> findListHoaDonDaGiao(Long id) {
		return hoaDonRepository.findListHoaDonDaGiao(id);
	}

	
	
}
