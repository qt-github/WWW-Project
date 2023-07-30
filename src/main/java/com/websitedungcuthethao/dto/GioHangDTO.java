package com.websitedungcuthethao.dto;

import java.util.ArrayList;

public class GioHangDTO {
	private ArrayList<GiohangSanphamDTO> cart = new ArrayList<GiohangSanphamDTO>();
	private double tongTienHoaDon;
	public ArrayList<GiohangSanphamDTO> getCart() {
		return cart;
	}
	public void setCart(ArrayList<GiohangSanphamDTO> cart) {
		this.cart = cart;
	}
	public double getTongTienHoaDon() {
		return tongTienHoaDon;
	}
	public void setTongTienHoaDon(double tongTienHoaDon) {
		this.tongTienHoaDon = tongTienHoaDon;
	}
	

}
