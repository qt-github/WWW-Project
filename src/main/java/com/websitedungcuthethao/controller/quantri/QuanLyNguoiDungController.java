package com.websitedungcuthethao.controller.quantri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitedungcuthethao.constant.SystemConstant;
import com.websitedungcuthethao.dto.AbstractDTO;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.service.impl.NguoiDungService;

@Controller
@RequestMapping("/quan-tri/quan-ly-nguoi-dung")
public class QuanLyNguoiDungController {
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping
	public String index(Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit);
		List<NguoiDung> listNguoiDung= nguoiDungService.findAllAndPaging(pageable);

		abstractDTO.setTotalItem(nguoiDungService.getTotalItem());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		System.out.println(abstractDTO.toString());
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("listNguoiDung", listNguoiDung);
		
		
		return"quantri/quanlynguoidung";
	}
	
	@RequestMapping("/sua-trang-thai/{id}")
	public String suaTrangThaiNguoiDung(@PathVariable Long id) {
		try {
			if(nguoiDungService.findById(id).isTrangThai()==true) {
				System.out.println(1);
				nguoiDungService.setTrangThaiNguoiDung(id, SystemConstant.INACTIVE_STATUS);
				System.out.println(nguoiDungService.findById(id).isTrangThai());
			}else {
				nguoiDungService.setTrangThaiNguoiDung(id, SystemConstant.ACTIVE_STATUS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "redirect:/quan-tri/quan-ly-nguoi-dung?page=1&limit=3";
	}

	
}
