package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.CTPhieuNhap;
import DTO.danhsachphieunhapDTO;

public class CTPhieuNhapDAO {
	public boolean add(CTPhieuNhap pn){
		String sql="insert into tbl_chitietphieunhap(mapn,tensach,soluong,dongia,thanhtien) values (?,?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,pn.getMapn());
			ps.setString(2,pn.getTensach());
			ps.setInt(3,pn.getSoluong());
			ps.setInt(4,pn.getDongia());
			ps.setInt(5,pn.getThanhtien());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(CTPhieuNhap pn) {
		String sql="update tbl_chitietphieunhap set soluong=?, dongia=?, thanhtien=? where mapn=? and tensach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getSoluong());
			ps.setInt(2,pn.getDongia());
			ps.setInt(3,pn.getThanhtien());
			ps.setInt(4,pn.getMapn());
			ps.setString(5,pn.getTensach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit_sl(CTPhieuNhap pn) {
		String sql="update tbl_chitietphieunhap set soluong=?, thanhtien=? where mapn=? and tensach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getSoluong());
			ps.setInt(2,pn.getThanhtien());
			ps.setInt(3,pn.getMapn());
			ps.setString(4,pn.getTensach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(CTPhieuNhap pn) {
		String sql="delete from tbl_chitietphieunhap where mapn=? and tensach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getMapn());
			ps.setString(2,pn.getTensach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<CTPhieuNhap> danhsach(){
		ArrayList<CTPhieuNhap> ctpn=new ArrayList<>();
		String sql="select * from tbl_chitietphieunhap";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CTPhieuNhap ct= new CTPhieuNhap();
				ct.setMapn(rs.getInt(1));
				ct.setTensach(rs.getString(2));
				ct.setSoluong(rs.getInt(3));
				ct.setDongia(rs.getInt(4));
				ct.setThanhtien(rs.getInt(5));
				ctpn.add(ct);
			}
		}catch(Exception ex) {
			
		}
		return ctpn;
	}
	public ArrayList<CTPhieuNhap> danhsachid(int mapn){
		ArrayList<CTPhieuNhap> ctpn= new ArrayList<>();
		String sql="select * from tbl_chitietphieunhap where mapn=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,mapn);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				CTPhieuNhap ct= new CTPhieuNhap();
				ct.setMapn(rs.getInt(1));
				ct.setTensach(rs.getString(2));
				ct.setSoluong(rs.getInt(3));
				ct.setDongia(rs.getInt(4));
				ct.setThanhtien(rs.getInt(5));
				ctpn.add(ct);
			}
		}catch(Exception ex) {
			
		}
		return ctpn;
	}
}