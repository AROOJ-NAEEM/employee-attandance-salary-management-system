package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class employeedetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtfirstname;
	private JTextField txtsurname;
	private JTextField txtemail;
	private JTextField txtgender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeedetails frame = new employeedetails();
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
	private JTextField txtCNIC;
	private JTextField txtDOB;
	private JTextField txtaddress;
	private JTextField txtage;
	private JTextField txtphone;
	public employeedetails() {
		con=connEmployee.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Id:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(103, 54, 102, 25);
		contentPane.add(lblNewLabel_2);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setColumns(10);
		txtid.setBounds(215, 54, 161, 25);
		contentPane.add(txtid);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(290, 90, 359, 305);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Fetch Details");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"sorry employee not found");
						txtfirstname.setText("");
						txtsurname.setText("");
						txtgender.setText("");
						txtemail.setText("");
						txtCNIC.setText("");
						txtDOB.setText("");
						txtage.setText("");
						txtaddress.setText("");
						txtphone.setText("");
						txtid.requestFocus();
					}
					else
					{
						txtfirstname.setText(rs.getString("firstname"));
						txtsurname.setText(rs.getString("surname"));
						txtgender.setText(rs.getString("gender"));
						txtemail.setText(rs.getString("email"));
						txtCNIC.setText(rs.getString("CNIC"));
						txtDOB.setText(rs.getString("DOB"));
						txtage.setText(rs.getString("age"));
						txtaddress.setText(rs.getString("address"));
						txtphone.setText(rs.getString("phone"));
						
						
						

						textArea.setText("");
						textArea.append("Employee Details:\n"
								+ "============================\n"
								+ "Employee id:\t\t"+txtid.getText()+"\n"
								+ "First Name:\t\t"+txtfirstname.getText()+"\n"
								+ "Surname:\t\t"+txtsurname.getText()+"\n"
								+ "Gender:\t\t"+txtgender.getText()+"\n"
								+ "CNIC:\t\t"+txtCNIC.getText()+"\n"
								+ "DOB:\t\t"+txtDOB.getText()+"\n"
								+ "Age:\t\t"+txtage.getText()+"\n"
								+ "Address:\t\t"+txtaddress.getText()+"\n"
								+ "Phone:\t\t"+txtphone.getText()+"\n"
								+ "============================\n"
								);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				        
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(386, 55, 130, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Details");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(221, 10, 232, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 90, 102, 25);
		contentPane.add(lblNewLabel_2_1);
		
		txtfirstname = new JTextField();
		txtfirstname.setEnabled(false);
		txtfirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname.setColumns(10);
		txtfirstname.setBounds(119, 90, 161, 25);
		contentPane.add(txtfirstname);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sur Name:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 126, 102, 25);
		contentPane.add(lblNewLabel_2_2);
		
		txtsurname = new JTextField();
		txtsurname.setEnabled(false);
		txtsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname.setColumns(10);
		txtsurname.setBounds(120, 126, 161, 25);
		contentPane.add(txtsurname);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 198, 102, 25);
		contentPane.add(lblNewLabel_2_3);
		
		txtemail = new JTextField();
		txtemail.setEnabled(false);
		txtemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtemail.setColumns(10);
		txtemail.setBounds(119, 198, 161, 25);
		contentPane.add(txtemail);
		
		JLabel lblNewLabel_2_4 = new JLabel("Gender:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 162, 102, 25);
		contentPane.add(lblNewLabel_2_4);
		
		txtgender = new JTextField();
		txtgender.setEnabled(false);
		txtgender.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtgender.setColumns(10);
		txtgender.setBounds(119, 162, 161, 25);
		contentPane.add(txtgender);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.BLUE);
		btnReset.setForeground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText(null);
				txtfirstname.setText(null);
				txtsurname.setText(null);
				txtgender.setText(null);
				txtemail.setText(null);
				txtCNIC.setText(null);
				txtDOB.setText(null);
				txtage.setText(null);
				txtaddress.setText(null);
				txtphone.setText(null);
				textArea.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(10, 406, 130, 23);
		contentPane.add(btnReset);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBackground(Color.BLUE);
		btnPrint.setForeground(Color.WHITE);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            MessageFormat header = new MessageFormat("Printing in progress");
				
				try
				{
					textArea.print();
					
				}
				catch(java.awt.print.PrinterException ev) {
					System.out.println("NoPrinter Found");
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrint.setBounds(266, 406, 130, 23);
		contentPane.add(btnPrint);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLUE);
		btnHome.setForeground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				clsInfo b=new clsInfo();
				b.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHome.setBounds(519, 406, 130, 23);
		contentPane.add(btnHome);
		
		JLabel lblCNIC = new JLabel("CNIC:");
		lblCNIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCNIC.setBounds(10, 234, 102, 25);
		contentPane.add(lblCNIC);
		
		txtCNIC = new JTextField();
		txtCNIC.setEnabled(false);
		txtCNIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCNIC.setColumns(10);
		txtCNIC.setBounds(119, 234, 161, 25);
		contentPane.add(txtCNIC);
		
		JLabel lblDOB = new JLabel("DOB:");
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDOB.setBounds(10, 270, 102, 25);
		contentPane.add(lblDOB);
		
		txtDOB = new JTextField();
		txtDOB.setEnabled(false);
		txtDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDOB.setColumns(10);
		txtDOB.setBounds(119, 270, 161, 25);
		contentPane.add(txtDOB);
		
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbladdress.setBounds(10, 306, 102, 25);
		contentPane.add(lbladdress);
		
		txtaddress = new JTextField();
		txtaddress.setEnabled(false);
		txtaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtaddress.setColumns(10);
		txtaddress.setBounds(119, 306, 161, 25);
		contentPane.add(txtaddress);
		
		JLabel lblage = new JLabel("Age:");
		lblage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblage.setBounds(10, 342, 102, 25);
		contentPane.add(lblage);
		
		txtage = new JTextField();
		txtage.setEnabled(false);
		txtage.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtage.setColumns(10);
		txtage.setBounds(119, 342, 161, 25);
		contentPane.add(txtage);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblphone.setBounds(10, 370, 102, 25);
		contentPane.add(lblphone);
		
		txtphone = new JTextField();
		txtphone.setEnabled(false);
		txtphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtphone.setColumns(10);
		txtphone.setBounds(119, 370, 161, 25);
		contentPane.add(txtphone);
		
		
	}
}
