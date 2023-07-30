package com.websitedungcuthethao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(GiaTriThuocTinhSanPham_PK.class)
public class GiaTriThuocTinhSanPham {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "sanphamID")
	private SanPham sanpham;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "thuoctinhID")
	private ThuocTinhSanPham thuoctinhsanpham;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String giaTriThuocTinh;

	public GiaTriThuocTinhSanPham(SanPham sanpham, ThuocTinhSanPham thuoctinhsanpham, String giaTriThuocTinh) {
		super();
		this.sanpham = sanpham;
		this.thuoctinhsanpham = thuoctinhsanpham;
		this.giaTriThuocTinh = giaTriThuocTinh;
	}

	public GiaTriThuocTinhSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public ThuocTinhSanPham getThuoctinhsanpham() {
		return thuoctinhsanpham;
	}

	public void setThuoctinhsanpham(ThuocTinhSanPham thuoctinhsanpham) {
		this.thuoctinhsanpham = thuoctinhsanpham;
	}

	public String getGiaTriThuocTinh() {
		return giaTriThuocTinh;
	}

	public void setGiaTriThuocTinh(String giaTriThuocTinh) {
		this.giaTriThuocTinh = giaTriThuocTinh;
	}

	@Override
	public String toString() {
		return "GiaTriThuocTinhSanPham [sanpham=" + sanpham + ", thuoctinhsanpham=" + thuoctinhsanpham
				+ ", giaTriThuocTinh=" + giaTriThuocTinh + "]";
	}
	
	
	
}
