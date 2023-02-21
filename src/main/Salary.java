package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Salary extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txttax;
	private JTextField txtnetsalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salary frame = new Salary();
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
	private JTextField txtfirstname;
	private JTextField txtsurname;
	private JTextField txttimein;
	private JTextField txttimeout;
	private JTextField txtWorkinghours;
	public Salary() {
		con=connEmployee.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Id:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 78, 103, 23);
		contentPane.add(lblNewLabel_2);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setColumns(10);
		txtid.setBounds(109, 76, 325, 28);
		contentPane.add(txtid);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(444, 79, 402, 311);
		contentPane.add(textArea);
		
		JButton btnNewButton_2 = new JButton("View Salary");
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					pst =(PreparedStatement) con.prepareStatement("select * from attendance where id=? GROUP BY id HAVING COUNT(*) > 1");
					int id=Integer.parseInt(txtid.getText());
					pst.setInt(1,id);
					
					
					ResultSet rs=pst.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"sorry employee not found");
						txtfirstname.setText("");
						txtsurname.setText("");
						txttimein.setText("");
						txttimeout.setText("");
					}
					else
					{
				
					txtfirstname.setText(rs.getString("firstname"));
					txtsurname.setText(rs.getString("surname"));
					String timein=rs.getString("timein");
					String timeout=rs.getString("timeout");
					
					double salary,tax,netSalary;
					String EmpID = txtid.getText();
					
					txttimein.setText(timein);
					txttimeout.setText(timeout);
					
					LocalTime timeIn = LocalTime.parse(timein, DateTimeFormatter.ofPattern("H:m:s"));
					LocalTime timeOut = LocalTime.parse(timeout, DateTimeFormatter.ofPattern("H:m:s"));
					
					long dif = ChronoUnit.SECONDS.between(timeIn, timeOut);
					if (dif < 0)
					    dif += 24 * 60;
					long sumHour = dif / (60*60);
					long sumMinute = (dif%3600) / (60);
					long sumSecond = dif % 60;

			        txtWorkinghours.setText(sumHour+":"+sumMinute+":"+sumSecond);
					double one_hour_salary=5000;
					double one_mint_salary=(5000/60);
					double one_sec_salary=(5000/3600);
					//double salary1=(working_hours*one_hour_salary)*30 ;
					double salary1=(sumHour*one_hour_salary+ sumMinute*one_mint_salary + sumSecond*one_sec_salary)*30 ;
					if(salary1>50000)
					{
						tax=salary1*10/100;
					}
					else if(salary1>35000)
					{
						tax=salary1*5/100;
					}
					else
					{
						tax=0;
					}
					txttax.setText(String.valueOf(tax));
					
					netSalary=salary1-tax;
					txtnetsalary.setText(String.valueOf(netSalary));
					
					
					textArea.setText("");
					textArea.append("Pay Slip:\n"
							+ "============================\n"
							+ "Employee id:\t\t"+txtid.getText()+"\n"
							+ "First Name:\t\t"+txtfirstname.getText()+"\n"
							+ "Surname:\t\t"+txtsurname.getText()+"\n"
							//+ "Total Working Hours:\t\t"+working_hours+"\n"
							//+ "Basic Salary:\t\t"+txtsalary.getText()+"\n"
							+ "Basic Salary:\t\t"+salary1+"\n"
							+ "Tax:\t\t"+txttax.getText()+"\n"
							+ "Net Salary:\t\t"+txtnetsalary.getText()+"\n"
							+ "============================\n"
							);
					
					}
					
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(10, 126, 424, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(Color.BLUE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText(null);
				//txtsalary.setText(null);
				txtnetsalary.setText(null);
				txttax.setText(null);
				txtfirstname.setText(null);
				txtsurname.setText(null);
				txttimein.setText(null);
				txttimeout.setText(null);
				textArea.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(10, 361, 89, 36);
		contentPane.add(btnReset);
		
		JLabel lblTax = new JLabel("Tax:");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTax.setBounds(10, 279, 40, 23);
		contentPane.add(lblTax);
		
		txttax = new JTextField();
		txttax.setEnabled(false);
		txttax.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttax.setColumns(10);
		txttax.setBounds(73, 277, 125, 28);
		contentPane.add(txttax);
		
		JLabel lblNewLabel_2_1 = new JLabel("Net Salary:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(208, 279, 81, 23);
		contentPane.add(lblNewLabel_2_1);
		
		txtnetsalary = new JTextField();
		txtnetsalary.setEnabled(false);
		txtnetsalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtnetsalary.setColumns(10);
		txtnetsalary.setBounds(299, 277, 125, 28);
		contentPane.add(txtnetsalary);
		
		JButton btnNewButton_3 = new JButton("Generate Pay Slip");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(216, 361, 218, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				clsInfo b=new clsInfo();
				b.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(757, 401, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblfirstname = new JLabel("Firstname:");
		lblfirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblfirstname.setBounds(0, 201, 81, 23);
		contentPane.add(lblfirstname);
		
		txtfirstname = new JTextField();
		txtfirstname.setEnabled(false);
		txtfirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname.setColumns(10);
		txtfirstname.setBounds(73, 199, 125, 28);
		contentPane.add(txtfirstname);
		
		JLabel lblsurname = new JLabel("Surname:");
		lblsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsurname.setBounds(218, 201, 103, 23);
		contentPane.add(lblsurname);
		
		txtsurname = new JTextField();
		txtsurname.setEnabled(false);
		txtsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname.setColumns(10);
		txtsurname.setBounds(309, 199, 125, 28);
		contentPane.add(txtsurname);
		
		JLabel lbltimein = new JLabel("Time in:");
		lbltimein.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltimein.setBounds(10, 165, 71, 14);
		contentPane.add(lbltimein);
		
		txttimein = new JTextField();
		txttimein.setEnabled(false);
		txttimein.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimein.setBounds(73, 165, 125, 28);
		contentPane.add(txttimein);
		txttimein.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Time out:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(210, 165, 89, 20);
		contentPane.add(lblNewLabel_3);
		
		txttimeout = new JTextField();
		txttimeout.setEnabled(false);
		txttimeout.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimeout.setBounds(309, 165, 125, 28);
		contentPane.add(txttimeout);
		txttimeout.setColumns(10);
		
		txtWorkinghours = new JTextField();
		txtWorkinghours.setEnabled(false);
		txtWorkinghours.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtWorkinghours.setBounds(187, 238, 247, 28);
		contentPane.add(txtWorkinghours);
		txtWorkinghours.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Working Hours in 1 day:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 243, 173, 17);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 0, 836, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbltimeout = new JLabel("Salary");
		lbltimeout.setBounds(10, 28, 74, 29);
		panel.add(lbltimeout);
		lbltimeout.setForeground(Color.BLACK);
		lbltimeout.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbltimeout.setBackground(Color.BLACK);
		
		
	}
}
