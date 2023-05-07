package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.SachBUS;
import BUS.TacGiaBUS;
import BUS.TheLoaiBUS;
import DTO.SachDTO;
import DTO.TacGiaDTO;
import DTO.TheLoaiDTO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
public class sach2 extends JPanel {

	
	private JTextField txttensach;
	private JTable table;
	private JComboBox comboBox_1;
	private DefaultTableModel model;
	private JComboBox comboBox ;
	private ArrayList<TacGiaDTO> tacgia=new ArrayList<>();
	private Vector<String> tacgia1= new Vector<>();
	private ArrayList<TheLoaiDTO> theloai=new ArrayList<>();
	private ArrayList<SachDTO> sach=new ArrayList<>();
	private Vector<String> theloai1= new Vector<>();
	private JTextField txtsl;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sach2 frame = new sach2();
					frame.setVisible(true);
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
	public sach2() {
		setBackground(UIManager.getColor("MenuItem.background"));
		setForeground(new Color(0, 0, 0));
		
		setBounds(100, 100, 1018, 684);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1018, 70);
		panel.setBackground(UIManager.getColor("MenuItem.selectionForeground"));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SÁCH");
		lblNewLabel.setForeground(UIManager.getColor("OptionPane.foreground"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(417, 0, 175, 70);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 80, 1065, 2);
		add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("MenuItem.selectionForeground"));
		panel_1.setBounds(25, 93, 554, 214);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sách");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(142, 49, 95, 27);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Thể loại");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(142, 128, 95, 27);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(142, 166, 95, 27);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tác giả");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_5.setBounds(142, 87, 95, 27);
		panel_1.add(lblNewLabel_1_5);
		
		txttensach = new JTextField();
		txttensach.setColumns(10);
		txttensach.setBounds(261, 51, 202, 24);
		panel_1.add(txttensach);
		TacGiaBUS tgb= new TacGiaBUS();
		tacgia=tgb.danhsach();
		for(TacGiaDTO tg:tacgia) {
			tacgia1.add(tg.getMatacgia()+"-"+tg.getTentacgia());
		}
		//System.out.println(tacgia.size());
		comboBox = new JComboBox(tacgia1);
		
		
	
		
		
		//comboBox.setModel(new DefaultComboBoxModel(tacgia1);
		comboBox.setBounds(261, 89, 202, 24);
		panel_1.add(comboBox);
		TheLoaiBUS tlb= new TheLoaiBUS();
		theloai=tlb.danhsach();
		for(TheLoaiDTO tg:theloai) {
			theloai1.add(tg.getMatheloai()+"-"+tg.getTentheloai());
		}
		comboBox_1 = new JComboBox(theloai1);
		//comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"hi"}));
		comboBox_1.setBounds(261, 130, 202, 24);
		panel_1.add(comboBox_1);
		txtsl = new JTextField();
		txtsl.setColumns(10);
		txtsl.setBounds(261, 168, 202, 24);
		panel_1.add(txtsl);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(261, 13, 202, 24);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID sách");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(144, 14, 95, 27);
		panel_1.add(lblNewLabel_1_1_1);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(25, 438, 926, 235);
		
		
		table = new JTable();
		
		 model=  new DefaultTableModel();
		table.setModel(model);
			
			
		
