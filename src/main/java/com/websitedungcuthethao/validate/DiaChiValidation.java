package com.websitedungcuthethao.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitedungcuthethao.entity.DiaChi;

@Component
public class DiaChiValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return DiaChi.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return;
		}
		
		DiaChi diaChi= (DiaChi) target;
		
		String soNha=diaChi.getSoNha();
		
		if(soNha.equals("")) {
			errors.rejectValue("soNha", null, "Số nhà không được để trống!");
		}
		
		String quan =diaChi.getQuan();
		if(quan.equals("")) {
			errors.rejectValue("quan", null, "Quận/huyện Không được để trông!");
		}
		String tinhTP=diaChi.getTinhTP();
		if(tinhTP.equals("")) {
			errors.rejectValue("tinhTP", null, "Tỉnh/thành phố không được để trống");
		}
	}

}
