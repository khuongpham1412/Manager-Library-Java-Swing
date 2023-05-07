package BUS;

import java.util.ArrayList;
import DAO.TacGiaDAO;
import DTO.TacGiaDTO;

	public class TacGiaBUS {
		TacGiaDAO tgd = new TacGiaDAO();
		public boolean add(TacGiaDTO tg) throws Exception {
			if(tgd.add(tg)) {
				return true;
			}
			return false;
		}
		public boolean edit(TacGiaDTO tg) throws Exception {
			if(tgd.edit(tg)) {
				return true;
			}
			return false;
		}
		public boolean delete(TacGiaDTO tg) throws Exception {
			if(tgd.delete(tg)) {
				return true;
			}
			return false;
		}
		public ArrayList<TacGiaDTO> danhsach(){
			return tgd.danhsach();
		}
	}
