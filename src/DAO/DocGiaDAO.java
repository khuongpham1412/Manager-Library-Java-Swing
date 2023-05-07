package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.DocGiaDTO;

public class DocGiaDAO {
	public boolean add(DocGiaDTO dg){
		String sql="insert into tbl_docgia(tendocgia,tuoi,gioitinh,diachi,sdt,trangthai) values (?,?,?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,dg.getTendg());
			ps.setInt(2,dg.getTuoi());
			ps.setString(3,dg.getGioitinh());
			ps.setString(4,dg.getDiachi());
			ps.setString(5,dg.getSdt());
			ps.setInt(6,dg.getTrangthai());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(DocGiaDTO dg) {
		String sql="update tbl_docgia set tendocgia=?,tuoi=?, gioitinh=?, diachi=?, sdt=?,trangthai=? where madocgia=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,dg.getTendg());
			ps.setInt(2,dg.getTuoi());
			ps.setString(3,dg.getGioitinh());
			ps.setString(4,dg.getDiachi());
			ps.setString(5,dg.getSdt());
			ps.setInt(6,dg.getTrangthai());
			ps.setInt(7,dg.getMadg());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit_tt(DocGiaDTO dg) {
		String sql="update tbl_docgia set trangthai=? where madocgia=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,dg.getTrangthai());
			ps.setInt(2,dg.getMadg());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(DocGiaDTO dg) {
		String sql="delete from tbl_docgia where madocgia=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,dg.getMadg());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<DocGiaDTO> danhsach(){
		ArrayList<DocGiaDTO> docgia=new ArrayList<>();
		String sql="select * from tbl_docgia";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DocGiaDTO dg= new DocGiaDTO();
				dg.setMadg(rs.getInt(1));
				dg.setTendg(rs.getString(2));
				dg.setTuoi(rs.getInt(3));
				dg.setGioitinh(rs.getString(4));
				dg.setDiachi(rs.getString(5));
				dg.setSdt(rs.getString(6));
				dg.setTrangthai(rs.getInt(7));
				docgia.add(dg);
			}
		}catch(Exception ex) {
			
		}
		return docgia;
	}
}
