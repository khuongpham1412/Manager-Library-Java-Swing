package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.TheLoaiDTO;

public class TheLoaiDAO {
	public boolean add(TheLoaiDTO tl){
		String sql="insert into tbl_theloai(tentheloai) values (?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,tl.getTentheloai());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(TheLoaiDTO tl) {
		String sql="update tbl_theloai set tentheloai=? where matheloai=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,tl.getTentheloai());
			ps.setInt(2,tl.getMatheloai());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(TheLoaiDTO tl) {
		String sql="delete from tbl_theloai where matheloai=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,tl.getMatheloai());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public ArrayList<Object> choose(TheLoaiDTO tl) {
		ArrayList<Object> theloai=new ArrayList<>();
		String sql="select matheloai from tbl_theloai where tentheloai=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,tl.getTentheloai());
			ResultSet rs=ps.executeQuery();
			tl.setTentheloai(rs.getString(2));
			theloai.add(tl);
		}catch(Exception ex) {
			
		}
		return theloai;
	}
	
	
	public ArrayList<TheLoaiDTO> danhsach(){
		ArrayList<TheLoaiDTO> theloai=new ArrayList<>();
		String sql="select * from tbl_theloai";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TheLoaiDTO tl= new TheLoaiDTO();
				tl.setMatheloai(rs.getInt(1));
				tl.setTentheloai(rs.getString(2));
				theloai.add(tl);
			}
		}catch(Exception ex) {
			
		}
		return theloai;
	}
}
