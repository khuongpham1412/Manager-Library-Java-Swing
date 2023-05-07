package DTO;

public class NhanVienDTO {
	private int manv,tuoi,matk,trangthai;
	private String tennv,diachi,sdt,gioitinh;
	public NhanVienDTO() {
		
	}
	public NhanVienDTO(int manv, int tuoi, String tennv, String diachi, String sdt, String gioitinh,int matk,int trangthai) {
		super();
		this.manv = manv;
		this.tuoi = tuoi;
		this.tennv = tennv;
		this.diachi = diachi;
		this.sdt = sdt;
		this.gioitinh = gioitinh;
		this.matk= matk;
		this.trangthai=trangthai;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public int getMatk() {
		return matk;
	}
	public void setMatk(int matk) {
		this.matk = matk;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
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
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
}
