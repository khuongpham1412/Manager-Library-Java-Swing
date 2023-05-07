package BUS;

import java.util.ArrayList;

import DAO.PhieuNhapDAO;

import DTO.PhieuNhapDTO;

public class PhieuNhapBUS {
	PhieuNhapDAO pnd = new PhieuNhapDAO();
	public boolean add(PhieuNhapDTO pn) throws Exception {
		if(pnd.add(pn)) {
			return true;
		}
		return false;
	}
	public boolean edit(PhieuNhapDTO pn) throws Exception {
//		if(svd.edit(sv)) {
//			return true;
//		}
		return false;
	}
	public boolean delete(PhieuNhapDTO pn) throws Exception {
//		if(svd.delete(sv)) {
//			return true;
//		}
		return false;
	}
	public ArrayList<PhieuNhapDTO> danhsach(){
		return pnd.danhsach();
	}
}
