package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.NhanVienDTO;

public class NhanVienDAO {
	public boolean add(NhanVienDTO nv){
		String sql="insert into tbl_nhanvien(tennhanvien,tuoi,gioitinh,diachi,sdt,trangthai) values (?,?,?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,nv.getTennv());
			ps.setInt(2,nv.getTuoi());
			ps.setString(3,nv.getGioitinh());
			ps.setString(4,nv.getDiachi());
			ps.setString(5,nv.getSdt());
			ps.setInt(6,nv.getTrangthai());
			
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(NhanVienDTO nv) {
		String sql="update tbl_nhanvien set tennhanvien=?,tuoi=?, gioitinh=?, diachi=?, sdt=? where manhanvien=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,nv.getTennv());
			ps.setInt(2,nv.getTuoi());
			ps.setString(3,nv.getGioitinh());
			ps.setString(4,nv.getDiachi());
			ps.setString(5,nv.getSdt());
			ps.setInt(6,nv.getManv());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edittaikhoan(NhanVienDTO nv) {
		String sql="update tbl_nhanvien set mataikhoan=?, trangthai=? where manhanvien=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,nv.getMatk());
			ps.setInt(2,nv.getTrangthai());
			ps.setInt(3,nv.getManv());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(NhanVienDTO nv) {
		String sql="delete from tbl_nhanvien where manhanvien=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,nv.getManv());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<NhanVienDTO> danhsach(){
		ArrayList<NhanVienDTO> nhanvien=new ArrayList<>();
		String sql="select * from tbl_nhanvien";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				NhanVienDTO nv= new NhanVienDTO();
				nv.setManv(rs.getInt(1));
				nv.setTennv(rs.getString(2));
				nv.setTuoi(rs.getInt(3));
				nv.setGioitinh(rs.getString(4));
				nv.setDiachi(rs.getString(5));
				nv.setSdt(rs.getString(6));
				nv.setMatk(rs.getInt(7));
				nv.setTrangthai(rs.getInt(8));
				nhanvien.add(nv);
			}
		}catch(Exception ex) {
			
		}
		return nhanvien;
	}
	public ArrayList<NhanVienDTO> danhsach_ma(int manv){
		ArrayList<NhanVienDTO> nhanvien=new ArrayList<>();
		String sql="select * from tbl_nhanvien where manhanvien=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,manv);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				NhanVienDTO nv= new NhanVienDTO();
				nv.setManv(rs.getInt(1));
				nv.setTennv(rs.getString(2));
				nv.setTuoi(rs.getInt(3));
				nv.setGioitinh(rs.getString(4));
				nv.setDiachi(rs.getString(5));
				nv.setSdt(rs.getString(6));
				nv.setMatk(rs.getInt(7));
				nv.setTrangthai(rs.getInt(8));
				nhanvien.add(nv);
			}
		}catch(Exception ex) {
			
		}
		return nhanvien;
	}
}
