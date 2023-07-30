package com.websitedungcuthethao.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.websitedungcuthethao.dto.ThemSanPhamDTO;


@Component
public class SanPhamThemValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ThemSanPhamDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass()))
			return;
		
		ThemSanPhamDTO sanPhamDTO=(ThemSanPhamDTO) target;
		
		String ten=sanPhamDTO.getTen();
		if(ten.equals("")) {
			errors.rejectValue("ten", null, "Không được để trống");
		}
		
		CommonsMultipartFile anhDaiDien=sanPhamDTO.getAnhDaiDien();
		
		if(anhDaiDien.getOriginalFilename().equals("")) {
			errors.rejectValue("anhDaiDien", null, "Chưa chọn ảnh");
		}
		
		
		try {
			double gia=Double.parseDouble(sanPhamDTO.getGia());
			if(gia<0) {
				errors.rejectValue("gia", null, "Giá phải lớn hơn 0");
			}
		} catch (Exception e) {
			errors.rejectValue("gia", null, "Giá phải là chữ số");
		}
		String moTa=sanPhamDTO.getMoTa();
		if(moTa.equals("")) {
			errors.rejectValue("moTa", null, "Không được để trống");
		}
		String noiDung=sanPhamDTO.getNoiDung();
		if(noiDung.equals("")) {
			errors.rejectValue("noiDung", null, "Không được để trống");
		}
		
		try {
			int soLuong=Integer.parseInt(sanPhamDTO.getSoLuong());
			if(soLuong<0) {
				errors.rejectValue("soLuong", null, "Số lượng phải lớn hơn hoặc bằng  0");
			}
		} catch (Exception e) {
			errors.rejectValue("soLuong", null, "Không hợp lệ");
		}
		
		try {
			int thoiGianBaoHanh=Integer.parseInt(sanPhamDTO.getThoiGianBaoHanh());
			if(thoiGianBaoHanh<0) {
				errors.rejectValue("thoiGianBaoHanh", null, "Thời gian phải lớn hơn hoặc bằng 0");
			}
		} catch (Exception e) {
			errors.rejectValue("thoiGianBaoHanh", null, "Không hợp lệ");
		}
		
		String thuongHieu=sanPhamDTO.getThuongHieu();
		if(thuongHieu.equals("")) {
			errors.rejectValue("thuongHieu", null, "Không được để trống");
		}
		
	
		
//		String giaTriThuocTinh=sanPhamDTO.getGiaTriThuocTinh();
//		if(giaTriThuocTinh.equals("")) {
//			errors.rejectValue("giaTriThuocTinh", null, "GiÃ¡ trá»‹ thuá»™c tÃ­nh sáº£n pháº©m khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		}
//		
//		String thuongHieu=sanPhamDTO.getThuongHieu();
//		if(giaTriThuocTinh.equals("")) {
//			errors.rejectValue("thuongHieu", null, "ThÆ°Æ¡ng hiá»‡u sáº£n pháº©m khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		}
	}

}
