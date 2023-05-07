//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.border.Border;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextPane;
//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import java.awt.Color;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.border.LineBorder;
//
//import BUS.NhanVienBUS;
//import BUS.TaiKhoanBUS;
//import DTO.NhanVienDTO;
//import DTO.TaiKhoanDTO;
//
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.awt.event.ActionEvent;
//
//public class DangNhap extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField txtuser;
//	private JTextField txtpass;
//	private JTextPane txtpnTnNgiDng;
//	private JLabel lblNewLabel;
//	private JLabel lblNewLabel_1;
//	ArrayList<TaiKhoanDTO> taikhoan= new ArrayList<>();
//	ArrayList<NhanVienDTO> nhanvien= new ArrayList<>();
//	public static int manv;
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					DangNhap frame = new DangNhap();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
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
//	public DangNhap() {
//		NhanVienDTO nv= new NhanVienDTO();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 556, 453);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		Border emptyBorder = BorderFactory.createEmptyBorder(0,0, 0, 0);
//		contentPane.setLayout(null);
//		
//		JTextPane txtpnngK = new JTextPane();
//		txtpnngK.setEditable(false);
//		txtpnngK.setBounds(212, 73, 234, 31);
//		contentPane.add(txtpnngK);
//		txtpnngK.setForeground(new Color(204, 0, 0));
//		txtpnngK.setFont(new Font("Tahoma", Font.BOLD, 20));
//		txtpnngK.setText("ĐĂNG NHẬP");
//		
//		txtpnTnNgiDng = new JTextPane();
//		txtpnTnNgiDng.setBounds(94, 115, 101, 20);
//		contentPane.add(txtpnTnNgiDng);
//		txtpnTnNgiDng.setFont(new Font("Tahoma", Font.BOLD, 11));
//		txtpnTnNgiDng.setText("Tài Khoản");
//		txtpnTnNgiDng.setEditable(false);
//		
//		JTextPane txtpnMtKhu = new JTextPane();
//		txtpnMtKhu.setBounds(94, 163, 101, 20);
//		contentPane.add(txtpnMtKhu);
//		txtpnMtKhu.setFont(new Font("Tahoma", Font.BOLD, 11));
//		txtpnMtKhu.setEditable(false);
//		txtpnMtKhu.setText("Mật khẩu");
//		
//		JButton btnNewButton = new JButton("");
//		
//		btnNewButton.setBounds(220, 217, 101, 31);
//		contentPane.add(btnNewButton);
//		btnNewButton.setIcon(new ImageIcon(DangNhap.class.getResource("./nutdangnhap.png")));
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
//		btnNewButton.setBorder(emptyBorder);
//		
//		txtpass = new JPasswordField();
//		txtpass.setBounds(212, 163, 182, 20);
//		contentPane.add(txtpass);
//		txtpass.setText("");
//		txtpass.setColumns(10);
//		
//		txtuser = new JTextField();
//		txtuser.setBounds(212, 115, 182, 20);
//		contentPane.add(txtuser);
//		txtuser.setColumns(10);
//		
//		lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(DangKy.class.getResource("./khungdangky.png")));
//		lblNewLabel.setBounds(62, 23, 422, 294);
//		contentPane.add(lblNewLabel);
//		
//		lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon(DangKy.class.getResource("./dangky.png")));
//		lblNewLabel_1.setBounds(0, 0, 541, 414);
//		contentPane.add(lblNewLabel_1);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(txtuser.getText().equals("") || txtpass.getText().equals("") ) {
//					JOptionPane.showMessageDialog(null,"Yêu cầu nhập đầy đủ các trường dữ liệu");
//				}
//				else {
//					TaiKhoanDTO tk= new TaiKhoanDTO();
//					TaiKhoanBUS tkb= new TaiKhoanBUS();
//					taikhoan=tkb.danhsach_dn(txtuser.getText(),txtpass.getText());
//					if(taikhoan.size()==0) {
//						JOptionPane.showMessageDialog(null,"Tài Khoản Hoặc Mật Khẩu Không Chính Xác!!!");
//						return;
//					}
//					if(txtuser.getText().equals(taikhoan.get(0).getUsername()) && txtpass.getText().equals(taikhoan.get(0).getPassword()) ) {
//						JOptionPane.showMessageDialog(null,"Đăng Nhập Thành Công");
//						
//						nhanvien=new NhanVienBUS().danhsach_ma(taikhoan.get(0).getMataikhoan());
//						
//						Index index= new Index();
//						index.setVisible(true);
//						vaitro(taikhoan.get(0).getVaitro(),index);
//						
//						
//						
//						manv=nhanvien.get(0).getManv();
//						setVisible(false);
//						
//					}
//					else {
//						
//					}
//				}
//			}
//		});
//	}
//public void vaitro(int vaitro,Index index) {
//	if(String.valueOf(vaitro).equals("0")) {
//		
//		index.btnsach.setEnabled(false);
//		index.btntheloai.setEnabled(false);
//		index.btnncc.setEnabled(false);
//		index.btntacgia.setEnabled(false);
//		index.btnnhanvien.setEnabled(false);
//		index.btndocgia.setEnabled(false);
//		index.btnttv.setEnabled(false);
//		index.btnpm.setEnabled(false);
//		index.btnphanquyen.setEnabled(false);
//	}
//	else if(String.valueOf(vaitro).equals("1")) {
//		index.btnsach.setEnabled(false);
//		index.btntheloai.setEnabled(false);
//		index.btnncc.setEnabled(false);
//		index.btntacgia.setEnabled(false);
//		index.btnnhanvien.setEnabled(false);
//		index.btndocgia.setEnabled(true);
//		index.btnttv.setEnabled(true);
//		index.btnpm.setEnabled(true);
//		index.btnphanquyen.setEnabled(false);
//	}
//	else if(String.valueOf(vaitro).equals("2")) {
//		index.btndocgia.setEnabled(false);
//		index.btnttv.setEnabled(false);
//		index.btnpm.setEnabled(false);
//		index.btnnhanvien.setEnabled(false);
//		index.btnsach.setEnabled(true);
//		index.btntheloai.setEnabled(true);
//		index.btnncc.setEnabled(true);
//		index.btntacgia.setEnabled(true);
//		index.btnphanquyen.setEnabled(false);
//	}
//	else if(String.valueOf(vaitro).equals("3")) {
//		index.btndocgia.setEnabled(true);
//		index.btnttv.setEnabled(true);
//		index.btnpm.setEnabled(true);
//		index.btnnhanvien.setEnabled(true);
//		index.btnsach.setEnabled(true);
//		index.btntheloai.setEnabled(true);
//		index.btnncc.setEnabled(true);
//		index.btntacgia.setEnabled(true);
//		index.btnphanquyen.setEnabled(true);
//	}
//	
//}
//
//}
