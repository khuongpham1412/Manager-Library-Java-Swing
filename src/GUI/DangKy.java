package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtpass;
	private JTextField txtpass1;
	private JTextPane txtpnTnNgiDng;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private ArrayList<TaiKhoanDTO> taikhoan= new ArrayList<>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					DangKy frame = new DangKy();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DangKy(int manv) {
		NhanVienDTO nv= new NhanVienDTO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 453);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Border emptyBorder = BorderFactory.createEmptyBorder(0,0, 0, 0);
		contentPane.setLayout(null);
		
		JTextPane txtpnngK = new JTextPane();
		txtpnngK.setEditable(false);
		txtpnngK.setBounds(172, 73, 234, 31);
		contentPane.add(txtpnngK);
		txtpnngK.setForeground(new Color(204, 0, 0));
		txtpnngK.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnngK.setText("ĐĂNG KÝ TÀI KHOẢN");
		
		txtpnTnNgiDng = new JTextPane();
		txtpnTnNgiDng.setBounds(94, 115, 101, 20);
		contentPane.add(txtpnTnNgiDng);
		txtpnTnNgiDng.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnTnNgiDng.setText("Tên người dùng");
		txtpnTnNgiDng.setEditable(false);
		
		JTextPane txtpnMtKhu = new JTextPane();
		txtpnMtKhu.setBounds(94, 146, 101, 20);
		contentPane.add(txtpnMtKhu);
		txtpnMtKhu.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnMtKhu.setEditable(false);
		txtpnMtKhu.setText("Mật khẩu");
		
		
		JTextPane txtpnXcNhnMt = new JTextPane();
		txtpnXcNhnMt.setBounds(94, 177, 115, 20);
		contentPane.add(txtpnXcNhnMt);
		txtpnXcNhnMt.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnXcNhnMt.setEditable(false);
		txtpnXcNhnMt.setText("Xác nhận mật khẩu");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtuser.getText().equals("") || txtpass.getText().equals("") || txtpass1.getText().equals("") ) {
					JOptionPane.showMessageDialog(null,"Yêu cầu nhập đầy đủ các trường dữ liệu");
				}
				if(!txtpass.getText().equals(txtpass1.getText())) {
					JOptionPane.showMessageDialog(null,"Mật khẩu nhập không khớp!!!");
					return;
				}
				
					TaiKhoanDTO tk= new TaiKhoanDTO();
					tk.setUsername(txtuser.getText());
					tk.setPassword(txtpass.getText());
					tk.setVaitro(0);
					TaiKhoanBUS tkb= new TaiKhoanBUS();
					try {
						if(tkb.add(tk)) {
							NhanVienDTO nv= new NhanVienDTO();
							taikhoan=tkb.danhsach();
							nv.setManv(manv);
							
							nv.setMatk(taikhoan.get(taikhoan.size()-1).getMataikhoan());
							nv.setTrangthai(1);
							
							
							NhanVienBUS nvb= new NhanVienBUS();
							if(nvb.edittaikhoan(nv)) {
								JOptionPane.showMessageDialog(null,"Tạo tài khoản thành công");
								NhanVien nv1= new NhanVien();
								nv1.removeAll();
								nv1.repaint();
								nv1.revalidate();
								nv1.hienthi();
								setVisible(false);
							}
							
						}
					} catch (Exception e1) {
						
					}
					
				
			}
		});
		btnNewButton.setBounds(212, 214, 110, 46);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(DangKy.class.getResource("./nutdangky.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBorder(emptyBorder);
		
		txtpass1 = new JPasswordField();
		txtpass1.setBounds(224, 177, 182, 20);
		contentPane.add(txtpass1);
		txtpass1.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(224, 146, 182, 20);
		contentPane.add(txtpass);
		txtpass.setText("");
		txtpass.setColumns(10);
		
		txtuser = new JTextField();
		txtuser.setBounds(224, 115, 182, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DangKy.class.getResource("./khungdangky.png")));
		lblNewLabel.setBounds(62, 23, 422, 294);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DangKy.class.getResource("./dangky.png")));
		lblNewLabel_1.setBounds(0, 0, 541, 414);
		contentPane.add(lblNewLabel_1);
		
	}
//	public void manhanvien(int a) {
//		NhanVienDTO nv= new NhanVienDTO();
//		nv.setManv(a);
//		System.out.println(nv.getManv());
//	}
//	public int getMa() {
//		NhanVienDTO manv= new NhanVienDTO();
//		return manv.getManv();
//	}

}
