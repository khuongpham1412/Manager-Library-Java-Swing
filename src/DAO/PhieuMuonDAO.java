package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.connection;
import DTO.PhieuMuonDTO;

public class PhieuMuonDAO {
	public boolean add(PhieuMuonDTO pm){
		String sql="insert into tbl_phieumuon(manv,mathetv,ngaymuon,ngaytra) values (?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,pm.getManv());
			ps.setInt(2,pm.getMathetv());
			ps.setDate(3,new Date(pm.getNgaymuon().getTime()));
			ps.setString(4,pm.getNgaytra());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Ngày nhập phải có định dạng MM/dd/yyyy");
			
		}
		return false;
	}
	
	public boolean edit(PhieuMuonDTO pm) {
		String sql="update tbl_phieumuon ngaytra=? where mapm=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,pm.getNgaytra());
			ps.setInt(2,pm.getMapm());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
			
		}
		return false;
	}
	public boolean delete(PhieuMuonDTO pm) {
		String sql="delete from tbl_phieumuon where mapm=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pm.getMapm());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<PhieuMuonDTO> danhsach(){
		ArrayList<PhieuMuonDTO> pn=new ArrayList<>();
		String sql="select * from tbl_phieumuon";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PhieuMuonDTO pn1= new PhieuMuonDTO();
				pn1.setMapm(rs.getInt(1));
				
				pn1.setManv(rs.getInt(2));
				pn1.setMathetv(rs.getInt(3));
				pn1.setNgaymuon(rs.getDate(4));
				pn1.setNgaytra(String.valueOf(rs.getDate(5)));
				pn.add(pn1);
			}
		}catch(Exception ex) {
			
		}
		return pn;
	}
}
