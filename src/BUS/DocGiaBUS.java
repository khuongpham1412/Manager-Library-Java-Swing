package BUS;

import java.util.ArrayList;

import DAO.DocGiaDAO;

import DTO.DocGiaDTO;

public class DocGiaBUS {
	DocGiaDAO dgd = new DocGiaDAO();
	public boolean add(DocGiaDTO dg) throws Exception {
		if(dgd.add(dg)) {
			return true;
		}
		return false;
	}
	public boolean edit(DocGiaDTO dg) throws Exception {
		if(dgd.edit(dg)) {
			return true;
		}
		return false;
	}
	public boolean edit_tt(DocGiaDTO dg) throws Exception {
		if(dgd.edit_tt(dg)) {
			return true;
		}
		return false;
	}
	public boolean delete(DocGiaDTO dg) throws Exception {
		if(dgd.delete(dg)) {
			return true;
		}
		return false;
	}
	public ArrayList<DocGiaDTO> danhsach(){
		return dgd.danhsach();
	}
}
