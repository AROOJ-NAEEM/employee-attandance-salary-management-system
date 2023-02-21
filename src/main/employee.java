package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class employee extends JFrame {

	private JPanel Jpane;
	private JTextField txtfirstname;
	private JTextField txtsurname;
	private JTextField txtemail;
	private JTextField txtCNIC;
	private JTextField txtage;
	private JTextField txtaddress;
	private JTextField txtphone;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnsave;
	private JButton btndelete;
	private JButton btnupdate;
	private JButton btnprint;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee frame = new employee();
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
	private JLabel lblNewLabel;
	private JPanel panel;
	private JButton btnedit;
	private JTextField txtsearch;
	public employee() {
		
		
		con=connEmployee.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 537);
		Jpane = new JPanel();
		Jpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Jpane);
		Jpane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(10, 96, 121, 24);
		Jpane.add(lblFirstName);
		
		txtfirstname = new JTextField();
		txtfirstname.setEnabled(false);
		txtfirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfirstname.setColumns(10);
		txtfirstname.setBounds(10, 131, 183, 24);
		Jpane.add(txtfirstname);
		
		JLabel lblsurname = new JLabel("Sur Name:");
		lblsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsurname.setBounds(215, 96, 102, 24);
		Jpane.add(lblsurname);
		
		txtsurname = new JTextField();
		txtsurname.setEnabled(false);
		txtsurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsurname.setColumns(10);
		txtsurname.setBounds(214, 131, 183, 24);
		Jpane.add(txtsurname);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(10, 166, 68, 24);
		Jpane.add(lblGender);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemail.setBounds(215, 166, 68, 24);
		Jpane.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setEnabled(false);
		txtemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtemail.setColumns(10);
		txtemail.setBounds(215, 201, 183, 24);
		Jpane.add(txtemail);
		
		JLabel lblCNIC = new JLabel("CNIC:");
		lblCNIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCNIC.setBounds(10, 234, 68, 24);
		Jpane.add(lblCNIC);
		
		txtCNIC = new JTextField();
		txtCNIC.setEnabled(false);
		txtCNIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCNIC.setColumns(10);
		txtCNIC.setBounds(10, 263, 183, 24);
		Jpane.add(txtCNIC);
		
		JLabel lblDOB = new JLabel("DOB:");
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDOB.setBounds(215, 236, 68, 24);
		Jpane.add(lblDOB);
		
		JLabel lblage = new JLabel("Age:");
		lblage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblage.setBounds(10, 298, 68, 24);
		Jpane.add(lblage);
		
		txtage = new JTextField();
		txtage.setEnabled(false);
		txtage.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtage.setColumns(10);
		txtage.setBounds(10, 333, 183, 24);
		Jpane.add(txtage);
		
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbladdress.setBounds(215, 298, 68, 24);
		Jpane.add(lbladdress);
		
		txtaddress = new JTextField();
		txtaddress.setEnabled(false);
		txtaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtaddress.setColumns(10);
		txtaddress.setBounds(215, 333, 182, 24);
		Jpane.add(txtaddress);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblphone.setBounds(10, 368, 68, 24);
		Jpane.add(lblphone);
		
		txtphone = new JTextField();
		txtphone.setEnabled(false);
		txtphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtphone.setColumns(10);
		txtphone.setBounds(10, 392, 183, 24);
		Jpane.add(txtphone);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(10, 201, 183, 22);
		Jpane.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(215, 263, 183, 24);
		Jpane.add(dateChooser);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				txtage.setEnabled(true);
				txtfirstname.setEnabled(true);
				txtsurname.setEnabled(true);
				txtaddress.setEnabled(true);
				txtphone.setEnabled(true);
				txtemail.setEnabled(true);
				txtCNIC.setEnabled(true);
				txtage.setEnabled(true);
				comboBox.setEnabled(true);
				dateChooser.setEnabled(true);
				btnsave.setEnabled(true);
				btnadd.setEnabled(false);
				
			}
		});
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnadd.setBackground(Color.BLUE);
		btnadd.setForeground(Color.WHITE);
		btnadd.setBounds(10, 455, 89, 23);
		Jpane.add(btnadd);
		
		btnedit = new JButton("Edit");
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtage.setEnabled(true);
				txtfirstname.setEnabled(true);
				txtsurname.setEnabled(true);
				txtaddress.setEnabled(true);
				txtphone.setEnabled(true);
				txtemail.setEnabled(true);
				txtCNIC.setEnabled(true);
				txtage.setEnabled(true);
				comboBox.setEnabled(true);
				dateChooser.setEnabled(true);
				btnupdate.setEnabled(true);
			
			}
		});
		btnedit.setBackground(Color.BLUE);
		btnedit.setForeground(Color.WHITE);
		btnedit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnedit.setBounds(506, 455, 89, 23);
		Jpane.add(btnedit);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(407, 124, 684, 300);
		Jpane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df=(DefaultTableModel)table.getModel();
				int Selected= table.getSelectedRow();
				int id=Integer.parseInt(df.getValueAt(Selected,0).toString());
				txtfirstname.setText(df.getValueAt(Selected,1).toString());
				txtsurname.setText(df.getValueAt(Selected,2).toString());
				//txtgender.setText(df.getValueAt(Selected,3).toString());
				String comboSub=df.getValueAt(Selected,3).toString();
				for(int i=0;i<comboBox.getItemCount();i++)
				{
					if(comboBox.getItemAt(i).toString().equalsIgnoreCase(comboSub))
					{
						comboBox.setSelectedIndex(i);
					}
				}
				//String gender=comboBox.getSelectedItem().toString();
				txtemail.setText(df.getValueAt(Selected,4).toString());
				txtCNIC.setText(df.getValueAt(Selected,5).toString());
				//txtDOB.setText(df.getValueAt(Selected,6).toString());
				//String dateChooser=(df.getValueAt(Selected,6).toString());
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse((String)df.getValueAt(Selected,6));
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txtage.setText(df.getValueAt(Selected,7).toString());
				txtaddress.setText(df.getValueAt(Selected,8).toString());
				txtphone.setText(df.getValueAt(Selected,9).toString());
				btndelete.setEnabled(true);
				btnedit.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "firstname", "surname", "gender", "email", "CNIC", "DOB", "age", "address", "phone", "status"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		
		btnsave = new JButton("Save");
		btnsave.setEnabled(false);
		btnsave.setForeground(Color.WHITE);
		btnsave.setBackground(Color.BLUE);
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					String firstname= txtfirstname.getText();
					String surname= txtsurname.getText();
					String email= txtemail.getText();
					//String gender= txtgender.getText();
					String gender=comboBox.getSelectedItem().toString();
					String CNIC= txtCNIC.getText();
					//String DOB= txtDOB.getText();
					SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd");
					String DOB=dFormat.format(dateChooser.getDate());
					String age= txtage.getText();
					String address= txtaddress.getText();
					String phone= txtphone.getText();
					
					
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into employee(firstname,surname,gender,email,CNIC,DOB,age,address,phone,status) values(?,?,?,?,?,?,?,?,?,?)");
					
					pst.setString(1,firstname);
					pst.setString(2,surname);
					pst.setString(3,gender);
					pst.setString(4,email);
					pst.setString(5,CNIC);
					pst.setString(6,DOB);
					pst.setString(7,age);
					pst.setString(8,address);
					pst.setString(9,phone);
					pst.setString(10,"1");
					pst.executeUpdate();
					JOptionPane.showMessageDialog(Jpane, "Data Added");
					txtage.setEnabled(false);
					txtfirstname.setEnabled(false);
					txtsurname.setEnabled(false);
					txtaddress.setEnabled(false);
					txtphone.setEnabled(false);
					txtemail.setEnabled(false);
					txtCNIC.setEnabled(false);
					txtage.setEnabled(false);
					comboBox.setEnabled(false);
					dateChooser.setEnabled(false);
					btnedit.setEnabled(true);
					btnadd.setEnabled(true);
					btndelete.setEnabled(true);
					btnprint.setEnabled(true);

					btnsave.setEnabled(false);
					/*txtfirstname.setText("");
					txtsurname.setText("");
					txtemail.setText("");
					txtCNIC.setText("");
					//txtDOB.setText("");
					txtage.setText("");
					txtaddress.setText("");
					txtphone.setText("");
					//txtgender.setText("");*/
					view_employee();
					
				}		
			
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(Jpane,"Data not added");
				}
				
			}	
		});
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsave.setBounds(109, 455, 89, 23);
		Jpane.add(btnsave);
		
		btndelete = new JButton("Delete");
		btndelete.setForeground(Color.WHITE);
		btndelete.setBackground(Color.BLUE);
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*JOptionPane.showConfirmDialog(null, "Do you really want to Delete?","Delete", JOptionPane.YES_NO_OPTION);
				 
				   try {
					   DefaultTableModel df=(DefaultTableModel)table.getModel();
						df.setRowCount(0);
						int Selected= table.getSelectedRow();
					   int id=Integer.parseInt(df.getValueAt(Selected,0).toString());
					   pst =(PreparedStatement) con.prepareStatement("DELETE FROM employee WHERE(id,firstname,surname,gender,email,CNIC,DOB,age,address,phone) values('"+id+"',?,?,?,?,?,?,?,?,?)");
					   pst.executeUpdate();
					   JOptionPane.showMessageDialog(null, "Data is Deleted");
				   }
				   catch(Exception ev) {
					   JOptionPane.showMessageDialog(null, ev);
				   }*/
			   
				/*try
				{
					pst =(PreparedStatement) con.prepareStatement("DELETE FROM employee where(id,firstname,surname,gender,email,CNIC,DOB,age,address,phone) values(?,?,?,?,?,?,?,?,?,?)");
					pst.execute();
					DefaultTableModel df=(DefaultTableModel)table.getModel();
					df.setRowCount(0);
					JOptionPane.showMessageDialog(null,"Data Deleted");
					pst.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}*/
				DefaultTableModel df=(DefaultTableModel)table.getModel();
				int s=table.getSelectedRow();
				int id=Integer.parseInt(df.getValueAt(s,0).toString());
				if(table.getSelectedRowCount()==1)
				{
					df.removeRow(table.getSelectedRow());
					
					try {
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
						PreparedStatement pst = (PreparedStatement) con.prepareStatement("update employee set firstname=?,surname=?,gender=?,email=?,CNIC=?,DOB=?,age=?,address=?,phone=?,status=? where id=?");
						 
						pst.setString(1,firstname);
						pst.setString(2,surname);
						pst.setString(3,gender);
						pst.setString(4,email);
						pst.setString(5,CNIC);
						pst.setString(6,DOB);
						pst.setString(7,age);
						pst.setString(8,address);
						pst.setString(9,phone);
						pst.setString(10,"0");
						pst.setInt(11,id);
				        pst.executeUpdate();
				        
				        int a;
						pst = (PreparedStatement) con.prepareStatement("select * from employee");
						ResultSet rs =pst.executeQuery();
						ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();
						a=rd.getColumnCount();
						DefaultTableModel df1=(DefaultTableModel)table.getModel();
						df1.setRowCount(0);
						while(rs.next())
						{
							java.util.Vector<String> v2= new java.util.Vector<String>();
							for(int i=1;i<=a;i++)
							{
								v2.add(rs.getString("id"));
								v2.add(rs.getString("firstname"));
								v2.add(rs.getString("surname"));
								v2.add(rs.getString("gender"));
								v2.add(rs.getString("email"));
								v2.add(rs.getString("CNIC"));
								v2.add(rs.getString("DOB"));
								v2.add(rs.getString("age"));
								v2.add(rs.getString("address"));
								v2.add(rs.getString("phone"));
								v2.add(rs.getString("status"));
							}
							df1.addRow(v2);
						}
						view_employee();
				        
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else
				{
					if(table.getSelectedRowCount()==0) 
					{
						JOptionPane.showMessageDialog(Jpane,"Table is Empty");
					}
					else
					{
						JOptionPane.showMessageDialog(Jpane,"Please select single row for delete");
					}
						
				}
				txtage.setEnabled(false);
				txtfirstname.setEnabled(false);
				txtsurname.setEnabled(false);
				txtaddress.setEnabled(false);
				txtphone.setEnabled(false);
				txtemail.setEnabled(false);
				txtCNIC.setEnabled(false);
				txtage.setEnabled(false);
				comboBox.setEnabled(false);
				dateChooser.setEnabled(false);
				
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndelete.setBounds(203, 455, 89, 23);
		Jpane.add(btndelete);
		
		btnupdate = new JButton("Update");
		btnupdate.setEnabled(false);
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setBackground(Color.BLUE);
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel df=(DefaultTableModel)table.getModel();
				int s=table.getSelectedRow();
				int id=Integer.parseInt(df.getValueAt(s,0).toString());
				try {
				
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
				pst = (PreparedStatement) con.prepareStatement("update employee set firstname=?,surname=?,gender=?,email=?,CNIC=?,DOB=?,age=?,address=?,phone=?,status=? where id=?");
				
				pst.setString(1,firstname);
				pst.setString(2,surname);
				pst.setString(3,gender);
				pst.setString(4,email);
				pst.setString(5,CNIC);
				pst.setString(6,DOB);
				pst.setString(7,age);
				pst.setString(8,address);
				pst.setString(9,phone);
				pst.setString(10,"1");
				pst.setInt(11,id);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(Jpane, "List updated");
				txtage.setEnabled(false);
				txtfirstname.setEnabled(false);
				txtsurname.setEnabled(false);
				txtaddress.setEnabled(false);
				txtphone.setEnabled(false);
				txtemail.setEnabled(false);
				txtCNIC.setEnabled(false);
				txtage.setEnabled(false);
				comboBox.setEnabled(false);
				dateChooser.setEnabled(false);
				/*txtfirstname.setText("");
				txtsurname.setText("");
				txtemail.setText("");
				txtCNIC.setText("");
				//txtDOB.setText("");
				txtage.setText("");
				txtaddress.setText("");
				txtphone.setText("");
				//txtgender.setText("");*/
				
				int a;
				pst = (PreparedStatement) con.prepareStatement("select * from employee");
				ResultSet rs =pst.executeQuery();
				ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();
				a=rd.getColumnCount();
				DefaultTableModel df1=(DefaultTableModel)table.getModel();
				df1.setRowCount(0);
				while(rs.next())
				{
					java.util.Vector<String> v2= new java.util.Vector<String>();
					for(int i=1;i<=a;i++)
					{
						v2.add(rs.getString("id"));
						v2.add(rs.getString("firstname"));
						v2.add(rs.getString("surname"));
						v2.add(rs.getString("gender"));
						v2.add(rs.getString("email"));
						v2.add(rs.getString("CNIC"));
						v2.add(rs.getString("DOB"));
						v2.add(rs.getString("age"));
						v2.add(rs.getString("address"));
						v2.add(rs.getString("phone"));
						v2.add(rs.getString("status"));
					}
					df1.addRow(v2);
				}
				}
				
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnupdate.setBounds(308, 455, 89, 23);
		Jpane.add(btnupdate);
		
		btnprint = new JButton("Print");
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
		btnprint.setBounds(407, 455, 89, 23);
		Jpane.add(btnprint);
		
		btnNewButton_4 = new JButton("Home");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.BLUE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				clsInfo a=new clsInfo();
				a.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(1002, 464, 89, 23);
		Jpane.add(btnNewButton_4);
		
		lblNewLabel = new JLabel("Employee Database Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(265, 11, 556, 53);
		Jpane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 0, 1081, 85);
		Jpane.add(panel);
		
		
		txtsearch = new JTextField();
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel Table = (DefaultTableModel)table.getModel();
		   		String Search = txtsearch.getText();
		   		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Table);
		   		table.setRowSorter(tr);
		   		tr.setRowFilter(RowFilter.regexFilter(Search));
				/*try {
				int a;
				PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("select * from employee where firstname=?");
				pst1.setString(1,txtsearch.getText());
				ResultSet rs =pst1.executeQuery();
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();
				a=rd.getColumnCount();
				DefaultTableModel df=(DefaultTableModel)table.getModel();
				df.setRowCount(0);
				while(rs.next())
				{
					java.util.Vector<String> v2= new java.util.Vector<String>();
					for(int i=1;i<=a;i++)
					{
						v2.add(rs.getString("id"));
						v2.add(rs.getString("firstname"));
						v2.add(rs.getString("surname"));
						v2.add(rs.getString("gender"));
						v2.add(rs.getString("email"));
						v2.add(rs.getString("CNIC"));
						v2.add(rs.getString("DOB"));
						v2.add(rs.getString("age"));
						v2.add(rs.getString("address"));
						v2.add(rs.getString("phone"));
					}
					df.addRow(v2);
				}
				
			}		
			
			catch(Exception e2)
			{
				e2.printStackTrace();
			}*/
			}
		});
		txtsearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtsearch.setBounds(646, 98, 271, 20);
		Jpane.add(txtsearch);
		txtsearch.setColumns(10);
		
		JLabel lblsearch = new JLabel("");
		Image img10= new ImageIcon(this.getClass().getResource("/search.JPG")).getImage();
		lblsearch.setIcon(new ImageIcon(img10));
		lblsearch.setBounds(916, 96, 34, 24);
		Jpane.add(lblsearch);
		
		JButton btnclear = new JButton("Reset");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnclear.setForeground(Color.WHITE);
		btnclear.setBackground(Color.BLUE);
		btnclear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnclear.setBounds(605, 455, 89, 23);
		Jpane.add(btnclear);
		
		view_employee();
		/*try {
			 pst = (PreparedStatement) con.prepareStatement("select max(id) from employee");				
	         ResultSet rs =  pst.executeQuery();
	            if(rs.next())
	            {
				int id = rs.getInt("max(id)");
				id = id+1;
				txtid.setText(""+ id);
	            con.close();
	            }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
		
		
	}
	public void view_employee() {
		int a;
		PreparedStatement pst1;
		try {
		pst1 = (PreparedStatement) con.prepareStatement("select * from employee");
		ResultSet rs =pst1.executeQuery();
		ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();
		a=rd.getColumnCount();
		DefaultTableModel df=(DefaultTableModel)table.getModel();
		df.setRowCount(0);
		while(rs.next())
		{
			java.util.Vector<String> v2= new java.util.Vector<String>();
			for(int i=1;i<=a;i++)
			{
				v2.add(rs.getString("id"));
				v2.add(rs.getString("firstname"));
				v2.add(rs.getString("surname"));
				v2.add(rs.getString("gender"));
				v2.add(rs.getString("email"));
				v2.add(rs.getString("CNIC"));
				v2.add(rs.getString("DOB"));
				v2.add(rs.getString("age"));
				v2.add(rs.getString("address"));
				v2.add(rs.getString("phone"));
				v2.add(rs.getString("status"));
			}
			df.addRow(v2);}}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

