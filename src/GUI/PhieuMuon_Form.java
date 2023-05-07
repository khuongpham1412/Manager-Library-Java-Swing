package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BUS.CTPhieuMuonBUS;
import BUS.DocGiaBUS;
import BUS.NhanVienBUS;
import BUS.PhieuMuonBUS;
import BUS.SachBUS;
import BUS.TheThuVienBUS;
import DTO.CTPhieuMuon;
import DTO.DocGiaDTO;
import DTO.NhanVienDTO;
import DTO.PhieuMuonDTO;
import DTO.SachDTO;
import DTO.TheThuVienDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PhieuMuon_Form extends JPanel {
	ArrayList<TheThuVienDTO> thethuvien=new ArrayList<>();
	ArrayList<TheThuVienDTO> thethuvien_tt=new ArrayList<>();
	ArrayList<SachDTO> masach=new ArrayList<>();
	ArrayList<TheThuVienDTO> thethuvien_ma=new ArrayList<>();
	ArrayList<PhieuMuonDTO> phieumuon=new ArrayList<>();
	ArrayList<CTPhieuMuon> ctphieumuon_ma=new ArrayList<>();
	ArrayList<CTPhieuMuon> ctphieumuon=new ArrayList<>();
	ArrayList<SachDTO> sach=new ArrayList<>();
	Vector<String> thethuvien1= new Vector<>();
	Vector<String> sach1= new Vector<>();
	JTable table;
	private JTextField textField_36;
	DefaultTableModel model;
	JTable table1;
	DefaultTableModel model1;
	/**
	/**
	 * Create the panel.
	 */
	public PhieuMuon_Form() {
		setBackground(UIManager.getColor("Panel.background"));
		
		
		setLayout(null);
		TheThuVienBUS ttvb= new TheThuVienBUS();
		thethuvien=ttvb.danhsach();
		thethuvien1.add("Option...");
		for(TheThuVienDTO ttv:thethuvien) {
			thethuvien1.add(String.valueOf(ttv.getMathetv()));
		}
		SachBUS sb= new SachBUS();
		sach=sb.danhsach();
		SachDTO s = new SachDTO();
		sach1.add("Option...");
		for(SachDTO s1:sach) {
			sach1.add(String.valueOf(s1.getMasach()));
		}
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBounds(10, 2, 945, 700);
		add(panel_18);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBounds(462, 397, 473, 200);
		panel_18.add(panel_4_2);
		panel_4_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Sách");
		lblNewLabel.setBackground(UIManager.getColor("Panel.background"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(26, 54, 73, 32);
		panel_4_2.add(lblNewLabel);
		
		JButton btnThemctpm = new JButton("Thêm");
		btnThemctpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnThemctpm.setBounds(21, 117, 126, 48);
		panel_4_2.add(btnThemctpm);
		
		JButton btnXoactpm = new JButton("Xóa");
		btnXoactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnXoactpm.setEnabled(false);
		btnXoactpm.setBounds(157, 117, 126, 48);
		panel_4_2.add(btnXoactpm);
		
		JComboBox comboBox = new JComboBox(sach1);
		comboBox.setBounds(109, 55, 112, 32);
		panel_4_2.add(comboBox);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBounds(10, 113, 489, 273);
		panel_18.add(panel_1_5);
		
		JTextPane txtpnMNv_1 = new JTextPane();
		txtpnMNv_1.setText("Mã NV");
		txtpnMNv_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMNv_1.setEditable(false);
		txtpnMNv_1.setBackground(UIManager.getColor("Panel.background"));
		txtpnMNv_1.setBounds(20, 48, 94, 38);
		panel_1_5.add(txtpnMNv_1);
		
		JTextField txtmanv = new JTextField();
		txtmanv.setEnabled(false);
		txtmanv.setColumns(10);
		txtmanv.setBounds(124, 43, 232, 38);
		panel_1_5.add(txtmanv);
		DangNhap dn= new DangNhap();
		txtmanv.setText(String.valueOf(dn.manv));
		JButton btnNewButton_2_3 = new JButton("Tải lại");
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_3.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_2_3.setBounds(378, 202, 101, 56);
		panel_1_5.add(btnNewButton_2_3);
		
		JButton btnThempm = new JButton("Thêm");
		btnThempm.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnThempm.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnThempm.setBounds(378, 30, 101, 56);
		panel_1_5.add(btnThempm);
		
		JButton btnXoapm = new JButton("Xóa");
		btnXoapm.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnXoapm.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnXoapm.setBounds(378, 118, 101, 56);
		panel_1_5.add(btnXoapm);
		
		JTextPane txtpnMNv_1_1 = new JTextPane();
		txtpnMNv_1_1.setText("Mã thẻ TV");
		txtpnMNv_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMNv_1_1.setEditable(false);
		txtpnMNv_1_1.setBackground(UIManager.getColor("Panel.background"));
		txtpnMNv_1_1.setBounds(20, 102, 94, 38);
		panel_1_5.add(txtpnMNv_1_1);
		
		JTextPane txtpnMNv_1_1_1 = new JTextPane();
		txtpnMNv_1_1_1.setText("Ngày mượn");
		txtpnMNv_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMNv_1_1_1.setEditable(false);
		txtpnMNv_1_1_1.setBackground(UIManager.getColor("Panel.background"));
		txtpnMNv_1_1_1.setBounds(20, 156, 94, 38);
		panel_1_5.add(txtpnMNv_1_1_1);
		
		JTextField txtngaymuon = new JTextField();
		txtngaymuon.setEnabled(false);
		txtngaymuon.setColumns(10);
		txtngaymuon.setBounds(124, 151, 232, 38);
		panel_1_5.add(txtngaymuon);
		
		JTextPane ngaytra = new JTextPane();
		ngaytra.setText("Ngày trả");
		ngaytra.setFont(new Font("Tahoma", Font.BOLD, 13));
		ngaytra.setEditable(false);
		ngaytra.setBackground(UIManager.getColor("Panel.background"));
		ngaytra.setBounds(20, 216, 94, 38);
		panel_1_5.add(ngaytra);
		
		JTextField txtngaytra = new JTextField();
		txtngaytra.setColumns(10);
		txtngaytra.setBounds(124, 211, 232, 38);
		panel_1_5.add(txtngaytra);
		
		JComboBox comboBox_1 = new JComboBox(thethuvien1);
		
		comboBox_1.setBounds(125, 105, 85, 22);
		panel_1_5.add(comboBox_1);
		
		textField_36 = new JTextField();
		
		textField_36.setText("");
		textField_36.setColumns(10);
		textField_36.setBounds(350, 59, 330, 33);
		panel_18.add(textField_36);
		
		JButton btnNewButton_10_1 = new JButton("Danh sách");
		btnNewButton_10_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_10_1.setBounds(38, 66, 110, 36);
		panel_18.add(btnNewButton_10_1);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		table1= new JTable();
		
		model1= new DefaultTableModel();
		table1.setModel(model1);
		model1.addColumn("Ma PM");
		model1.addColumn("Ma nv");
		model1.addColumn("Ma TTV");
		model1.addColumn("Ngay muon");
		model1.addColumn("Ngay tra");
		scrollPane_6.setViewportView(table1);
		scrollPane_6.setBounds(505, 113, 409, 273);
		panel_18.add(scrollPane_6);
		
		JTextPane txtpnTmKim_4 = new JTextPane();
		txtpnTmKim_4.setText("Tìm kiếm");
		txtpnTmKim_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTmKim_4.setEditable(false);
		txtpnTmKim_4.setBackground(UIManager.getColor("Panel.background"));
		txtpnTmKim_4.setBounds(270, 66, 90, 33);
		panel_18.add(txtpnTmKim_4);
		
		JTextPane txtpnPhiuMn = new JTextPane();
		txtpnPhiuMn.setText("Phiếu mượn");
		txtpnPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnPhiuMn.setEditable(false);
		txtpnPhiuMn.setBackground(UIManager.getColor("Panel.background"));
		txtpnPhiuMn.setBounds(367, 11, 181, 44);
		panel_18.add(txtpnPhiuMn);
		
		JScrollPane scrollPane_1_2 = new JScrollPane();
		table = new JTable();
		
		model= new DefaultTableModel();
		table.setModel(model);
		scrollPane_1_2.setViewportView(table);
		model.addColumn("Ma PM");
		model.addColumn("Ma sach");
		scrollPane_1_2.setBounds(10, 397, 442, 200);
		panel_18.add(scrollPane_1_2);
		
		final JPanel PhieuTra_Form = new JPanel();
		PhieuTra_Form.setLayout(null);
		add(PhieuTra_Form, "name_14545921437400");
		
		JPanel panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBounds(10, 11, 945, 804);
		PhieuTra_Form.add(panel_19);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBounds(467, 487, 468, 306);
		panel_19.add(panel_4_3);
		
		JTextPane txtpnMSch_3 = new JTextPane();
		txtpnMSch_3.setText("SL sách");
		txtpnMSch_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3.setEditable(false);
		txtpnMSch_3.setBackground(SystemColor.menu);
		txtpnMSch_3.setBounds(10, 28, 82, 25);
		panel_4_3.add(txtpnMSch_3);
		
		JTextField textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(102, 22, 233, 31);
		panel_4_3.add(textField_39);
		
		JButton btnNewButton_8_2 = new JButton("...");
		btnNewButton_8_2.setBounds(354, 21, 83, 32);
		panel_4_3.add(btnNewButton_8_2);
		
		JButton btnNewButton_6_3 = new JButton("Xóa");
		btnNewButton_6_3.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_6_3.setBounds(240, 238, 103, 38);
		panel_4_3.add(btnNewButton_6_3);
		
		JButton btnNewButton_4_3 = new JButton("Thêm");
		btnNewButton_4_3.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_4_3.setBounds(10, 238, 103, 38);
		panel_4_3.add(btnNewButton_4_3);
		
		JButton btnNewButton_5_3 = new JButton("Sửa");
		btnNewButton_5_3.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_5_3.setBounds(127, 238, 103, 38);
		panel_4_3.add(btnNewButton_5_3);
		
		JButton btnNewButton_7_2 = new JButton("Tải lại");
		btnNewButton_7_2.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_7_2.setBounds(353, 238, 103, 38);
		panel_4_3.add(btnNewButton_7_2);
		
		JTextPane txtpnMSch_3_1 = new JTextPane();
		txtpnMSch_3_1.setText("Ngày trả");
		txtpnMSch_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1.setEditable(false);
		txtpnMSch_3_1.setBackground(SystemColor.menu);
		txtpnMSch_3_1.setBounds(10, 78, 82, 25);
		panel_4_3.add(txtpnMSch_3_1);
		
		JTextField textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(102, 72, 335, 31);
		panel_4_3.add(textField_33);
		
		JTextPane txtpnMSch_3_2 = new JTextPane();
		txtpnMSch_3_2.setText("Ghi chú");
		txtpnMSch_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_2.setEditable(false);
		txtpnMSch_3_2.setBackground(SystemColor.menu);
		txtpnMSch_3_2.setBounds(10, 120, 82, 25);
		panel_4_3.add(txtpnMSch_3_2);
		
		JTextField textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(102, 114, 335, 113);
		panel_4_3.add(textField_34);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setLayout(null);
		panel_1_6.setBounds(10, 66, 512, 362);
		panel_19.add(panel_1_6);
		
		JButton btnNewButton_2_4 = new JButton("Tải lại");
		btnNewButton_2_4.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_2_4.setBounds(401, 300, 101, 40);
		panel_1_6.add(btnNewButton_2_4);
		
		JButton btnNewButton_3_3 = new JButton("Sửa");
		btnNewButton_3_3.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_3_3.setBounds(141, 300, 101, 40);
		panel_1_6.add(btnNewButton_3_3);
		
		JButton btnNewButton_12 = new JButton("Thêm");
		btnNewButton_12.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_12.setBounds(10, 300, 101, 40);
		panel_1_6.add(btnNewButton_12);
		
		JButton btnNewButton_1_10 = new JButton("Xóa");
		btnNewButton_1_10.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_1_10.setBounds(278, 300, 101, 40);
		panel_1_6.add(btnNewButton_1_10);
		
		JTextPane txtpnMSch_3_1_1 = new JTextPane();
		txtpnMSch_3_1_1.setText("Mã PT");
		txtpnMSch_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1.setEditable(false);
		txtpnMSch_3_1_1.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1.setBounds(10, 19, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1);
		
		JTextField textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(114, 17, 351, 40);
		panel_1_6.add(textField_35);
		
		JTextPane txtpnMSch_3_1_1_1 = new JTextPane();
		txtpnMSch_3_1_1_1.setText("Mã NV");
		txtpnMSch_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1_1.setEditable(false);
		txtpnMSch_3_1_1_1.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1_1.setBounds(10, 86, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1_1);
		
		JTextField textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(114, 84, 351, 40);
		panel_1_6.add(textField_37);
		
		JTextPane txtpnMSch_3_1_1_2 = new JTextPane();
		txtpnMSch_3_1_1_2.setText("Mã thẻ TV");
		txtpnMSch_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1_2.setEditable(false);
		txtpnMSch_3_1_1_2.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1_2.setBounds(10, 153, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1_2);
		
		JTextField textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(114, 151, 351, 40);
		panel_1_6.add(textField_38);
		
		JTextPane txtpnMSch_3_1_1_3 = new JTextPane();
		txtpnMSch_3_1_1_3.setText("Ngày trả");
		txtpnMSch_3_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1_3.setEditable(false);
		txtpnMSch_3_1_1_3.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1_3.setBounds(10, 221, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1_3);
		
		JTextField textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(114, 219, 351, 40);
		panel_1_6.add(textField_54);
		
		JTextField textField_44 = new JTextField();
		textField_44.setText("");
		textField_44.setColumns(10);
		textField_44.setBounds(180, 439, 390, 37);
		panel_19.add(textField_44);
		
		JButton btnNewButton_9_3 = new JButton("Phạt");
		btnNewButton_9_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_9_3.setBounds(580, 436, 72, 40);
		panel_19.add(btnNewButton_9_3);
		
		JButton btnNewButton_10_2 = new JButton("Danh sách");
		btnNewButton_10_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_10_2.setBounds(662, 436, 110, 40);
		panel_19.add(btnNewButton_10_2);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(4, 487, 453, 306);
		panel_19.add(scrollPane_7);
		
		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(532, 66, 403, 359);
		panel_19.add(scrollPane_1_3);
		
		JTextPane txtpnTmKim_5 = new JTextPane();
		txtpnTmKim_5.setText("Tìm kiếm");
		txtpnTmKim_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTmKim_5.setEditable(false);
		txtpnTmKim_5.setBackground(SystemColor.menu);
		txtpnTmKim_5.setBounds(94, 439, 90, 37);
		panel_19.add(txtpnTmKim_5);
		btnThemctpm.setEnabled(false);
		
		JButton phieutra = new JButton("Trả Sách");
		
		phieutra.setFont(new Font("Tahoma", Font.BOLD, 14));
		phieutra.setBounds(310, 54, 112, 38);
		panel_4_2.add(phieutra);
		phieutra.setEnabled(false);
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 103, 846, -1);
		panel_18.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 463, 846, -1);
		panel_18.add(separator_1);
		JTextPane txtpnPhiuMn_1 = new JTextPane();
		txtpnPhiuMn_1.setText("Phiếu trả");
		txtpnPhiuMn_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnPhiuMn_1.setEditable(false);
		txtpnPhiuMn_1.setBackground(SystemColor.menu);
		txtpnPhiuMn_1.setBounds(399, 11, 181, 44);
		panel_19.add(txtpnPhiuMn_1);
		
		JPanel DangXuat = new JPanel();
		DangXuat.setLayout(null);
		add(DangXuat, "name_14548034441000");
		btnThemctpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhieuMuonBUS pmb= new PhieuMuonBUS();
				phieumuon=pmb.danhsach();
				int i=model.getRowCount();
				int i2=comboBox.getSelectedIndex();
				CTPhieuMuonBUS ctpmb = new CTPhieuMuonBUS();
				CTPhieuMuon ctpm= new CTPhieuMuon();
				SachDTO s= new SachDTO();
				SachBUS sb= new SachBUS();
				if(i==3) {
					JOptionPane.showMessageDialog(null,"Mỗi lần chỉ được mượn tối đa 3 quyển sách!!!");
					return;
				}
				if(i>=1) {
					int masach=Integer.parseInt(comboBox.getSelectedItem().toString());
					for(int i1=0;i1<model.getRowCount();i1++) {
						if(String.valueOf(masach).equals(model.getValueAt(i1,0).toString())) {
							JOptionPane.showMessageDialog(null,"MỖI LOẠI SÁCH CHỈ ĐƯƠC MƯỢN 1 LẦN 1 CUỐN");
							return;
						}
					}
					ctpm.setMapm(phieumuon.get(phieumuon.size()-1).getMapm());
					ctpm.setMasach(masach);
					int sl=sach.get(i2-1).getSoluong()-1;
					if(sl<0) {
						JOptionPane.showMessageDialog(null,"Số lượng đã hết!!!");
						return;
					}
					s.setMasach(masach);
					s.setSoluong(sl);
					try {
						if(ctpmb.add(ctpm) && sb.edit_sl(s)) {
							JOptionPane.showMessageDialog(null,"Thêm sách thành công");
							model.addRow(new Object[] {
									phieumuon.get(phieumuon.size()-1).getMapm(),sach.get(i2-1).getMasach()
							});
							return;
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"MỖI LOẠI SÁCH CHỈ ĐƯƠC MƯỢN 1 LẦN 1 CUỐN");
				}
				else {
					int masach=Integer.parseInt(comboBox.getSelectedItem().toString());
					
					ctpm.setMapm(phieumuon.get(phieumuon.size()-1).getMapm());
					ctpm.setMasach(masach);
					int sl=sach.get(i2-1).getSoluong()-1;
					if(sl<0) {
						JOptionPane.showMessageDialog(null,"Số lượng đã hết!!!");
						return;
					}
					s.setMasach(masach);
					s.setSoluong(sl);
					
					try {
						if(ctpmb.add(ctpm) && sb.edit_sl(s)) {
							JOptionPane.showMessageDialog(null,"Thêm sách thành công");
							model.addRow(new Object[] {
									phieumuon.get(phieumuon.size()-1).getMapm(),sach.get(i2-1).getMasach()
							});
							return;
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"MỖI LOẠI SÁCH CHỈ ĐƯƠC MƯỢN 1 LẦN 1 CUỐN");
				}
			}
		});
		btnXoactpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					PhieuMuonBUS pmb= new PhieuMuonBUS();
					phieumuon=pmb.danhsach();
					int i=table.getSelectedRow();
					CTPhieuMuon ctpm= new CTPhieuMuon();
					ctpm.setMapm(phieumuon.get(phieumuon.size()-1).getMapm());
					ctpm.setMasach(Integer.parseInt(model.getValueAt(i,1).toString()));
					
					CTPhieuMuonBUS ctpmb= new CTPhieuMuonBUS();
					SachDTO s= new SachDTO();
					SachBUS sb= new SachBUS();
					s.setMasach(Integer.parseInt(model.getValueAt(i,1).toString()));
					masach=sb.danhsach_masach(s.getMasach());
					s.setSoluong(masach.get(0).getSoluong()+1);
					try {
						if(ctpmb.delete(ctpm) && sb.edit_sl(s)) {
							JOptionPane.showMessageDialog(null,"Xóa sách thành công");
							model.removeRow(i);
							return;
						}
					} catch (Exception e1) {
						
					}
				}
				
			}
		});
		btnXoapm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					int i=table1.getSelectedRow();
					if(i>=0) {
						CTPhieuMuon ctpm= new CTPhieuMuon();
						PhieuMuonDTO pm= new PhieuMuonDTO();
						CTPhieuMuonBUS ctpmb= new CTPhieuMuonBUS();
						PhieuMuonBUS pmb= new PhieuMuonBUS();
						int mapm=Integer.parseInt(model1.getValueAt(i,0).toString());
						pm.setMapm(mapm);
						ctpm.setMapm(mapm);
						TheThuVienBUS ttvb= new TheThuVienBUS();
						thethuvien_ma=ttvb.danhsach_ma(Integer.parseInt(model1.getValueAt(i,2).toString()));
						if(String.valueOf(thethuvien_ma.get(0).getTinhtrang()).equals("1")) {
							JOptionPane.showMessageDialog(null,"Phiếu mượn này chưa trả sách");
							return;
						}
						try {
							if(ctpmb.delete_ma(ctpm) && pmb.delete(pm)) {
								JOptionPane.showMessageDialog(null,"Xóa phiếu mượn thành công");
								hienthi();
								model.setRowCount(0);
								return;
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Xóa phiếu mượn thất bại");
						return;
					}
				
				}
			}
		});
		btnThempm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedItem().equals("Option...") || txtmanv.getText().equals("") || txtngaytra.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Yêu cầu nhập đầy đủ các trường!!!");
					return;
				}
				PhieuMuonDTO pm= new PhieuMuonDTO();
				PhieuMuonBUS pmb= new PhieuMuonBUS();
				int mathe=Integer.parseInt(comboBox_1.getSelectedItem().toString());
				int manv=Integer.parseInt(txtmanv.getText());
				Date now= new Date();
				String ngaytra=txtngaytra.getText();
				pm.setManv(manv);
				pm.setMathetv(mathe);
				pm.setNgaymuon(now);
				pm.setNgaytra(ngaytra);
				try {
					SimpleDateFormat df= new SimpleDateFormat("MM/dd/yyyy");
					Date date= new SimpleDateFormat("MM/dd/yyyy").parse(pm.getNgaytra());
					if(now.after(date)) {
						JOptionPane.showMessageDialog(null,"Ngày trả không được nhỏ hơn ngày mượn: "+df.format(now));
						return;
					}
				} catch (ParseException e1) {
					
				}
				TheThuVienDTO ttv= new TheThuVienDTO();
				ttv.setMathetv(mathe);
				ttv.setTinhtrang(1);
				try {
					if(pmb.add(pm) && ttvb.edit_tt(ttv)) {
						JOptionPane.showMessageDialog(null,"Tạo phiếu mượn thành công");
						hienthi();
						return;
					}
				} catch (Exception e1) {
					
				}
				JOptionPane.showMessageDialog(null,"Tạo phiếu mượn thất bại");
			}
		});
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				phieutra.setEnabled(true);
				PhieuMuonBUS pmb= new PhieuMuonBUS();
				phieumuon=pmb.danhsach();
				int i=table1.getSelectedRow();
				
				if(model1.getValueAt(i,0).toString().equals(String.valueOf(phieumuon.get(phieumuon.size()-1).getMapm()))) {
					btnThemctpm.setEnabled(true);
				}
				else {
					btnThemctpm.setEnabled(false);
					btnXoactpm.setEnabled(false);
				}
				
				if(i>=0) {
					model.setRowCount(0);
					CTPhieuMuonBUS ctpmb = new CTPhieuMuonBUS();
					ctphieumuon=ctpmb.danhsachid(Integer.parseInt(model1.getValueAt(i,0).toString()));
					for(CTPhieuMuon ct: ctphieumuon) {
						
						model.addRow(new Object[] {
								ct.getMapm(),ct.getMasach()
						});
					}
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int i=table.getSelectedRow();
				int i1=table1.getSelectedRow();
				if(i1<table1.getRowCount()-1) {
					btnThemctpm.setEnabled(false);
					btnXoactpm.setEnabled(false);
					return;
				}
				else {
					btnThemctpm.setEnabled(true);
					btnXoactpm.setEnabled(true);
				}
					
				
				if(i>=0) {
					comboBox.setSelectedItem(model.getValueAt(i,0).toString());
					
				}
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=Integer.parseInt(comboBox_1.getSelectedItem().toString());
				TheThuVienBUS ttvb= new TheThuVienBUS();
				thethuvien_tt=ttvb.danhsach_ma(i);
				if(String.valueOf(thethuvien_tt.get(0).getTinhtrang()).equals("1")) {
					JOptionPane.showMessageDialog(null,"Độc giả này đang mượn sách");
					comboBox_1.setSelectedIndex(0);
					return;
				}
			}
		});
		phieutra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dem=0;
				int i=table1.getSelectedRow();
				
				int mathetv=Integer.parseInt(model1.getValueAt(i,2).toString());
				int maphieumuon=Integer.parseInt(model1.getValueAt(i,0).toString());
			
				CTPhieuMuonBUS ctpmb= new CTPhieuMuonBUS();
				ctphieumuon_ma=ctpmb.danhsachid(maphieumuon);
				SachDTO s= new SachDTO();
				SachBUS sb= new SachBUS();
				for(CTPhieuMuon ctpm:ctphieumuon_ma) {
					masach=sb.danhsach_masach(ctpm.getMasach());
					s.setMasach(masach.get(0).getMasach());
					s.setSoluong(masach.get(0).getSoluong()+1);
					try {
						if(sb.edit_sl(s)) {
							dem++;
						}
					} catch (Exception e1) {
						
					}
				}
				if(dem>0) {
					TheThuVienDTO ttv= new TheThuVienDTO();
					ttv.setMathetv(mathetv);
					ttv.setTinhtrang(0);
					TheThuVienBUS ttvb= new TheThuVienBUS();
					try {
						if(ttvb.edit_tt(ttv)) {
							JOptionPane.showMessageDialog(null,"Đã Trả Sách");
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Trả thất bại");
				}
				}
				
		});
		textField_36.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchID();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchID();
             
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchID();
              
             
			}
		});

	
		hienthi();
	}
	public void SearchID(){
        try{
            model1.setRowCount(0);
            if(textField_36.getText().isEmpty()){
                table.setModel(model);
            }
            PhieuMuonBUS pmb= new PhieuMuonBUS();
    		phieumuon=pmb.danhsach();
    		String hd = textField_36.getText().toLowerCase();
    		for(PhieuMuonDTO pm:phieumuon) {
    			if(String.valueOf(pm.getMapm()).toLowerCase().contains(hd)){
    			model1.addRow(new Object[] {
    					pm.getMapm(),pm.getManv(),pm.getMathetv(),pm.getNgaymuon(),pm.getNgaytra()
    			});
    			table1.setModel(model1);
    			}
    		}
            
        }catch(Exception E){
        }
    }
	
	public void hienthi() {
		PhieuMuonBUS pmb= new PhieuMuonBUS();
		phieumuon=pmb.danhsach();
		model1.setRowCount(0);
		for(PhieuMuonDTO pm:phieumuon) {
			model1.addRow(new Object[] {
					pm.getMapm(),pm.getManv(),pm.getMathetv(),pm.getNgaymuon(),pm.getNgaytra()
			});
		}
	}
}
