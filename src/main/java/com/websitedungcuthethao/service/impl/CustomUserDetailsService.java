package com.websitedungcuthethao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websitedungcuthethao.constant.SystemConstant;
import com.websitedungcuthethao.dto.NguoiDungDTO;
import com.websitedungcuthethao.entity.LoaiNguoiDung;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.repository.NguoiDungRepository;

@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		NguoiDung nguoiDung= nguoiDungRepository.findOneByTenDangNhapAndTrangThai(username, SystemConstant.ACTIVE_STATUS);
		
		if(nguoiDung ==null) {
			throw new UsernameNotFoundException("Không tim thấy người dùng");
		}
		// put thong tin nguoi dung vao security  vÃ  duy tri dang nhap
		
		LoaiNguoiDung loaiNguoiDung= nguoiDung.getLoainguoidung();

		
		
		List<GrantedAuthority> authorties =new ArrayList<GrantedAuthority>();
		authorties.add(new SimpleGrantedAuthority(loaiNguoiDung.getTenLoai()));
		
		
		NguoiDungDTO nguoiDungDTO= new NguoiDungDTO(nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau(), true, true, true, true, authorties);
		nguoiDungDTO.setFullName(nguoiDung.getHo()+" "+nguoiDung.getTen());
		return nguoiDungDTO;
	}

}
