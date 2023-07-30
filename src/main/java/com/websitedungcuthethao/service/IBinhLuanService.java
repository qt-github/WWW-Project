package com.websitedungcuthethao.service;

import java.time.LocalDate;
import java.util.List;

import com.websitedungcuthethao.entity.BinhLuan;

public interface IBinhLuanService {
	BinhLuan save(BinhLuan binhLuan);
	void deleteById(Long id);
	List<BinhLuan> findBySanPham(Long id);
	
	void themBinhLuan(String anhSanPham, String binhLuan,LocalDate ngayBinhLuan,Long nguoidungID, Long sanphamID);
}
