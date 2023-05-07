package DTO;

public class NhaCungCapDTO {
	private int mancc;
	private String tenncc,diachi,sdt;
	public int getMancc() {
		return mancc;
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
	public void setMancc(int mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public NhaCungCapDTO(int mancc, String tenncc,String diachi, String sdt) {
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.diachi=diachi;
		this.sdt=sdt;
	}
	public NhaCungCapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhaCungCap [MaNCC=" + mancc + ", TenNCC=" + tenncc + "]";
	}
	
}