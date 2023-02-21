package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clsInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsInfo frame = new clsInfo();
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
	public clsInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setBackground(Color.BLUE);
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employee b=new employee();
				b.setVisible(true);
				
			}
		});
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEmployee.setBounds(98, 184, 164, 23);
		contentPane.add(btnEmployee);
		
		JButton btnemployeedetails = new JButton("Employee Details");
		btnemployeedetails.setForeground(Color.WHITE);
		btnemployeedetails.setBackground(Color.BLUE);
		btnemployeedetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeedetails c =new employeedetails();
				c.setVisible(true);
			}
		});
		btnemployeedetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnemployeedetails.setBounds(488, 184, 176, 23);
		contentPane.add(btnemployeedetails);
		
		JButton btnSalary = new JButton("Salary");
		btnSalary.setForeground(Color.WHITE);
		btnSalary.setBackground(Color.BLUE);
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Salary d=new Salary();
				d.setVisible(true);
			}
		});
		btnSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalary.setBounds(488, 371, 176, 23);
		contentPane.add(btnSalary);
		
		JLabel lblEmployee = new JLabel("");
		Image img3= new ImageIcon(this.getClass().getResource("/employee1.JPG")).getImage();
		lblEmployee.setIcon(new ImageIcon(img3));
		lblEmployee.setBounds(125, 110, 116, 63);
		contentPane.add(lblEmployee);
		
		JLabel lblemployeedetails = new JLabel("");
		Image img4= new ImageIcon(this.getClass().getResource("/employeedetails.JPG")).getImage();
		lblemployeedetails.setIcon(new ImageIcon(img4));
		lblemployeedetails.setBounds(537, 88, 84, 85);
		contentPane.add(lblemployeedetails);
		
		JLabel lblsalary = new JLabel("");
		Image img5= new ImageIcon(this.getClass().getResource("/salary.JPG")).getImage();
		lblsalary.setIcon(new ImageIcon(img5));
		lblsalary.setBounds(547, 275, 58, 85);
		contentPane.add(lblsalary);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(98, 29, 151, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Log out!");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginfoam a=new loginfoam();
				a.setVisible(true);
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(626, 36, 116, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/home.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(10, 0, 78, 71);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				clsAttendence x=new clsAttendence();
				x.setVisible(true);
			}
		});
		btnAttendance.setForeground(Color.WHITE);
		btnAttendance.setBackground(Color.BLUE);
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAttendance.setBounds(98, 390, 164, 23);
		contentPane.add(btnAttendance);
		
		JLabel lblattendance = new JLabel("");
		Image img6= new ImageIcon(this.getClass().getResource("/attendance.JPG")).getImage();
		lblattendance.setIcon(new ImageIcon(img6));
		lblattendance.setBounds(106, 236, 130, 143);
		contentPane.add(lblattendance);
		
		JLabel lblimg10 = new JLabel("");
		Image img10= new ImageIcon(this.getClass().getResource("/clsinfo2.JPG")).getImage();
		lblimg10.setIcon(new ImageIcon(img10));
		lblimg10.setBounds(-339, 0, 1129, 424);
		contentPane.add(lblimg10);
		
		
	}
}
