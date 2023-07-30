package com.websitedungcuthethao.controller.dangnhap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DangNhap {
	

	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String index() {
		

		
		return "dangnhap/dangnhap";
	}
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "redirect:/dang-nhap?accessDenied";
	}
	
}
