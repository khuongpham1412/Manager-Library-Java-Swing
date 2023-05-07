package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BUS.CTPhieuNhapBUS;
import BUS.KhoSachBUS;
import BUS.PhieuNhapBUS;
import BUS.SachBUS;
import DTO.CTPhieuNhap;
import DTO.KhoSachDTO;
import DTO.PhieuNhapDTO;
import DTO.SachDTO;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class PhieuNhap extends JFrame {
	ArrayList<PhieuNhapDTO> phieunhap = new ArrayList<>();
	ArrayList<CTPhieuNhap> ctphieunhap = new ArrayList<>();
	ArrayList<KhoSachDTO> khosach = new ArrayList<>();
	Vector<Object> khosach1= new Vector<>();
	private JTextField txtmanv;
	private JTextField txtngaynhap;
	private JTextField t3;
	private JTextField t4;
	private JTextField textField_7;
	private JTable table_1;
	private JTable table;
	private DefaultTableModel model;
	int tongtien=0;
	private JTextField txttensach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuNhap frame = new PhieuNhap();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhieuNhap() {
		model= new DefaultTableModel();
		table_1 = new JTable();
		table_1.setModel(model);
		KhoSachBUS sb= new KhoSachBUS();
		khosach=sb.danhsach();
		SachDTO s = new SachDTO();
		khosach1.add("Option...");
		for(KhoSachDTO s1:khosach) {
			khosach1.add(s1.getMasach()+"-"+s1.getTensach());
		}
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 800, 600);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 770, 545);
		
		JPanel panel_1 = new JPanel();
		  panel_1.setBorder(BorderFactory.createTitledBorder("Phiếu nhập"));
		panel_1.setBounds(10, 307, 409, 207);
		
		textField_7 = new JTextField();
		textField_7.setBounds(140, 276, 340, 20);
		textField_7.setText("");
		textField_7.setColumns(10);;
		
		JButton btnNewButton = new JButton("Thêm Sách");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		TacGia tg1= new TacGia();
		System.out.println(tg1.tg);
		btnNewButton.setIcon(new ImageIcon(PhieuNhap.class.getResource("./add.png")));
		btnNewButton.setBounds(133, 143, 161, 29);
		JButton btnNewButton_4 = new JButton("Thêm");
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(panel_1);
		
		txttensach = new JTextField();
		txttensach.setBounds(133, 23, 161, 20);
		panel_1.add(txttensach);
		txttensach.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(132, 68, 72, 20);
		panel_1.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(132, 99, 72, 20);
		panel_1.add(t4);
		t4.setColumns(10);
		
		JTextPane txtpnTnSch = new JTextPane();
		txtpnTnSch.setBounds(22, 23, 92, 20);
		panel_1.add(txtpnTnSch);
		txtpnTnSch.setText("Tên Sách");
		txtpnTnSch.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnTnSch.setEditable(false);
		txtpnTnSch.setBackground(SystemColor.menu);
		
		JTextPane txtpnNgyTr = new JTextPane();
		txtpnNgyTr.setBounds(22, 68, 92, 20);
		panel_1.add(txtpnNgyTr);
		txtpnNgyTr.setEditable(false);
		txtpnNgyTr.setBackground(UIManager.getColor("Panel.background"));
		txtpnNgyTr.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnNgyTr.setText("Số lượng");
		
		JTextPane txtpnGhiCh = new JTextPane();
		txtpnGhiCh.setBounds(22, 99, 92, 20);
		panel_1.add(txtpnGhiCh);
		txtpnGhiCh.setEditable(false);
		txtpnGhiCh.setBackground(UIManager.getColor("Panel.background"));
		txtpnGhiCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnGhiCh.setText("Đơn giá");
		panel.add(textField_7);
		
		JScrollPane scrollPane = new JScrollPane();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				if(i>=0) {
					//comboBox.setSelectedItem(model.getValueAt(i,1));
					
					t3.setText(model.getValueAt(i,2).toString());
					t4.setText(model.getValueAt(i,3).toString());
					btnNewButton_4.setEnabled(false);
				}
			}
		});
		scrollPane.setBounds(366, 58, 394, 185);
		panel.add(scrollPane);
		
		
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		scrollPane.setViewportView(table_1);
		model.addColumn("Ma Phieu Nhap");
		model.addColumn("Ma sach");
		model.addColumn("So luong");
		model.addColumn("Don Gia");
		model.addColumn("Thanh Tien");
		JTextPane txtpnTmKim = new JTextPane();
		txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnTmKim.setText("Tìm kiếm");
		txtpnTmKim.setBounds(28, 276, 72, 20);
		panel.add(txtpnTmKim);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(10, 58, 347, 207);
			panel.add(panel_4);
			panel_4.setBorder(BorderFactory.createTitledBorder("Chi tiết phiếu nhập"));
			
			
			
			btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton_4.setIcon(new ImageIcon(PhieuNhap.class.getResource("./add.png")));
			
				btnNewButton_4.setBounds(30, 173, 92, 23);
				
				JButton btnNewButton_6 = new JButton("Xóa");
				btnNewButton_6.setEnabled(false);
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
//						PhieuNhapBUS pnb= new PhieuNhapBUS();
//						phieunhap=pnb.danhsach();
//						int mapn=phieunhap.get(phieunhap.size()-1).getMapn()+1;
//						int masach=khosach.get(comboBox.getSelectedIndex()-1).getMasach();
//						CTPhieuNhap ctpn= new CTPhieuNhap();
//						ctpn.setMapn(mapn);
//						ctpn.setTensach(masach);
//						CTPhieuNhapBUS ctpnb= new CTPhieuNhapBUS();
//						try {
//							if(ctpnb.delete(ctpn)) {
//								JOptionPane.showMessageDialog(null,"Xoa thanh cong");
//								hienthi();
//								return;
//							}
//						} catch (Exception e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						JOptionPane.showMessageDialog(null,"Xoa that bai");
					}
				});
				btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNewButton_6.setIcon(new ImageIcon(PhieuNhap.class.getResource("./eraser.png")));
				btnNewButton_6.setBounds(207, 173, 82, 23);
				panel_4.setLayout(null);
				panel_4.add(btnNewButton_6);
				panel_4.add(btnNewButton_4);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(128, 76, 66, 22);
				panel_4.add(comboBox);
				
				
				txtmanv = new JTextField();
				txtmanv.setBounds(125, 35, 142, 20);
				panel_4.add(txtmanv);
				txtmanv.setColumns(10);
				
				txtngaynhap = new JTextField();
				txtngaynhap.setEnabled(false);
				txtngaynhap.setBounds(125, 127, 142, 20);
				panel_4.add(txtngaynhap);
				txtngaynhap.setColumns(10);
				
				JTextPane txtpnMNv = new JTextPane();
				txtpnMNv.setBounds(10, 35, 112, 20);
				panel_4.add(txtpnMNv);
				txtpnMNv.setEditable(false);
				txtpnMNv.setBackground(UIManager.getColor("Panel.background"));
				txtpnMNv.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtpnMNv.setText("Mã nhân viên");
				
				JTextPane txtpncGi = new JTextPane();
				txtpncGi.setBounds(10, 76, 66, 20);
				panel_4.add(txtpncGi);
				txtpncGi.setEditable(false);
				txtpncGi.setBackground(UIManager.getColor("Panel.background"));
				txtpncGi.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtpncGi.setText("Mã nhà CC");
				JTextPane txtpnNgyMn = new JTextPane();
				txtpnNgyMn.setBounds(10, 127, 112, 20);
				panel_4.add(txtpnNgyMn);
				txtpnNgyMn.setEditable(false);
				txtpnNgyMn.setBackground(UIManager.getColor("Panel.background"));
				txtpnNgyMn.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtpnNgyMn.setText("Ngày nhập");
				setVisible(true);
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(429, 307, 331, 207);
				panel.add(scrollPane_1);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"M\u00E3 PN", "M\u00E3 NV", "M\u00E3 NCC", "Ng\u00E0y nh\u1EADp"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane_1.setViewportView(table);
				
				JTextPane txtpnPhiuNhp = new JTextPane();
				txtpnPhiuNhp.setEditable(false);
				txtpnPhiuNhp.setBackground(UIManager.getColor("Panel.background"));
				txtpnPhiuNhp.setText("Phiếu Nhập");
				txtpnPhiuNhp.setFont(new Font("Tahoma", Font.BOLD, 20));
				txtpnPhiuNhp.setBounds(291, 11, 174, 36);
				panel.add(txtpnPhiuNhp);
				
				hienthi();
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int dem=0;
						PhieuNhapDTO pn= new PhieuNhapDTO();
						pn.setManv(Integer.parseInt(txtmanv.getText()));
						//pn.setMancc(Integer.parseInt(txtmancc.getText()));
						pn.setNgaynhap(txtngaynhap.getText());
						SachDTO s= new SachDTO();
						SachBUS sb= new SachBUS();
						for(int i=0;i<model.getRowCount();i++) {
							s.setMasach(Integer.parseInt(model.getValueAt(i,1).toString()));
							int sl=Integer.parseInt(model.getValueAt(i,2).toString());
							s.setSoluong(sl);
							
							for(KhoSachDTO s1:khosach) {
								if(String.valueOf(s.getMasach()).equals(String.valueOf(s1.getMasach()))) {
									s.setSoluong(s1.getSoluong()+sl);
									try {
										if(sb.edit_sl(s)) {
											dem++;
											break;
										}
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								
							}
							if(dem==0) {
								try {
									if(sb.add(s)) {
										break;
									}
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else {
								dem=0;
							}
							
						}
					}
				});
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if( t3.getText().equals("") ) {
							JOptionPane.showMessageDialog(null,"Yêu cầu nhập đầy đủ các trường!!!");
							return;
						}
						int mapn=phieunhap.get(phieunhap.size()-1).getMapn();
						phieunhap=new PhieuNhapBUS().danhsach();
						ctphieunhap=new CTPhieuNhapBUS().danhsachid(mapn);
						
						String tensach=txttensach.getText();
						int sl=Integer.parseInt(t3.getText());
						int dongia=Integer.parseInt(t4.getText());
						int thanhtien=sl*dongia;
						CTPhieuNhap ctpn= new CTPhieuNhap();
						int dem=0;
						ctpn.setMapn(mapn);
						ctpn.setTensach(tensach);
						ctpn.setSoluong(sl);
						ctpn.setDongia(dongia);
						ctpn.setThanhtien(thanhtien);
						for(CTPhieuNhap ctpn1:ctphieunhap) {
							String tens=ctpn1.getTensach();
							if(tensach.toLowerCase().equals(ctpn1.getTensach().toLowerCase())) {
								ctpn.setTensach(tens);
								ctpn.setSoluong(ctpn1.getSoluong()+sl);
								ctpn.setThanhtien(ctpn1.getSoluong()*ctpn1.getDongia());
								
								try {
									if(new CTPhieuNhapBUS().edit_sl(ctpn)) {
										dem++;
									}
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						if(dem==0) {
							try {
								if(new CTPhieuNhapBUS().add(ctpn)) {
									dem++;
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						KhoSachDTO ks1= new KhoSachDTO();
						khosach=new KhoSachBUS().danhsach();
						for(KhoSachDTO ks:khosach) {
							if(tensach.toLowerCase().equals(ks.getTensach().toLowerCase())) {
								
								ks1.setMasach(ks.getMasach());
								ks1.setSoluong(ks.getSoluong()+sl);
								ks1.setGia(dongia);
								
								try {
									if(new KhoSachBUS().edit_sl(ks1)) {
								
											JOptionPane.showMessageDialog(null,"thanh cong");
											return;
										
									}
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						ks1.setTensach(tensach);
						ks1.setSoluong(sl);
						ks1.setGia(dongia);
						try {
							if(new KhoSachBUS().add(ks1)) {
								
									JOptionPane.showMessageDialog(null,"thanh cong");
									return;
								
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						
						
						
						
						
					}
				});
						
				
	}
	public void them() {
		
		hienthi();
	
	}
	public void hienthi() {
		PhieuNhapBUS pnb= new PhieuNhapBUS();
		phieunhap=pnb.danhsach();
		CTPhieuNhapBUS ctpnb= new CTPhieuNhapBUS();
		int mapn=phieunhap.get(phieunhap.size()-1).getMapn()+1;
		ctphieunhap=ctpnb.danhsachid(mapn);
		model.setRowCount(0);
		for(CTPhieuNhap ctpn1: ctphieunhap) {
			model.addRow(new Object[] {
					ctpn1.getMapn(),ctpn1.getTensach(),ctpn1.getSoluong(),ctpn1.getDongia(),ctpn1.getThanhtien()
			});
		}
	}
}
