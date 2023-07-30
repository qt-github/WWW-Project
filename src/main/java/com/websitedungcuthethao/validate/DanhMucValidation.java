package com.websitedungcuthethao.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitedungcuthethao.entity.DanhMuc;

@Component
public class DanhMucValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return DanhMuc.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return ;
		}
		
		DanhMuc danhMuc= (DanhMuc) target;
		
		String ten= danhMuc.getTen();
		if(ten.equals("")) {
			errors.rejectValue("ten", null, "Tên Danh mục không được để trống");
		}
	}

}
