package DTO;

public class CTPhieuMuon {
	private int mapm,masach;
	public CTPhieuMuon() {
		
	}
	public CTPhieuMuon(int mapm, int masach) {
		super();
		this.mapm = mapm;
		this.masach = masach;
	}
	public int getMapm() {
		return mapm;
	}
	public void setMapm(int mapm) {
		this.mapm = mapm;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
}
