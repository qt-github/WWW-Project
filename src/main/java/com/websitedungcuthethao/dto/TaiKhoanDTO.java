package com.websitedungcuthethao.dto;

public class TaiKhoanDTO {
	private String tenDangNhap;
	private String matKhau;
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * @param tenDangNhap
	 * @param matKhau
	 */
	public TaiKhoanDTO(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	
	
}
