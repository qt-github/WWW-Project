package com.websitedungcuthethao.controller.nguoidung;

import java.time.LocalDate;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websitedungcuthethao.dto.GiohangSanphamDTO;
import com.websitedungcuthethao.dto.NguoiDungDTO;
import com.websitedungcuthethao.entity.HoaDon;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.HoaDonService;
import com.websitedungcuthethao.service.impl.NguoiDungService;
import com.websitedungcuthethao.service.impl.SanPhamService;
import com.websitedungcuthethao.util.SecurityUtils;

@Controller
public class ThanhToanController {
	@Autowired
	NguoiDungService nguoiDungService;
	
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	SanPhamService sanPhamService;
		
	NguoiDung nguoidung = null;
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public String checkout (Model model) {
		NguoiDungDTO nguoidungDTO = null;
		try {
			nguoidungDTO = SecurityUtils.getPrincipal();
		} catch (Exception e) {
			return "redirect:/dang-nhap";
		}

		nguoidung = nguoiDungService.findOneByTenDangNhap(nguoidungDTO.getUsername());
		model.addAttribute("nguoidung",nguoidung);
		
		return "nguoidung/thanhtoan";
	}
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
	public String datHang (Model model, HttpSession session) {
		
		int soLuongSp = (int) session.getAttribute("tongSoLuongGioHang");
		double tongTienHD = (double) session.getAttribute("tongThanhTienGioHang");
//		kiem tra dia chi
		if(nguoidung.getDsDiaChi().size()==0) {
			return "redirect:/them-dia-chi/"+nguoidung.getId();
		}
		
//		lap hoa don
		HoaDon hd = new HoaDon(nguoiDungService.findOneByTenDangNhap(nguoidung.getTenDangNhap()),false,LocalDate.now(),LocalDate.now().plusDays(7),null,soLuongSp,tongTienHD);
		hoaDonService.saveHoaDon(hd);
//		them chi tiet hoa don
		HashMap<Long, GiohangSanphamDTO> dsSanPhamGioHang  = (HashMap<Long, GiohangSanphamDTO>) session.getAttribute("gioHang");
		hoaDonService.themDSChiTietHoaDon(hd.getId(), dsSanPhamGioHang);
		
//		cap nhat san pham (số lượng sp, số lượt mua) giảm
		dsSanPhamGioHang.forEach((k, v)-> {
			SanPham sp = sanPhamService.findById(v.getSanPham().getId());
			sp.setSoLuong(sp.getSoLuong() -v.getSoLuong());
			sp.setSoLuotMua(sp.getSoLuotMua()+1);
			sanPhamService.save(sp);
		});
		
		
		session.removeAttribute("gioHang");
		session.removeAttribute("tongSoLuongGioHang");
		session.removeAttribute("tongThanhTienGioHang");
		return "nguoidung/thong_bao_dat_hang";
	}
}
