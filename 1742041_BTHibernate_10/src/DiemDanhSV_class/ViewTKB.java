package DiemDanhSV_class;

import java.util.Date;

public class ViewTKB {
	private String tenMonHoc;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private int thuTrongTuan;
	private Date gioBatDau;
	private Date gioKetThuc;
	private String tenPhongHoc;

	public ViewTKB() {
	}

	public ViewTKB(String tenMonHoc, Date ngayBatDau, int thuTrongTuan, Date gioBatDau, Date gioKetThuc,
			String tenPhongHoc) {
		this.tenMonHoc = tenMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.thuTrongTuan = thuTrongTuan;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
	}

	public ViewTKB(String tenMonHoc, Date ngayBatDau, Date ngayKetThuc, int thuTrongTuan, Date gioBatDau,
			Date gioKetThuc, String tenPhongHoc) {
		this.tenMonHoc = tenMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.thuTrongTuan = thuTrongTuan;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
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

	public int getThuTrongTuan() {
		return this.thuTrongTuan;
	}

	public void setThuTrongTuan(int thuTrongTuan) {
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
