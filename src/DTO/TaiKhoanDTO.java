package DTO;

public class TaiKhoanDTO {
	private int mataikhoan,vaitro;
	private String username,password;
	public TaiKhoanDTO() {
		
	}
	public TaiKhoanDTO(int vaitro,int mataikhoan, String username, String password) {
		super();
		this.mataikhoan = mataikhoan;
		this.username = username;
		this.password = password;
	}
	public int getVaitro() {
		return vaitro;
	}
	public void setVaitro(int vaitro) {
		this.vaitro = vaitro;
	}
	public int getMataikhoan() {
		return mataikhoan;
	}
	public void setMataikhoan(int mataikhoan) {
		this.mataikhoan = mataikhoan;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
