package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.LoaiSachDTO;

public class LoaiSachDAO {
	public boolean add(LoaiSachDTO ls){
		String sql="insert into tbl_loaisach(tenloaisach) values (?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,ls.getTenloaisach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(LoaiSachDTO ls) {
		String sql="update tbl_loaisach set tenloaisach=? where maloaisach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,ls.getTenloaisach());
			ps.setInt(2,ls.getMaloaisach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(LoaiSachDTO ls) {
		String sql="delete from tbl_loaisach where maloaisach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,ls.getMaloaisach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<LoaiSachDTO> danhsach(){
		ArrayList<LoaiSachDTO> loaisach=new ArrayList<>();
		String sql="select * from tbl_chitietphieunhap";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				LoaiSachDTO ls= new LoaiSachDTO();
				ls.setMaloaisach(rs.getInt(1));
				ls.setTenloaisach(rs.getString(2));
				loaisach.add(ls);
			}
		}catch(Exception ex) {
			
		}
		return loaisach; 
	}
}
