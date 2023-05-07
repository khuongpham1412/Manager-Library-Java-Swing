package DTO;

public class DocGiaDTO {
	private int madg,tuoi,trangthai;
	private String tendg,gioitinh,diachi,sdt;
	public DocGiaDTO() {
		
	}
	public DocGiaDTO(int trangthai,int madg, String tendg, int tuoi, String gioitinh, String diachi, String sdt) {
		super();
		this.madg = madg;
		this.tuoi=tuoi;
		this.tendg = tendg;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.trangthai=trangthai;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public int getMadg() {
		return madg;
	}
	public void setMadg(int madg) {
		this.madg = madg;
	}
	public String getTendg() {
		return tendg;
	}
	public void setTendg(String tendg) {
		this.tendg = tendg;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
