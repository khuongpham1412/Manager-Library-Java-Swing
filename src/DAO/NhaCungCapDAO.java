package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.NhaCungCapDTO;

public class NhaCungCapDAO {
	public boolean add(NhaCungCapDTO ncc) {
		String sql="insert into tbl_nhacungcap(tenncc,diachi,sdt) values (?,?,?)";
		try {
			
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,ncc.getTenncc());
			ps.setString(2,ncc.getDiachi());
			ps.setString(3,ncc.getSdt());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit(NhaCungCapDTO ncc) {
		String sql="update tbl_nhacungcap set tenncc=?, diachi=?, sdt=? where mancc=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,ncc.getTenncc());
			ps.setString(2,ncc.getDiachi());
			ps.setString(3,ncc.getSdt());
			ps.setInt(4,ncc.getMancc());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(NhaCungCapDTO ncc) {
		String sql="delete from tbl_nhacungcap where mancc=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,ncc.getMancc());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public ArrayList<NhaCungCapDTO> danhsach(){
		ArrayList<NhaCungCapDTO> nhacungcap= new ArrayList<>();
		String sql="select * from tbl_nhacungcap";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				NhaCungCapDTO ncc= new NhaCungCapDTO();
				ncc.setMancc(rs.getInt(1));
				ncc.setTenncc(rs.getString(2));
				ncc.setDiachi(rs.getString(3));
				ncc.setSdt(rs.getString(4));
				nhacungcap.add(ncc);
			}
		}catch(Exception ex) {
			
		}
		return nhacungcap;
	}
}
