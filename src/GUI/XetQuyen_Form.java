package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.TaiKhoanBUS;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class XetQuyen_Form extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public XetQuyen_Form(int matk) {
		bg= new ButtonGroup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cập Nhật");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton.setBounds(168, 199, 121, 23);
		contentPane.add(btnNewButton);
		
		
		
		JRadioButton rdoqls = new JRadioButton("Quản Lý Sách");
		rdoqls.setBounds(162, 75, 121, 23);
		bg.add(rdoqls);
		
		JRadioButton rdoslp = new JRadioButton("Quản Lý Phiếu Mượn");
		rdoslp.setBounds(162, 119, 127, 23);
		bg.add(rdoslp);
		contentPane.add(rdoqls);
		contentPane.add(rdoslp);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdoqls.isSelected()) {
					
					try {
						if(new TaiKhoanBUS().edit_vaitro(matk,2)) {
							JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					try {
						if(new TaiKhoanBUS().edit_vaitro(matk,1)) {
							JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
							setVisible(false);
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
			}
		});
	}
}
