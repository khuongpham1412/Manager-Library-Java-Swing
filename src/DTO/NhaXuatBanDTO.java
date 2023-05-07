package DTO;

public class NhaXuatBanDTO {
	private int manxb;
	private String tennxb,diachi,sdt;
	public NhaXuatBanDTO() {
		
	}
	public NhaXuatBanDTO(int manxb, String tennxb, String diachi, String sdt) {
		super();
		this.manxb = manxb;
		this.tennxb = tennxb;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public int getManxb() {
		return manxb;
	}
	public void setManxb(int manxb) {
		this.manxb = manxb;
	}
	public String getTennxb() {
		return tennxb;
	}
	public void setTennxb(String tennxb) {
		this.tennxb = tennxb;
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
	@Override
	public String toString() {
		return "NhaXuatBanDTO [manxb=" + manxb + ", tennxb=" + tennxb + ", diachi=" + diachi + ", sdt=" + sdt + "]";
	}
	
}
