package BUS;

import java.util.ArrayList;

import DAO.CTPhieuMuonDAO;
import DTO.CTPhieuMuon;


public class CTPhieuMuonBUS {
	CTPhieuMuonDAO ctpmd = new CTPhieuMuonDAO();
	public boolean add(CTPhieuMuon pm) throws Exception {
		if(ctpmd.add(pm)) {
			return true;
		}
		return false;
	}
	
	public boolean delete(CTPhieuMuon pm) throws Exception {
		if(ctpmd.delete(pm)) {
			return true;
		}
		return false;
	}
	public boolean delete_ma(CTPhieuMuon pm) throws Exception {
		if(ctpmd.delete_ma(pm)) {
			return true;
		}
		return false;
	}
	public ArrayList<CTPhieuMuon> danhsach(){
		return ctpmd.danhsach();
	}
	
	public ArrayList<CTPhieuMuon> danhsachid(int mapm){
		return ctpmd.danhsachid(mapm);
	}
}
