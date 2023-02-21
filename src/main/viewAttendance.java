package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class viewAttendance extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAttendance frame = new viewAttendance();
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
	    Connection con=null;
		
		PreparedStatement pst = null;
		private JTable table;
	public viewAttendance() {
		con=connEmployee.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Attendance");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 166, 36);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 0, 555, 47);
		contentPane.add(panel);
		
		JLabel lblid = new JLabel("Employee ID:");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblid.setBounds(10, 58, 93, 22);
		contentPane.add(lblid);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setBounds(113, 61, 200, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 555, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "firstname", "surname", "date", "timein", "timeout"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnviewAttendance = new JButton("View Attendance");
		btnviewAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a;
					PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("select * from attendance where id=?");
					int id=Integer.parseInt(txtid.getText());
					pst1.setInt(1,id);
					ResultSet rs =pst1.executeQuery();
					//pst =(PreparedStatement) con.prepareStatement("select * from attendance where id in(select id from attendance GROUP BY id HAVING COUNT(id) > 1)");
					//pst =(PreparedStatement) con.prepareStatement("select id, MAX(firstname) AS firstname, MAX(surname) AS surname, MAX(date) AS date, MAX(timein) AS timein, MAX(timeout) AS timeout from attendance GROUP BY id");
					//int id=Integer.parseInt(txtid.getText());
					//pst.setInt(1,id);
					
					
					
					//ResultSet rs=pst.executeQuery();
					ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();
					a=rd.getColumnCount();
					DefaultTableModel df=(DefaultTableModel)table.getModel();
					df.setRowCount(0);
					if(rs.next()==false)
					{JOptionPane.showMessageDialog(null,"sorry employee not found");
					}
					else
					{
						java.util.Vector<String> v2= new java.util.Vector<String>();
						for(int i=1;i<=a;i++)
						{
							v2.add(rs.getString("id"));
							v2.add(rs.getString("firstname"));
							v2.add(rs.getString("surname"));
							v2.add(rs.getString("date"));
							v2.add(rs.getString("timein"));
							v2.add(rs.getString("timeout"));
						}
						df.addRow(v2);
					}
					
				
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnviewAttendance.setBackground(Color.BLUE);
		btnviewAttendance.setForeground(Color.WHITE);
		btnviewAttendance.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnviewAttendance.setBounds(10, 499, 166, 23);
		contentPane.add(btnviewAttendance);
		
		
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(253, 499, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				clsAttendence s= new clsAttendence();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(476, 499, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
