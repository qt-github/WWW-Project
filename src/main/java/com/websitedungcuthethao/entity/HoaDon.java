package com.websitedungcuthethao.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class HoaDon{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
	@JoinColumn(name = "nguoidungID", nullable = false)
	private NguoiDung nguoidung;
	
	private boolean trangThai;
	
	private LocalDate ngayDat;
	
	private LocalDate ngayNhanDuKien;
	
	private LocalDate ngayNhan;
	
	private int soLuongSanPham;
	
	private double tongTienHoaDon;
	
	private boolean nguoiDungXacNhan;
	
	public boolean isNguoiDungXacNhan() {
		return nguoiDungXacNhan;
	}


	public void setNguoiDungXacNhan(boolean nguoiDungXacNhan) {
		this.nguoiDungXacNhan = nguoiDungXacNhan;
	}


	@OneToMany(mappedBy = "hoadon")
	private Set<ChiTietHoaDon> dsChiTietHoaDon = new HashSet<ChiTietHoaDon>();


	public HoaDon(Long id, NguoiDung nguoidung, boolean trangThai, LocalDate ngayDat, LocalDate ngayNhanDuKien,
			LocalDate ngayNhan, int soLuongSanPham, double tongTienHoaDon) {
		super();
		this.id = id;
		this.nguoidung = nguoidung;
		this.trangThai = trangThai;
		this.ngayDat = ngayDat;
		this.ngayNhanDuKien = ngayNhanDuKien;
		this.ngayNhan = ngayNhan;
		this.soLuongSanPham = soLuongSanPham;
		this.tongTienHoaDon = tongTienHoaDon;
	}


	public HoaDon(NguoiDung nguoidung, boolean trangThai, LocalDate ngayDat, LocalDate ngayNhanDuKien,
			LocalDate ngayNhan, int soLuongSanPham, double tongTienHoaDon) {
		super();
		this.nguoidung = nguoidung;
		this.trangThai = trangThai;
		this.ngayDat = ngayDat;
		this.ngayNhanDuKien = ngayNhanDuKien;
		this.ngayNhan = ngayNhan;
		this.soLuongSanPham = soLuongSanPham;
		this.tongTienHoaDon = tongTienHoaDon;
	}
	
	


	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public NguoiDung getNguoidung() {
		return nguoidung;
	}


	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}


	public boolean isTrangThai() {
		return trangThai;
	}


	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}


	public LocalDate getNgayDat() {
		return ngayDat;
	}


	public void setNgayDat(LocalDate ngayDat) {
		this.ngayDat = ngayDat;
	}


	public LocalDate getNgayNhanDuKien() {
		return ngayNhanDuKien;
	}


	public void setNgayNhanDuKien(LocalDate ngayNhanDuKien) {
		this.ngayNhanDuKien = ngayNhanDuKien;
	}


	public LocalDate getNgayNhan() {
		return ngayNhan;
	}


	public void setNgayNhan(LocalDate ngayNhan) {
		this.ngayNhan = ngayNhan;
	}


	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}


	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}


	public double getTongTienHoaDon() {
		return tongTienHoaDon;
	}


	public void setTongTienHoaDon(double tongTienHoaDon) {
		this.tongTienHoaDon = tongTienHoaDon;
	}


	public Set<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}


	public void setDsChiTietHoaDon(Set<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}


	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", nguoidung=" + nguoidung + ", trangThai=" + trangThai + ", ngayDat=" + ngayDat
				+ ", ngayNhanDuKien=" + ngayNhanDuKien + ", ngayNhan=" + ngayNhan + ", soLuongSanPham=" + soLuongSanPham
				+ ", tongTienHoaDon=" + tongTienHoaDon + "]";
	}
	
	

	
}
