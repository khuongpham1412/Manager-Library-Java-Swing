package DTO;

import java.util.Date;

public class TheThuVienDTO {
	private int mathetv,madocgia,tinhtrang;
	private Date ngaybd;
	private String ngayhh;
	public TheThuVienDTO() {
		
	}
	public TheThuVienDTO(int mathetv, Date ngaybd, String ngayhh,int madocgia,int tinhtrang) {
		super();
		this.mathetv = mathetv;
		this.ngaybd = ngaybd;
		this.ngayhh = ngayhh;
		this.tinhtrang=tinhtrang;
		
		this.madocgia=madocgia;
	}
	
	public int getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public int getMadocgia() {
		return madocgia;
	}
	public void setMadocgia(int madocgia) {
		this.madocgia = madocgia;
	}
	public int getMathetv() {
		return mathetv;
	}
	public void setMathetv(int mathetv) {
		this.mathetv = mathetv;
	}
	public Date getNgaybd() {
		return ngaybd;
	}
	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}
	public String getNgayhh() {
		return ngayhh;
	}
	public void setNgayhh(String ngayhh) {
		this.ngayhh = ngayhh;
	}
	
}
