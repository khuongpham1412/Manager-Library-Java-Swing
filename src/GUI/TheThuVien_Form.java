package GUI;

import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BUS.DocGiaBUS;
import BUS.SachBUS;
import BUS.TheThuVienBUS;
import DTO.DocGiaDTO;
import DTO.SachDTO;
import DTO.TheThuVienDTO;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

public class TheThuVien_Form extends JPanel {
	ArrayList<DocGiaDTO> docgia = new ArrayList<>();
	ArrayList<TheThuVienDTO> thethuvien = new ArrayList<>();
	Vector<String> docgia1= new Vector<>();
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtngaybd;
	private JTextField txtma;
	private JButton btnNewButton_1_2;
	private JTextField textField_5;
	/**
	 * Create the panel.
	 */
	public TheThuVien_Form() {
		setLayout(null);
		DocGiaBUS dgb= new DocGiaBUS();
		docgia=dgb.danhsach();
		DocGiaDTO s = new DocGiaDTO();
		docgia1.add("Option...");
		for(DocGiaDTO s1:docgia) {
			if(s1.getTrangthai()!=1) {
				docgia1.add(String.valueOf(s1.getMadg()));
			}
			
		}
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(SystemColor.textInactiveText, 2, true));
		panel_12.setBounds(109, 47, 734, 206);
		add(panel_12);
		
		JTextPane txtpnNmSinh = new JTextPane();
		txtpnNmSinh.setText("Mã độc giả");
		txtpnNmSinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnNmSinh.setEditable(false);
		txtpnNmSinh.setBackground(UIManager.getColor("Panel.background"));
		txtpnNmSinh.setBounds(10, 52, 82, 27);
		panel_12.add(txtpnNmSinh);
		
		JTextPane txtpnSinThoi = new JTextPane();
		txtpnSinThoi.setText("Ngày hết hạn");
		txtpnSinThoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSinThoi.setEditable(false);
		txtpnSinThoi.setBackground(UIManager.getColor("Panel.background"));
		txtpnSinThoi.setBounds(10, 119, 116, 27);
		panel_12.add(txtpnSinThoi);
		
		JTextField ngayhh = new JTextField();
		ngayhh.setColumns(10);
		ngayhh.setBounds(129, 119, 181, 27);
		panel_12.add(ngayhh);
		
		JButton btnNewButton_1_4 = new JButton("Thêm");
		
		btnNewButton_1_4.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_4.setBounds(111, 157, 122, 36);
		panel_12.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_1_2 = new JButton("Sửa");
		btnNewButton_1_1_2.setEnabled(false);
		
		btnNewButton_1_1_2.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_2.setBounds(247, 157, 122, 36);
		panel_12.add(btnNewButton_1_1_2);
		
		btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setEnabled(false);
		
		btnNewButton_1_2.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(385, 157, 122, 36);
		panel_12.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3_1 = new JButton("Tải lại");
		btnNewButton_1_3_1.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3_1.setBounds(520, 157, 122, 36);
		panel_12.add(btnNewButton_1_3_1);
		
		JComboBox comboBox = new JComboBox(docgia1);
		comboBox.setBounds(129, 52, 181, 27);
		panel_12.add(comboBox);
		
		txtngaybd = new JTextField();
		txtngaybd.setEnabled(false);
		txtngaybd.setColumns(10);
		txtngaybd.setBounds(129, 90, 181, 27);
		panel_12.add(txtngaybd);
		
		txtma = new JTextField();
		txtma.setEnabled(false);
		txtma.setColumns(10);
		txtma.setBounds(129, 11, 181, 27);
		panel_12.add(txtma);
		
		JTextPane ngaybd = new JTextPane();
		ngaybd.setText("Ngày bắt đầu");
		ngaybd.setFont(new Font("Tahoma", Font.BOLD, 13));
		ngaybd.setEditable(false);
		ngaybd.setBackground(UIManager.getColor("Panel.background"));
		ngaybd.setBounds(10, 90, 116, 27);
		panel_12.add(ngaybd);
		
		JTextPane txtpnMaThe = new JTextPane();
		txtpnMaThe.setText("Mã thẻ");
		txtpnMaThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMaThe.setEditable(false);
		txtpnMaThe.setBackground(UIManager.getColor("Panel.background"));
		txtpnMaThe.setBounds(10, 14, 116, 27);
		panel_12.add(txtpnMaThe);
		
		JTextPane txtpnTmKim = new JTextPane();
		txtpnTmKim.setText("Tìm kiếm");
		txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTmKim.setEditable(false);
		txtpnTmKim.setBackground(UIManager.getColor("Panel.background"));
		txtpnTmKim.setBounds(216, 291, 76, 32);
		add(txtpnTmKim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 341, 735, 202);
		table= new JTable();
		
