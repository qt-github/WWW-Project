package com.websitedungcuthethao.controller.dangnhap;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.service.impl.NguoiDungService;
import com.websitedungcuthethao.util.SenMail;

@Controller
public class QuenMatKhau {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private SenMail senMail;

	private long ranNum = 0;
	
	private String tdn;

	@RequestMapping(value = "/quen-mat-khau/tim-tai-khoan", method = RequestMethod.GET)
	public ModelAndView timTaiKhoan() {
		return new ModelAndView("doimatkhau/timtaikhoan");
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/quen-mat-khau/tim-tai-khoan/xac-nhan", method = RequestMethod.POST)
	public ModelAndView guiMa(@RequestParam String tenDangNhap) {
		tdn=tenDangNhap;
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung = nguoiDungService.findOneByTenDangNhap(tenDangNhap);
		if (nguoiDung == null) {
			return new ModelAndView("redirect:/quen-mat-khau/tim-tai-khoan");
		}
//		ranNum = ThreadLocalRandom.current().nextLong(100000, 999999);
//		senMail.SenEmail(nguoiDung.getEmail(), "Mã xác nhận đổi mật khẩu", String.valueOf(ranNum));
//		return new ModelAndView("doimatkhau/xacnhanma");
		return new ModelAndView("doimatkhau/doimatkhau_quenmatkhau");
	}
	
//	@RequestMapping(value = "/quen-mat-khau/doi-mat-khau", method = RequestMethod.POST)
//	public  ModelAndView xacNhanMa(@RequestParam String maXN) {
//		long num= Long.parseLong(maXN);
//		if(num!=ranNum) {
//			return new ModelAndView("redirect:/quen-mat-khau/tim-tai-khoan/xac-nhan");
//		}
//		
//		return new ModelAndView("doimatkhau/doimatkhau_quenmatkhau");
//	}
	
	@RequestMapping(value ="/quen-mat-khau/doi-mat-khau/luu-mat-khau", method = RequestMethod.POST)
	public ModelAndView doiMatKhat(@RequestParam String matkhau,@RequestParam String xacnhanmatkhau) {
		if(!matkhau.trim().equals(xacnhanmatkhau.trim())) {
			return new ModelAndView("redirect:/quen-mat-khau/doi-mat-khau");
		}
		
		NguoiDung nguoiDung= nguoiDungService.findOneByTenDangNhap(tdn);
		System.out.println(nguoiDung.getMatKhau());
		nguoiDung.setMatKhau(BCrypt.hashpw(matkhau.trim(),BCrypt.gensalt(12)));
		System.out.println(nguoiDung.getMatKhau());
		nguoiDungService.UpdateNguoiDung(nguoiDung);
		
		return new ModelAndView("redirect:/");
	}
	
}
