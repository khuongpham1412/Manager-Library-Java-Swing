package DTO;

public class TacGiaDTO {
	private int matacgia;
	private String tentacgia;
	public TacGiaDTO() {
		
	}
	public TacGiaDTO(int matacgia, String tentacgia) {
		super();
		this.matacgia = matacgia;
		this.tentacgia = tentacgia;
	}
	public int getMatacgia() {
		return matacgia;
	}
	public void setMatacgia(int matacgia) {
		this.matacgia = matacgia;
	}
	public String getTentacgia() {
		return tentacgia;
	}
	public void setTentacgia(String tentacgia) {
		this.tentacgia = tentacgia;
	}
}
