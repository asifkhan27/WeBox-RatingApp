package com.asif.ui;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.asif.codes.FileManagement;
import com.asif.codes.GetImageLoc;
import com.asif.codes.addFileToAnyLocation;
import com.asif.database.interactionJDBC;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class editprofile {

private JFrame epjw;

private JTextPane epName;
private JTextPane epName1;
private JTextPane epEmpid;
private JTextPane epEmpid1;
private JTextPane epDeptid;
private JTextPane epDeptid1;
private JTextPane epPhno;
private JTextPane epPhno1;
private JTextPane epSite;
private JTextPane epSite1;
private JTextPane epAddress;
private JTextPane epAddress1;
private JTextPane epDescription;
private JTextPane epDescription1;

private JTextPane epdate;
private JComboBox<String> epDate;
private JComboBox<String> epMonth;
private JComboBox<String> epYear;

private JRadioButton epMale;
private JRadioButton epFemale;
private JRadioButton epOther;

private JButton epSubmit;
private JButton epCancel;
private JButton epProfilePic;

String ProfileLoc;
String p=null;

private final ButtonGroup buttonGroup = new ButtonGroup();

public editprofile(String email,String[] values) throws IOException
	{
		initComponents(email,values);
	}

	
	
private void initComponents(String email,String[] values) throws IOException {
	ProfileLoc=values[10]; 
/////////////////////////////////////////////main jwindow//////////////////////////////////////////////////////////////////////////////////////	
	epjw=new JFrame("Edit Profile");
	epjw.getContentPane().setBackground(Color.WHITE);
	epjw.setSize(510,580);
	epjw.setLocationRelativeTo(null);
	epjw.getContentPane().setLayout(null);
	
////////////////////////////////////////////text fields/////////////////////////////////////////////////////////////////////////////////////	
	
	epName = new JTextPane();
	epName.setOpaque(false);
	epName.setEditable(false);
	epName.setText("Name :");
	epName.setBounds(209, 28, 58, 19);
	epjw.getContentPane().add(epName);
	
	epName1 = new JTextPane();
	epName1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epName1.setBounds(277, 28, 186, 19);
	epName1.setText(values[1]);
	epjw.getContentPane().add(epName1);

	
	epEmpid = new JTextPane();
	epEmpid.setOpaque(false);
	epEmpid.setEditable(false);
	epEmpid.setText("Emp Id :");
	epEmpid.setBounds(209, 71, 58, 19);
	epjw.getContentPane().add(epEmpid);
	
	epEmpid1 = new JTextPane();
	epEmpid1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epEmpid1.setBounds(277, 71, 186, 19);
	epEmpid1.setText(values[2]);
	epjw.getContentPane().add(epEmpid1);
	
	epDeptid = new JTextPane();
	epDeptid.setOpaque(false);
	epDeptid.setEditable(false);
	epDeptid.setText("Dept Id :");
	epDeptid.setBounds(209, 113, 58, 19);
	epjw.getContentPane().add(epDeptid);
	
	epDeptid1 = new JTextPane();
	epDeptid1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epDeptid1.setBounds(277, 113, 186, 19);
	epDeptid1.setText(values[3]);
	epjw.getContentPane().add(epDeptid1);
	
	epPhno = new JTextPane();
	epPhno.setEditable(false);
	epPhno.setOpaque(false);
	epPhno.setText("Ph.no :");
	epPhno.setBounds(10, 197, 58, 19);
	epjw.getContentPane().add(epPhno);
	
	epPhno1 = new JTextPane();
	epPhno1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epPhno1.setBounds(84, 197, 223, 19);
	epPhno1.setText(values[4]);
	epjw.getContentPane().add(epPhno1);
	
	epSite = new JTextPane();
	epSite.setEditable(false);
	epSite.setOpaque(false);
	epSite.setText("Site :");
	epSite.setBounds(10, 236, 64, 19);
	epjw.getContentPane().add(epSite);
	
	epSite1 = new JTextPane();
	epSite1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epSite1.setBounds(84, 236, 223, 19);
	epSite1.setText(values[5]);
	epjw.getContentPane().add(epSite1);
	
	epAddress = new JTextPane();
	epAddress.setEditable(false);
	epAddress.setText("Address :");
	epAddress.setBounds(10, 271, 64, 19);
	epjw.getContentPane().add(epAddress);
	
	epAddress1 = new JTextPane();
	epAddress1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epAddress1.setBounds(84, 271, 223, 62);
	epAddress1.setText(values[6]);
	epjw.getContentPane().add(epAddress1);
	
	epDescription = new JTextPane();
	epDescription.setOpaque(false);
	epDescription.setEditable(false);
	epDescription.setText("Description :");
	epDescription.setBounds(10, 348, 70, 19);
	epjw.getContentPane().add(epDescription);
	
	epDescription1 = new JTextPane();
	epDescription1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	epDescription1.setBounds(84, 355, 379, 152);
	epDescription1.setText(values[9]);
	epjw.getContentPane().add(epDescription1);
	
//////////////////////////////////////////////////////Combobox radiobutton////////////////////////////////////////////////////////////////////////////////	
	
////////////date of Birth///////////////
	
	epdate= new JTextPane();
	epdate.setText("Date of Birth :");
	epdate.setBounds(351, 167, 90, 19);
	epjw.getContentPane().add(epdate);
	
	String [] dt= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String [] mt= {"January","February","March","April","May","June","July","August","September","October","November","December"};
	String [] yr= {"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001",};
	
	
	
	
	
	epDate = new JComboBox(dt);
	epDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
	epDate.setBounds(317, 196,36, 21);
	
	epjw.getContentPane().add(epDate);
	
	epMonth = new JComboBox(mt);
	epMonth.setFont(new Font("Tahoma", Font.PLAIN, 10));
	epMonth.setBounds(361, 196,70, 21);
	
	epjw.getContentPane().add(epMonth);
	
	epYear= new JComboBox(yr);
	epYear.setFont(new Font("Tahoma", Font.PLAIN, 10));
	epYear.setBounds(440, 196,47, 21);
	
	epjw.getContentPane().add(epYear);
	
	if(values[7]!=null)
	{
		String[] cval=values[7].split(" ");
		epDate.setSelectedItem(cval[0]);
		epMonth.setSelectedItem(cval[1]);
		epYear.setSelectedItem(cval[2]);
	}

///////////Gender/////////////////////////
	
	epMale= new JRadioButton("Male");
	epMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
	buttonGroup.add(epMale);
	epMale.setBounds(373, 260, 68, 21);
	epjw.getContentPane().add(epMale);
	
	epFemale = new JRadioButton("Female");
	epFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
	buttonGroup.add(epFemale);
	epFemale.setBounds(373, 283, 68, 21);
	epjw.getContentPane().add(epFemale);
	
	epOther= new JRadioButton("Other");
	epOther.setFont(new Font("Tahoma", Font.PLAIN, 12));
	buttonGroup.add(epOther);
	epOther.setBounds(373, 306, 68, 21);
	epjw.getContentPane().add(epOther);
	
	if(values[8]!=null) {
	if(values[8].equals("Male")) epMale.setSelected(true);
	else if(values[8].equals("Female")) epFemale.setSelected(true);
	else if(values[8].equals("Other")) epOther.setSelected(true);}
	
/////////////////////////////////////////////////////buttons////////////////////////////////////////////////////////////////////////////////////
	
	epProfilePic = new JButton(new ImageIcon(ImageIO.read(new File(values[10]))
	        .getScaledInstance(123,132, Image.SCALE_AREA_AVERAGING)));
	//epProfilePic.setIcon(new ImageIcon(values[10]));
	
	epProfilePic.setFocusable(false);
	
	epProfilePic.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			p=new GetImageLoc().getpath();
			
			if((p.equals("")))
			{
				epProfilePic.setIcon(new ImageIcon(values[10]));
			}
			else
			{	
				File FProfileLoc=new File(new FileManagement().profilePicLocation,email+".jpg");
				ProfileLoc=FProfileLoc.toString();
				epProfilePic.setIcon(new ImageIcon(p));
			}
			}
	});
	epProfilePic.setFont(new Font("Verdana", Font.PLAIN, 20));
	epProfilePic.setBounds(28, 28,123, 132);
	epjw.getContentPane().add(epProfilePic);

