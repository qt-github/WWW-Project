package com.websitedungcuthethao.controller.quantri;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitedungcuthethao.constant.SystemConstant;
import com.websitedungcuthethao.dto.AbstractDTO;
import com.websitedungcuthethao.dto.ThemSanPhamDTO;
import com.websitedungcuthethao.entity.DanhMuc;
import com.websitedungcuthethao.entity.NhaCungCap;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.entity.ThuocTinhSanPham;
import com.websitedungcuthethao.service.impl.DanhMucService;
import com.websitedungcuthethao.service.impl.GiaTriThuocTinhSanPhamService;
import com.websitedungcuthethao.service.impl.NhaCungCapService;
import com.websitedungcuthethao.service.impl.SanPhamService;
import com.websitedungcuthethao.service.impl.ThuocTinhSanPhamService;
import com.websitedungcuthethao.util.LuuAnh;
import com.websitedungcuthethao.validate.SanPhamSuaValidation;
import com.websitedungcuthethao.validate.SanPhamThemValidation;

@Controller
@RequestMapping("/quan-tri/quan-ly-san-pham")
public class QuanLiSanPhamController {
	

	private SanPham sanP=null;
	ThemSanPhamDTO spSua = null;
	@Autowired
	private ThuocTinhSanPhamService thuocTinhSanPhamService;
	
	@Autowired
	private GiaTriThuocTinhSanPhamService giaTriThuocTinhSanPhamService;
	
	@Autowired
	private DanhMucService danhMucService;
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private NhaCungCapService nhaCungCapService;
	
	
	@Autowired
	private LuuAnh luuAnh;
	
	@Autowired
	private SanPhamThemValidation sanPhamThemValidation;
	
	@Autowired
	private SanPhamSuaValidation sanPhamSuaValidation;
	
	@GetMapping
	public String index(Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		List<DanhMuc>list= danhMucService.findAllDanhMucCon();
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit);
		
//		List<SanPham>dsSanPham= sanPhamService.findByDanhMucID(list.get(0).getId(), pageable);
		List<SanPham> dsSanPham= sanPhamService.findAllAndPaging(pageable);

