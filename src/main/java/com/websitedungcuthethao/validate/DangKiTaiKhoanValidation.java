 package com.websitedungcuthethao.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitedungcuthethao.dto.NguoiDungDTO;
import com.websitedungcuthethao.dto.NguoiDungDangKyDTO;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.service.impl.NguoiDungService;

@Component
public class DangKiTaiKhoanValidation implements Validator{

	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NguoiDungDangKyDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass()))
			return;
		
		NguoiDungDangKyDTO nguoiDung= (NguoiDungDangKyDTO) target;
		String ho= nguoiDung.getHo();
		if(!ho.matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n" + 
				"fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n" + 
				"UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]{1,}$")) {
			errors.rejectValue("ho", null, "Họ không chứa số");
		}
		
		String ten = nguoiDung.getTen();
		if(!ten.matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n" + 
				"fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n" + 
				"UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]{1,}$")) {
			errors.rejectValue("ten", null, "Tên không chứa số");
		}
		
		String tenDangNhap=nguoiDung.getTenDangNhap();
		if(tenDangNhap.equals("")) {
			errors.rejectValue("tenDangNhap", null, "Không được để trống");
		}
		else {
			List<NguoiDung>listND=nguoiDungService.findAll();
			for (NguoiDung nd : listND) {
				if(tenDangNhap.equals(nd.getTenDangNhap())) {
					errors.rejectValue("tenDangNhap", null, "Tên đăng nhập đã tồn tại");
				}
			}
		}
		
		
		String email= nguoiDung.getEmail();
		if(!email.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")) {
			errors.rejectValue("email", null, "Email không hợp lệ");
		} else {
			List<NguoiDung>listND=nguoiDungService.findAll();
			for (NguoiDung nd : listND) {
				if(email.equals(nd.getEmail())) {
					errors.rejectValue("email", null, "Email đã được sử dụng với tài khoản khác");
				}
			}
		}
		
		String soDienThoai=nguoiDung.getSoDienThoai();
		if(!soDienThoai.matches("^0+[0-9]{9}$")) {
			errors.rejectValue("soDienThoai", null, "Không được để trống và bắt đầu bằng '0' theo sau là 9 chữ số");
		}else {
			List<NguoiDung>listND=nguoiDungService.findAll();
			for (NguoiDung nd : listND) {
				if(soDienThoai.equals(nd.getSoDienThoai())) {
					errors.rejectValue("soDienThoai", null, "Số điện thoại này sử dụng với tài khoản khác");
				}
			}
		}
		
		String matKhau= nguoiDung.getMatKhau();
		if(!matKhau.matches("^[A-Za-z0-9]{6,}$")) {
			errors.rejectValue("matKhau", null, "Mật khẩu ít nhất 6 kí tự!");
		}
		String xacNhanMatKhau= nguoiDung.getXacNhanMatKhau();
		if(!xacNhanMatKhau.equals(matKhau)) {
			errors.rejectValue("xacNhanMatKhau", null, "Mật khẩu xác nhận không trùng với mật khẩu");
		}
	}

}
