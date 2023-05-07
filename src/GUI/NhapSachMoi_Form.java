//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import BUS.CTPhieuNhapBUS;
//import BUS.SachBUS;
//import BUS.TacGiaBUS;
//import BUS.TheLoaiBUS;
//import DTO.CTPhieuNhap;
//import DTO.SachDTO;
//import DTO.TacGiaDTO;
//import DTO.TheLoaiDTO;
//
//import javax.swing.JComboBox;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Vector;
//import java.awt.event.ActionEvent;
//import javax.swing.JLabel;
//
//public class NhapSachMoi_Form extends JFrame {
//	
//	private JPanel contentPane;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	ArrayList<SachDTO> sach= new ArrayList<>();
//	ArrayList<TheLoaiDTO> theloai= new ArrayList<>();
//	ArrayList<TacGiaDTO> tacgia= new ArrayList<>();
//	Vector<Object> theloai1= new Vector<>();
//	Vector<Object> tacgia1= new Vector<>();
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public NhapSachMoi_Form(int mapn) {
//		System.out.println(mapn);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 744, 472);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		TheLoaiDTO tld= new TheLoaiDTO();
//		TheLoaiBUS tlb= new TheLoaiBUS();
//		theloai1.add("Option...");
//		theloai=tlb.danhsach();
//		for(TheLoaiDTO tl: theloai) {
//			theloai1.add(tl.getMatheloai()+"-"+tl.getTentheloai());
//		}
//		TacGiaDTO tg= new TacGiaDTO();
//		TacGiaBUS tgb= new TacGiaBUS();
//		tacgia1.add("Option...");
//		tacgia=tgb.danhsach();
//		for(TacGiaDTO tl: tacgia) {
//			tacgia1.add(tl.getMatacgia()+"-"+tl.getTentacgia());
//		}
//		JComboBox comboBox = new JComboBox(theloai1);
//		comboBox.setBounds(310, 95, 171, 34);
//		contentPane.add(comboBox);
//		
//		JComboBox comboBox_1 = new JComboBox(tacgia1);
//		comboBox_1.setBounds(310, 140, 171, 34);
//		contentPane.add(comboBox_1);
//		
//		textField = new JTextField();
//		textField.setBounds(314, 46, 171, 38);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10);
//		textField_1.setBounds(310, 198, 171, 38);
//		contentPane.add(textField_1);
//		
//		textField_2 = new JTextField();
//		textField_2.setColumns(10);
//		textField_2.setBounds(310, 258, 171, 38);
//		contentPane.add(textField_2);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) {
//					JOptionPane.showMessageDialog(null,"Khong duoc de trong");
//				}
//				else {
//					SachDTO s= new SachDTO();
//					SachBUS sb= new SachBUS();
//					s.setTensach(textField.getText());
//					s.setMaloai(theloai.get(comboBox.getSelectedIndex()-1).getMatheloai());
//					s.setMatacgia(tacgia.get(comboBox_1.getSelectedIndex()-1).getMatacgia());
//					int sl=Integer.parseInt(textField_1.getText());
//					int dongia=Integer.parseInt(textField_2.getText());
//					int thanhtien=sl*dongia;
//					s.setSoluong(sl);
//					try {
//						if(sb.add(s)) {
//							sach=sb.danhsach();
//							int masach=sach.get(sach.size()-1).getMasach();
//							CTPhieuNhap ctpn= new CTPhieuNhap();
//							ctpn.setMapn(mapn);
//							ctpn.setMasach(masach);
//							ctpn.setSoluong(sl);
//							ctpn.setDongia(dongia);
//							ctpn.setThanhtien(thanhtien);
//							CTPhieuNhapBUS ctpnb= new CTPhieuNhapBUS();
//							if(ctpnb.add(ctpn)) {
//								JOptionPane.showMessageDialog(null,"Them thanh cong");
//								PhieuNhap pn=new PhieuNhap();
//								pn.hienthi();
//								setVisible(false);
//								return;
//							}
//						}
//					} catch (Exception e2) {
//						
//					}
//					JOptionPane.showMessageDialog(null,"Them that bai");
//				}
//			}
//
//
//			
//		});
//		btnNewButton.setBounds(250, 341, 89, 23);
//		contentPane.add(btnNewButton);
//		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setBounds(52, 58, 114, 26);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblSoLuong = new JLabel("so luong");
//		lblSoLuong.setBounds(52, 210, 114, 26);
//		contentPane.add(lblSoLuong);
//		
//		JLabel lblDongia = new JLabel("dongia");
//		lblDongia.setBounds(52, 258, 114, 26);
//		contentPane.add(lblDongia);
//	}
//}
