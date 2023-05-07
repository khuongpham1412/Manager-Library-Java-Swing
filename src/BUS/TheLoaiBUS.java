package BUS;

import java.util.ArrayList;
import DAO.TheLoaiDAO;
import DTO.TheLoaiDTO;

	public class TheLoaiBUS {
		TheLoaiDAO tld = new TheLoaiDAO();
		public boolean add(TheLoaiDTO tl){
			try {
				if(tld.add(tl)==true) {
					return true;
				}
			}catch(Exception ex) {
				
			}
			
			return false;
		}
		public boolean edit(TheLoaiDTO tl) throws Exception {
			if(tld.edit(tl)) {
				return true;
			}
			return false;
		}
		public boolean delete(TheLoaiDTO tl) throws Exception {
			if(tld.delete(tl)) {
				return true;
			}
			return false;
		}
		public ArrayList<TheLoaiDTO> danhsach(){
			return tld.danhsach();
		}
	}
