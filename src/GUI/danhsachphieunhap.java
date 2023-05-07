package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.CTPhieuNhapBUS;
import BUS.TheLoaiBUS;
import DTO.TheLoaiDTO;
import DTO.danhsachphieunhapDTO;

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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class danhsachphieunhap extends JFrame {
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private ArrayList<danhsachphieunhapDTO> ds= new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					danhsachphieunhap frame = new danhsachphieunhap();
					frame.setVisible(true);
					//frame.setUndecorated(false);
					
//					frame.hienthi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public danhsachphieunhap() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 758, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 207, 641, 221);
		
		model= new DefaultTableModel();
		table = new JTable();
		
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 744, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.add(scrollPane);
		lblNewLabel = new JLabel("THE LOAI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(296, 0, 127, 74);
		panel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(0, 86, 744, 2);
		contentPane.add(separator);
		
		
		
		JButton btnThoat = new JButton("Thoat");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnThoat.setBounds(422, 453, 89, 40);
		contentPane.add(btnThoat);
		
		
		
		JButton btnChon = new JButton("Chon");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"Vui long chon hang");
					return;
				}
			}
		});
		btnChon.setBounds(208, 453, 89, 40);
		contentPane.add(btnChon);
		model.addColumn("Ma Sach");
		model.addColumn("So Luong");
		hienthi();
		
	}
	public void hienthi() {
		CTPhieuNhapBUS ctpnb= new CTPhieuNhapBUS();
		//ds=ctpnb.danhsach1();
		model.setRowCount(0);
		System.out.println("hi");
		for(danhsachphieunhapDTO dspn:ds) {
			model.addRow(new Object[] {
				dspn.getMasach(),dspn.getSoluong()
			});
			//System.out.println("h");
			//System.out.println(ds.get(i));
		}
	}
	public int giatri() {
		int i=table.getSelectedRow();
		return (int) model.getValueAt(i,0);
		
	}
	public int hang() {
		return table.getSelectedRow();
		
	}
}
