package DiemDanhSV_class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewTKB {
	private String tenMonHoc;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private String thuTrongTuan;
	private Date gioBatDau;
	private Date gioKetThuc;
	private String tenPhongHoc;

	public ViewTKB() {
	}

	public ViewTKB(String tenMonHoc, Date ngayBatDau, int thuTrongTuan, Date gioBatDau, Date gioKetThuc,
			String tenPhongHoc) {
		this.tenMonHoc = tenMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.thuTrongTuan = convertThuTrongTuan(thuTrongTuan);
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
	}

	public ViewTKB(String tenMonHoc, Date ngayBatDau, Date ngayKetThuc, int maThuTrongTuan, Date gioBatDau,
			Date gioKetThuc, String tenPhongHoc) {
		this.tenMonHoc = tenMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.thuTrongTuan = convertThuTrongTuan(maThuTrongTuan);
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
	}
	
	public ViewTKB(String maMonHoc, Date ngayBatDau, Date ngayKetThuc, String thuTrongTuan, Date gioBatDau,
			Date gioKetThuc, String tenPhongHoc) {
		this.tenMonHoc = maMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.thuTrongTuan = thuTrongTuan;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
	}
	
	public ViewTKB(String maMonHoc, String ngayBatDau, String ngayKetThuc, String thuTrongTuan, String gioBatDau,
			String gioKetThuc, String tenPhongHoc) throws ParseException {
		this.tenMonHoc = maMonHoc;
		this.ngayBatDau = new SimpleDateFormat("dd/MM/yyyy").parse(ngayBatDau);
		this.ngayKetThuc = new SimpleDateFormat("dd/MM/yyyy").parse(ngayKetThuc);
		this.thuTrongTuan = thuTrongTuan;
		this.gioBatDau = new SimpleDateFormat("HH:mm").parse(gioBatDau);
		this.gioKetThuc = new SimpleDateFormat("HH:mm").parse(gioKetThuc);
		this.tenPhongHoc = tenPhongHoc;
	}
	
	public static String convertThuTrongTuan(int i_thu_trong_tuan) {
		switch (i_thu_trong_tuan) {
		case 1:	return "Chủ nhật";
		case 2: return "Thứ hai";
		case 3: return "Thứ ba";
		case 4: return "Thứ tư";
		case 5: return "Thứ năm";
		case 6: return "Thứ sáu";
		case 7: return "Thứ bảy";
		default:
			return "";
		}
	}

	public String getTenMonHoc() {
		return this.tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public Date getNgayBatDau() {
		return this.ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return this.ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getThuTrongTuan() {
		return this.thuTrongTuan;
	}

	public void setThuTrongTuan(String thuTrongTuan) {
		this.thuTrongTuan = thuTrongTuan;
	}

	public Date getGioBatDau() {
		return this.gioBatDau;
	}

	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public Date getGioKetThuc() {
		return this.gioKetThuc;
	}

	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	public String getTenPhongHoc() {
		return this.tenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}

}
