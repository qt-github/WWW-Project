package com.websitedungcuthethao.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BinhLuan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nguoidungID")
	private NguoiDung nguoidung;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sanphamID")
	private SanPham sanpham;
	
	@Column(columnDefinition = "Ntext")
	private String binhLuan;

	private String anhSanPham;
	private LocalDate ngayBinhLuan;
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
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public String getBinhLuan() {
		return binhLuan;
	}
	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}
	public String getAnhSanPham() {
		return anhSanPham;
	}
	public void setAnhSanPham(String anhSanPham) {
		this.anhSanPham = anhSanPham;
	}
	public LocalDate getNgayBinhLuan() {
		return ngayBinhLuan;
	}
	public void setNgayBinhLuan(LocalDate ngayBinhLuan) {
		this.ngayBinhLuan = ngayBinhLuan;
	}
	/**
	 * @param nguoidung
	 * @param sanpham
	 * @param binhLuan
	 * @param anhSanPham
	 * @param ngayBinhLuan
	 */
	public BinhLuan(NguoiDung nguoidung, SanPham sanpham, String binhLuan, String anhSanPham, LocalDate ngayBinhLuan) {
		super();
		this.nguoidung = nguoidung;
		this.sanpham = sanpham;
		this.binhLuan = binhLuan;
		this.anhSanPham = anhSanPham;
		this.ngayBinhLuan = ngayBinhLuan;
	}
	public BinhLuan(Long id, NguoiDung nguoidung, SanPham sanpham, String binhLuan, String anhSanPham,
			LocalDate ngayBinhLuan) {
		super();
		this.id = id;
		this.nguoidung = nguoidung;
		this.sanpham = sanpham;
		this.binhLuan = binhLuan;
		this.anhSanPham = anhSanPham;
		this.ngayBinhLuan = ngayBinhLuan;
	}
	@Override
	public String toString() {
		return "BinhLuan [id=" + id + ", nguoidung=" + nguoidung + ", sanpham=" + sanpham + ", binhLuan=" + binhLuan
				+ ", anhSanPham=" + anhSanPham + ", ngayBinhLuan=" + ngayBinhLuan + "]";
	}
	public BinhLuan() {
		super();
	}
	
	
	

}
