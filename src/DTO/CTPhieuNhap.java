package DTO;

public class CTPhieuNhap {
	private int mapn, soluong,dongia,thanhtien;
	private String tensach;
	public CTPhieuNhap() {
		
	}
	
	
	public CTPhieuNhap(int mactpn, int mapn, String tensach, int soluong, int dongia, int thanhtien) {
		super();
		
		this.mapn = mapn;
		this.tensach = tensach;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}


	
	public int getMapn() {
		return mapn;
	}


	public void setMapn(int mapn) {
		this.mapn = mapn;
	}


	public String getTensach() {
		return tensach;
	}


	public void setTensach(String tensach) {
		this.tensach = tensach;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public int getDongia() {
		return dongia;
	}


	public void setDongia(int dongia) {
		this.dongia = dongia;
	}


	public int getThanhtien() {
		return thanhtien;
	}


	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}


	
	
	
}
