package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class PhanQuyen_Form extends JPanel {

	
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<TaiKhoanDTO> taikhoan= new ArrayList<>();
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanQuyen_Form frame = new PhanQuyen_Form();
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
	public PhanQuyen_Form() {
		
		setBounds(100, 100, 582, 389);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 67, 365, 227);
		add(scrollPane);
		 model= new DefaultTableModel();
		table = new JTable();
		
		table.setModel(model);
		model.addColumn("Ma tai khoan");
		model.addColumn("Ten tai khoan");
		model.addColumn("Mat khau");
		model.addColumn("Quyen Han");
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Xét Quyền");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					XetQuyen_Form xq= new XetQuyen_Form(Integer.parseInt(model.getValueAt(i,0).toString()));
					xq.setVisible(true);
					xq.setLocationRelativeTo(null);
				}
				else {
					JOptionPane.showMessageDialog(null,"Yêu cầu lựa chọn nhân viên");
					return;
				}
			
				
			}
		});
		btnNewButton.setBounds(244, 33, 133, 23);
		add(btnNewButton);
		
		hienthi();
	}
	public void hienthi() {
		taikhoan=new TaiKhoanBUS().danhsach();
		model.setRowCount(0);
		String vaitro="";
		for(TaiKhoanDTO tk:taikhoan) {
			if(tk.getVaitro()==3) {
				continue;
			}
			if(tk.getVaitro()==0) {
				vaitro="Chưa xét quyền";
			}
			else if(tk.getVaitro()==1) {
				 vaitro="Quản Lý Phiếu Mượn";
			}
			else if(tk.getVaitro()==2) {
				 vaitro="Quản Lý Sách";
			}
			model.addRow(new Object[] {
				tk.getMataikhoan(),tk.getUsername(),tk.getPassword(),vaitro
			});
		}
		
	}
}
