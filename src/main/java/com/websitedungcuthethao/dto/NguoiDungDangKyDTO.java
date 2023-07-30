package com.websitedungcuthethao.dto;

public class NguoiDungDangKyDTO {
	private String ho;
	private String ten;
	private boolean gioiTinh;
	private String email;
	private String soDienThoai;
	private String tenDangNhap;
	private String matKhau;
	private String xacNhanMatKhau;
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
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
	public String getXacNhanMatKhau() {
		return xacNhanMatKhau;
	}
	public void setXacNhanMatKhau(String xacNhanMatKhau) {
		this.xacNhanMatKhau = xacNhanMatKhau;
	}
	public NguoiDungDangKyDTO() {
		super();
	}
	public NguoiDungDangKyDTO(String ho, String ten, boolean gioiTinh, String email, String soDienThoai,
			String tenDangNhap, String matKhau, String xacNhanMatKhau) {
		super();
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.xacNhanMatKhau = xacNhanMatKhau;
	}
	@Override
	public String toString() {
		return "NguoiDungDangKyDTO [ho=" + ho + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", xacNhanMatKhau=" + xacNhanMatKhau + "]";
	}

}
