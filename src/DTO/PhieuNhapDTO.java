package DTO;

import java.util.Date;

public class PhieuNhapDTO {
	private String ngaynhap;
	private int mapn,manv,mancc, tongtien;
	public PhieuNhapDTO() {
		
	}
	public PhieuNhapDTO(int mapn, int manv, int mancc, String ngaynhap, int tongtien) {
		this.mapn = mapn;
		this.manv = manv;
		this.mancc = mancc;
		this.ngaynhap = ngaynhap;
		this. tongtien = tongtien;
	}
	public int getMapn() {
		return mapn;
	}
	public void setMapn(int mapn) {
		this.mapn = mapn;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public int getMancc() {
		return mancc;
	}
	public void setMancc(int mancc) {
		this.mancc = mancc;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	@Override
	public String toString() {
		return "PhieuNhap [manv=" + manv + ", mancc=" + mancc + ", ngaynhap=" + ngaynhap + ", mapn=" + mapn
				+ ", tongtien=" + tongtien + "]";
	}
	
}
