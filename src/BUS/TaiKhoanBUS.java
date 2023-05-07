package BUS;

import java.util.ArrayList;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

public class TaiKhoanBUS {
	TaiKhoanDAO tkd = new TaiKhoanDAO();
	public boolean add(TaiKhoanDTO tk) throws Exception {
		if(tkd.add(tk)) {
			return true;
		}
		return false;
	}
	public boolean edit_vaitro(int matk,int vaitro) throws Exception {
		if(tkd.edit_vaitro(matk,vaitro)) {
			return true;
		}
		return false;
	}
	public boolean delete(TaiKhoanDTO tk) throws Exception {
		if(tkd.delete(tk)) {
			return true;
		}
		return false;
	}
	public ArrayList<TaiKhoanDTO> danhsach(){
		return tkd.danhsach();
	}
	public ArrayList<TaiKhoanDTO> danhsach_dn(String user,String pass){
		return tkd.danhsach_dn( user, pass);
	}
}