/////////////Submit button
	
	epSubmit = new JButton("Submit");
	epSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			String name	  	   =epName1.getText();
			String Empid	   =epEmpid1.getText();
			String Deptid	   =epDeptid1.getText();
			String Phno		   =epPhno1.getText();
			String Site 	   =epSite1.getText();
			String Address     =epAddress1.getText();
			String Description =epDescription1.getText();
			
			String Gender="";
			if(epMale.isSelected()) Gender=epMale.getText();
			else if(epFemale.isSelected()) Gender=epFemale.getText();
			else if(epOther.isSelected()) Gender=epOther.getText();
			

			String Date=epDate.getSelectedItem().toString()+" "+epMonth.getSelectedItem().toString()+" "+epYear.getSelectedItem().toString();
			
			
			if(p!=null) {
			try {
				new addFileToAnyLocation().addFile(p,ProfileLoc);
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}}
			try {
				new interactionJDBC().update(email, name, Empid, Deptid, Phno, Site, Address,Date,Gender,Description, ProfileLoc);
				homepage.hpjframe.dispose();
				epjw.dispose();
				new homepage(email);
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}	
	});
	epSubmit.setBounds(415, 519, 75, 21);
	epjw.getContentPane().add(epSubmit);

/////////////Cancel button
	
	epCancel = new JButton("Cancel");
	epCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			epjw.dispose();
		}
	});
	epCancel.setBounds(318, 519, 75, 21);
	epjw.getContentPane().add(epCancel);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	epjw.setVisible(true);
}

}

