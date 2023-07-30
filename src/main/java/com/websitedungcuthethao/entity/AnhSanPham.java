package com.websitedungcuthethao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnhSanPham{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String anh;
	
	@ManyToOne
	@JoinColumn(name = "sanphamID", nullable = false)
	private SanPham sanpham;

	public AnhSanPham(Long id, String anh, SanPham sanpham) {
		super();
		this.id = id;
		this.anh = anh;
		this.sanpham = sanpham;
	}

	public AnhSanPham(String anh, SanPham sanpham) {
		super();
		this.anh = anh;
		this.sanpham = sanpham;
	}

	public AnhSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	@Override
	public String toString() {
		return "AnhSanPham [id=" + id + ", anh=" + anh + ", sanpham=" + sanpham + "]";
	}
	
	
	
	
	
}
