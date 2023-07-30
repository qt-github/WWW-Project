package com.websitedungcuthethao.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate ngayTao;
	
	@ManyToOne
	@JoinColumn(name = "loainguoidungID")
	private LoaiNguoiDung loainguoidung;

	@Column(columnDefinition = "nvarchar(50)")
	private String ho;

	@Column(columnDefinition = "nvarchar(50)")
	private String ten;

	private boolean gioiTinh;


	private String email;

	private String soDienThoai;

	private String tenDangNhap;

	private String matKhau;
	
	private boolean trangThai;

	@OneToMany(mappedBy = "nguoidung")
	Set<DiaChi> dsDiaChi = new HashSet<DiaChi>();

	public NguoiDung(Long id, LocalDate ngayTao, LoaiNguoiDung loainguoidung, String ho, String ten, boolean gioiTinh,
			 String email, String soDienThoai, String tenDangNhap, String matKhau, boolean trangThai,
			Set<DiaChi> dsDiaChi) {
		super();
		this.id = id;
		this.ngayTao = ngayTao;
		this.loainguoidung = loainguoidung;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;

		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.dsDiaChi = dsDiaChi;
	}

	public NguoiDung(LocalDate ngayTao, LoaiNguoiDung loainguoidung, String ho, String ten, boolean gioiTinh,
			 String email, String soDienThoai, String tenDangNhap, String matKhau, boolean trangThai,
			Set<DiaChi> dsDiaChi) {
		super();
		this.ngayTao = ngayTao;
		this.loainguoidung = loainguoidung;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.dsDiaChi = dsDiaChi;
	}

	public NguoiDung() {
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

	public LoaiNguoiDung getLoainguoidung() {
		return loainguoidung;
	}

	public void setLoainguoidung(LoaiNguoiDung loainguoidung) {
		this.loainguoidung = loainguoidung;
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
		return "NguoiDung [id=" + id + ", ngayTao=" + ngayTao + ", loainguoidung=" + loainguoidung + ", ho=" + ho
				+ ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", email=" + email
				+ ", soDienThoai=" + soDienThoai + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", trangThai=" + trangThai + "]";
	}

		
	
}
