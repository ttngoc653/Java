package frmStudentManagement;

public class SinhVien {
	public SinhVien(String code, String name, String layer, String year, String gpa, String address) {
		super();
		this.code = code;
		this.name = name;
		this.layer = layer;
		this.year = year;
		this.gpa = gpa;
		this.address = address;
	}
	
	public SinhVien() {
		super();
		this.code = "";
		this.name = "";
		this.layer = "";
		this.year = "";
		this.gpa = "";
		this.address = "";
	}
	
	private String code;
	private String name;
	private String layer;
	private String year;
	private String gpa;
	private String address;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
