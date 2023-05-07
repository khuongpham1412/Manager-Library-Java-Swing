package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.TacGiaBUS;
import DTO.TacGiaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TacGia extends JPanel {
	public static String tg;
	private DefaultTableModel model;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnthem;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtma;
	private JTextField txtten;
	private ArrayList<TacGiaDTO> theloai= new ArrayList<>();
	private JButton btncapnhat;
	private JTextField textField;
	private JComboBox comboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TacGia frame = new TacGia();
					
					frame.hienthi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TacGia() {
		setBounds(100, 110, 911, 541);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(171, 309, 641, 221);
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(TacGia.class.getResource("./edit.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthem = new JButton("Thêm");
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
		model= new DefaultTableModel();
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Panel.background"));
		panel.setBounds(107, 0, 744, 74);
		add(panel);
		panel.setLayout(null);
		add(scrollPane);
		lblNewLabel = new JLabel("TÁC GIẢ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(UIManager.getColor("OptionPane.messageForeground"));
		lblNewLabel.setBounds(296, 0, 127, 74);
		panel.add(lblNewLabel);
		separator = new JSeparator();
		separator.setBounds(0, 79, 911, 2);
		add(separator);
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("OptionPane.messageForeground")));
		panel_1.setBounds(171, 101, 641, 82);
		add(panel_1);
		panel_1.setLayout(null);
		lblNewLabel_1 = new JLabel("Mã");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 25, 77, 33);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_2 = new JLabel("Tên tác giả");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(288, 25, 104, 33);
		panel_1.add(lblNewLabel_2);
		txtma = new JTextField();
		txtma.setEditable(false);
		txtma.setBounds(66, 32, 135, 20);
		panel_1.add(txtma);
		txtma.setColumns(10);
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(391, 32, 175, 20);
		panel_1.add(txtten);
		btnthem.setIcon(new ImageIcon(TacGia.class.getResource("./add.png")));
		btnthem.setBounds(221, 199, 110, 40);
		add(btnthem);
		btnSua.setEnabled(false);
		btnSua.setBounds(360, 199, 110, 40);
		add(btnSua);
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(TacGia.class.getResource("./eraser.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setEnabled(false);
		btnXoa.setBounds(496, 199, 110, 40);
		add(btnXoa);
		btncapnhat = new JButton("Cập nhật");
		btncapnhat.setIcon(new ImageIcon(TacGia.class.getResource("./refresh.png")));
		btncapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btncapnhat.setBounds(628, 199, 123, 40);
		add(btncapnhat);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(342, 256, 186, 31);
		add(textField);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox.setBounds(538, 256, 96, 31);
		add(comboBox);
		model.addColumn("Ma Tac Gia");
		model.addColumn("Ten Tac Gia");
		hienthi();
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
		eventclick();
	}
	
	
	private void eventclick() {
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				hienthi();
			}
		});
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( txtten.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
				}
				else {
				
					TacGiaDTO tl= new TacGiaDTO();
					
					tl.setTentacgia(txtten.getText());
					TacGiaBUS tlb= new TacGiaBUS();
					try {
						if(tlb.add(tl)) {
							JOptionPane.showMessageDialog(null,"Them Tac Gia Thanh Cong");
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Them Tac Gia That Bai");
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					txtma.setText(String.valueOf(model.getValueAt(i,0)));
					txtten.setText((String) model.getValueAt(i,1));
				}
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnthem.setEnabled(false);
			}
			
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
				}
				else {
					int ma=Integer.parseInt(txtma.getText());
					TacGiaDTO tl= new TacGiaDTO();
					tl.setMatacgia(ma);
					tl.setTentacgia(txtten.getText());
					TacGiaBUS tlb= new TacGiaBUS();
					try {
						if(tlb.edit(tl)) {
							
							JOptionPane.showMessageDialog(null,"Sua Tac Gia Thanh Cong");
							btnthem.setEnabled(true);
							btnSua.setEnabled(false);
							btnXoa.setEnabled(false);
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Sua Tac Gia That Bai");
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					int ma=Integer.parseInt(txtma.getText());
					TacGiaDTO tl= new TacGiaDTO();
					tl.setMatacgia(ma);
					TacGiaBUS tlb= new TacGiaBUS();
					try {
						if(tlb.delete(tl)) {
							JOptionPane.showMessageDialog(null,"Xoa Tac Gia Thanh Cong");
							btnthem.setEnabled(true);
							btnSua.setEnabled(false);
							btnXoa.setEnabled(false);
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Xoa Tac Gia That Bai");
				}
				
			}
		});
	}

	
	public void SearchName(){
        try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            TacGiaBUS nvb= new TacGiaBUS();
    		theloai=nvb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(TacGiaDTO tg : theloai){
                if(tg.getTentacgia().toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
        					tg.getMatacgia(),tg.getTentacgia()
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
            TacGiaBUS nvb= new TacGiaBUS();
    		theloai=nvb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(TacGiaDTO tg : theloai){
                if(String.valueOf(tg.getMatacgia()).toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
                			tg.getMatacgia(),tg.getTentacgia()
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
	}
	
	
	public void hienthi() {
		TacGiaBUS tlb= new TacGiaBUS();
		theloai=tlb.danhsach();
		model.setRowCount(0);
		for(TacGiaDTO tl:theloai) {
			model.addRow(new Object[] {
				tl.getMatacgia(),tl.getTentacgia()
			});
		}
	}
}
