package DTO;

public class LoaiSachDTO {
	private int maloaisach;
	private String tenloaisach;
	public LoaiSachDTO() {
		
	}
	public LoaiSachDTO(int maloaisach, String tenloaisach) {
		super();
		this.maloaisach = maloaisach;
		this.tenloaisach = tenloaisach;
	}
	public int getMaloaisach() {
		return maloaisach;
	}
	public void setMaloaisach(int maloaisach) {
		this.maloaisach = maloaisach;
	}
	public String getTenloaisach() {
		return tenloaisach;
	}
	public void setTenloaisach(String tenloaisach) {
		this.tenloaisach = tenloaisach;
	}
	@Override
	public String toString() {
		return "LoaiSachDAO [maloaisach=" + maloaisach + ", tenloaisach=" + tenloaisach + "]";
	}
}
