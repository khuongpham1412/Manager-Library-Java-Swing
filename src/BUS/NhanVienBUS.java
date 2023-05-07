package BUS;


	

	import java.util.ArrayList;

	import DAO.NhanVienDAO;

	import DTO.NhanVienDTO;

	public class NhanVienBUS {
		NhanVienDAO nvd = new NhanVienDAO();
		public boolean add(NhanVienDTO nv) throws Exception {
			if(nvd.add(nv)) {
				return true;
			}
			return false;
		}
		public boolean edittaikhoan(NhanVienDTO nv) throws Exception {
			if(nvd.edittaikhoan(nv)) {
				return true;
			}
			return false;
		}
		public boolean edit(NhanVienDTO nv) throws Exception {
			if(nvd.edit(nv)) {
				return true;
			}
			return false;
		}
		public boolean delete(NhanVienDTO nv) throws Exception {
			if(nvd.delete(nv)) {
				return true;
			}
			return false;
		}
		public ArrayList<NhanVienDTO> danhsach(){
			return nvd.danhsach();
		}
		public ArrayList<NhanVienDTO> danhsach_ma(int manv){
			return nvd.danhsach_ma(manv);
		}
	}


