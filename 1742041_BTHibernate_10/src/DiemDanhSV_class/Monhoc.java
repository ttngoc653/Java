package DiemDanhSV_class;
// Generated Jul 11, 2018 11:12:50 AM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Monhoc generated by hbm2java
 */
@Entity
@Table(name = "monhoc", catalog = "diemdanhsinhvien", uniqueConstraints = @UniqueConstraint(columnNames = "ten_mon_hoc"))
public class Monhoc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maMonHoc;
	private String tenMonHoc;

	public Monhoc() {
	}

	public Monhoc(String maMonHoc, String tenMonHoc) {
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
	}

	@Id

	@Column(name = "ma_mon_hoc", unique = true, nullable = false, length = 8)
	public String getMaMonHoc() {
		return this.maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	@Column(name = "ten_mon_hoc", unique = true, nullable = false, length = 128)
	public String getTenMonHoc() {
		return this.tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

}
