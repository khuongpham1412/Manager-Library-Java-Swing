package BUS;
	import java.util.ArrayList;

import DAO.NhaCungCapDAO;

import DTO.NhaCungCapDTO;


	public class NhaCungCapBUS {
		NhaCungCapDAO nccd = new NhaCungCapDAO();
		public boolean add(NhaCungCapDTO ncc) throws Exception {
			if(nccd.add(ncc)) {
				return true;
			}
			return false;
		}
		
		public boolean edit(NhaCungCapDTO ncc) throws Exception {
			if(nccd.edit(ncc)) {
				return true;
			}
			return false;
		}
		public boolean delete(NhaCungCapDTO ncc) throws Exception {
			if(nccd.delete(ncc)) {
				return true;
			}
			return false;
		}
		public ArrayList<NhaCungCapDTO> danhsach(){
			return nccd.danhsach();
		}
	}


