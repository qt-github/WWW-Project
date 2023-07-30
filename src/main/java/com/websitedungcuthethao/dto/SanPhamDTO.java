package com.websitedungcuthethao.dto;

public class SanPhamDTO {
	private Long id;
	private String ten;
	private String tenDanhMuc;
	private String tenNhaCungCap;
	private String moTa;
	private String thuongHieu;
	private String noiDung;
	private double gia;
	private double phanTramGiamGia;
	private int soLuong;
	private String anhDaiDien;
	private int soLuotXem;
	private int soLuotMua;
	private int thoiGianBaoHanh;
	private boolean trangThai;
	private String nguoiSua;
	private String tenThuoctinh;
	private String giaTriThuocTinh;
	public SanPhamDTO(Long id, String ten, String tenDanhMuc, String tenNhaCungCap, String moTa, String thuongHieu,
			String noiDung, double gia, double phanTramGiamGia, int soLuong, String anhDaiDien, int soLuotXem,
			int soLuotMua, int thoiGianBaoHanh, boolean trangThai, String nguoiSua, String tenThuoctinh,
			String giaTriThuocTinh) {
		super();
		this.id = id;
		this.ten = ten;
		this.tenDanhMuc = tenDanhMuc;
		this.tenNhaCungCap = tenNhaCungCap;
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
		this.nguoiSua = nguoiSua;
		this.tenThuoctinh = tenThuoctinh;
		this.giaTriThuocTinh = giaTriThuocTinh;
	}
	public SanPhamDTO(String ten, String tenDanhMuc, String tenNhaCungCap, String moTa, String thuongHieu,
			String noiDung, double gia, double phanTramGiamGia, int soLuong, String anhDaiDien, int soLuotXem,
			int soLuotMua, int thoiGianBaoHanh, boolean trangThai, String nguoiSua, String tenThuoctinh,
			String giaTriThuocTinh) {
		super();
		this.ten = ten;
		this.tenDanhMuc = tenDanhMuc;
		this.tenNhaCungCap = tenNhaCungCap;
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
		this.nguoiSua = nguoiSua;
		this.tenThuoctinh = tenThuoctinh;
		this.giaTriThuocTinh = giaTriThuocTinh;
	}
	public SanPhamDTO() {
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
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
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
	public String getNguoiSua() {
		return nguoiSua;
	}
	public void setNguoiSua(String nguoiSua) {
		this.nguoiSua = nguoiSua;
	}
	public String getTenThuoctinh() {
		return tenThuoctinh;
	}
	public void setTenThuoctinh(String tenThuoctinh) {
		this.tenThuoctinh = tenThuoctinh;
	}
	public String getGiaTriThuocTinh() {
		return giaTriThuocTinh;
	}
	public void setGiaTriThuocTinh(String giaTriThuocTinh) {
		this.giaTriThuocTinh = giaTriThuocTinh;
	}
	@Override
	public String toString() {
		return "SanPhamDTO [id=" + id + ", ten=" + ten + ", tenDanhMuc=" + tenDanhMuc + ", tenNhaCungCap="
				+ tenNhaCungCap + ", moTa=" + moTa + ", thuongHieu=" + thuongHieu + ", noiDung=" + noiDung + ", gia="
				+ gia + ", phanTramGiamGia=" + phanTramGiamGia + ", soLuong=" + soLuong + ", anhDaiDien=" + anhDaiDien
				+ ", soLuotXem=" + soLuotXem + ", soLuotMua=" + soLuotMua + ", thoiGianBaoHanh=" + thoiGianBaoHanh
				+ ", trangThai=" + trangThai + ", nguoiSua=" + nguoiSua + ", tenThuoctinh=" + tenThuoctinh
				+ ", giaTriThuocTinh=" + giaTriThuocTinh + "]";
	}
	
	
	


	
	
}
	