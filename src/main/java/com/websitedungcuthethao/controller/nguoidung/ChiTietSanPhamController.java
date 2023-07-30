package com.websitedungcuthethao.controller.nguoidung;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.websitedungcuthethao.dto.NguoiDungDTO;
import com.websitedungcuthethao.entity.BinhLuan;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.BinhLuanService;
import com.websitedungcuthethao.service.impl.NguoiDungService;
import com.websitedungcuthethao.service.impl.SanPhamService;
import com.websitedungcuthethao.util.LuuAnh;
import com.websitedungcuthethao.util.SecurityUtils;

@Controller

public class ChiTietSanPhamController {
	@Autowired
	SanPhamService sanPhamSV;
	@Autowired
	NguoiDungService nguoiDungService;
	@Autowired
	private BinhLuanService binhLuanService;
	@Autowired
	private LuuAnh luuAnh;

	@RequestMapping("/chi-tiet-san-pham/{id}")
	public String index(@PathVariable Long id, Model model) {
		SanPham sp = sanPhamSV.findById(id);

		List<BinhLuan> listBL = binhLuanService.findBySanPham(sp.getId());

		model.addAttribute("listBL", listBL);

		model.addAttribute("sp", sp);

		return "nguoidung/chitietsanpham";
	}

//	chi-tiet-san-pham/luu-binh-luan

	@RequestMapping("/chi-tiet-san-pham/luu-binh-luan/{id}")
	public String luuBinhLuan(@PathVariable Long id,HttpSession session,@RequestParam("binhLuan") String binhLuan,@RequestParam CommonsMultipartFile anhSanPham) throws IOException {
//		System.out.println(anhSanPham.getOriginalFilename()+"1");
		System.out.println(binhLuan);
		NguoiDungDTO nguoidungDTO = null;
		try {
			nguoidungDTO = SecurityUtils.getPrincipal();
		} catch (Exception e) {
			return "redirect:/dang-nhap";
		}
		NguoiDung nguoidung = nguoiDungService.findOneByTenDangNhap(nguoidungDTO.getUsername());
		if (binhLuan != null) {
			luuAnh.luuAnh(anhSanPham, session);
			binhLuanService.themBinhLuan(anhSanPham.getOriginalFilename(), binhLuan, LocalDate.now(), nguoidung.getId(),id);
		}

		return "redirect:/chi-tiet-san-pham/"+id;
	}
}
