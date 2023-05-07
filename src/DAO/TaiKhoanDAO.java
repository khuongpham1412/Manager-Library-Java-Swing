package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.TaiKhoanDTO;

public class TaiKhoanDAO {
	public boolean add(TaiKhoanDTO tk){
		String sql="insert into tbl_taikhoan(usernam,password,vaitro) values (?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,tk.getUsername());
			ps.setString(2,tk.getPassword());
			ps.setInt(3,tk.getVaitro());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit_vaitro(int matk,int vaitro) {
		String sql="update tbl_taikhoan set vaitro=? where mataikhoan=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,vaitro);
			ps.setInt(2,matk);
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(TaiKhoanDTO tk) {
		String sql="delete from tbl_taikhoan where mataikhoan=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,tk.getMataikhoan());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	
	
	public ArrayList<TaiKhoanDTO> danhsach(){
		ArrayList<TaiKhoanDTO> taikhoan=new ArrayList<>();
		String sql="select * from tbl_taikhoan";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TaiKhoanDTO tk= new TaiKhoanDTO();
				tk.setMataikhoan(rs.getInt(1));
				tk.setUsername(rs.getString(2));
				tk.setPassword(rs.getString(3));
				tk.setVaitro(rs.getInt(4));
				taikhoan.add(tk);
			}
		}catch(Exception ex) {
			
		}
		return taikhoan;
	}
	public ArrayList<TaiKhoanDTO> danhsach_dn(String user,String mk){
		ArrayList<TaiKhoanDTO> taikhoan=new ArrayList<>();
		String sql="select * from tbl_taikhoan where usernam=? and password=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,user);
			ps.setString(2,mk);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TaiKhoanDTO tk= new TaiKhoanDTO();
				tk.setMataikhoan(rs.getInt(1));
				tk.setUsername(rs.getString(2));
				tk.setPassword(rs.getString(3));
				tk.setVaitro(rs.getInt(4));
				taikhoan.add(tk);
			}
		}catch(Exception ex) {
			
		}
		return taikhoan;
	}
	
}
