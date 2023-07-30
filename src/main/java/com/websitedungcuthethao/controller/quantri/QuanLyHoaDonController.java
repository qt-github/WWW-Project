package com.websitedungcuthethao.controller.quantri;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitedungcuthethao.constant.SystemConstant;
import com.websitedungcuthethao.dto.AbstractDTO;
import com.websitedungcuthethao.entity.ChiTietHoaDon;
import com.websitedungcuthethao.entity.HoaDon;
import com.websitedungcuthethao.entity.NguoiDung;
import com.websitedungcuthethao.entity.SanPham;
import com.websitedungcuthethao.service.impl.ChiTietHoaDonService;
import com.websitedungcuthethao.service.impl.HoaDonService;
import com.websitedungcuthethao.service.impl.NguoiDungService;
import com.websitedungcuthethao.service.impl.SanPhamService;
import com.websitedungcuthethao.util.SenMail;

@Controller
@RequestMapping("/quan-tri/quan-ly-hoa-don")
public class QuanLyHoaDonController {
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	private SenMail senMail;

	
	
	@GetMapping
	public String index(Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		
		
		Pageable pageable=new PageRequest(page -1, limit, Direction.DESC,"ngayDat");
		List<HoaDon> dsHD= hoaDonService.findAllByTrangThaiAndPaging(SystemConstant.ACTIVE_STATUS, pageable);
		dsHD.forEach(t->{
			
		});
		abstractDTO.setTotalItem(hoaDonService.getTotalItem());
		abstractDTO.setLimit(limit);
		
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsHD", dsHD);
		
		
		return"quantri/quanlyhoadon";
	}
	
	
	@GetMapping("/xem-chi-tiet/{id}")
	public String chitietHoaDon(Model model,@PathVariable Long id) {
		List<SanPham> listSanPham= new ArrayList<SanPham>();
		System.out.println(id);
		HoaDon hoaDon=hoaDonService.findById(id);
		List<ChiTietHoaDon> listCT=chiTietHoaDonService.findByMaHoaDon(id);
		NguoiDung nguoiDung=nguoiDungService.findById(hoaDon.getNguoidung().getId());
		System.out.println(listCT);
		for (ChiTietHoaDon ct : listCT) {
			System.out.println(ct.getSanpham().getId());
			Long idSP=ct.getSanpham().getId();
			SanPham sanPham= sanPhamService.findById(idSP);
			System.out.println(sanPham);
			listSanPham.add(sanPham);
		}
		model.addAttribute("hoaDon", hoaDon);
		model.addAttribute("listCT", listCT);
		model.addAttribute("nguoiDung", nguoiDung);
		model.addAttribute("listSP", listSanPham);
		return "quantri/chitiethoadon";
	}
	
	
	@GetMapping("/xem-chi-tiet-chua-xac-nhan/{id}")
	public String chitietHoaDonChuaXacNhan(Model model,@PathVariable Long id) {
		List<SanPham> listSanPham= new ArrayList<SanPham>();
		HoaDon hoaDon=hoaDonService.findById(id);
		List<ChiTietHoaDon> listCT=chiTietHoaDonService.findByMaHoaDon(id);
		NguoiDung nguoiDung=nguoiDungService.findById(hoaDon.getNguoidung().getId());
		System.out.println(listCT);
		for (ChiTietHoaDon ct : listCT) {
			System.out.println(ct.getSanpham().getId());
			Long idSP=ct.getSanpham().getId();
			SanPham sanPham= sanPhamService.findById(idSP);
			System.out.println(sanPham);
			listSanPham.add(sanPham);
		}
		model.addAttribute("hoaDon", hoaDon);
		model.addAttribute("listCT", listCT);
		model.addAttribute("nguoiDung", nguoiDung);
		model.addAttribute("listSP", listSanPham);
		return "quantri/chitietdonhangchuaxacnhan";
	}
	
	@GetMapping("/don-hang-chua-xac-nhan")
	public String donHangChuaXacNhan(Model model, @RequestParam("page") int page,@RequestParam("limit") int limit) {
		
		AbstractDTO abstractDTO= new AbstractDTO();
		abstractDTO.setPage(page);
		abstractDTO.setLimit(limit);
		Pageable pageable=new PageRequest(page -1, limit);
		List<HoaDon> dsHD= hoaDonService.findAllByTrangThaiAndPaging(SystemConstant.INACTIVE_STATUS, pageable);
		abstractDTO.setTotalItem(hoaDonService.getTotalItem());
		abstractDTO.setLimit(limit);
		abstractDTO.setTotalPage((int) Math.ceil(abstractDTO.getTotalItem()/abstractDTO.getLimit())+1);
		model.addAttribute("abstractDTO",abstractDTO);
		model.addAttribute("dsHD", dsHD);
		return"quantri/quanlydonhangchuaxacnhan";
	}
	@GetMapping("don-hang-chua-xac-nhan/xac-nhan/{id}")
	public String xacNhanDonHang(@PathVariable Long id) {
		System.out.println(id);
		try {
//			HoaDon hoaDon= hoaDonService.findById(id);
//			NguoiDung nguoiDung=nguoiDungService.findById(hoaDon.getNguoidung().getId());
//			senMail.SenEmail(nguoiDung.getEmail(),
//					"Xac nhan don hang","Don hang cua ban da duoc xac nhan và dang trong qua trinh van chuyen vui long xem cac thong tin duoi day:"+"\n"+"Tong tien:"+hoaDon.getTongTienHoaDon()+" VNĐ"+"\n"+"Ngay nhan du kien:"+hoaDon.getNgayNhanDuKien()+"\n"+"Xin chan thanh cam on su ung ho qua ban."+"\n"+"Moi chi tiet vui long lien he:0702074032");
			
			hoaDonService.setTrangThaiHoaDon(id, SystemConstant.ACTIVE_STATUS);
			
		} catch (Exception e) {
		}
		return"redirect:/quan-tri/quan-ly-hoa-don/don-hang-chua-xac-nhan?page=1&limit=6";
	}
	
	
	@GetMapping("don-hang-chua-xac-nhan/tu-choi/{id}")
	public String tuChoiDonHang(@PathVariable Long id) {

		try {
			List<ChiTietHoaDon>list= chiTietHoaDonService.findByMaHoaDon(id);
			list.forEach(cthd-> {
				int soLuongSanPhamDatHang = cthd.getSoLuong();
//				phục hồi lại số lượng sản phẩm
				SanPham p = cthd.getSanpham();
				p.setSoLuong(p.getSoLuong() + soLuongSanPhamDatHang);
				sanPhamService.save(p);
			});
			
//			xoa hoa don + xoa ds cthd
			HoaDon hoaDon= hoaDonService.findById(id);
			hoaDonService.deleteHoaDon(hoaDon);
			
			
//			NguoiDung nguoiDung= nguoiDungService.findById(hoaDon.getNguoidung().getId());
//			gui mai cho khach hang
//			senMail.SenEmail(nguoiDung.getEmail(),
//					"Thong bao huy don dat hang",
//					"Vi mot so li do don hang cua ban da bi huy. Chung toi chan thanh xin loi vi su bat tien nay."+"\n"+"hay truy cap vao website: http://localhost:8080/website-dungcuthethao/  cua chung toi de tiep tuc mua sap"+"\n moi chi tiet vui long lien he: 0702704302");
			
			
		} catch (Exception e) {
		}
		return"redirect:/quan-tri/quan-ly-hoa-don/don-hang-chua-xac-nhan?page=1&limit=6";
	}
}
