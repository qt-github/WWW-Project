package com.websitedungcuthethao.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ThemSanPhamDTO {
	private String ten;
	private String tenDanhMuc;
	private String tenNhaCungCap;
	private String moTa;
	private String thuongHieu;
	private String noiDung;
	private String gia;
	private String phanTramGiamGia;
	private String soLuong;
	private CommonsMultipartFile anhDaiDien;
	private String thoiGianBaoHanh;
	private String tenThuocTinh;
	private String giaTriThuocTinh;
	public ThemSanPhamDTO(String ten, String tenDanhMuc, String tenNhaCungCap, String moTa, String thuongHieu,
			String noiDung, String gia, String soLuong, CommonsMultipartFile anhDaiDien, String thoiGianBaoHanh, String phanTramGiamGia
			) {
		super();
		this.ten = ten;
		this.tenDanhMuc = tenDanhMuc;
		this.tenNhaCungCap = tenNhaCungCap;
		this.moTa = moTa;
		this.thuongHieu = thuongHieu;
		this.noiDung = noiDung;
		this.gia = gia;
		this.soLuong = soLuong;
		this.anhDaiDien = anhDaiDien;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.phanTramGiamGia = phanTramGiamGia;
	}
	public ThemSanPhamDTO(String ten, String tenDanhMuc, String tenNhaCungCap, String moTa, String thuongHieu,
			String noiDung, String gia, String soLuong, String thoiGianBaoHanh, String phanTramGiamGia
			) {
		super();
		this.ten = ten;
		this.tenDanhMuc = tenDanhMuc;
		this.tenNhaCungCap = tenNhaCungCap;
		this.moTa = moTa;
		this.thuongHieu = thuongHieu;
		this.noiDung = noiDung;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.phanTramGiamGia = phanTramGiamGia;
	}
	public ThemSanPhamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public CommonsMultipartFile getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(CommonsMultipartFile anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public String getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public String getTenThuocTinh() {
		return tenThuocTinh;
	}
	public void setTenThuocTinh(String tenThuocTinh) {
		this.tenThuocTinh = tenThuocTinh;
	}
	public String getGiaTriThuocTinh() {
		return giaTriThuocTinh;
	}
	public void setGiaTriThuocTinh(String giaTriThuocTinh) {
		this.giaTriThuocTinh = giaTriThuocTinh;
	}
	
	public String getPhanTramGiamGia() {
		return phanTramGiamGia;
	}
	public void setPhanTramGiamGia(String phanTramGiamGia) {
		this.phanTramGiamGia = phanTramGiamGia;
	}
	@Override
	public String toString() {
		return "ThemSanPhamDTO [ten=" + ten + ", tenDanhMuc=" + tenDanhMuc + ", tenNhaCungCap=" + tenNhaCungCap
				+ ", moTa=" + moTa + ", thuongHieu=" + thuongHieu + ", noiDung=" + noiDung + ", gia=" + gia
				+ ", soLuong=" + soLuong + ", anhDaiDien=" + anhDaiDien + ", thoiGianBaoHanh=" + thoiGianBaoHanh
				+ ", tenThuocTinh=" + tenThuocTinh + ", giaTriThuocTinh=" + giaTriThuocTinh + "]";
	}
	public ThemSanPhamDTO(String ten, String moTa, String thuongHieu, String noiDung, String gia,
			String phanTramGiamGia, String thoiGianBaoHanh) {
		super();
		this.ten = ten;
		this.moTa = moTa;
		this.thuongHieu = thuongHieu;
		this.noiDung = noiDung;
		this.gia = gia;
		this.phanTramGiamGia = phanTramGiamGia;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
}
