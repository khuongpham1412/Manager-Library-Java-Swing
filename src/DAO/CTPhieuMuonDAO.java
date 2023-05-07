package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.CTPhieuMuon;
import DTO.CTPhieuNhap;
import DTO.danhsachphieunhapDTO;

public class CTPhieuMuonDAO {
	public boolean add(CTPhieuMuon pm){
		String sql="insert into tbl_chitietphieumuon(mapm,masach) values (?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,pm.getMapm());
			ps.setInt(2,pm.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	
	public boolean delete(CTPhieuMuon pm) {
		String sql="delete from tbl_chitietphieumuon where mapm=? and masach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pm.getMapm());
			ps.setInt(2,pm.getMasach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}

	public boolean delete_ma(CTPhieuMuon pm) {
		String sql="delete from tbl_chitietphieumuon where mapm=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pm.getMapm());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}

	public ArrayList<CTPhieuMuon> danhsach(){
		ArrayList<CTPhieuMuon> ctpn=new ArrayList<>();
		String sql="select * from tbl_chitietphieumuon";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CTPhieuMuon ct= new CTPhieuMuon();
				ct.setMapm(rs.getInt(1));
				ct.setMasach(rs.getInt(2));
				
				ctpn.add(ct);
			}
		}catch(Exception ex) {
			
		}
		return ctpn;
	}
	public ArrayList<CTPhieuMuon> danhsachid(int mapm){
		ArrayList<CTPhieuMuon> ctpn= new ArrayList<>();
		String sql="select * from tbl_chitietphieumuon where mapm=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,mapm);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				CTPhieuMuon ct= new CTPhieuMuon();
				ct.setMapm(rs.getInt(1));
				ct.setMasach(rs.getInt(2));
				ctpn.add(ct);
			}
		}catch(Exception ex) {
			
		}
		return ctpn;
	}
}