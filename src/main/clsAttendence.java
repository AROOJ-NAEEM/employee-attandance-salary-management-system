package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class clsAttendence extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtfirstname;
	private JTextField txtsurname;
	JLabel lblclock;
	JButton btntimeout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JLabel lblclock = new JLabel("");
				JButton btntimeout = new JButton("Time Out");
				JButton btntimein = new JButton("Time In");
				try {
					clsAttendence frame = new clsAttendence();
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
	private JTextField txttimein;
	private JTextField txttimeout;
	private JTextField txtdate;
	private JTextField txtid1;
	private JTextField txtfirstname1;
	private JTextField txtsurname1;
	private JTextField txtdate1;
	private JTextField txttimein1;
	private JTextField txttimeout1;
	private JTextField txtid2;
	private JTextField txtfirstname2;
	private JTextField txtsurname2;
	private JTextField txtdate2;
	private JTextField txttimein2;
	private JTextField txttimeout2;
	private JTextField txtid3;
	private JTextField txtfirstname3;
	private JTextField txtsurname3;
	private JTextField txtdate3;
	private JTextField txttimein3;
	private JTextField txttimeout3;
	private JTextField txtid4;
	private JTextField txtfirstname4;
	private JTextField txtsurname4;
	private JTextField txtdate4;
	private JTextField txttimein4;
	private JTextField txttimeout4;
	private JTable table;
	public clsAttendence() {
		con=connEmployee.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1443, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("Attendance");
		lblNewLabel.setBounds(5, 11, 136, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblid = new JLabel("Employee id:");
		lblid.setBounds(15, 66, 88, 17);
		lblid.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setText("1");
		txtid.setBounds(107, 63, 113, 23);
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setColumns(10);
		
		JButton btnreset = new JButton("Reset");
		btnreset.setBounds(15, 499, 137, 25);
		btnreset.setBackground(Color.BLUE);
		btnreset.setForeground(Color.WHITE);
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText(null);
				txtfirstname.setText(null);
				txtsurname.setText(null);
				//textArea.setText(null);
				txtid1.setText(null);
				txtfirstname1.setText(null);
				txtsurname1.setText(null);
				txtid2.setText(null);
				txtfirstname2.setText(null);
				txtsurname2.setText(null);
				txtid3.setText(null);
				txtfirstname3.setText(null);
				txtsurname3.setText(null);
			}
		});
		
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnhome = new JButton("Home");
		btnhome.setBounds(1220, 499, 140, 25);
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			clsInfo b=new clsInfo();
			b.setVisible(true);
			}
		});
		btnhome.setBackground(Color.BLUE);
		btnhome.setForeground(Color.WHITE);
		btnhome.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btntimeout = new JButton("Time Out");
		btntimeout.setBounds(1051, 62, 98, 25);
		btntimeout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal1=new GregorianCalendar();
				
				
				int second1=cal1.get(Calendar.SECOND);
				int mint1=cal1.get(Calendar.MINUTE);
				int hrs1=cal1.get(Calendar.HOUR);
				
				txttimeout.setText(hrs1+":"+mint1+":"+second1);
				/*textArea.setText("");
				textArea.append(
						"Attendence sheet:\n"
						+ "============================\n"
						+ "Employee id:\t\t"+txtid.getText()+"\n"
						+ "First Name:\t\t"+txtfirstname.getText()+"\n"
						+ "Surname:\t\t"+txtsurname.getText()+"\n"
						+ "Time In:\t\t"+txttimein.getText()+"\n"
						+ "Time Out:\t\t"+txttimeout.getText()+"\n"
						+ "Date:\t\t"+txtdate.getText()+"\n"
						+ "============================\n"
				
						);*/
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					try {
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into attendance(id,firstname,surname,date,timein,timeout) values(?,?,?,?,?,?)");
	                pst.setInt(1,id);
					pst.setString(2,txtfirstname.getText());
					pst.setString(3,txtsurname.getText());
					pst.setString(4,txtdate.getText());
					pst.setString(5,txttimein.getText());
					pst.setString(6,txttimeout.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					int a;
					PreparedStatement pst1;
					try {
						pst1 = (PreparedStatement) con.prepareStatement("select * from attendance");
						ResultSet rs2 =pst1.executeQuery();
						ResultSetMetaData rd=(ResultSetMetaData) rs2.getMetaData();
						a=rd.getColumnCount();
						DefaultTableModel df=(DefaultTableModel)table.getModel();
						df.setRowCount(0);
						while(rs2.next())
						{
							java.util.Vector<String> v2= new java.util.Vector<String>();
							for(int i=1;i<=a;i++)
							{
								v2.add(rs2.getString("id"));
								v2.add(rs2.getString("firstname"));
								v2.add(rs2.getString("surname"));
								v2.add(rs2.getString("date"));
								v2.add(rs2.getString("timein"));
								v2.add(rs2.getString("timeout"));
							}
							df.addRow(v2);
						}
						//btntimein.setEnabled(true);
						//btntimeout.setEnabled(false);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					
				
				catch(Exception ev)
				{

					System.out.println(ev);
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			
			
		});
		btntimeout.setForeground(Color.WHITE);
		btntimeout.setBackground(Color.BLUE);
		btntimeout.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btntimein = new JButton("Time In");
		btntimein.setBounds(230, 58, 88, 32);
		btntimein.setBackground(Color.BLUE);
		btntimein.setForeground(Color.WHITE);
		btntimein.addActionListener(new ActionListener() {
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
						txttimein.setText("");
					}
					else
					{
					txtfirstname.setText(rs.getString("firstname"));
					txtsurname.setText(rs.getString("surname"));
					
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int mint=cal.get(Calendar.MINUTE);
					int hrs=cal.get(Calendar.HOUR);
					
					txttimein.setText(hrs+":"+mint+":"+second);
					txtdate.setText(year+":"+month+":"+day);
					//btntimeout.setEnabled(true);
					
					
					//btntimein.setEnabled(false);
					
					
					/*textArea.setText("");
					textArea.append(
							"Attendence sheet:\n"
							+ "============================\n"
							+ "Employee id:\t\t"+txtid.getText()+"\n"
							+ "First Name:\t\t"+txtfirstname.getText()+"\n"
							+ "Surname:\t\t"+txtsurname.getText()+"\n"
							+ "Time In:\t\t"+txttimein.getText()+"\n"
							+ "Date:\t\t"+txtdate.getText()+"\n"
							+ "============================\n"
							);*/
                   /* PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into attendance(id,firstname,surname,date,timein,timeout) values(?,?,?,?,?,?)");
                    pst.setInt(1,id);
					pst.setString(2,txtfirstname.getText());
					pst.setString(3,txtsurname.getText());
					pst.setString(4,txtdate.getText());
					pst.setString(5,txttimein.getText());
					pst.setString(6,txttimeout.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");*/
					}
					
				}
				catch(Exception ev)
				{

					System.out.println(ev);
				}
			}
		});
		btntimein.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Firstname:");
		lblNewLabel_2.setBounds(328, 66, 73, 17);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(411, 63, 113, 23);
		txtfirstname.setEnabled(false);
		txtfirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Surname:");
		lblNewLabel_3.setBounds(534, 66, 67, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtsurname = new JTextField();
		txtsurname.setBounds(611, 63, 98, 23);
		txtsurname.setEnabled(false);
		txtsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname.setColumns(10);
		
	
		
		JButton btnprint = new JButton("Print");
		btnprint.setBounds(162, 499, 137, 25);
		btnprint.setForeground(Color.WHITE);
		btnprint.setBackground(Color.BLUE);
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            MessageFormat header = new MessageFormat("Printing in progress");
				
				try
				{
					table.print(JTable.PrintMode.NORMAL, header,null);
					
				}
				catch(java.awt.print.PrinterException ev) {
					System.out.println("NoPrinter Found");
				}
			}
		});
		btnprint.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbltimein = new JLabel("Time in:");
		lbltimein.setBounds(879, 66, 54, 17);
		lbltimein.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txttimein = new JTextField();
		txttimein.setBounds(943, 63, 98, 23);
		txttimein.setEnabled(false);
		txttimein.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimein.setColumns(10);
		
		JLabel lbltimeout = new JLabel("Time out:");
		lbltimeout.setBounds(1159, 66, 66, 17);
		lbltimeout.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txttimeout = new JTextField();
		txttimeout.setBounds(1236, 63, 124, 23);
		txttimeout.setEnabled(false);
		txttimeout.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimeout.setColumns(10);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Date:");
		lblNewLabel_4.setBounds(719, 66, 37, 17);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBackground(Color.BLUE);
		
		txtdate = new JTextField();
		txtdate.setBounds(771, 63, 98, 23);
		txtdate.setEnabled(false);
		txtdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtdate.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(btnreset);
		contentPane.add(btnprint);
		contentPane.add(btnhome);
		contentPane.add(lbltimeout);
		contentPane.add(txttimeout);
		contentPane.add(lblid);
		contentPane.add(txtid);
		contentPane.add(btntimein);
		contentPane.add(btntimeout);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lbltimein);
		contentPane.add(txttimein);
		contentPane.add(txtfirstname);
		contentPane.add(lblNewLabel_3);
		contentPane.add(txtsurname);
		contentPane.add(lblNewLabel_4);
		contentPane.add(txtdate);
		contentPane.add(lblNewLabel);
		
		JLabel lblclock = new JLabel("");
		lblclock.setBounds(345, 11, 137, 27);
		lblclock.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblclock);
		
		JLabel lblid_1 = new JLabel("Employee id:");
		lblid_1.setBounds(15, 102, 88, 17);
		lblid_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblid_1);
		
		txtid1 = new JTextField();
		txtid1.setEnabled(false);
		txtid1.setText("2");
		txtid1.setBounds(107, 99, 113, 23);
		txtid1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid1.setColumns(10);
		contentPane.add(txtid1);
		
		JButton btntimeout_1 = new JButton("Time Out");
		btntimeout_1.setBounds(1051, 98, 98, 25);
		btntimeout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            Calendar cal1=new GregorianCalendar();
				
				
				int second1=cal1.get(Calendar.SECOND);
				int mint1=cal1.get(Calendar.MINUTE);
				int hrs1=cal1.get(Calendar.HOUR);
				
				txttimeout1.setText(hrs1+":"+mint1+":"+second1);
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid1.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					try {
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into attendance(id,firstname,surname,date,timein,timeout) values(?,?,?,?,?,?)");
	                pst.setInt(1,id);
					pst.setString(2,txtfirstname1.getText());
					pst.setString(3,txtsurname1.getText());
					pst.setString(4,txtdate1.getText());
					pst.setString(5,txttimein1.getText());
					pst.setString(6,txttimeout1.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					int a;
					PreparedStatement pst1;
					try {
						pst1 = (PreparedStatement) con.prepareStatement("select * from attendance");
						ResultSet rs2 =pst1.executeQuery();
						ResultSetMetaData rd=(ResultSetMetaData) rs2.getMetaData();
						a=rd.getColumnCount();
						DefaultTableModel df=(DefaultTableModel)table.getModel();
						df.setRowCount(0);
						while(rs2.next())
						{
							java.util.Vector<String> v2= new java.util.Vector<String>();
							for(int i=1;i<=a;i++)
							{
								v2.add(rs2.getString("id"));
								v2.add(rs2.getString("firstname"));
								v2.add(rs2.getString("surname"));
								v2.add(rs2.getString("date"));
								v2.add(rs2.getString("timein"));
								v2.add(rs2.getString("timeout"));
							}
							df.addRow(v2);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					
				
				catch(Exception ev)
				{

					System.out.println(ev);
				}
				}
				catch(Exception ev)
				{
					System.out.println(ev);
				}
			}
			
		});
		btntimeout_1.setForeground(Color.WHITE);
		btntimeout_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimeout_1.setBackground(Color.BLUE);
		contentPane.add(btntimeout_1);
		
		JButton btntimein_1 = new JButton("Time In");
		btntimein_1.setBounds(230, 94, 88, 32);
		btntimein_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid1.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"sorry employee not found");
						txtfirstname1.setText("");
						txtsurname1.setText("");
						txttimein1.setText("");
					}
					else
					{
					txtfirstname1.setText(rs.getString("firstname"));
					txtsurname1.setText(rs.getString("surname"));
					
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int mint=cal.get(Calendar.MINUTE);
					int hrs=cal.get(Calendar.HOUR);
					
					txttimein1.setText(hrs+":"+mint+":"+second);
					txtdate1.setText(year+":"+month+":"+day);
					//btntimeout_1.setEnabled(true);
					//btntimein_1.setEnabled(false);
					}
					
				}
				catch(Exception ev)
				{

					System.out.println(ev);
				}
				
			}
		});
		btntimein_1.setForeground(Color.WHITE);
		btntimein_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimein_1.setBackground(Color.BLUE);
		contentPane.add(btntimein_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Firstname:");
		lblNewLabel_2_1.setBounds(328, 102, 73, 17);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2_1);
		
		txtfirstname1 = new JTextField();
		txtfirstname1.setBounds(411, 99, 113, 23);
		txtfirstname1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname1.setEnabled(false);
		txtfirstname1.setColumns(10);
		contentPane.add(txtfirstname1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Surname:");
		lblNewLabel_3_1.setBounds(534, 102, 67, 17);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3_1);
		
		txtsurname1 = new JTextField();
		txtsurname1.setBounds(611, 99, 98, 23);
		txtsurname1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname1.setEnabled(false);
		txtsurname1.setColumns(10);
		contentPane.add(txtsurname1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Date:");
		lblNewLabel_4_1.setBounds(719, 102, 37, 17);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_4_1);
		
		txtdate1 = new JTextField();
		txtdate1.setBounds(771, 99, 98, 23);
		txtdate1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtdate1.setEnabled(false);
		txtdate1.setColumns(10);
		contentPane.add(txtdate1);
		
		JLabel lbltimein_1 = new JLabel("Time in:");
		lbltimein_1.setBounds(879, 102, 54, 17);
		lbltimein_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimein_1);
		
		txttimein1 = new JTextField();
		txttimein1.setBounds(943, 99, 98, 23);
		txttimein1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimein1.setEnabled(false);
		txttimein1.setColumns(10);
		contentPane.add(txttimein1);
		
		
		
		JLabel lbltimeout_1 = new JLabel("Time out:");
		lbltimeout_1.setBounds(1159, 102, 66, 17);
		lbltimeout_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimeout_1);
		
		txttimeout1 = new JTextField();
		txttimeout1.setBounds(1236, 99, 124, 23);
		txttimeout1.setEnabled(false);
		txttimeout1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimeout1.setColumns(10);
		contentPane.add(txttimeout1);
		
		JLabel lblid_2 = new JLabel("Employee id:");
		lblid_2.setBounds(15, 138, 88, 17);
		lblid_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblid_2);
		
		txtid2 = new JTextField();
		txtid2.setEnabled(false);

		txtid2.setText("3");
		txtid2.setBounds(107, 135, 113, 23);
		txtid2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid2.setColumns(10);
		contentPane.add(txtid2);
		
		JButton btntimeout_2 = new JButton("Time Out");
		btntimeout_2.setBounds(1051, 134, 98, 25);
		btntimeout_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             Calendar cal1=new GregorianCalendar();
				
				
				int second1=cal1.get(Calendar.SECOND);
				int mint1=cal1.get(Calendar.MINUTE);
				int hrs1=cal1.get(Calendar.HOUR);
				
				txttimeout2.setText(hrs1+":"+mint1+":"+second1);
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid2.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					try {
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into attendance(id,firstname,surname,date,timein,timeout) values(?,?,?,?,?,?)");
	                pst.setInt(1,id);
					pst.setString(2,txtfirstname2.getText());
					pst.setString(3,txtsurname2.getText());
					pst.setString(4,txtdate2.getText());
					pst.setString(5,txttimein2.getText());
					pst.setString(6,txttimeout2.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					int a;
					PreparedStatement pst1;
					try {
						pst1 = (PreparedStatement) con.prepareStatement("select * from attendance");
						ResultSet rs2 =pst1.executeQuery();
						ResultSetMetaData rd=(ResultSetMetaData) rs2.getMetaData();
						a=rd.getColumnCount();
						DefaultTableModel df=(DefaultTableModel)table.getModel();
						df.setRowCount(0);
						while(rs2.next())
						{
							java.util.Vector<String> v2= new java.util.Vector<String>();
							for(int i=1;i<=a;i++)
							{
								v2.add(rs2.getString("id"));
								v2.add(rs2.getString("firstname"));
								v2.add(rs2.getString("surname"));
								v2.add(rs2.getString("date"));
								v2.add(rs2.getString("timein"));
								v2.add(rs2.getString("timeout"));
							}
							df.addRow(v2);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					
				
				catch(Exception ev)
				{

					System.out.println(ev);
				}
				}
				catch(Exception ev)
				{
					System.out.println(ev);
				}
			}
			
		});
		btntimeout_2.setForeground(Color.WHITE);
		btntimeout_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimeout_2.setBackground(Color.BLUE);
		contentPane.add(btntimeout_2);
		
		JButton btntimein_2 = new JButton("Time In");
		btntimein_2.setBounds(230, 130, 88, 32);
		btntimein_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid2.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"sorry employee not found");
						txtfirstname2.setText("");
						txtsurname2.setText("");
						txttimein2.setText("");
					}
					else
					{
					txtfirstname2.setText(rs.getString("firstname"));
					txtsurname2.setText(rs.getString("surname"));
					
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int mint=cal.get(Calendar.MINUTE);
					int hrs=cal.get(Calendar.HOUR);
					
					txttimein2.setText(hrs+":"+mint+":"+second);
					txtdate2.setText(year+":"+month+":"+day);
					//btntimeout_2.setEnabled(true);
					//btntimein_2.setEnabled(false);
					
					}
					
				}
				catch(Exception ev)
				{

					System.out.println(ev);
				}
			}
		});
		btntimein_2.setForeground(Color.WHITE);
		btntimein_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimein_2.setBackground(Color.BLUE);
		contentPane.add(btntimein_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Firstname:");
		lblNewLabel_2_2.setBounds(328, 138, 73, 17);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2_2);
		
		txtfirstname2 = new JTextField();
		txtfirstname2.setBounds(411, 135, 113, 23);
		txtfirstname2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname2.setEnabled(false);
		txtfirstname2.setColumns(10);
		contentPane.add(txtfirstname2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Surname:");
		lblNewLabel_3_2.setBounds(534, 138, 67, 17);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3_2);
		
		txtsurname2 = new JTextField();
		txtsurname2.setBounds(611, 135, 98, 23);
		txtsurname2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname2.setEnabled(false);
		txtsurname2.setColumns(10);
		contentPane.add(txtsurname2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Date:");
		lblNewLabel_4_2.setBounds(719, 138, 37, 17);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_4_2);
		
		txtdate2 = new JTextField();
		txtdate2.setBounds(771, 135, 98, 23);
		txtdate2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtdate2.setEnabled(false);
		txtdate2.setColumns(10);
		contentPane.add(txtdate2);
		
		JLabel lbltimein_2 = new JLabel("Time in:");
		lbltimein_2.setBounds(879, 138, 54, 17);
		lbltimein_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimein_2);
		
		txttimein2 = new JTextField();
		txttimein2.setBounds(943, 135, 98, 23);
		txttimein2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimein2.setEnabled(false);
		txttimein2.setColumns(10);
		contentPane.add(txttimein2);
		
		
		
		JLabel lbltimeout_2 = new JLabel("Time out:");
		lbltimeout_2.setBounds(1159, 138, 66, 17);
		lbltimeout_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimeout_2);
		
		txttimeout2 = new JTextField();
		txttimeout2.setBounds(1236, 135, 124, 23);
		txttimeout2.setEnabled(false);
		txttimeout2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimeout2.setColumns(10);
		contentPane.add(txttimeout2);
		
		JLabel lblid_3 = new JLabel("Employee id:");
		lblid_3.setBounds(15, 174, 88, 17);
		lblid_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblid_3);
		
		txtid3 = new JTextField();
		txtid3.setText("4");
		txtid3.setEnabled(false);
		txtid3.setBounds(107, 171, 113, 23);
		txtid3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid3.setColumns(10);
		contentPane.add(txtid3);
		
		JButton btntimeout_3 = new JButton("Time Out");
		btntimeout_3.setBounds(1051, 170, 98, 25);
		btntimeout_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             Calendar cal1=new GregorianCalendar();
				
				
				int second1=cal1.get(Calendar.SECOND);
				int mint1=cal1.get(Calendar.MINUTE);
				int hrs1=cal1.get(Calendar.HOUR);
				
				txttimeout3.setText(hrs1+":"+mint1+":"+second1);
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid3.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					try {
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into attendance(id,firstname,surname,date,timein,timeout) values(?,?,?,?,?,?)");
	                pst.setInt(1,id);
					pst.setString(2,txtfirstname3.getText());
					pst.setString(3,txtsurname3.getText());
					pst.setString(4,txtdate3.getText());
					pst.setString(5,txttimein3.getText());
					pst.setString(6,txttimeout3.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					int a;
					PreparedStatement pst1;
					try {
						pst1 = (PreparedStatement) con.prepareStatement("select * from attendance");
						ResultSet rs2 =pst1.executeQuery();
						ResultSetMetaData rd=(ResultSetMetaData) rs2.getMetaData();
						a=rd.getColumnCount();
						DefaultTableModel df=(DefaultTableModel)table.getModel();
						df.setRowCount(0);
						while(rs2.next())
						{
							java.util.Vector<String> v2= new java.util.Vector<String>();
							for(int i=1;i<=a;i++)
							{
								v2.add(rs2.getString("id"));
								v2.add(rs2.getString("firstname"));
								v2.add(rs2.getString("surname"));
								v2.add(rs2.getString("date"));
								v2.add(rs2.getString("timein"));
								v2.add(rs2.getString("timeout"));
							}
							df.addRow(v2);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					
				
				catch(Exception ev)
				{

					System.out.println(ev);
				}
				}
				catch(Exception ev)
				{
					System.out.println(ev);
				}
			}
			
		});
		btntimeout_3.setForeground(Color.WHITE);
		btntimeout_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimeout_3.setBackground(Color.BLUE);
		contentPane.add(btntimeout_3);
		
		JButton btntimein_3 = new JButton("Time In");
		btntimein_3.setBounds(230, 166, 88, 32);
		btntimein_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid3.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"sorry employee not found");
						txtfirstname3.setText("");
						txtsurname3.setText("");
						txttimein3.setText("");
					}
					else
					{
					txtfirstname3.setText(rs.getString("firstname"));
					txtsurname3.setText(rs.getString("surname"));
					
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int mint=cal.get(Calendar.MINUTE);
					int hrs=cal.get(Calendar.HOUR);
					
					txttimein3.setText(hrs+":"+mint+":"+second);
					txtdate3.setText(year+":"+month+":"+day);
					//btntimeout_3.setEnabled(true);
					//btntimein_3.setEnabled(false);
					
					}
					
				}
				catch(Exception ev)
				{

					System.out.println(ev);
				}
			}
		});
		btntimein_3.setForeground(Color.WHITE);
		btntimein_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimein_3.setBackground(Color.BLUE);
		contentPane.add(btntimein_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Firstname:");
		lblNewLabel_2_3.setBounds(328, 174, 73, 17);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2_3);
		
		txtfirstname3 = new JTextField();
		txtfirstname3.setBounds(411, 171, 113, 23);
		txtfirstname3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname3.setEnabled(false);
		txtfirstname3.setColumns(10);
		contentPane.add(txtfirstname3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Surname:");
		lblNewLabel_3_3.setBounds(534, 174, 67, 17);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3_3);
		
		txtsurname3 = new JTextField();
		txtsurname3.setBounds(611, 171, 98, 23);
		txtsurname3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname3.setEnabled(false);
		txtsurname3.setColumns(10);
		contentPane.add(txtsurname3);
		
		JLabel lblNewLabel_4_3 = new JLabel("Date:");
		lblNewLabel_4_3.setBounds(719, 174, 37, 17);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_3.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_4_3);
		
		txtdate3 = new JTextField();
		txtdate3.setBounds(771, 171, 98, 23);
		txtdate3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtdate3.setEnabled(false);
		txtdate3.setColumns(10);
		contentPane.add(txtdate3);
		
		JLabel lbltimein_3 = new JLabel("Time in:");
		lbltimein_3.setBounds(879, 174, 54, 17);
		lbltimein_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimein_3);
		
		txttimein3 = new JTextField();
		txttimein3.setBounds(943, 171, 98, 23);
		txttimein3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimein3.setEnabled(false);
		txttimein3.setColumns(10);
		contentPane.add(txttimein3);
		
		
		
		JLabel lbltimeout_3 = new JLabel("Time out:");
		lbltimeout_3.setBounds(1159, 174, 66, 17);
		lbltimeout_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimeout_3);
		
		txttimeout3 = new JTextField();
		txttimeout3.setBounds(1236, 171, 124, 23);
		txttimeout3.setEnabled(false);
		txttimeout3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimeout3.setColumns(10);
		contentPane.add(txttimeout3);
		
		JLabel lblid_4 = new JLabel("Employee id:");
		lblid_4.setBounds(15, 210, 88, 17);
		lblid_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblid_4);
		
		txtid4 = new JTextField();
		txtid4.setText("5");
		txtid4.setEnabled(false);
		txtid4.setBounds(107, 207, 113, 23);
		txtid4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid4.setColumns(10);
		contentPane.add(txtid4);
		
		JButton btntimeout_4 = new JButton("Time Out");
		btntimeout_4.setBounds(1051, 206, 98, 25);
		btntimeout_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            Calendar cal1=new GregorianCalendar();
				
				
				int second1=cal1.get(Calendar.SECOND);
				int mint1=cal1.get(Calendar.MINUTE);
				int hrs1=cal1.get(Calendar.HOUR);
				
				txttimeout4.setText(hrs1+":"+mint1+":"+second1);
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid4.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					try {
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into attendance(id,firstname,surname,date,timein,timeout) values(?,?,?,?,?,?)");
	                pst.setInt(1,id);
					pst.setString(2,txtfirstname4.getText());
					pst.setString(3,txtsurname4.getText());
					pst.setString(4,txtdate4.getText());
					pst.setString(5,txttimein4.getText());
					pst.setString(6,txttimeout4.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					int a;
					PreparedStatement pst1;
					try {
						pst1 = (PreparedStatement) con.prepareStatement("select * from attendance");
						ResultSet rs2 =pst1.executeQuery();
						ResultSetMetaData rd=(ResultSetMetaData) rs2.getMetaData();
						a=rd.getColumnCount();
						DefaultTableModel df=(DefaultTableModel)table.getModel();
						df.setRowCount(0);
						while(rs2.next())
						{
							java.util.Vector<String> v2= new java.util.Vector<String>();
							for(int i=1;i<=a;i++)
							{
								v2.add(rs2.getString("id"));
								v2.add(rs2.getString("firstname"));
								v2.add(rs2.getString("surname"));
								v2.add(rs2.getString("date"));
								v2.add(rs2.getString("timein"));
								v2.add(rs2.getString("timeout"));
							}
							df.addRow(v2);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					
				
				catch(Exception ev)
				{

					System.out.println(ev);
				}
				}
				catch(Exception ev)
				{
					System.out.println(ev);
				}
			
			}
		});
		btntimeout_4.setForeground(Color.WHITE);
		btntimeout_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimeout_4.setBackground(Color.BLUE);
		contentPane.add(btntimeout_4);
		
		JButton btntimein_4 = new JButton("Time In");
		btntimein_4.setBounds(230, 202, 88, 32);
		btntimein_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst =(PreparedStatement) con.prepareStatement("select id,firstname,surname,gender,email,CNIC,DOB,age,address,phone from employee where id=?");
					int id=Integer.parseInt(txtid4.getText());
					pst.setInt(1,id);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==false)
					{
						JOptionPane.showMessageDialog(null,"sorry employee not found");
						txtfirstname4.setText("");
						txtsurname4.setText("");
						txttimein4.setText("");
					}
					else
					{
					txtfirstname4.setText(rs.getString("firstname"));
					txtsurname4.setText(rs.getString("surname"));
					
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int mint=cal.get(Calendar.MINUTE);
					int hrs=cal.get(Calendar.HOUR);
					
					txttimein4.setText(hrs+":"+mint+":"+second);
					txtdate4.setText(year+":"+month+":"+day);
					//btntimeout_4.setEnabled(true);
					//btntimein_4.setEnabled(false);
					
					}
					
				}
				catch(Exception ev)
				{

					System.out.println(ev);
				}
			}
		});
		btntimein_4.setForeground(Color.WHITE);
		btntimein_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btntimein_4.setBackground(Color.BLUE);
		contentPane.add(btntimein_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("Firstname:");
		lblNewLabel_2_4.setBounds(328, 210, 73, 17);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2_4);
		
		txtfirstname4 = new JTextField();
		txtfirstname4.setBounds(411, 207, 113, 23);
		txtfirstname4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname4.setEnabled(false);
		txtfirstname4.setColumns(10);
		contentPane.add(txtfirstname4);
		
		JLabel lblNewLabel_3_4 = new JLabel("Surname:");
		lblNewLabel_3_4.setBounds(534, 210, 67, 17);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3_4);
		
		txtsurname4 = new JTextField();
		txtsurname4.setBounds(611, 207, 98, 23);
		txtsurname4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname4.setEnabled(false);
		txtsurname4.setColumns(10);
		contentPane.add(txtsurname4);
		
		JLabel lblNewLabel_4_4 = new JLabel("Date:");
		lblNewLabel_4_4.setBounds(719, 210, 37, 17);
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_4.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_4_4);
		
		txtdate4 = new JTextField();
		txtdate4.setBounds(771, 207, 98, 23);
		txtdate4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtdate4.setEnabled(false);
		txtdate4.setColumns(10);
		contentPane.add(txtdate4);
		
		JLabel lbltimein_4 = new JLabel("Time in:");
		lbltimein_4.setBounds(879, 210, 54, 17);
		lbltimein_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimein_4);
		
		txttimein4 = new JTextField();
		txttimein4.setBounds(943, 207, 98, 23);
		txttimein4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimein4.setEnabled(false);
		txttimein4.setColumns(10);
		contentPane.add(txttimein4);
		
		
		
		JLabel lbltimeout_4 = new JLabel("Time out:");
		lbltimeout_4.setBounds(1159, 210, 66, 17);
		lbltimeout_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbltimeout_4);
		
		txttimeout4 = new JTextField();
		txttimeout4.setBounds(1236, 207, 124, 23);
		txttimeout4.setEnabled(false);
		txttimeout4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttimeout4.setColumns(10);
		contentPane.add(txttimeout4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 241, 1345, 241);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(5, 0, 1355, 55);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Show Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				viewAttendance x=new viewAttendance();
				x.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(309, 499, 137, 25);
		contentPane.add(btnNewButton);
	}
	
	private void clock() {
		// TODO Auto-generated method stub
		
		
	}
	
}
