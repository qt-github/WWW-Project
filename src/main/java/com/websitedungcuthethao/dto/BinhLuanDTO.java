package com.websitedungcuthethao.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class BinhLuanDTO {
	private CommonsMultipartFile anhSanPham;
	private Long idSanPham;
	private String binhLuan;
	public CommonsMultipartFile getAnhSanPham() {
		return anhSanPham;
	}
	public void setAnhSanPham(CommonsMultipartFile anhSanPham) {
		this.anhSanPham = anhSanPham;
	}
	public Long getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(Long idSanPham) {
		this.idSanPham = idSanPham;
	}
	public String getBinhLuan() {
		return binhLuan;
	}
	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}
	public BinhLuanDTO(CommonsMultipartFile anhSanPham, Long idSanPham, String binhLuan) {
		super();
		this.anhSanPham = anhSanPham;
		this.idSanPham = idSanPham;
		this.binhLuan = binhLuan;
	}
	public BinhLuanDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BinhLuanDTO [anhSanPham=" + anhSanPham + ", idSanPham=" + idSanPham + ", binhLuan=" + binhLuan + "]";
	}
	
	
	
}
