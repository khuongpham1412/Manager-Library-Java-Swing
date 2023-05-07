package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.TacGiaDTO;

public class TacGiaDAO {
	public boolean add(TacGiaDTO tg){
		String sql="insert into tbl_tacgia(tentacgia) values (?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1,tg.getTentacgia());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(TacGiaDTO tg) {
		String sql="update tbl_tacgia set tentacgia=? where matacgia=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,tg.getTentacgia());
			ps.setInt(2,tg.getMatacgia());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(TacGiaDTO tg) {
		String sql="delete from tbl_tacgia where matacgia=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,tg.getMatacgia());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<TacGiaDTO> danhsach(){
		ArrayList<TacGiaDTO> tacgia=new ArrayList<>();
		String sql="select * from tbl_tacgia";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TacGiaDTO tg= new TacGiaDTO();
				tg.setMatacgia(rs.getInt(1));
				tg.setTentacgia(rs.getString(2));
				tacgia.add(tg);
			}
		}catch(Exception ex) {
			
		}
		return tacgia;
	}
}
