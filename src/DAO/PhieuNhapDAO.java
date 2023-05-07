package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.PhieuNhapDTO;

public class PhieuNhapDAO {
	public boolean add(PhieuNhapDTO pn){
		String sql="insert into tbl_phieunhap(manv,mancc,ngaynhap,tongtien) values (?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,pn.getManv());
			ps.setInt(2,pn.getMancc());
			ps.setString(3,pn.getNgaynhap());
			ps.setInt(4,pn.getTongtien());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			//ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(PhieuNhapDTO pn) {
		String sql="update tbl_phieunhap set manv=?, mancc=?, ngaynhap=?, tongtien=? where mapn=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getManv());
			ps.setInt(2,pn.getMancc());
			ps.setString(3,pn.getNgaynhap());
			ps.setInt(4,pn.getTongtien());
			ps.setInt(5,pn.getMapn());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(PhieuNhapDTO pn) {
		String sql="delete from tbl_phieunhap where mapn=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getMapn());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<PhieuNhapDTO> danhsach(){
		ArrayList<PhieuNhapDTO> pn=new ArrayList<>();
		String sql="select * from tbl_phieunhap";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PhieuNhapDTO pn1= new PhieuNhapDTO();
				pn1.setMapn(rs.getInt(1));
				
				pn1.setManv(rs.getInt(2));
				pn1.setMancc(rs.getInt(3));
				pn1.setNgaynhap(rs.getString(4));
				pn1.setTongtien(rs.getInt(5));
				pn.add(pn1);
			}
		}catch(Exception ex) {
			
		}
		return pn;
	}
}
