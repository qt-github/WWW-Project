package com.websitedungcuthethao.controller.nguoidung;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitedungcuthethao.dto.NguoiDungDTO;
import com.websitedungcuthethao.entity.ChiTietHoaDon;
import com.websitedungcuthethao.entity.HoaDon;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.HoaDonService;
import com.websitedungcuthethao.service.impl.NguoiDungService;
import com.websitedungcuthethao.util.SecurityUtils;

@Controller
@RequestMapping("/don-hang")
public class DonHangController {
	@Autowired
	NguoiDungService nguoiDungService;
	@Autowired
	private HoaDonService hoaDonService;

	
	@GetMapping
	public String formXacNhanDonHang(Model model) {
		
		NguoiDungDTO nguoidungDTO = null;
		try {
			nguoidungDTO = SecurityUtils.getPrincipal();
		} catch (Exception e) {
			return "redirect:/dang-nhap";
		}
		
		NguoiDung nguoidung = nguoiDungService.findOneByTenDangNhap(nguoidungDTO.getUsername());
		
		model.addAttribute("nguoidung", nguoidung);
		
		List<HoaDon> listHD=hoaDonService.findByNguoiDungIDAndTrangThaiXacNhan(nguoidung.getId());
		model.addAttribute("listHD", listHD);
		model.addAttribute("soLuongDonHang", listHD.size());
				
		return "nguoidung/xacnhandonhang";
	}
	
	@GetMapping("/xac-nhan/{id}")
	public String xacNhan(@PathVariable Long id) {
		try {
			hoaDonService.setTrangThaiNguoiMuaXacNhan(id);
		} catch (Exception e) {
		}
		try {
			hoaDonService.setNgayNhan(LocalDate.now(),id);
			HoaDon hoaDon=hoaDonService.findById(id);
			System.out.println(hoaDon.getNgayNhan());
		} catch (Exception e) {
		}
		return "redirect:/don-hang";
	}
	
//	/don-hang-da-nhan/${nguoidung.id}
	
	@GetMapping("/don-hang-da-nhan/{id}")
	public String formDonHangDaNhan(Model model,@PathVariable Long id) {
		NguoiDungDTO nguoidungDTO = null;
		try {
			nguoidungDTO = SecurityUtils.getPrincipal();
		} catch (Exception e) {
			return "redirect:/dang-nhap";
		}
		List<HoaDon> listHD=hoaDonService.findListHoaDonDaGiao(id);
		model.addAttribute("listHD", listHD);
				
		return "nguoidung/donhangdanhan";
	}
	
//	don-hang/don-hang-da-nhan/xem-chi-tiet/3
	
	@GetMapping("/don-hang-da-nhan/xem-chi-tiet/{id}")
	public String xemChiTietDonHangDaNhan(Model model,@PathVariable Long id) {
		HoaDon hoaDon =hoaDonService.findById(id);
		Set<ChiTietHoaDon> listCTHD= hoaDon.getDsChiTietHoaDon();
		NguoiDung nguoiDung=hoaDon.getNguoidung();
		List<SanPham> listSP=new ArrayList<SanPham>();
		for (ChiTietHoaDon chiTietHoaDon : listCTHD) {
			listSP.add(chiTietHoaDon.getSanpham());
		}
		model.addAttribute("hoaDon", hoaDon);
		model.addAttribute("listSP", listSP);
		model.addAttribute("nguoiDung", nguoiDung);
		return "nguoidung/xemchitietdonhangdanhan";
	}
	
}
