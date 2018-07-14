package DiemDanhSV_class;
// Generated Jul 11, 2018 11:12:50 AM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BuoihocId generated by hbm2java
 */
@Embeddable
public class BuoihocId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maTkb;
	private Date ngayHoc;
	private Date gioHoc;

	public BuoihocId() {
	}

	public BuoihocId(int maTkb, Date ngayHoc, Date gioHoc) {
		this.maTkb = maTkb;
		this.ngayHoc = ngayHoc;
		this.gioHoc = gioHoc;
	}

	@Column(name = "ma_tkb", nullable = false)
	public int getMaTkb() {
		return this.maTkb;
	}

	public void setMaTkb(int maTkb) {
		this.maTkb = maTkb;
	}

	@Column(name = "ngay_hoc", nullable = false, length = 10)
	public Date getNgayHoc() {
		return this.ngayHoc;
	}

	public void setNgayHoc(Date ngayHoc) {
		this.ngayHoc = ngayHoc;
	}

	@Column(name = "gio_hoc", nullable = false, length = 8)
	public Date getGioHoc() {
		return this.gioHoc;
	}

	public void setGioHoc(Date gioHoc) {
		this.gioHoc = gioHoc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BuoihocId))
			return false;
		BuoihocId castOther = (BuoihocId) other;

		return (this.getMaTkb() == castOther.getMaTkb())
				&& ((this.getNgayHoc() == castOther.getNgayHoc()) || (this.getNgayHoc() != null
						&& castOther.getNgayHoc() != null && this.getNgayHoc().equals(castOther.getNgayHoc())))
				&& ((this.getGioHoc() == castOther.getGioHoc()) || (this.getGioHoc() != null
						&& castOther.getGioHoc() != null && this.getGioHoc().equals(castOther.getGioHoc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMaTkb();
		result = 37 * result + (getNgayHoc() == null ? 0 : this.getNgayHoc().hashCode());
		result = 37 * result + (getGioHoc() == null ? 0 : this.getGioHoc().hashCode());
		return result;
	}

}
