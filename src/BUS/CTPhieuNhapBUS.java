package BUS;

import java.util.ArrayList;

import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhap;
import DTO.danhsachphieunhapDTO;

public class CTPhieuNhapBUS {
	CTPhieuNhapDAO svd = new CTPhieuNhapDAO();
	public boolean add(CTPhieuNhap pn) throws Exception {
		if(svd.add(pn)) {
			return true;
		}
		return false;
	}
	public boolean edit(CTPhieuNhap pn) throws Exception {
		if(svd.edit(pn)) {
			return true;
		}
		return false;
	}
	public boolean edit_sl(CTPhieuNhap pn) throws Exception {
		if(svd.edit_sl(pn)) {
			return true;
		}
		return false;
	}
	public boolean delete(CTPhieuNhap pn) throws Exception {
		if(svd.delete(pn)) {
			return true;
		}
		return false;
	}
	public ArrayList<CTPhieuNhap> danhsach(){
		return svd.danhsach();
	}
	
	public ArrayList<CTPhieuNhap> danhsachid(int mapn){
		return svd.danhsachid(mapn);
	}
}
