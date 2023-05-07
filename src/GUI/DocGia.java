package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import BUS.DocGiaBUS;
import BUS.TacGiaBUS;
import BUS.TheThuVienBUS;
import DTO.DocGiaDTO;
import DTO.TacGiaDTO;
import DTO.TheThuVienDTO;

import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DocGia extends JPanel {

	private JTextField txtten;
	private JTextField textField_1;
	private JTextField txtdiachi;
	private JTextField txtgt;
	private JTextField txtsdt;
	private JTextField textField_6;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<DocGiaDTO> docgia= new ArrayList<>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocGia frame = new DocGia();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DocGia() {
		setBackground(UIManager.getColor("Panel.background"));
		
		setBounds(300, 200, 918, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textInactiveText, 2, true));
		panel.setBounds(113, 47, 734, 206);
		add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnTn = new JTextPane();
		txtpnTn.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTn.setText("Họ tên");
		txtpnTn.setBackground(UIManager.getColor("Panel.background"));
		txtpnTn.setEditable(false);
		txtpnTn.setBounds(27, 9, 82, 27);
		panel.add(txtpnTn);
		
		JTextPane txttuoi = new JTextPane();
		txttuoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txttuoi.setText("Tuổi");
		txttuoi.setBackground(UIManager.getColor("Panel.background"));
		txttuoi.setEditable(false);
		txttuoi.setBounds(27, 60, 82, 27);
		panel.add(txttuoi);
		
		JTextPane txtpnaCh = new JTextPane();
		txtpnaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnaCh.setText("Địa chỉ");
		txtpnaCh.setBackground(UIManager.getColor("Panel.background"));
		txtpnaCh.setEditable(false);
		txtpnaCh.setBounds(27, 109, 82, 27);
		panel.add(txtpnaCh);
		
		JTextPane txtpnGiiTnh = new JTextPane();
		txtpnGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnGiiTnh.setText("Giới tính");
		txtpnGiiTnh.setBackground(UIManager.getColor("Panel.background"));
		txtpnGiiTnh.setEditable(false);
		txtpnGiiTnh.setBounds(387, 9, 116, 27);
		panel.add(txtpnGiiTnh);
		
		JTextPane txtpnSinThoi = new JTextPane();
		txtpnSinThoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSinThoi.setText("Số điện thoại");
		txtpnSinThoi.setBackground(UIManager.getColor("Panel.background"));
		txtpnSinThoi.setEditable(false);
		txtpnSinThoi.setBounds(387, 60, 116, 27);
		panel.add(txtpnSinThoi);
		
		txtten = new JTextField();
		txtten.setBounds(132, 9, 181, 27);
		panel.add(txtten);
		txtten.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 60, 181, 27);
		panel.add(textField_1);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(132, 109, 574, 27);
		panel.add(txtdiachi);
		
		txtgt = new JTextField();
		txtgt.setColumns(10);
		txtgt.setBounds(525, 9, 181, 27);
		panel.add(txtgt);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(525, 60, 181, 27);
		panel.add(txtsdt);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		JButton btnNewButton_1_1 = new JButton("Sửa");
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_2.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("") || txtgt.getText().equals("") || txttuoi.getText().equals("") || txtdiachi.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
				}
				else {
					DocGiaDTO dg= new DocGiaDTO();
					dg.setTendg(txtten.getText());
					dg.setTuoi(Integer.parseInt(textField_1.getText()));
					dg.setGioitinh(txtgt.getText());
					dg.setSdt(txtsdt.getText());
					dg.setDiachi(txtdiachi.getText());
					dg.setTrangthai(0);
					DocGiaBUS tgb= new DocGiaBUS();
					try {
						if(tgb.add(dg)) {
							//System.out.println("hel");
							JOptionPane.showMessageDialog(null,"Thêm Độc Gỉa Thành Công");
							hienthi();
							return;
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Thêm Độc Gỉa Thất Bại");
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DocGia.class.getResource("./add.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(111, 157, 122, 36);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("") || txtgt.getText().equals("") || txttuoi.getText().equals("") || txtdiachi.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
				}
				else {
					DocGiaDTO dg= new DocGiaDTO();
					dg.setMadg(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					dg.setTendg(txtten.getText());
					dg.setTuoi(Integer.parseInt(textField_1.getText()));
					dg.setGioitinh(txtgt.getText());
					dg.setSdt(txtsdt.getText());
					dg.setDiachi(txtdiachi.getText());
					dg.setTrangthai(0);
					DocGiaBUS tgb= new DocGiaBUS();
					try {
						if(tgb.edit(dg)) {
							//System.out.println("hel");
							JOptionPane.showMessageDialog(null,"Sửa Độc Gỉa Thành Công");
							btnNewButton_1_1.setEnabled(false);
							btnNewButton_1_2.setEnabled(false);
							btnNewButton_1.setEnabled(true);
							hienthi();
							return;
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Sửa Độc Gỉa Thất Bại");
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(DocGia.class.getResource("./edit.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(247, 157, 122, 36);
		panel.add(btnNewButton_1_1);
		
		
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					DocGiaDTO dg= new DocGiaDTO();
					dg.setMadg(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					DocGiaBUS tgb= new DocGiaBUS();
					TheThuVienBUS ttvb= new TheThuVienBUS();
					TheThuVienDTO ttv= new TheThuVienDTO();
					ttv.setMadocgia(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					try {
						if(tgb.delete(dg) || ttvb.delete_madocgia(ttv)) {
							JOptionPane.showMessageDialog(null,"Xoa Độc Gỉa Thành Công");
							btnNewButton_1_1.setEnabled(false);
							btnNewButton_1_2.setEnabled(false);
							btnNewButton_1.setEnabled(true);
							
							hienthi();
							return;
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Xoa Độc Gỉa Thất Bại");
				
				
				}
				
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon(DocGia.class.getResource("./eraser.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(385, 157, 122, 36);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Tải lại");
		btnNewButton_1_3.setIcon(new ImageIcon(DocGia.class.getResource("./refresh.png")));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3.setBounds(520, 157, 122, 36);
		panel.add(btnNewButton_1_3);
		
		JTextPane txtpnTmKim = new JTextPane();
		txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTmKim.setText("Tìm kiếm");
		txtpnTmKim.setBackground(UIManager.getColor("Panel.background"));
		txtpnTmKim.setEditable(false);
		txtpnTmKim.setBounds(220, 291, 76, 32);
		add(txtpnTmKim);
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 341, 735, 202);
		add(scrollPane);
		 model= new DefaultTableModel();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					txtten.setText( model.getValueAt(i,1).toString());
					textField_1.setText( model.getValueAt(i,2).toString());
					txtgt.setText(model.getValueAt(i,3).toString());
					txtsdt.setText( model.getValueAt(i,5).toString());
					txtdiachi.setText(model.getValueAt(i,4).toString());
					btnNewButton_1.setEnabled(false);
					btnNewButton_1_1.setEnabled(true);
					btnNewButton_1_2.setEnabled(true);
				}
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(model);
		scrollPane.setViewportView(table);
		model.addColumn("Mã Độc Giả");
		model.addColumn("Tên Độc Giả");
		model.addColumn("Tuổi");
		model.addColumn("Giới Tính");
		model.addColumn("Đia Chỉ");
		model.addColumn("SĐT");
		JTextPane txtpncGi = new JTextPane();
		txtpncGi.setText("Độc giả");
		txtpncGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpncGi.setEditable(false);
		txtpncGi.setBackground(UIManager.getColor("Panel.background"));
		txtpncGi.setBounds(421, 0, 89, 39);
		add(txtpncGi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(306, 270, 428, 58);
		add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 120, 215), 6, true));
		panel_1.setLayout(null);
		textField_6 = new JTextField();
		textField_6.setBorder(emptyBorder);
		textField_6.setBounds(6, 7, 356, 40);
		panel_1.add(textField_6);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setBackground(UIManager.getColor("Panel.background"));
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox.setBounds(362, 7, 56, 22);
		panel_1.add(comboBox);
		hienthi();
		textField_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) =="Mã"){
					SearchMaDG();
				}
		        else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
		            	  SearchTenDG();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
					SearchMaDG();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
            	  SearchTenDG();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchMaDG();
              }
				 else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
	            	  SearchTenDG();
	              }
			}
			
		});
		hienthi();
	}
	public void SearchMaDG(){
		try{
            model.setRowCount(0);
            if(textField_6.getText().isEmpty()){
                table.setModel(model);
            }
            DocGiaBUS dgb= new DocGiaBUS();
    		docgia=dgb.danhsach();
            String hd = textField_6.getText().toLowerCase();
            for(DocGiaDTO docg : docgia){
                if(String.valueOf(docg.getMadg()).toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
                			docg.getMadg(),docg.getTendg(),docg.getTuoi(),docg.getGioitinh(),docg.getDiachi(),docg.getSdt()
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
    }
    public void SearchTenDG() {
        try{
            model.setRowCount(0);
            if(textField_6.getText().isEmpty()){
                table.setModel(model);
            }
            DocGiaBUS dg= new DocGiaBUS();
            docgia=dg.danhsach();
            String hd = textField_6.getText().toLowerCase();
            for(DocGiaDTO docg : docgia){
                if(docg.getTendg().toLowerCase().contains(hd)){
                    model.addRow(new Object[] {
                    		docg.getMadg(),docg.getTendg(),docg.getTuoi(),docg.getGioitinh(),docg.getDiachi(),docg.getSdt()
                    });
                    table.setModel(model);
                }
            }
        }catch(Exception E){
        }
    }
	
	
	public void hienthi() {
		DocGiaBUS dgb= new DocGiaBUS();
		docgia=dgb.danhsach();
		model.setRowCount(0);
		for(DocGiaDTO dg:docgia) {
			model.addRow(new Object[] {
					dg.getMadg(),dg.getTendg(),dg.getTuoi(),dg.getGioitinh(),dg.getDiachi(),dg.getSdt()
			});
		}
	}
	
}
