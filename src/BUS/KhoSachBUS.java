package BUS;

import java.util.ArrayList;

import DAO.KhoSachDAO;
import DTO.KhoSachDTO;

public class KhoSachBUS {
	KhoSachDAO sd = new KhoSachDAO();
	public boolean add(KhoSachDTO s) throws Exception {
		if(sd.add(s)) {
			return true;
		}
		return false;
	}
	public boolean edit(KhoSachDTO s) throws Exception {
		if(sd.edit(s)) {
			return true;
		}
		return false;
	}
	public boolean edit_sl(KhoSachDTO s) throws Exception {
		if(sd.edit_sl(s)) {
			return true;
		}
		return false;
	}
	
		public boolean edit_sl1(int sl,int masach) throws Exception {
			if(sd.edit_sl1(sl,masach)) {
				return true;
			}
			return false;
		}
	
	public boolean delete(KhoSachDTO s) throws Exception {
		if(sd.delete(s)) {
			return true;
		}
		return false;
	}
	public ArrayList<KhoSachDTO> danhsach(){
		return sd.danhsach();
	}
	public ArrayList<KhoSachDTO> danhsach_masach(int masach){
		return sd.danhsach_masach(masach);
	}
}
