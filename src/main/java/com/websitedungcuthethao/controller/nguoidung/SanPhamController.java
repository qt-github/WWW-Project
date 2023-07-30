package com.websitedungcuthethao.controller.nguoidung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitedungcuthethao.constant.SystemConstant;
import com.websitedungcuthethao.dto.AbstractDTO;
import com.websitedungcuthethao.entity.DanhMuc;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.DanhMucService;
import com.websitedungcuthethao.service.impl.SanPhamService;

@Controller
@RequestMapping(value = "/danh-sach-san-pham")
public class SanPhamController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired 
	DanhMucService danhService;
	
	@GetMapping
	public String index (Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit);
		List<SanPham> dsSanPham= sanPhamService.findAllByTrangThaiAndPaging(SystemConstant.ACTIVE_STATUS, pageable);

		abstractDTO.setTotalItem(sanPhamService.getTotalItem());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		
		List<DanhMuc> listDanhMuc = danhService.findAllDanhMucCon();
		model.addAttribute("listDanhMuc", listDanhMuc);
		
		return "nguoidung/danhsachsanpham";
	}
	@GetMapping("danh-muc/{id}")
	public String getDsSanPhamByDanhMuc(@PathVariable Long id, Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit, Direction.ASC,"gia");
		List<SanPham> dsSanPham= sanPhamService.findByDanhMucIDAndTrangThai(id, SystemConstant.ACTIVE_STATUS, pageable);
		abstractDTO.setTotalItem((long) dsSanPham.size());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		model.addAttribute("danhmucID", id);
		
		List<DanhMuc> listDanhMuc = danhService.findAllDanhMucCon();
		model.addAttribute("listDanhMuc", listDanhMuc);
		return "nguoidung/danhsachsanpham_theodanhmuc";
	}
	
	@GetMapping("danh-muc/{id}/sap-xep/{value}")
	public String getDsSanPhamByDanhMucVaSapXep(@PathVariable String value, @PathVariable Long id, Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable= null;
		if(value.equals("asc")) {
			pageable = new PageRequest(page -1, limit, Direction.ASC,"gia");
		}
		else {
			pageable = new PageRequest(page -1, limit, Direction.DESC,"gia");
		}
		
		List<SanPham> dsSanPham= sanPhamService.findByDanhMucIDAndTrangThai(id, SystemConstant.ACTIVE_STATUS, pageable);
		abstractDTO.setTotalItem((long) dsSanPham.size());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		model.addAttribute("danhmucID", id);
		
//		giaTriSapXep thuộc asc or desc
		model.addAttribute("giaTriSapXep",value);
		
		List<DanhMuc> listDanhMuc = danhService.findAllDanhMucCon();
		model.addAttribute("listDanhMuc", listDanhMuc);
		return "nguoidung/danhsachsanpham_theodanhmuc";
	}
	
	@GetMapping("sap-xep/{value}")
	public String sapXep(@PathVariable String value, Model model,  @RequestParam("page") int page,@RequestParam("limit") int limit) {
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		Pageable pageable= null;
		if(value.equals("asc")) {
			pageable = new PageRequest(page -1, limit, Direction.ASC,"gia");
		}
		else {
			pageable = new PageRequest(page -1, limit, Direction.DESC,"gia");
		}
		
		List<SanPham> dsSanPham = sanPhamService.findAllByTrangThaiAndPaging(SystemConstant.ACTIVE_STATUS, pageable);
		abstractDTO.setTotalItem(sanPhamService.getTotalItem());		
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		
//		giaTriSapXep thuộc asc or desc
		model.addAttribute("giaTriSapXep",value);
		
		List<DanhMuc> listDanhMuc = danhService.findAllDanhMucCon();
		model.addAttribute("listDanhMuc", listDanhMuc);
		return "nguoidung/danhsachsanpham";
	}
	
	@GetMapping("/tim-kiem/{keywork}")
	public String timKiem (Model model, @PathVariable String keywork,  @RequestParam("page") int page,@RequestParam("limit") int limit ) {

		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit, Direction.ASC,"gia");
		List<SanPham> dsSanPham= sanPhamService.search(keywork, pageable);
		abstractDTO.setTotalItem(dsSanPham.size()*1L);
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		model.addAttribute("keywork",keywork);
		List<DanhMuc> listDanhMuc = danhService.findAllDanhMucCon();
		model.addAttribute("listDanhMuc", listDanhMuc);
		return "nguoidung/ketqua_timkiem";
	}
	@GetMapping(value = "/tim-kiem/{keywork}/sap-xep/{value}")
	public String timKiemVaSapXep (Model model, @PathVariable String keywork, @PathVariable String value, @RequestParam("page") int page,@RequestParam("limit") int limit ) {
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		Pageable pageable= null;
		if(value.equals("asc")) {
			pageable = new PageRequest(page -1, limit, Direction.ASC,"gia");
		}
		else {
			pageable = new PageRequest(page -1, limit, Direction.DESC,"gia");
		}
		
		List<SanPham> dsSanPham= sanPhamService.search(keywork, pageable);
		
		abstractDTO.setTotalItem((long) dsSanPham.size());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsSanPham", dsSanPham);
		model.addAttribute("keywork",keywork);
//		giaTriSapXep thuộc asc or desc
		model.addAttribute("giaTriSapXep",value);
		
		List<DanhMuc> listDanhMuc = danhService.findAllDanhMucCon();
		model.addAttribute("listDanhMuc", listDanhMuc);
		return "nguoidung/ketqua_timkiem";
	}
	

}
