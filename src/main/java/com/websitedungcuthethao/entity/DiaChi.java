package com.websitedungcuthethao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DiaChi{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "nguoidungID")
	private NguoiDung nguoidung;
	@Column(columnDefinition = "nvarchar(25)")
	private String soNha;
	@Column(columnDefinition = "nvarchar(25)")
	private String quan;

	
	@Column(columnDefinition = "nvarchar(25)")
	private String tinhTP;

	
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public String getTinhTP() {
		return tinhTP;
	}

	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}

	@Override
	public String toString() {
		return ""+soNha + ", " + quan + ", " + tinhTP ;
	}

	public DiaChi(NguoiDung nguoidung, String soNha, String quan, String tinhTP) {
		super();
		this.nguoidung = nguoidung;
		this.soNha = soNha;
		this.quan = quan;
		this.tinhTP = tinhTP;
	}
	
	
}
