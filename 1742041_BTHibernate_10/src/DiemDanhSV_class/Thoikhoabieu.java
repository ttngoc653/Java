package DiemDanhSV_class;
// Generated Jul 11, 2018 11:12:50 AM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Thoikhoabieu generated by hbm2java
 */
@Entity
@Table(name = "thoikhoabieu", catalog = "diemdanhsinhvien", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ten_phong_hoc", "gio_bat_dau", "ngay_bat_dau", "thu_trong_tuan" }))
public class Thoikhoabieu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8264597318414427657L;
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

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma_tkb", unique = true, nullable = false)
	public Integer getMaTkb() {
		return this.maTkb;
	}

	public void setMaTkb(Integer maTkb) {
		this.maTkb = maTkb;
	}

	@Column(name = "ma_mon_hoc", nullable = false, length = 8)
	public String getMaMonHoc() {
		return this.maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_bat_dau", nullable = false, length = 10)
	public Date getNgayBatDau() {
		return this.ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_ket_thuc", length = 10)
	public Date getNgayKetThuc() {
		return this.ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Column(name = "thu_trong_tuan", nullable = false)
	public int getThuTrongTuan() {
		return this.thuTrongTuan;
	}

	public void setThuTrongTuan(int thuTrongTuan) {
		this.thuTrongTuan = thuTrongTuan;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "gio_bat_dau", nullable = false, length = 8)
	public Date getGioBatDau() {
		return this.gioBatDau;
	}

	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "gio_ket_thuc", nullable = false, length = 8)
	public Date getGioKetThuc() {
		return this.gioKetThuc;
	}

	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	@Column(name = "ten_phong_hoc", nullable = false, length = 32)
	public String getTenPhongHoc() {
		return this.tenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}

}