		model= new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Ma the");
		model.addColumn("Ma doc gia");
		model.addColumn("Ngay bat bau");
		model.addColumn("Ngay het han");
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JTextPane txtpncGi = new JTextPane();
		txtpncGi.setText("Thẻ Thư Viện");
		txtpncGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpncGi.setEditable(false);
		txtpncGi.setBackground(UIManager.getColor("Panel.background"));
		txtpncGi.setBounds(415, 11, 176, 39);
		add(txtpncGi);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 120, 215), 6, true));
		panel_1_1.setBounds(302, 270, 428, 58);
		add(panel_1_1);
		
		 textField_5= new JTextField("");
		
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBorder(emptyBorder);
		textField_5.setBackground(UIManager.getColor("Panel.background"));
		textField_5.setBounds(6, 7, 362, 40);
		panel_1_1.add(textField_5);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Option...") || ngayhh.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Yêu cầu nhập đầy đủ các trường");
					return;
				}
				TheThuVienDTO ttv = new TheThuVienDTO();
				String madocgia=String.valueOf(comboBox.getSelectedItem());
				ttv.setMadocgia(Integer.parseInt(madocgia));
				Date now= new Date();
				
				ttv.setNgaybd(now);
			
				ttv.setNgayhh(ngayhh.getText());
				ttv.setTinhtrang(0);
				TheThuVienBUS ttvb= new TheThuVienBUS();
				DocGiaDTO dg= new DocGiaDTO();
				DocGiaBUS dgb= new DocGiaBUS();
				dg.setMadg(Integer.parseInt(madocgia));
				dg.setTrangthai(1);
				String a=ttv.getNgayhh();
				Date date;
				try {
					date = new SimpleDateFormat("MM/dd/yyyy").parse(a);
					if(now.after(date)) {
						JOptionPane.showMessageDialog(null,"Ngày hết hạn phải lớn hơn ngày tạo thẻ: "+now);
						return;
					}
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
			
					if(ttvb.add(ttv) && dgb.edit_tt(dg)) {
						JOptionPane.showMessageDialog(null,"Tạo thẻ thư viện thành công");
						hienthi();
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Them that bai");
			}
		});
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					TheThuVienDTO ttv= new TheThuVienDTO();
					ttv.setMathetv(Integer.parseInt(txtma.getText()));
					TheThuVienBUS ttvb= new TheThuVienBUS();
					try {
						if(ttvb.delete(ttv)) {
							JOptionPane.showMessageDialog(null,"Xóa thẻ thư viện thành công");
							btnNewButton_1_2.setEnabled(false);
							btnNewButton_1_1_2.setEnabled(false);
							comboBox.setEnabled(true);
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Xoa that bai");
				}
				
			}
		});
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TheThuVienDTO ttv= new TheThuVienDTO();
				ttv.setMathetv(Integer.parseInt(txtma.getText()));
				ttv.setNgayhh(ngayhh.getText());
				TheThuVienBUS ttvb= new TheThuVienBUS();
				Date now= new Date();
				String a=ttv.getNgayhh();
				Date date;
				try {
					date = new SimpleDateFormat().parse(a);
					if(now.after(date)) {
						JOptionPane.showMessageDialog(null,"Ngày hết hạn phải lớn hơn ngày tạo: "+now);
						return;
					}
				} catch (ParseException e2) {
				}
				
				try {
					if(ttvb.edit(ttv)) {
						JOptionPane.showMessageDialog(null,"Cập nhật dữ liệu thành công");
						btnNewButton_1_2.setEnabled(false);
						btnNewButton_1_1_2.setEnabled(false);
						comboBox.setEnabled(true);
						hienthi();
						return;
					}
				} catch (Exception e1) {
					
				}
				JOptionPane.showMessageDialog(null,"Sua that bai");
			}
			
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i= table.getSelectedRow();
				if(i>=0) {
					
					txtma.setText(model.getValueAt(i,0).toString());
					comboBox.addItem(model.getValueAt(i,1).toString());
					comboBox.setSelectedItem(model.getValueAt(i,1).toString());
					txtngaybd.setText(model.getValueAt(i,2).toString());
					ngayhh.setText(model.getValueAt(i,3).toString());
					btnNewButton_1_1_2.setEnabled(true);
					btnNewButton_1_2.setEnabled(true);
					comboBox.setEnabled(false);
				}
				
			}
		});
		hienthi();
		textField_5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
					SearchMaTheTV();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
					SearchMaTheTV();
             
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchMaTheTV();
              
			}
		});
	}
	
	public void SearchMaTheTV(){
        try{
            model.setRowCount(0);
            if(textField_5.getText().isEmpty()){
                table.setModel(model);
            }
            TheThuVienBUS thethuvienb= new TheThuVienBUS();
    		thethuvien=thethuvienb.danhsach();
            String hd = textField_5.getText().toLowerCase();
            for(TheThuVienDTO ttv : thethuvien){
                if(String.valueOf(ttv.getMathetv()).toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
                			ttv.getMathetv(),ttv.getMadocgia(),ttv.getNgaybd(),ttv.getNgayhh()
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
    }
	public void hienthi() {
		TheThuVienBUS ttvb= new TheThuVienBUS();
		thethuvien=ttvb.danhsach();
		model.setRowCount(0);
		for(TheThuVienDTO ttv:thethuvien) {
			model.addRow(new Object[] {
				ttv.getMathetv(),ttv.getMadocgia(),ttv.getNgaybd(),ttv.getNgayhh()
			});
		}
	}
}
