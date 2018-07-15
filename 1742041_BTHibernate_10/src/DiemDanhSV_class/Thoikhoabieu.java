package DiemDanhSV_class;

// default package
// Generated Jul 15, 2018 7:18:40 PM by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * Thoikhoabieu generated by hbm2java
 */
public class Thoikhoabieu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer maTkb;
	private String maMonHoc;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private int thuTrongTuan;
	private Date gioBatDau;
	private Date gioKetThuc;
	private String tenPhongHoc;

	public Thoikhoabieu() {
	}

	public Thoikhoabieu(String maMonHoc, Date ngayBatDau, int thuTrongTuan, Date gioBatDau, Date gioKetThuc,
			String tenPhongHoc) {
		this.maMonHoc = maMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.thuTrongTuan = thuTrongTuan;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
	}

	public Thoikhoabieu(String maMonHoc, Date ngayBatDau, Date ngayKetThuc, int thuTrongTuan, Date gioBatDau,
			Date gioKetThuc, String tenPhongHoc) {
		this.maMonHoc = maMonHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.thuTrongTuan = thuTrongTuan;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.tenPhongHoc = tenPhongHoc;
	}

	public Integer getMaTkb() {
		return this.maTkb;
	}

	public void setMaTkb(Integer maTkb) {
		this.maTkb = maTkb;
	}

	public String getMaMonHoc() {
		return this.maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
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
