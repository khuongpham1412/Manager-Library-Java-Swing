package DTO;

public class danhsachphieunhapDTO {
	private int masach,soluong;
	public danhsachphieunhapDTO() {
		
	}
	public danhsachphieunhapDTO(int masach, int soluong) {
		super();
		this.masach = masach;
		this.soluong = soluong;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
