package com.websitedungcuthethao.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.websitedungcuthethao.entity.DiaChi;

public class NguoiDungDTONew {

	private Long id;

	private LocalDate ngayTao;

	private Long loainguoidungID;

	private String ho;

	private String ten;

	private boolean gioiTinh;
	
	private LocalDate ngaySinh;

	private String email;

	private String soDienThoai;

	private String tenDangNhap;

	private String matKhau;
	
	private boolean trangThai;

	Set<DiaChi> dsDiaChi = new HashSet<DiaChi>();

	public NguoiDungDTONew(Long id, LocalDate ngayTao, Long loainguoidungID, String ho, String ten, boolean gioiTinh,
			LocalDate ngaySinh, String email, String soDienThoai, String tenDangNhap, String matKhau, boolean trangThai
		) {
		super();
		this.id = id;
		this.ngayTao = ngayTao;
		this.loainguoidungID = loainguoidungID;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
	}

	public NguoiDungDTONew(LocalDate ngayTao, Long loainguoidungID, String ho, String ten, boolean gioiTinh,
			LocalDate ngaySinh, String email, String soDienThoai, String tenDangNhap, String matKhau,
			boolean trangThai) {
		super();
		this.ngayTao = ngayTao;
		this.loainguoidungID = loainguoidungID;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
	}
	

	public NguoiDungDTONew() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Long getLoainguoidungID() {
		return loainguoidungID;
	}

	public void setLoainguoidungID(Long loainguoidungID) {
		this.loainguoidungID = loainguoidungID;
	}

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

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
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

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Set<DiaChi> getDsDiaChi() {
		return dsDiaChi;
	}

	public void setDsDiaChi(Set<DiaChi> dsDiaChi) {
		this.dsDiaChi = dsDiaChi;
	}

	@Override
	public String toString() {
		return "NguoiDungDTONew [id=" + id + ", ngayTao=" + ngayTao + ", loainguoidungID=" + loainguoidungID + ", ho="
				+ ho + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", trangThai=" + trangThai + "]";
	}
	

}
