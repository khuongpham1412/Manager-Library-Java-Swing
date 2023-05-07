package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class NhaCungCap extends JPanel {

	
	private JTextField txtten;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTable table;
	private DefaultTableModel model;
	ArrayList<NhaCungCapDTO> ncc= new ArrayList<>();
	private JTextField txtma;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCap frame = new NhaCungCap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhaCungCap() {
		
		setBounds(100, 100, 952, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(SystemColor.textInactiveText, 2, true));
		panel.setBounds(130, 48, 764, 274);
		add(panel);
		
		JTextPane txtpnNgyBtu_1 = new JTextPane();
		txtpnNgyBtu_1.setText("Địa chỉ");
		txtpnNgyBtu_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnNgyBtu_1.setEditable(false);
		txtpnNgyBtu_1.setBackground(UIManager.getColor("Panel.background"));
		txtpnNgyBtu_1.setBounds(127, 102, 176, 27);
		panel.add(txtpnNgyBtu_1);
		
		JTextPane txtpnSinThoi_1 = new JTextPane();
		txtpnSinThoi_1.setText("Số điện thoại");
		txtpnSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSinThoi_1.setEditable(false);
		txtpnSinThoi_1.setBackground(UIManager.getColor("Panel.background"));
		txtpnSinThoi_1.setBounds(127, 144, 176, 27);
		panel.add(txtpnSinThoi_1);
		
		JTextPane txtpnGiiTnh = new JTextPane();
		txtpnGiiTnh.setText("Tên nhà cung cấp");
		txtpnGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnGiiTnh.setEditable(false);
		txtpnGiiTnh.setBackground(UIManager.getColor("Panel.background"));
		txtpnGiiTnh.setBounds(127, 58, 176, 27);
		panel.add(txtpnGiiTnh);
		
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(337, 54, 281, 27);
		panel.add(txtten);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(337, 102, 281, 27);
		panel.add(txtdiachi);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(337, 144, 281, 27);
		panel.add(txtsdt);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		
		btnNewButton_1.setIcon(new ImageIcon(NhaCungCap.class.getResource("./add.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(111, 216, 122, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setEnabled(false);
		
		btnNewButton_1_1.setIcon(new ImageIcon(NhaCungCap.class.getResource("./edit.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(247, 216, 122, 36);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setEnabled(false);
		
		btnNewButton_1_2.setIcon(new ImageIcon(NhaCungCap.class.getResource("./eraser.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(385, 216, 122, 36);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Tải lại");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienthi();
			}
		});
		btnNewButton_1_3.setIcon(new ImageIcon(NhaCungCap.class.getResource("./refresh.png")));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3.setBounds(520, 216, 122, 36);
		panel.add(btnNewButton_1_3);
		
		JLabel lblNewLabel = new JLabel("Mã nhà cung cấp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBackground(UIManager.getColor("Panel.background"));
		lblNewLabel.setBounds(127, 11, 195, 32);
		panel.add(lblNewLabel);
		
		txtma = new JTextField();
		txtma.setEnabled(false);
		txtma.setColumns(10);
		txtma.setBounds(337, 11, 281, 27);
		panel.add(txtma);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 409, 763, 217);
		
		model= new DefaultTableModel();
		table = new JTable();
		
		table.setModel(model);
		
		model.addColumn("Ma ncc");
		model.addColumn("Ten ncc");
		model.addColumn("Dia Chi ncc");
		model.addColumn("SDT ncc");
		scrollPane.setViewportView(table);
		add(scrollPane);
		JTextPane txtpnNhCungCp = new JTextPane();
		txtpnNhCungCp.setText("Nhà cung cấp");
		txtpnNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnNhCungCp.setEditable(false);
		txtpnNhCungCp.setBackground(UIManager.getColor("Panel.background"));
		txtpnNhCungCp.setBounds(442, 11, 176, 27);
		add(txtpnNhCungCp);
		
		JTextPane txtpnTmKim = new JTextPane();
		txtpnTmKim.setText("Tìm kiếm");
		txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTmKim.setEditable(false);
		txtpnTmKim.setBackground(SystemColor.menu);
		txtpnTmKim.setBounds(256, 366, 76, 32);
		add(txtpnTmKim);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 120, 215), 6, true));
		panel_1.setBounds(342, 340, 428, 58);
		add(panel_1);
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
		textField = new JTextField();
		
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(emptyBorder);
		textField.setBackground(UIManager.getColor("Panel.background"));
		textField.setBounds(10, 7, 342, 40);
		panel_1.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox.setBounds(360, 7, 58, 22);
		panel_1.add(comboBox);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("") || txtdiachi.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
					return;
				}
				else {
					String tenncc=txtten.getText();
					String diachi=txtdiachi.getText();
					String sdt=txtsdt.getText();
					NhaCungCapDTO ncc= new NhaCungCapDTO();
					ncc.setTenncc(tenncc);
					ncc.setDiachi(diachi);
					ncc.setSdt(sdt);
					NhaCungCapBUS nccb= new NhaCungCapBUS();
					try {
						if(nccb.add(ncc)==true) {
							JOptionPane.showMessageDialog(null,"Them Nha cung cap thnah cong");
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"them that bai");
				}
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("") || txtdiachi.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
					return;
				}
				else {
					int mancc=Integer.parseInt(txtma.getText());
					String tenncc=txtten.getText();
					String diachi=txtdiachi.getText();
					String sdt=txtsdt.getText();
					NhaCungCapDTO ncc= new NhaCungCapDTO();
					ncc.setMancc(mancc);
					ncc.setTenncc(tenncc);
					ncc.setDiachi(diachi);
					ncc.setSdt(sdt);
					NhaCungCapBUS nccb= new NhaCungCapBUS();
					try {
						if(nccb.edit(ncc)) {
							JOptionPane.showMessageDialog(null,"Sua Nha cung cap thnah cong");
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Sua that bai");
				}
			}
		});
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					int mancc=Integer.parseInt(txtma.getText());
					NhaCungCapDTO ncc= new NhaCungCapDTO();
					ncc.setMancc(mancc);
					NhaCungCapBUS nccb= new NhaCungCapBUS();
					try {
						if(nccb.delete(ncc)) {
							JOptionPane.showMessageDialog(null,"Xoa Nha cung cap thnah cong");
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					txtma.setText(model.getValueAt(i,0).toString());
					txtten.setText(model.getValueAt(i,1).toString());
					txtdiachi.setText(model.getValueAt(i,2).toString());
					txtsdt.setText(model.getValueAt(i,3).toString());
				}
				btnNewButton_1_1.setEnabled(true);
				btnNewButton_1_2.setEnabled(true);
				
			}
		});
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchID();
				}
	              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
	                  SearchName();
	              }
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchID();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
                  SearchName();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchID();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
                  SearchName();
              }
			}
		});
		hienthi();
	}
	public void SearchName() {
		try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            NhaCungCapBUS nvb= new NhaCungCapBUS();
    		ncc=nvb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(NhaCungCapDTO ncc: ncc){
                if(ncc.getTenncc().toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
        					ncc.getMancc(),ncc.getTenncc(),ncc.getDiachi(),ncc.getSdt(),
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
	}
	public void SearchID() {
		try{
			model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            NhaCungCapBUS nvb= new NhaCungCapBUS();
    		ncc=nvb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(NhaCungCapDTO ncc: ncc){
                if(String.valueOf(ncc.getMancc()).toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
        					ncc.getMancc(),ncc.getTenncc(),ncc.getDiachi(),ncc.getSdt(),
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
	}
	public void hienthi() {
		NhaCungCapBUS nccb= new NhaCungCapBUS();
		ncc=nccb.danhsach();
		model.setRowCount(0);
		for(NhaCungCapDTO ncc1:ncc) {
			model.addRow(new Object[] {
					ncc1.getMancc(),ncc1.getTenncc(),ncc1.getDiachi(),ncc1.getSdt()
			});
		}
	}
}
