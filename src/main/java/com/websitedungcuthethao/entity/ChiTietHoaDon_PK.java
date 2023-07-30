package com.websitedungcuthethao.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

public class ChiTietHoaDon_PK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long sanpham;
	private Long hoadon;
	
	public ChiTietHoaDon_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon_PK(Long sanpham, Long hoadon) {
		super();
		this.sanpham = sanpham;
		this.hoadon = hoadon;
	}
	public Long getSanpham() {
		return sanpham;
	}
	public void setSanpham(Long sanpham) {
		this.sanpham = sanpham;
	}
	public Long getHoadon() {
		return hoadon;
	}
	public void setHoadon(Long hoadon) {
		this.hoadon = hoadon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoadon == null) ? 0 : hoadon.hashCode());
		result = prime * result + ((sanpham == null) ? 0 : sanpham.hashCode());
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
		ChiTietHoaDon_PK other = (ChiTietHoaDon_PK) obj;
		if (hoadon == null) {
			if (other.hoadon != null)
				return false;
		} else if (!hoadon.equals(other.hoadon))
			return false;
		if (sanpham == null) {
			if (other.sanpham != null)
				return false;
		} else if (!sanpham.equals(other.sanpham))
			return false;
		return true;
	}
	
	
}
