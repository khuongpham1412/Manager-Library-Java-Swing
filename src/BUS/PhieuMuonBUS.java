package BUS;

import java.util.ArrayList;

import DAO.PhieuMuonDAO;

import DTO.PhieuMuonDTO;

public class PhieuMuonBUS {
	PhieuMuonDAO pmd = new PhieuMuonDAO();
	public boolean add(PhieuMuonDTO pm) throws Exception {
		if(pmd.add(pm)) {
			return true;
		}
		return false;
	}
	public boolean edit(PhieuMuonDTO pm) throws Exception {
		if(pmd.edit(pm)) {
			return true;
		}
		return false;
	}
	public boolean delete(PhieuMuonDTO pm) throws Exception {
		if(pmd.delete(pm)) {
			return true;
		}
		return false;
	}
	public ArrayList<PhieuMuonDTO> danhsach(){
		return pmd.danhsach();
	}
}
