package DTO;

public class KhoSachDTO {
	private int masach,soluong,gia;
	private String tensach;
	public KhoSachDTO() {
		
	}
	public KhoSachDTO(int masach, int gia,  int soluong, String tensach) {
		super();
		this.masach = masach;
		this.gia=gia;
		this.soluong = soluong;
	
		this.tensach = tensach;
		//this.hinhanh = hinhanh;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
//	public String getHinhanh() {
//		return hinhanh;
//	}
//	public void setHinhanh(String hinhanh) {
//		this.hinhanh = hinhanh;
//	}
}
