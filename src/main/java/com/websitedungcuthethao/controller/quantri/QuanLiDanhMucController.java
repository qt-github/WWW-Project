package com.websitedungcuthethao.controller.quantri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitedungcuthethao.entity.DanhMuc;
import com.websitedungcuthethao.service.impl.DanhMucService;
import com.websitedungcuthethao.validate.DanhMucValidation;

@Controller
@RequestMapping("/quan-tri/danh-muc")
public class QuanLiDanhMucController {
	
	private DanhMuc dM=null;
	@Autowired
	private DanhMucService danhMucService;
	
	@Autowired
	private DanhMucValidation danhMucValidation;
	
	@GetMapping
	public String index(Model model) {
		List<DanhMuc> listDMCha= danhMucService.findAllDanhMucCha();
		List<DanhMuc> listDMCon= danhMucService.findAllDanhMucConById(listDMCha.get(0).getId());
		model.addAttribute("listDMCha", listDMCha);
		model.addAttribute("listDMCon", listDMCon);
		return"quantri/quanlydanhmuc";
	}
	
	
	@PostMapping
	public String locDanhMuc(Model model,@RequestParam Long dmchaID) {
		model.addAttribute("id", dmchaID);
		List<DanhMuc> listDMCha= danhMucService.findAllDanhMucCha();
		List<DanhMuc> listDMCon= danhMucService.findAllDanhMucConById(dmchaID);
		model.addAttribute("listDMCha", listDMCha);
		model.addAttribute("listDMCon", listDMCon);
		return"quantri/quanlydanhmuc";
	}
	
	@GetMapping("/them-danh-muc")
	public String themDanhMuc(Model model) {
		List<DanhMuc> listDMCha= danhMucService.findAllDanhMucCha();
		model.addAttribute("listDMCha", listDMCha);
		model.addAttribute("danhmuc", new DanhMuc());
		return"quantri/themdanhmuc";
	}
	
	@PostMapping("/them-danh-muc")
	public String luuDanhMuc(@ModelAttribute DanhMuc danhmuc,Model model,BindingResult bindingResult) {
		danhMucValidation.validate(danhmuc, bindingResult);
		if(bindingResult.hasErrors()) {
			List<DanhMuc> listDMCha= danhMucService.findAllDanhMucCha();
			model.addAttribute("listDMCha", listDMCha);
			model.addAttribute("danhmuc", danhmuc);
			return "quantri/themdanhmuc";
		}
		danhMucService.themDanhMuc(danhmuc);
		return"redirect:/quan-tri/danh-muc";
	}
	
	@GetMapping("/sua-danh-muc/{id}")
	public String formSuaDanhMuc(Model model,@PathVariable Long id) {
		DanhMuc danhmuc= danhMucService.findOne(id);
		dM=danhmuc;
		model.addAttribute("danhmuc", danhmuc);
		model.addAttribute("id", id);
		List<DanhMuc> listDMCha= danhMucService.findAllDanhMucCha();
		model.addAttribute("listDMCha", listDMCha);
		return"quantri/suadanhmuc";
	}
	
	@PostMapping("/sua-danh-muc/luu-thong-tin")
	public String luuTTDanhMuc(@ModelAttribute DanhMuc danhmuc,Model model,BindingResult bindingResult) {
		danhMucValidation.validate(danhmuc, bindingResult);
		if(bindingResult.hasErrors()) {
			List<DanhMuc> listDMCha= danhMucService.findAllDanhMucCha();
			model.addAttribute("listDMCha", listDMCha);
			model.addAttribute("danhmuc",danhmuc);
			return "quantri/suadanhmuc";
		}
		dM.setTen(danhmuc.getTen());
		dM.setDanhMucCha(danhmuc.getDanhMucCha());
		danhMucService.updateDanhMuc(dM);
		return"redirect:/quan-tri/danh-muc";
	}
	
	
}
