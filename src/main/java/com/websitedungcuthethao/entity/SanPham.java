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
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String ten;

	@ManyToOne
	@JoinColumn(name = "danhmucID", nullable = false)
	private DanhMuc danhmuc;

	@ManyToOne
	@JoinColumn(name = "nhacungcapID", nullable = false)
	private NhaCungCap nhacungcap;

	@Column(columnDefinition = "nvarchar(255)")
	private String moTa;

	@Column(columnDefinition = "nvarchar(50)")
	private String thuongHieu;

	@Column(columnDefinition = "Ntext")
	private String noiDung;

	private double gia;

	private double phanTramGiamGia;

	private int soLuong;

	private String anhDaiDien;

	private int soLuotXem;
	
	private int soLuotMua;

	private int thoiGianBaoHanh;

	private boolean trangThai;
	
	private LocalDate ngayTao;
	
	@OneToMany(mappedBy = "sanpham")
	private Set<GiaTriThuocTinhSanPham> dsThuocTinhSanPham = new HashSet<GiaTriThuocTinhSanPham>();

	public SanPham(Long id, String ten, DanhMuc danhmuc, NhaCungCap nhacungcap, String moTa, String thuongHieu,
			String noiDung, double gia, double phanTramGiamGia, int soLuong, String anhDaiDien, int soLuotXem,
			int soLuotMua, int thoiGianBaoHanh, boolean trangThai, LocalDate ngayTao) {
		super();
		this.id = id;
		this.ten = ten;
		this.danhmuc = danhmuc;
		this.nhacungcap = nhacungcap;
		this.moTa = moTa;
		this.thuongHieu = thuongHieu;
		this.noiDung = noiDung;
		this.gia = gia;
		this.phanTramGiamGia = phanTramGiamGia;
		this.soLuong = soLuong;
		this.anhDaiDien = anhDaiDien;
		this.soLuotXem = soLuotXem;
		this.soLuotMua = soLuotMua;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
	}

	public SanPham(String ten, DanhMuc danhmuc, NhaCungCap nhacungcap, String moTa, String thuongHieu, String noiDung,
			double gia, double phanTramGiamGia, int soLuong, String anhDaiDien, int soLuotXem, int soLuotMua,
			int thoiGianBaoHanh, boolean trangThai, LocalDate ngayTao) {
		super();
		this.ten = ten;
		this.danhmuc = danhmuc;
		this.nhacungcap = nhacungcap;
		this.moTa = moTa;
		this.thuongHieu = thuongHieu;
		this.noiDung = noiDung;
		this.gia = gia;
		this.phanTramGiamGia = phanTramGiamGia;
		this.soLuong = soLuong;
		this.anhDaiDien = anhDaiDien;
		this.soLuotXem = soLuotXem;
		this.soLuotMua = soLuotMua;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public DanhMuc getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public NhaCungCap getNhacungcap() {
		return nhacungcap;
	}

	public void setNhacungcap(NhaCungCap nhacungcap) {
		this.nhacungcap = nhacungcap;
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

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public double getPhanTramGiamGia() {
		return phanTramGiamGia;
	}

	public void setPhanTramGiamGia(double phanTramGiamGia) {
		this.phanTramGiamGia = phanTramGiamGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public int getSoLuotXem() {
		return soLuotXem;
	}

	public void setSoLuotXem(int soLuotXem) {
		this.soLuotXem = soLuotXem;
	}

	public int getSoLuotMua() {
		return soLuotMua;
	}

	public void setSoLuotMua(int soLuotMua) {
		this.soLuotMua = soLuotMua;
	}

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Set<GiaTriThuocTinhSanPham> getDsThuocTinhSanPham() {
		return dsThuocTinhSanPham;
	}

	public void setDsThuocTinhSanPham(Set<GiaTriThuocTinhSanPham> dsThuocTinhSanPham) {
		this.dsThuocTinhSanPham = dsThuocTinhSanPham;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", ten=" + ten + ", danhmuc=" + danhmuc + ", nhacungcap=" + nhacungcap + ", moTa="
				+ moTa + ", thuongHieu=" + thuongHieu + ", noiDung=" + noiDung + ", gia=" + gia + ", phanTramGiamGia="
				+ phanTramGiamGia + ", soLuong=" + soLuong + ", anhDaiDien=" + anhDaiDien + ", soLuotXem=" + soLuotXem
				+ ", soLuotMua=" + soLuotMua + ", thoiGianBaoHanh=" + thoiGianBaoHanh + ", trangThai=" + trangThai
				+ ", ngayTao=" + ngayTao + "]";
	}



}