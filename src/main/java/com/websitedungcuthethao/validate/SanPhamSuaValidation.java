package com.websitedungcuthethao.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.websitedungcuthethao.dto.ThemSanPhamDTO;

@Component
public class SanPhamSuaValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ThemSanPhamDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass()))
			return ;
		
		ThemSanPhamDTO sanPham= (ThemSanPhamDTO) target;
		
		String ten=sanPham.getTen();
		if(ten.equals("")) {
			errors.rejectValue("ten", null, "Tên sản phẩm không được để trống");
		}
		
		CommonsMultipartFile anhDaiDien=sanPham.getAnhDaiDien();
		
		if(anhDaiDien.getOriginalFilename().equals("")) {
			errors.rejectValue("anhDaiDien", null, "Chưa chọn ảnh đại diện");
		}
		
		
		try {
			double gia= Double.parseDouble( sanPham.getGia());
			if(gia<0) {
				errors.rejectValue("gia", null, "Giá sản phẩm phải lớn hơn 0");
			}
		} catch (Exception e) {
			errors.rejectValue("gia", null, "Giá sản phẩm phải là chữ số");
		}
		String moTa=sanPham.getMoTa();
		if(moTa.equals("")) {
			errors.rejectValue("moTa", null, "Mô tả sản phẩm không được để trống");
		}
		String noiDung=sanPham.getNoiDung();
		if(noiDung.equals("")) {
			errors.rejectValue("noiDung", null, "Nội dung sản phẩm không được để trống");
		}
		
		try {
			double phanTramGiamGia= Double.parseDouble(sanPham.getPhanTramGiamGia());
			if(phanTramGiamGia<0 || phanTramGiamGia>100) {
				errors.rejectValue("phanTramGiamGia", null, "phầm trăm giảm giá sản phẩm phải là lớn hơn 0 và nhỏ hơn 100");
			}
		} catch (Exception e) {
			errors.rejectValue("phanTramGiamGia", null, "phầm trăm giảm giá sản phẩm phải là chữ số");
		}
		
		try {
			int thoiGianBaoHanh= Integer.parseInt(sanPham.getThoiGianBaoHanh());
			if(thoiGianBaoHanh<0) {
				errors.rejectValue("thoiGianBaoHanh", null, "thời gian bảo hành sản phẩm phải lớn hơn 0");
			}
		} catch (Exception e) {
			errors.rejectValue("thoiGianBaoHanh", null, "thời gian bảo hành sản phẩm phải là chữ số");
		}
		
		String thuongHieu=sanPham.getThuongHieu();
		if(thuongHieu.equals("")) {
			errors.rejectValue("thuongHieu", null, "Thương hiệu sản phẩm không được để trống");
		}
		
	}

}