//			model.addColumn(new String []{
//				"Ma Sach", "Ten Sach","The Loai","Tac Gia","Gia","So Luong"});
		
		model.addColumn("Mã Sách");
		model.addColumn("Tên Sách");
		model.addColumn("Mã thể loại");
		model.addColumn("Mã tác giả");
		
		model.addColumn("Số lượng");
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setIcon(new ImageIcon(sach2.class.getResource("./add.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SachDTO s= new SachDTO();
				int tl=comboBox_1.getSelectedIndex();
				int tg=comboBox.getSelectedIndex();
				s.setTensach(txttensach.getText());
				s.setMatacgia(tacgia.get(tg).getMatacgia());
				s.setMaloai(theloai.get(tl).getMatheloai());
				
				s.setSoluong(Integer.parseInt(txtsl.getText()));
				SachBUS sb= new SachBUS();
				try {
					if(sb.add(s)) {
						JOptionPane.showMessageDialog(null,"Thêm sách thành công");
						hienthi();
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Them sach that bai");
			}
		});
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new ImageIcon(sach2.class.getResource("./eraser.png")));
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setIcon(new ImageIcon(sach2.class.getResource("./edit.png")));
		btnThem.setBounds(25, 331, 105, 33);
		scrollPane.setViewportView(table);
		add(scrollPane);
		add(btnThem);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				btnThem.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				if(i>=0) {
					
					txttensach.setText(model.getValueAt(i,1).toString());
					
					txtsl.setText(model.getValueAt(i,4).toString());
				}
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SachDTO s= new SachDTO();
				
				
				int sl=Integer.parseInt(txtsl.getText());
				int tl=comboBox_1.getSelectedIndex();
				int tg=comboBox.getSelectedIndex();
				s.setMasach(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
				s.setTensach(txttensach.getText());
				s.setMatacgia(tacgia.get(tg).getMatacgia());
				s.setMaloai(theloai.get(tl).getMatheloai());
				
				s.setSoluong(sl);
				SachBUS sb= new SachBUS();
				try {
					if(sb.edit(s)) {
						JOptionPane.showMessageDialog(null,"Sửa sách thành công");
						btnSua.setEnabled(false);
						btnXoa.setEnabled(false);
						btnThem.setEnabled(true);
						hienthi();
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Sua sach that bai");
			}
		});
		btnSua.setBounds(169, 331, 89, 33);
		add(btnSua);
		
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					SachDTO s= new SachDTO();
					s.setMasach(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					SachBUS sb= new SachBUS();
					try {
						if(sb.delete(s)) {
							JOptionPane.showMessageDialog(null,"Xóa sách thành công");
							btnSua.setEnabled(false);
							btnXoa.setEnabled(false);
							btnThem.setEnabled(true);
							hienthi();
							return;
						}
					} catch (Exception e1) {
						
					}
					JOptionPane.showMessageDialog(null,"Xoa sach that bai");
				}
				
			}
		});
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnXoa.setBounds(300, 331, 89, 33);
		add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setIcon(new ImageIcon(sach2.class.getResource("./refresh.png")));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienthi();
			}
		});
		btnCapNhat.setBounds(426, 331, 138, 33);
		add(btnCapNhat);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("MenuItem.selectionForeground"));
		panel_2.setBounds(642, 93, 309, 214);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(sach2.class.getResource("/image/10207-man-student-light-skin-tone-icon-64.png")));
		lblNewLabel_2.setBounds(73, 0, 176, 168);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton_5 = new JButton("Thêm Hình");
		btnNewButton_5.setBounds(122, 179, 111, 23);
		panel_2.add(btnNewButton_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox_2.setBounds(700, 390, 70, 31);
		add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 120, 215)));
		panel_3.setBackground(UIManager.getColor("MenuItem.background"));
		panel_3.setBounds(300, 383, 393, 44);
		add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(7, 8, 380, 28);
		panel_3.add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
					SearchMaSach();
				}
		        else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
		            	  SearchTenSach();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
					SearchMaSach();
              }
              else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
            	  SearchTenSach();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
                  SearchMaSach();
              }
				 else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
	            	  SearchTenSach();
	              }
			}
		});
		hienthi();
	}
	public void SearchMaSach(){
        try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            SachBUS s= new SachBUS();
            sach=s.danhsach();
            String hd = textField.getText().toLowerCase();
            for(SachDTO sach1 : sach){
                if(String.valueOf(sach1.getMasach()).toLowerCase().contains(hd)){
                    model.addRow(new Object[] {
                    		sach1.getMasach(),sach1.getTensach(),sach1.getMaloai(),sach1.getMatacgia(),sach1.getSoluong()
                    });
                    table.setModel(model);
                }
            }
        }catch(Exception E){
        }
    }
    public void SearchTenSach() {
        try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            SachBUS s= new SachBUS();
            sach=s.danhsach();
            String hd = textField.getText().toLowerCase();
            for(SachDTO sach1 : sach){
                if(sach1.getTensach().toLowerCase().contains(hd)){
                    model.addRow(new Object[] {
                    		sach1.getMasach(),sach1.getTensach(),sach1.getMaloai(),sach1.getMatacgia(),sach1.getSoluong()
                    });
                    table.setModel(model);
                }
            }
        }catch(Exception E){
        }
    }
	public void hienthi() {
		SachBUS sb= new SachBUS();
		sach=sb.danhsach();
		model.setRowCount(0);
		//System.out.println(theloai.get(0).getMatheloai());
		for(SachDTO s:sach) {
			model.addRow(new Object[] {
					s.getMasach(),s.getTensach(),s.getMaloai(),s.getMatacgia(),s.getSoluong()
				});
			
		}
	}
}