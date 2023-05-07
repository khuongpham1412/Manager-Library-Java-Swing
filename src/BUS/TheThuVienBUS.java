package BUS;

import java.util.ArrayList;

import DAO.TheThuVienDAO;
import DTO.TheThuVienDTO;

public class TheThuVienBUS {
	TheThuVienDAO ttvd = new TheThuVienDAO();
	public boolean add(TheThuVienDTO ttv) throws Exception {
		if(ttvd.add(ttv)) {
			return true;
		}
		return false;
	}
	public boolean edit(TheThuVienDTO ttv) throws Exception {
		if(ttvd.edit(ttv)) {
			return true;
		}
		return false;
	}
	public boolean edit_tt(TheThuVienDTO ttv) throws Exception {
		if(ttvd.edit_tt(ttv)) {
			return true;
		}
		return false;
	}
	public boolean delete(TheThuVienDTO ttv) throws Exception {
		if(ttvd.delete(ttv)) {
			return true;
		}
		return false;
	}
	public boolean delete_madocgia(TheThuVienDTO ttv) throws Exception {
		if(ttvd.delete_madocgia(ttv)) {
			return true;
		}
		return false;
	}
	public ArrayList<TheThuVienDTO> danhsach(){
		return ttvd.danhsach();
	}
//	public ArrayList<TheThuVienDTO> danhsach_tt(int ttv1){
//		return ttvd.danhsach_tt(ttv1);
//	}
	public ArrayList<TheThuVienDTO> danhsach_ma(int ttv1){
		return ttvd.danhsach_ma(ttv1);
	}
}
