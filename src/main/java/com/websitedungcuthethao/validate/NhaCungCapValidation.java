package com.websitedungcuthethao.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitedungcuthethao.entity.NhaCungCap;

@Component
public class NhaCungCapValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return NhaCungCap.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return;
		}
		
		NhaCungCap nhaCungCap= (NhaCungCap) target;
		
		String tenNhaCungCap =nhaCungCap.getTenNhaCungCap();
		if(tenNhaCungCap.equals("")) {
			errors.rejectValue("tenNhaCungCap", null, "Tên nhà cung cấp không được để trống");
		}
		String soDienThoai= nhaCungCap.getSoDienThoai();
		if(!soDienThoai.matches("^0+[0-9]{9}$") || soDienThoai.equals("")) {
			errors.rejectValue("soDienThoai", null, "Số điện thoại không để trống và phải bắt đầu bằng số 0 mà theo sau 9 chữ số");
		}
		
		String diachi= nhaCungCap.getDiachi();
		if(diachi.equals("")) {
			errors.rejectValue("diachi", null, "Địa chỉ không được để trống");
		}
		
		String email= nhaCungCap.getEmail();
		if(!email.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")|| email.equals("")) {
			errors.rejectValue("email", null, "Email không hợp lệ");
		}
		
	}

}
