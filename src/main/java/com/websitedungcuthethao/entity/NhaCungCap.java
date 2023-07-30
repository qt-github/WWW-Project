package com.websitedungcuthethao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(50)")
	private String tenNhaCungCap;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String diachi;
	
	private String soDienThoai;
	
	private String email;

	public NhaCungCap(Long id, String tenNhaCungCap, String diachi, String soDienThoai, String email) {
		super();
		this.id = id;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diachi = diachi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public NhaCungCap(String tenNhaCungCap, String diachi, String soDienThoai, String email) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.diachi = diachi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhaCungCap [id=" + id + ", tenNhaCungCap=" + tenNhaCungCap + ", diachi=" + diachi + ", soDienThoai="
				+ soDienThoai + ", email=" + email + "]";
	}
	
	
}
