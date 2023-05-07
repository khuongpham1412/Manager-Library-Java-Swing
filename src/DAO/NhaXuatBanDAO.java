package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.NhaXuatBanDTO;

public class NhaXuatBanDAO {
	public boolean add(NhaXuatBanDTO nxb) {
		String sql="insert into from tbl_nhaxuatban(tennxb,diachi,sdt) values (?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,nxb.getTennxb());
			ps.setString(2,nxb.getDiachi());
			ps.setString(3,nxb.getSdt());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit(NhaXuatBanDTO nxb) {
		String sql="update tbl_nhaxuatban set tennxb=?, diachi=?, sdt=? where manxb=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,nxb.getTennxb());
			ps.setString(2,nxb.getDiachi());
			ps.setString(3,nxb.getSdt());
			ps.setInt(4,nxb.getManxb());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(NhaXuatBanDTO nxb) {
		String sql="delete from tbl_nhaxuatban where manxb=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,nxb.getManxb());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public ArrayList<NhaXuatBanDTO> danhsach(){
		ArrayList<NhaXuatBanDTO> nhaxuatban= new ArrayList<>();
		String sql="select * from tbl_nhaxuatban";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				NhaXuatBanDTO nxb= new NhaXuatBanDTO();
				nxb.setManxb(rs.getInt(1));
				nxb.setTennxb(rs.getString(2));
				nxb.setDiachi(rs.getString(3));
				nxb.setSdt(rs.getString(4));
			}
		}catch(Exception ex) {
			
		}
		return nhaxuatban;
	}
}
