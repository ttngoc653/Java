package DiemDanhSV_class;
// Generated Jul 11, 2018 11:12:50 AM by Hibernate Tools 3.5.0.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Diemdanh generated by hbm2java
 */
@Entity
@Table(name = "diemdanh", catalog = "diemdanhsinhvien")
public class Diemdanh implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DiemdanhId id;
	private Boolean daDiHoc;

	public Diemdanh() {
	}

	public Diemdanh(DiemdanhId id) {
		this.id = id;
	}

	public Diemdanh(DiemdanhId id, Boolean daDiHoc) {
		this.id = id;
		this.daDiHoc = daDiHoc;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "maTkb", column = @Column(name = "ma_tkb", nullable = false)),
			@AttributeOverride(name = "ngayHoc", column = @Column(name = "ngay_hoc", nullable = false, length = 10)),
			@AttributeOverride(name = "gioHoc", column = @Column(name = "gio_hoc", nullable = false, length = 8)),
			@AttributeOverride(name = "mssv", column = @Column(name = "mssv", nullable = false, length = 32)) })
	public DiemdanhId getId() {
		return this.id;
	}

	public void setId(DiemdanhId id) {
		this.id = id;
	}

	@Column(name = "da_di_hoc")
	public Boolean getDaDiHoc() {
		return this.daDiHoc;
	}

	public void setDaDiHoc(Boolean daDiHoc) {
		this.daDiHoc = daDiHoc;
	}

}