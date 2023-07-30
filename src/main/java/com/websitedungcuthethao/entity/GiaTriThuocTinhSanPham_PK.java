package com.websitedungcuthethao.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class GiaTriThuocTinhSanPham_PK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long sanpham;
	private Long thuoctinhsanpham;
	
	public GiaTriThuocTinhSanPham_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiaTriThuocTinhSanPham_PK(Long sanpham, Long thuoctinhsanpham) {
		super();
		this.sanpham = sanpham;
		this.thuoctinhsanpham = thuoctinhsanpham;
	}
	public Long getSanpham() {
		return sanpham;
	}
	public void setSanpham(Long sanpham) {
		this.sanpham = sanpham;
	}
	public Long getThuoctinhsanpham() {
		return thuoctinhsanpham;
	}
	public void setThuoctinhsanpham(Long thuoctinhsanpham) {
		this.thuoctinhsanpham = thuoctinhsanpham;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sanpham == null) ? 0 : sanpham.hashCode());
		result = prime * result + ((thuoctinhsanpham == null) ? 0 : thuoctinhsanpham.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaTriThuocTinhSanPham_PK other = (GiaTriThuocTinhSanPham_PK) obj;
		if (sanpham == null) {
			if (other.sanpham != null)
				return false;
		} else if (!sanpham.equals(other.sanpham))
			return false;
		if (thuoctinhsanpham == null) {
			if (other.thuoctinhsanpham != null)
				return false;
		} else if (!thuoctinhsanpham.equals(other.thuoctinhsanpham))
			return false;
		return true;
	}
	
	
	
}
