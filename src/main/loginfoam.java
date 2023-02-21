package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class loginfoam extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginfoam frame = new loginfoam();
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
	public loginfoam() {
		con=connEmployee.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Here");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(318, 11, 168, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblusername.setBounds(250, 71, 112, 31);
		contentPane.add(lblusername);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpassword.setBounds(250, 113, 112, 31);
		contentPane.add(lblpassword);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setBounds(372, 72, 165, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(372, 114, 165, 30);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account? Sign up now!");
		lblNewLabel_1.setBounds(306, 197, 241, 19);
		contentPane.add(lblNewLabel_1);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setBackground(Color.BLUE);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String username=txtid.getText();
					String password=String.valueOf(passwordField.getPassword());
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from signup where firstname=? and password=?");
					pst.setString(1, username);
					pst.setString(2, password);
					ResultSet r =pst.executeQuery();
					if(r.next())
					{
						JOptionPane.showMessageDialog(contentPane,"Login Successfully");
						dispose();
						clsInfo info = new clsInfo();
						info.setVisible(true);
						
						
						
					}
					else if(username.equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(contentPane, "Username field is empty");
					}
					else if (password.equals(""))
					{
						JOptionPane.showMessageDialog(contentPane, "Password field is empty");
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane,"incorrect username and password");
						txtid.setText("");
						passwordField.setText("");
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlogin.setBounds(250, 155, 287, 31);
		contentPane.add(btnlogin);
		
		JButton btnsignup = new JButton("Sign Up!");
		btnsignup.setBackground(Color.BLUE);
		btnsignup.setForeground(Color.WHITE);
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				clsSignUp signup = new clsSignUp();
				signup.setVisible(true);
			
			}
		});
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsignup.setBounds(250, 219, 287, 31);
		contentPane.add(btnsignup);
		
		JLabel lblimg = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/login")).getImage();
		lblimg.setIcon(new ImageIcon(img));
		lblimg.setBounds(-31, 11, 271, 239);
		contentPane.add(lblimg);
	}
}
