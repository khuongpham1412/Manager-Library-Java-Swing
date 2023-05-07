package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.connection;
import DTO.TheThuVienDTO;

public class TheThuVienDAO {
	public boolean add(TheThuVienDTO ttv){
		String sql="insert into tbl_thethuvien(ngaybd,ngayhh,madocgia,tinhtrang) values (?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setDate(1,new Date(ttv.getNgaybd().getTime()));
			ps.setString(2,ttv.getNgayhh());
			
			
			ps.setInt(3,ttv.getMadocgia());
			ps.setInt(4,ttv.getTinhtrang());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Ngày nhập phải có định dạng MM/dd/yyyy");
			
		}
		return false;
	}
	
	public boolean edit(TheThuVienDTO ttv) {
		String sql="update tbl_thethuvien set ngayhh=? where mathetv=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,ttv.getNgayhh());
			
			ps.setInt(2,ttv.getMathetv());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Ngay nhap khong hop le");
		}
		return false;
	}
	public boolean edit_tt(TheThuVienDTO ttv) {
		String sql="update tbl_thethuvien set tinhtrang=? where mathetv=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,ttv.getTinhtrang());
			
			ps.setInt(2,ttv.getMathetv());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public boolean delete(TheThuVienDTO ttv) {
		String sql="delete from tbl_thethuvien where mathetv=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,ttv.getMathetv());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete_madocgia(TheThuVienDTO ttv) {
		String sql="delete from tbl_thethuvien where madocgia=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,ttv.getMadocgia());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<TheThuVienDTO> danhsach(){
		ArrayList<TheThuVienDTO> thetv=new ArrayList<>();
		String sql="select * from tbl_thethuvien";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TheThuVienDTO ttv= new TheThuVienDTO();
				ttv.setMathetv(rs.getInt(1));
				
				ttv.setNgaybd(rs.getDate(2));
				ttv.setNgayhh(String.valueOf(rs.getDate(3)));
			
				ttv.setMadocgia(rs.getInt(4));
				thetv.add(ttv);
			}
		}catch(Exception ex) {
			
		}
		return thetv;
	}
//	public ArrayList<TheThuVienDTO> danhsach_tt(int ttv1){
//		ArrayList<TheThuVienDTO> thetv=new ArrayList<>();
//		String sql="select * from tbl_thethuvien where madocgia=?";
//		try {
//			Connection conn=connection.openConnection();
//			PreparedStatement ps= conn.prepareStatement(sql);
//			ps.setInt(1,ttv1);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				TheThuVienDTO ttv= new TheThuVienDTO();
//				ttv.setMathetv(rs.getInt(1));
//				
//				ttv.setNgaybd(rs.getDate(2));
//				ttv.setNgayhh(String.valueOf(rs.getDate(3)));
//			
//				ttv.setMadocgia(rs.getInt(4));
//				ttv.setTinhtrang(rs.getInt(5));
//				thetv.add(ttv);
//			}
//		}catch(Exception ex) {
//			
//		}
//		return thetv;
//	}
	public ArrayList<TheThuVienDTO> danhsach_ma(int ttv1){
		ArrayList<TheThuVienDTO> thetv=new ArrayList<>();
		String sql="select * from tbl_thethuvien where mathetv=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,ttv1);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TheThuVienDTO ttv= new TheThuVienDTO();
				ttv.setMathetv(rs.getInt(1));
				
				ttv.setNgaybd(rs.getDate(2));
				ttv.setNgayhh(String.valueOf(rs.getDate(3)));
			
				ttv.setMadocgia(rs.getInt(4));
				ttv.setTinhtrang(rs.getInt(5));
				thetv.add(ttv);
			}
		}catch(Exception ex) {
			
		}
		return thetv;
	}
}
