package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.KhoSachDTO;

public class KhoSachDAO {
	public boolean add(KhoSachDTO s){
		String sql="insert into tbl_khosach(tensach,soluong,gia) values (?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,s.getTensach());
			ps.setInt(2,s.getSoluong());
			ps.setInt(3,s.getGia());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(KhoSachDTO s) {
		String sql="update tbl_khosach set tensach=?, soluong=?,gia=? where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,s.getTensach());
			ps.setInt(2,s.getSoluong());
			ps.setInt(3,s.getGia());
			
			ps.setInt(4,s.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit_sl(KhoSachDTO s) {
		String sql="update tbl_khosach set soluong=?,gia=? where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,s.getSoluong());
			ps.setInt(2,s.getGia());
			ps.setInt(3,s.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit_sl1(int sl,int masach) {
		String sql="update tbl_khosach set soluong=? where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,sl);
			ps.setInt(2,masach);
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(KhoSachDTO s) {
		String sql="delete from tbl_khosach where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,s.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<KhoSachDTO> danhsach(){
		ArrayList<KhoSachDTO> sach=new ArrayList<>();
		String sql="select * from tbl_khosach";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				KhoSachDTO s= new KhoSachDTO();
				s.setMasach(rs.getInt(1));
				s.setTensach(rs.getString(2));
				s.setSoluong(rs.getInt(3));
				s.setGia(rs.getInt(4));
				sach.add(s);
			}
		}catch(Exception ex) {
			
		}
		return sach;
	}
	public ArrayList<KhoSachDTO> danhsach_masach(int masach){
		ArrayList<KhoSachDTO> sach=new ArrayList<>();
		String sql="select * from tbl_khosach where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,masach);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				KhoSachDTO s= new KhoSachDTO();
				s.setMasach(rs.getInt(1));
				s.setTensach(rs.getString(2));
				s.setSoluong(rs.getInt(3));
				s.setGia(rs.getInt(4));
				sach.add(s);
			}
		}catch(Exception ex) {
			
		}
		return sach;
	}
}
