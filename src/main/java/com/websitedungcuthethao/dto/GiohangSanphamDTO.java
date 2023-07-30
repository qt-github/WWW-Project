package com.websitedungcuthethao.dto;

public class GiohangSanphamDTO {
	private int soLuong;
	private double tongGia;
	private SanPhamDTO sanPham;
	
	
	public GiohangSanphamDTO(int soLuong, double tongGia, SanPhamDTO sanPham) {
		this.soLuong = soLuong;
		this.tongGia = tongGia;
		this.sanPham = sanPham;
	}
	
	
	public GiohangSanphamDTO() {
	}


	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getTongGia() {
		return tongGia;
	}
	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}
	public SanPhamDTO getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPhamDTO sanPham) {
		this.sanPham = sanPham;
	}
	public double getGiaBanThucTe() {
		return this.sanPham.getGia() - this.sanPham.getGia()*this.sanPham.getPhanTramGiamGia()/100;
	}
	
}
