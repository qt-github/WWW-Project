package com.websitedungcuthethao.controller.nguoidung;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitedungcuthethao.dto.GiohangSanphamDTO;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.GioHangService;
import com.websitedungcuthethao.service.impl.SanPhamService;

@Controller
@RequestMapping
public class GioHangController {
	@Autowired
	GioHangService gioHangService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/gio-hang")
	public String index (Model model) {
		
		return "nguoidung/giohang";
	}
	
	
	@GetMapping("/gio-hang/them/{id}")
	public String themVaoGioHang(HttpServletRequest req,HttpSession session, @PathVariable Long id, Model model) {
		HashMap<Long, GiohangSanphamDTO> gioHang =(HashMap<Long, GiohangSanphamDTO>) req.getSession().getAttribute("gioHang");
		if(gioHang == null) {
			gioHang = new HashMap<Long, GiohangSanphamDTO>(); 
		}
		
		SanPham sp = sanPhamService.findById(id);
		
//		kiem tra so luong sp con lại trước khi thêm

		if(sp.getSoLuong() < 1) {
			System.out.println("loi so luong");
			return "redirect:"+req.getHeader("Referer");
		}
		else {
//			them vao giỏ hàng
			gioHang = gioHangService.themVaoGioHang(id, gioHang);
			session.setAttribute("gioHang", gioHang);
			session.setAttribute("tongSoLuongGioHang", gioHangService.getTongSoLuongGioHang(gioHang));
			session.setAttribute("tongThanhTienGioHang", gioHangService.getTongThanhTienGioHang(gioHang));
			
//			cap nhat tăng lượt xem sản phẩm
			sp.setSoLuotXem(sp.getSoLuotXem()+1);
			sanPhamService.save(sp);
		}
		
		

		
		
		return "redirect:"+req.getHeader("Referer");
	}
	@GetMapping("/gio-hang/xoa/{id}")
	public String xoaSanPhamGioHang(HttpServletRequest req,HttpSession session, @PathVariable Long id) {
		HashMap<Long, GiohangSanphamDTO> gioHang =(HashMap<Long, GiohangSanphamDTO>) req.getSession().getAttribute("gioHang");
		if(gioHang == null) {
			gioHang = new HashMap<Long, GiohangSanphamDTO>(); 
		}
		gioHang = gioHangService.xoaSanPhamGioHang(id, gioHang);
		session.setAttribute("gioHang", gioHang);
		session.setAttribute("tongSoLuongGioHang", gioHangService.getTongSoLuongGioHang(gioHang));
		session.setAttribute("tongThanhTienGioHang", gioHangService.getTongThanhTienGioHang(gioHang));
		
		return "redirect:"+req.getHeader("Referer");
	}
	
	@GetMapping("/gio-hang/sua/{id}/{soLuongMoi}")
	public String suaSanPhamGioHang(HttpServletRequest req,HttpSession session, @PathVariable Long id,  @PathVariable int soLuongMoi) {
		HashMap<Long, GiohangSanphamDTO> gioHang =(HashMap<Long, GiohangSanphamDTO>) req.getSession().getAttribute("gioHang");
		if(gioHang == null) {
			gioHang = new HashMap<Long, GiohangSanphamDTO>(); 
		}
		gioHang = gioHangService.suaSanPhamGioHang(id, soLuongMoi, gioHang);
		session.setAttribute("gioHang", gioHang);
		session.setAttribute("tongSoLuongGioHang", gioHangService.getTongSoLuongGioHang(gioHang));
		session.setAttribute("tongThanhTienGioHang", gioHangService.getTongThanhTienGioHang(gioHang));
		return "redirect:"+req.getHeader("Referer");
	}	
}
