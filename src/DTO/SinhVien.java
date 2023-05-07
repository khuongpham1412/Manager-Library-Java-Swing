package DTO;

public class SinhVien {
	private String masv;
	private String supername,name;
	private String sex;
	private String address;
	public SinhVien() {
		
	}
	public SinhVien(String masv,String supername, String name, String sex, String address) {
		this.masv= masv;
		this.supername=supername;
		this.name= name;
		this.sex= sex;
		this.address= address;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getSupername() {
		return supername;
	}
	public void setSupername(String supername) {
		this.supername = supername;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
