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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class clsSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtCNIC;
	private JTextField txtfirstname;
	private JTextField txtemail;
	private JTextField txtsurname;
	private JTextField txtage;
	private JTextField txtaddress;
	private JTextField txtphone;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsSignUp frame = new clsSignUp();
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
	private JTextField txtgender;
	public clsSignUp() {
		con=connEmployee.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up Foam!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(122, 32, 183, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblCNIC = new JLabel("CNIC:");
		lblCNIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCNIC.setBounds(217, 226, 68, 24);
		contentPane.add(lblCNIC);
		
		txtCNIC = new JTextField();
		txtCNIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCNIC.setColumns(10);
		txtCNIC.setBounds(217, 261, 183, 24);
		contentPane.add(txtCNIC);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(217, 86, 121, 24);
		contentPane.add(lblFirstName);
		
		txtfirstname = new JTextField();
		txtfirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname.setColumns(10);
		txtfirstname.setBounds(217, 121, 183, 24);
		contentPane.add(txtfirstname);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemail.setBounds(10, 226, 68, 24);
		contentPane.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtemail.setColumns(10);
		txtemail.setBounds(10, 261, 183, 24);
		contentPane.add(txtemail);
		
		JLabel lblDOB = new JLabel("DOB:");
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDOB.setBounds(10, 296, 68, 24);
		contentPane.add(lblDOB);
		
		JLabel lblsurname = new JLabel("Sur Name:");
		lblsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsurname.setBounds(10, 156, 102, 24);
		contentPane.add(lblsurname);
		
		txtsurname = new JTextField();
		txtsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname.setColumns(10);
		txtsurname.setBounds(10, 191, 183, 24);
		contentPane.add(txtsurname);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(217, 156, 68, 24);
		contentPane.add(lblGender);
		
		
		JLabel lblage = new JLabel("Age:");
		lblage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblage.setBounds(217, 296, 68, 24);
		contentPane.add(lblage);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtage.setColumns(10);
		txtage.setBounds(220, 331, 183, 24);
		contentPane.add(txtage);
		
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbladdress.setBounds(10, 366, 68, 24);
		contentPane.add(lbladdress);
		
		txtaddress = new JTextField();
		txtaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtaddress.setColumns(10);
		txtaddress.setBounds(10, 401, 183, 24);
		contentPane.add(txtaddress);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblphone.setBounds(217, 366, 68, 24);
		contentPane.add(lblphone);
		
		txtphone = new JTextField();
		txtphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtphone.setColumns(10);
		txtphone.setBounds(217, 401, 183, 24);
		contentPane.add(txtphone);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 86, 115, 24);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(10, 122, 183, 23);
		contentPane.add(passwordField);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 331, 189, 20);
		contentPane.add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(217, 191, 183, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sign UP!");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String password= passwordField.getText();
					String firstname= txtfirstname.getText();
					String surname= txtsurname.getText();
					String email= txtemail.getText();
					String CNIC= txtCNIC.getText();
					//String DOB= txtDOB.getText();
					SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd");
					String DOB=dFormat.format(dateChooser.getDate());
					String age= txtage.getText();
					String address= txtaddress.getText();
					String phone= txtphone.getText();
					//String gender= txtgender.getText();
					String gender=comboBox.getSelectedItem().toString();
					
						
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into signup(password,firstname,surname,email,CNIC,DOB,age,address,phone,gender) values(?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1,password);
					pst.setString(2,firstname);
					pst.setString(3,surname);
					pst.setString(4,email);
					pst.setString(5,CNIC);
					pst.setString(6,DOB);
					pst.setString(7,age);
					pst.setString(8,address);
					pst.setString(9,phone);
					pst.setString(10,gender);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					passwordField.setText("");
					txtfirstname.setText("");
					txtsurname.setText("");
					txtemail.setText("");
					txtCNIC.setText("");
					//txtDOB.setText("");
					txtage.setText("");
					txtaddress.setText("");
					txtphone.setText("");
					//txtgender.setText("");
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 436, 390, 35);
		contentPane.add(btnNewButton);
		
		/*txtgender = new JTextField();
		txtgender.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtgender.setColumns(10);
		txtgender.setBounds(217, 191, 183, 24);
		contentPane.add(txtgender);*/
		
		
		JLabel lblNewLabel_1 = new JLabel("Already have an account?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(152, 482, 153, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Login Now!");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginfoam login=new loginfoam();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(10, 507, 390, 32);
		contentPane.add(btnNewButton_1);
		
		
	}
}
