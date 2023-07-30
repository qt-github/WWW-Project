package com.websitedungcuthethao.controller.nguoidung;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.DanhMucService;
import com.websitedungcuthethao.service.impl.SanPhamService;

@Controller
@RequestMapping({ "/", "trang-chu" })
public class TrangChuController {
	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DanhMucService danhMucService;

	@GetMapping
	public String index(Model model) {
		ArrayList<SanPham> dsSanPhamNoiBat = (ArrayList<SanPham>) sanPhamService.findDSSanPhamNoiBat();
		model.addAttribute("dsSanPhamNoiBat", dsSanPhamNoiBat);
		
		ArrayList<SanPham> dsSanPhamLuotXemCaoNhat = (ArrayList<SanPham>) sanPhamService.findTop3SanPhamBySoLuotXem();
		model.addAttribute("dsSanPhamLuotXemCaoNhat", dsSanPhamLuotXemCaoNhat);

		ArrayList<SanPham> dsSanPhamGiamGiaCaoNhat = (ArrayList<SanPham>) sanPhamService.findTop3SanPhamGiamGiaNhieuNhat();
		model.addAttribute("dsSanPhamGiamGiaCaoNhat", dsSanPhamGiamGiaCaoNhat);
		
		model.addAttribute("spGiamGiaTrongNgay",dsSanPhamNoiBat.get(0));

		return "nguoidung/trangchu";
	}
	
	@GetMapping("thong-tin-cua-hang")
	public String thongTinCuaHang() {
		return "nguoidung/thongtincuahang";
	}
	
	@GetMapping("gioi-thieu")
	public String gioiThieu() {
		return "nguoidung/gioithieu";
	}
	
	@GetMapping("bao-hanh")
	public String baoHanh() {
		return "nguoidung/chinhsachbaohanh";
	}
	
	
}