		abstractDTO.setTotalItem(sanPhamService.getTotalItem());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit()+1));
		model.addAttribute("list",list);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		
		return"quantri/quanlisanpham";
	}

	@GetMapping("/them-san-pham")
	public String themSanPham(Model model) {
		ThemSanPhamDTO sanPham= new ThemSanPhamDTO();
		model.addAttribute("sanPham", sanPham);	
		List<DanhMuc> listDanhMuc= danhMucService.findAll();
		model.addAttribute("listDanhMuc", listDanhMuc);
		List<NhaCungCap> listNhaCungCap= nhaCungCapService.findAll(); 
		model.addAttribute("listNhaCungCap", listNhaCungCap);
		
		List<ThuocTinhSanPham> listThuocTinh= thuocTinhSanPhamService.findAll();
		model.addAttribute("listThuocTinh", listThuocTinh);
		
		return "quantri/themsanpham";
	}
	
	
	@PostMapping("/them-san-pham")
	public String luuSanPham(@ModelAttribute("sanPham") ThemSanPhamDTO sanPham,HttpSession session,BindingResult bindingResult, Model model) throws IOException{
		sanPhamThemValidation.validate(sanPham, bindingResult);
		if(bindingResult.hasErrors()) {
			List<DanhMuc> listDanhMuc= danhMucService.findAll();
			model.addAttribute("listDanhMuc", listDanhMuc);
			List<NhaCungCap> listNhaCungCap= nhaCungCapService.findAll(); 
			model.addAttribute("listNhaCungCap", listNhaCungCap);
			
			List<ThuocTinhSanPham> listThuocTinh= thuocTinhSanPhamService.findAll();
			model.addAttribute("listThuocTinh", listThuocTinh);
			model.addAttribute("mesErr","Thông tin đăng ký không hợp lệ");
			return"quantri/themsanpham";
		}
		SanPham sp= new SanPham();
		sp.setAnhDaiDien(sanPham.getAnhDaiDien().getOriginalFilename());
		sp.setTen(sanPham.getTen());
		sp.setDanhmuc(danhMucService.findByTen(sanPham.getTenDanhMuc()));
		sp.setNhacungcap(nhaCungCapService.findByTenNhaCungCap(sanPham.getTenNhaCungCap()));
		sp.setMoTa(sanPham.getMoTa());
		sp.setThuongHieu(sanPham.getThuongHieu());
		sp.setNoiDung(sanPham.getNoiDung());
		sp.setGia(Double.parseDouble(sanPham.getGia()));
		sp.setPhanTramGiamGia(0);
		sp.setSoLuong(Integer.parseInt(sanPham.getSoLuong()));
		sp.setSoLuotMua(0);
		sp.setSoLuotXem(0);
		sp.setThoiGianBaoHanh(Integer.parseInt(sanPham.getThoiGianBaoHanh()));
		sp.setTrangThai(true);
		sp.setNgayTao(LocalDate.now());
		sanPhamService.save(sp);
		
		
		luuAnh.luuAnh(sanPham.getAnhDaiDien(), session);
		
		if(!sanPham.getGiaTriThuocTinh().equals("")) {
			ThuocTinhSanPham thuocTinhSanPham= thuocTinhSanPhamService.findOneByTenThuoctinh(sanPham.getTenThuocTinh());
			giaTriThuocTinhSanPhamService.saveGTTTSP(sp.getId(), thuocTinhSanPham.getId(), sanPham.getGiaTriThuocTinh());
		}
		return "redirect:/quan-tri/quan-ly-san-pham?page=1&limit=12";
	}
	
	@GetMapping("/xoa-san-pham/{id}")
	public String tamNgungSanPham(@PathVariable Long id) {
		try {
			if(sanPhamService.findById(id).isTrangThai()==true) {
				sanPhamService.setTrangThaiSanPham(id, SystemConstant.INACTIVE_STATUS);
				
			}
			else if(sanPhamService.findById(id).isTrangThai()==false){
				sanPhamService.setTrangThaiSanPham(id, SystemConstant.ACTIVE_STATUS);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/quan-tri/quan-ly-san-pham?page=1&limit=12";
	}
	
	@GetMapping("/sua-san-pham/{id}")
	public String suaSanPham(@PathVariable Long id,Model model) {

		SanPham sanPham= sanPhamService.findById(id);
		sanP= sanPham;
		ThemSanPhamDTO themSanPhamDTO = new ThemSanPhamDTO(sanPham.getTen(), sanPham.getMoTa(), sanPham.getThuongHieu(), sanPham.getNoiDung(),String.valueOf( sanPham.getGia()),String.valueOf(sanPham.getPhanTramGiamGia()),String.valueOf( sanPham.getThoiGianBaoHanh()));
		model.addAttribute("themSanPhamDTO", themSanPhamDTO);
		return "quantri/suasanpham";
	}
	@PostMapping("/sua-san-pham/luu-thong-tin")
	public String suaSanPham(@ModelAttribute("themSanPhamDTO") ThemSanPhamDTO themSanPhamDTO,BindingResult  bindingResult,HttpSession session,Model model) throws IOException {
		
		sanPhamSuaValidation.validate(themSanPhamDTO, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("themSanPhamDTO", themSanPhamDTO);
			return"quantri/suasanpham";
		}
		
		
		luuAnh.luuAnh(themSanPhamDTO.getAnhDaiDien(), session);
		
		sanP.setTen(themSanPhamDTO.getTen());
		sanP.setAnhDaiDien(themSanPhamDTO.getAnhDaiDien().getOriginalFilename());
		sanP.setGia(Double.parseDouble(themSanPhamDTO.getGia()));
		sanP.setMoTa(themSanPhamDTO.getMoTa());
		sanP.setNoiDung(themSanPhamDTO.getNoiDung());
		sanP.setThoiGianBaoHanh(Integer.parseInt(themSanPhamDTO.getThoiGianBaoHanh()));
		sanP.setThuongHieu(themSanPhamDTO.getThuongHieu());
		sanP.setPhanTramGiamGia(Double.parseDouble(themSanPhamDTO.getPhanTramGiamGia()));
		sanPhamService.updateSanPham(sanP);
		return "redirect:/quan-tri/quan-ly-san-pham?page=1&limit=12";
		
		
	}
	@GetMapping("/them-thuoc-tinh-san-pham")
	public String themThuocTinhSanPham(Model model) {
		return "quantri/themthuoctinhsanpham";
	}
	@PostMapping("/them-thuoc-tinh-san-pham")
	public String themThuocTinhSanPhamSubmit(@RequestParam String tenThuocTinh , Model model) {
		ThuocTinhSanPham thuocTinhSanPham = new ThuocTinhSanPham(tenThuocTinh);
		thuocTinhSanPhamService.saveTTSP(thuocTinhSanPham);
		return "redirect:/quan-tri/quan-ly-san-pham/them-san-pham";
	}
	
	@GetMapping("/loc-san-pham/{id}")
	public String locSanPham(@PathVariable Long id, Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		List<DanhMuc>list= danhMucService.findAllDanhMucCon();
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit);
		
		List<SanPham> dsSanPham= sanPhamService.findByDanhMucIDAndTrangThai(id, SystemConstant.ACTIVE_STATUS, pageable);
		abstractDTO.setTotalItem((long) dsSanPham.size());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit() +1));
		model.addAttribute("list",list);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		
		// bien check kiem tra form submit vao dau
		model.addAttribute("idDanhMuc",id);
		return"quantri/quanlisanpham";
	}
	
	
}
