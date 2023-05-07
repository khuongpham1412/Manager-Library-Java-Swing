package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.SachDTO;

public class SachDAO {
	public boolean add(SachDTO s){
		String sql="insert into tbl_sach(tensach,maloai,matacgia,soluong) values (?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,s.getTensach());
			ps.setInt(2,s.getMaloai());
			ps.setInt(3,s.getMatacgia());
		
			ps.setInt(4,s.getSoluong());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(SachDTO s) {
		String sql="update tbl_sach set tensach=?, maloai=?, matacgia=?,soluong=? where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,s.getTensach());
			ps.setInt(2,s.getMaloai());
			ps.setInt(3,s.getMatacgia());
			
			ps.setInt(4,s.getSoluong());
			ps.setInt(5,s.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit_sl(SachDTO s) {
		String sql="update tbl_sach set soluong=? where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,s.getSoluong());
			ps.setInt(2,s.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(SachDTO s) {
		String sql="delete from tbl_sach where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,s.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<SachDTO> danhsach(){
		ArrayList<SachDTO> sach=new ArrayList<>();
		String sql="select * from tbl_sach";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SachDTO s= new SachDTO();
				s.setMasach(rs.getInt(1));
				s.setTensach(rs.getString(2));
				s.setMaloai(rs.getInt(3));
				s.setMatacgia(rs.getInt(4));
				
				s.setSoluong(rs.getInt(5));
				sach.add(s);
			}
		}catch(Exception ex) {
			
		}
		return sach;
	}
	public ArrayList<SachDTO> danhsach_masach(int masach){
		ArrayList<SachDTO> sach=new ArrayList<>();
		String sql="select * from tbl_sach where masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,masach);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SachDTO s= new SachDTO();
				s.setMasach(rs.getInt(1));
				s.setTensach(rs.getString(2));
				s.setMaloai(rs.getInt(3));
				s.setMatacgia(rs.getInt(4));
				
				s.setSoluong(rs.getInt(5));
				sach.add(s);
			}
		}catch(Exception ex) {
			
		}
		return sach;
	}
}
