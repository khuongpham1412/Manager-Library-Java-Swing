package DTO;

public class TheLoaiDTO {
	private int matheloai;
	private String tentheloai;
	public TheLoaiDTO() {
		
	}
	public TheLoaiDTO(int matheloai, String tentheloai) {
		super();
		this.matheloai = matheloai;
		this.tentheloai = tentheloai;
	}
	public int getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(int matheloai) {
		this.matheloai = matheloai;
	}
	public String getTentheloai() {
		return tentheloai;
	}
	public void setTentheloai(String tentheloai) {
		this.tentheloai = tentheloai;
	}
	
}
