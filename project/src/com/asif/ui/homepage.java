package com.asif.ui;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import com.asif.codes.UpdateRating;
import com.asif.database.interactionJDBC;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
public class homepage 
{
//////////////////////////////////////////////////////////////////initComponents/////////////////////////////////////////////////////////////////////////////////////////////////
	static JFrame hpjframe;
	private JLabel hpjlabel;
	private JLabel hpjllabel1;
	private String[] values;
	private JButton btnNewButton;
//////////////////////////////////////////////////////////////////////profile////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel hppjpanel;
	private JLabel hpppicture;
	private JTextPane hppname;
	private JTextPane hppemail;
	private JTextPane hppDescription;
	private JTextPane hppPhno1;
	private JTextPane hppEmail1;
	private JTextPane hppSite;
	private JTextPane hppSite1;
	private JTextPane hppAddress1;
	private JTextPane hppBirthday1;
	private JTextPane hppGender1;
	private JTextPane hppPhno;
	private JTextPane hppEmail;
	private JTextPane hppAddress;
	private JTextPane hppBirthday;
	private JTextPane hppContactInformation;
	private JTextPane hppGender;
	private JTextPane hppBasicInformation;
	private JTextPane hppEmpid;
	private JTextPane hppDeptid;
	private JTextPane hppEmpid1;
	private JTextPane hppDeptid1;
	private JTextPane hppPersonalOverview;
	///////////////////////////////////////////////////////////////////////feed//////////////////////////////////////////////////////////////////////////////////////////////////////
	private JPanel hpfjpanel;
	private JScrollPane hpfJscrollpane;
	private JLabel hpfjLabel;
	private JLabel hpfPic;
	private JTextPane hpfName;
	private JTextPane hpfEmail;
	private JTextPane hpfGender;
	private JTextPane hpfAge;
	private JTextPane hpfEmpId;
	private JTextPane hpfEmpId1;
	private JTextPane hpfDeptId;
	private JTextPane hpfDeptId1;
	private JTextPane hpfPhno;
	private JTextPane hpfPhno1;
	private JTextPane hpfSite;
	private JTextPane hpfSite1;
	private JTextPane hpfOverview;
	private JTextPane hpfOverview1;
	private JRadioButton [][] Rbutton;
	private String [] Useremails;
	



	public homepage(String email) throws ClassNotFoundException, SQLException
	{
		
		values=new interactionJDBC().getsvalue(email);
		initComponents(email);
		
	}

	
	
private void initComponents(String email){
	try {
	/////////////////////////////////////////////////////////////////
	ResultSet result=new interactionJDBC().SendQuery("select*from userdetails");
	ResultSet result1=new interactionJDBC().SendQuery("select count(*) as rowcount from userdetails");
	result1.next();
	int size = result1.getInt("rowcount");
	Rbutton=new JRadioButton[size-1][5];
	Useremails=new String[size-1];
////////////////////////////////////////////////////////////////
	
//main jframe
		
		hpjframe = new JFrame("Webox_Homepage");
		hpjframe.setType(Type.POPUP);
		hpjframe.getContentPane().setBackground(new Color(47, 79, 79));
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		hpjframe.setSize(800,1000);// width=1536,Height=864
		hpjframe.setLocationRelativeTo(null);
		hpjframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		hpjframe.getContentPane().setLayout(null);
		
		
//bottom jlabel
		
	
		URL BottomImage=homepage.class.getResource("/images/Bottom Image.jpg");
				hpjlabel= new JLabel(new ImageIcon(ImageIO.read(new File(BottomImage.toURI()))
				        .getScaledInstance(588,250, Image.SCALE_SMOOTH)));
			
		 
		hpjlabel.setOpaque(true);
		hpjlabel.setBackground(new Color(0, 128, 0));
		hpjlabel.setBounds(686, 519, 588, 250);
		hpjframe.getContentPane().add(hpjlabel);
		
//side jlabel
		URL SideImage=homepage.class.getResource("/images/Side Image.png");
			hpjllabel1 = new JLabel(new ImageIcon(ImageIO.read(new File(SideImage.toURI()))
			        .getScaledInstance(228,759, Image.SCALE_SMOOTH)));
	
		
		
		hpjllabel1.setBackground(new Color(0, 128, 128));
		hpjllabel1.setOpaque(true);
		hpjllabel1.setBounds(1284, 10, 228, 759);
		hpjframe.getContentPane().add(hpjllabel1);
			
		
//Question mark
		JTextPane txtpnYourPasswordMust = new JTextPane();
		JTextPane txtpnO = new JTextPane();
		txtpnO.setForeground(new Color(255, 255, 255));
		txtpnO.setEditable(false);
		txtpnO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtpnYourPasswordMust.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				txtpnYourPasswordMust.setForeground(Color.RED);
				txtpnYourPasswordMust.setBackground(new Color(250, 240, 230));
				txtpnYourPasswordMust.setOpaque(true);
				txtpnYourPasswordMust.setText("* In Order to Submit the Response Click Update Button.");

				
			}
			public void mouseExited(MouseEvent e) {
				txtpnYourPasswordMust.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
				txtpnYourPasswordMust.setText("");
				txtpnYourPasswordMust.setOpaque(false);
			}
			
		});
		
		txtpnO.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtpnO.setOpaque(false);
		txtpnO.setFont(new Font("Arial", Font.PLAIN, 25));
		txtpnO.setText("O");
		txtpnO.setBounds(647,2, 26, 30);
		hpjframe.getContentPane().add(txtpnO);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(255, 255, 255));
		textPane.setEditable(false);
		textPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textPane.setOpaque(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setText(" \u2753");
		textPane.setBounds(647,9, 26, 25);
		hpjframe.getContentPane().add(textPane);
		
		
		txtpnYourPasswordMust.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnYourPasswordMust.setBounds(667,32,105,50);
		txtpnYourPasswordMust.setOpaque(false);
		txtpnYourPasswordMust.setEditable(false);
		hpjframe.getContentPane().add(txtpnYourPasswordMust);
		
//////////////////////////////////////////////////profile/////////////////////////////////////////////////////////////////////////////////////////	

		hppjpanel= new JLabel(new ImageIcon(homepage.class.getResource("/images/LpI.jpg")));
		hppjpanel.setBackground(new Color(255, 255, 255));
		hppjpanel.setBounds(686, 10, 588, 499);
		hpjframe.getContentPane().add(hppjpanel);
		//hppjpanel.setLayout(null);
		
		
		
		hpppicture = new JLabel(new ImageIcon(ImageIO.read(new File(values[10]))
		        .getScaledInstance(132,132, Image.SCALE_SMOOTH)));
		//hpppicture.setIcon(new ImageIcon(values[10]));
		hpppicture.setHorizontalAlignment(SwingConstants.CENTER);
		hpppicture.setOpaque(true);
		hpppicture.setBackground(new Color(139, 0, 0));
		hpppicture.setBounds(23, 25, 132, 132);
		hppjpanel.add(hpppicture);
		
		hppname = new JTextPane();
		hppname.setEditable(false);
		hppname.setOpaque(false);
		hppname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hppname.setText(values[1]);
		hppname.setBounds(195, 40, 364, 31);
		hppjpanel.add(hppname);
		
		hppemail = new JTextPane();
		hppemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		hppemail.setText(values[0]);
		hppemail.setOpaque(false);
		hppemail.setEditable(false);
		hppemail.setBackground(Color.WHITE);
		hppemail.setBounds(195, 70, 364, 22);
		hppjpanel.add(hppemail);
		
		hppEmpid = new JTextPane();
		hppEmpid.setText("Emp.Id :");
		hppEmpid.setOpaque(false);
		hppEmpid.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppEmpid.setEditable(false);
		hppEmpid.setBounds(195, 102, 54, 19);
		hppjpanel.add(hppEmpid);
		
		hppEmpid1 = new JTextPane();
		hppEmpid1.setEditable(false);
		hppEmpid1.setVerifyInputWhenFocusTarget(false);
		hppEmpid1.setText(values[2]);
		hppEmpid1.setOpaque(false);
		hppEmpid1.setForeground(Color.BLUE);
		hppEmpid1.setFont(new Font("Tahoma", Font.BOLD, 10));
		hppEmpid1.setBounds(259, 102, 164, 19);
		hppjpanel.add(hppEmpid1);
		
		hppDeptid = new JTextPane();
		hppDeptid.setText("Dept.Id :");
		hppDeptid.setOpaque(false);
		hppDeptid.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppDeptid.setEditable(false);
		hppDeptid.setBounds(195, 131, 54, 19);
		hppjpanel.add(hppDeptid);
		
		hppDeptid1 = new JTextPane();
		hppDeptid1.setEditable(false);
		hppDeptid1.setVerifyInputWhenFocusTarget(false);
		hppDeptid1.setText(values[3]);
		hppDeptid1.setOpaque(false);
		hppDeptid1.setForeground(Color.BLUE);
		hppDeptid1.setFont(new Font("Tahoma", Font.BOLD, 10));
		hppDeptid1.setBounds(259, 131, 164, 19);
		hppjpanel.add(hppDeptid1);
		
		hppContactInformation = new JTextPane();
		hppContactInformation.setOpaque(false);
		hppContactInformation.setText("Contact Information");
		hppContactInformation.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppContactInformation.setEditable(false);
		hppContactInformation.setBounds(23, 181, 114, 19);
		hppjpanel.add(hppContactInformation);
		
		hppPhno = new JTextPane();
		hppPhno.setEditable(false);
		hppPhno.setOpaque(false);
		hppPhno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppPhno.setText("Ph.no :");
		hppPhno.setBounds(10, 225, 45, 19);
		hppjpanel.add(hppPhno);
		
		hppPhno1 = new JTextPane();
		hppPhno1.setEditable(false);
		hppPhno1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppPhno1.setOpaque(false);
		hppPhno1.setForeground(new Color(0, 0, 255));
		hppPhno1.setText(values[4]);
		hppPhno1.setBounds(65, 225, 164, 19);
		hppjpanel.add(hppPhno1);
		
		hppEmail = new JTextPane();
		hppEmail.setText("E-mail :");
		hppEmail.setOpaque(false);
		hppEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppEmail.setEditable(false);
		hppEmail.setBounds(10, 248, 45, 19);
		hppjpanel.add(hppEmail);
		
		hppEmail1 = new JTextPane();
		hppEmail1.setForeground(Color.BLUE);
		hppEmail1.setEditable(false);
		hppEmail1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppEmail1.setOpaque(false);
		hppEmail1.setText(values[0]);
		hppEmail1.setBounds(65, 248, 164, 19);
		hppjpanel.add(hppEmail1);
		
		hppSite = new JTextPane();
		hppSite.setText("Site :");
		hppSite.setOpaque(false);
		hppSite.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppSite.setEditable(false);
		hppSite.setBounds(10, 277, 45, 19);
		hppjpanel.add(hppSite);
		
		hppSite1 = new JTextPane();
		hppSite1.setForeground(Color.BLUE);
		hppSite1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppSite1.setEditable(false);
		hppSite1.setOpaque(false);
		hppSite1.setText(values[5]);
		hppSite1.setBounds(65, 276, 164, 19);
		hppjpanel.add(hppSite1);
		
		hppAddress = new JTextPane();
		hppAddress.setText("Address :");
		hppAddress.setOpaque(false);
		hppAddress.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppAddress.setEditable(false);
		hppAddress.setBounds(10, 308, 54, 19);
		hppjpanel.add(hppAddress);
		
		hppAddress1 = new JTextPane();
		hppAddress1.setForeground(Color.BLACK);
		hppAddress1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppAddress1.setEditable(false);
		hppAddress1.setOpaque(false);
		hppAddress1.setText(values[6]);
		hppAddress1.setBounds(75, 308, 154, 51);
		hppjpanel.add(hppAddress1);
		
		hppBasicInformation = new JTextPane();
		hppBasicInformation.setEditable(false);
		hppBasicInformation.setOpaque(false);
		hppBasicInformation.setText("Basic Information");
		hppBasicInformation.setBounds(23, 367, 114, 19);
		hppjpanel.add(hppBasicInformation);
		
		hppBirthday = new JTextPane();
		hppBirthday.setText("Birthday :");
		hppBirthday.setOpaque(false);
		hppBirthday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppBirthday.setEditable(false);
		hppBirthday.setBounds(10, 401, 54, 19);
		hppjpanel.add(hppBirthday);
		
		hppBirthday1 = new JTextPane();
		hppBirthday1.setForeground(Color.BLUE);
		hppBirthday1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppBirthday1.setEditable(false);
		hppBirthday1.setOpaque(false);
		hppBirthday1.setText(values[7]);
		hppBirthday1.setBounds(75, 401, 148, 19);
		hppjpanel.add(hppBirthday1);
		
		hppGender = new JTextPane();
		hppGender.setText("Gender :");
		hppGender.setOpaque(false);
		hppGender.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppGender.setEditable(false);
		hppGender.setBounds(10, 447, 54, 19);
		hppjpanel.add(hppGender);
		
		hppGender1 = new JTextPane();
		hppGender1.setForeground(Color.BLUE);
		hppGender1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppGender1.setEditable(false);
		hppGender1.setOpaque(false);
		hppGender1.setText(values[8]);
		hppGender1.setBounds(75, 447, 148, 19);
		hppjpanel.add(hppGender1);
		
		hppPersonalOverview = new JTextPane();
		hppPersonalOverview.setOpaque(false);
		hppPersonalOverview.setText("Personal Overview");
		hppPersonalOverview.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hppPersonalOverview.setEditable(false);
		hppPersonalOverview.setBounds(239, 181, 114, 19);
		hppjpanel.add(hppPersonalOverview);
		
		hppDescription = new JTextPane();
		hppDescription.setForeground(new Color(255, 255, 255));
		hppDescription.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		hppDescription.setEditable(false);
		hppDescription.setBackground(new Color(30, 144, 255));
		hppDescription.setText(values[9]);
		hppDescription.setBounds(239, 205, 320, 261);
		hppjpanel.add(hppDescription);
		
								
	//menubar//////////
		
	JMenuBar menuBar = new JMenuBar();
	menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	hpjframe.setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("Menu");
	mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	menuBar.add(mnNewMenu);
	
	JMenuItem mntmNewMenuItem = new JMenuItem("             Edit Profile");
	mntmNewMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	mntmNewMenuItem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLUE));
	mntmNewMenuItem.setPreferredSize(new Dimension(150,20));
	mntmNewMenuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				new editprofile(values[0], values);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	mnNewMenu.add(mntmNewMenuItem);
	
	JMenuItem mntmNewMenuItem1 = new JMenuItem("                Logout");
	mntmNewMenuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	mntmNewMenuItem1.setPreferredSize(new Dimension(150,20));
	mntmNewMenuItem1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			hpjframe.dispose();
			new loginpage();
		}
	});
	mnNewMenu.add(mntmNewMenuItem1);
	
	
	
	
///////////////////////////////////////////////////////////////////feed List//////////////////////////////////////////////////////////////////////////////	
	
	hpfjpanel = new JPanel();
	hpfjpanel.setLayout(new BoxLayout(hpfjpanel, BoxLayout.Y_AXIS));
	
	hpfJscrollpane=new JScrollPane(hpfjpanel);
	hpfJscrollpane.setBounds(10, 30, 637, 750);
	hpfJscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	//hpfJscrollpane.setViewportView();
	

//////////Generate list///////////////
	
	int j=0;
	while(result.next()) {
		if(!result.getString(1).equalsIgnoreCase(values[0])) {
		
	hpfjLabel = new JLabel();
	hpfjLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	hpfjLabel.setBackground(Color.WHITE);
	hpfjLabel.setOpaque(true);
	hpfjLabel.setMaximumSize(new Dimension(627, 323));
	hpfjLabel.setPreferredSize(new Dimension(627, 323));
	hpfjpanel.add(hpfjLabel);

	
	hpfPic = new JLabel(new ImageIcon(ImageIO.read(new File(result.getString(11)))
	        .getScaledInstance(132,132, Image.SCALE_SMOOTH)));
	hpfPic.setBackground(Color.ORANGE);
	hpfPic.setOpaque(true);
	hpfPic.setBounds(10, 10, 120, 126);
	hpfjLabel.add(hpfPic);
	

	hpfName = new JTextPane();
	hpfName.setText(result.getString(2));
	hpfName.setOpaque(false);
	hpfName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	hpfName.setEditable(false);
	hpfName.setBounds(140, 10, 364, 31);
	hpfjLabel.add(hpfName);
	
	hpfEmail = new JTextPane();
	hpfEmail.setText(result.getString(1));
	hpfEmail.setOpaque(false);
	hpfEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
	hpfEmail.setEditable(false);
	hpfEmail.setBackground(Color.WHITE);
	hpfEmail.setBounds(140,40, 364, 22);
	hpfjLabel.add(hpfEmail);
	
	hpfGender = new JTextPane();
	hpfGender.setForeground(Color.GREEN);
	hpfGender.setText(result.getString(9));
	hpfGender.setOpaque(false);
	hpfGender.setFont(new Font("Tahoma", Font.BOLD, 10));
	hpfGender.setEditable(false);
	hpfGender.setBounds(140,70,40,19);
	hpfjLabel.add(hpfGender);
	
	if(result.getString(8)!=null){
	String [] temp=result.getString(8).split(" ");
	
	hpfAge = new JTextPane();
	hpfAge.setForeground(Color.GREEN);
	hpfAge.setText(String.valueOf(2020-Integer.parseInt(temp[2])));
	hpfAge.setOpaque(false);
	hpfAge.setFont(new Font("Tahoma", Font.BOLD, 10));
	hpfAge.setEditable(false);
	hpfAge.setBounds(180,70,50,19);
	hpfjLabel.add(hpfAge);
	}
	
	hpfEmpId = new JTextPane();
	hpfEmpId.setText("Emp.Id :");
	hpfEmpId.setOpaque(false);
	hpfEmpId.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfEmpId.setEditable(false);
	hpfEmpId.setBounds(153, 91, 54, 19);
	hpfjLabel.add(hpfEmpId);
	
	hpfEmpId1 = new JTextPane();
	hpfEmpId1.setText(result.getString(3));
	hpfEmpId1.setOpaque(false);
	hpfEmpId1.setForeground(Color.BLUE);
	hpfEmpId1.setFont(new Font("Tahoma", Font.BOLD, 10));
	hpfEmpId1.setEditable(false);
	hpfEmpId1.setBounds(207, 91, 109, 19);
	hpfjLabel.add(hpfEmpId1);
	
	hpfDeptId = new JTextPane();
	hpfDeptId.setText("Dept.Id :");
	hpfDeptId.setOpaque(false);
	hpfDeptId.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfDeptId.setEditable(false);
	hpfDeptId.setBounds(153, 113, 54, 19);
	hpfjLabel.add(hpfDeptId);
	
	hpfDeptId1 = new JTextPane();
	hpfDeptId1.setText(result.getString(4));
	hpfDeptId1.setOpaque(false);
	hpfDeptId1.setForeground(Color.BLUE);
	hpfDeptId1.setFont(new Font("Tahoma", Font.BOLD, 10));
	hpfDeptId1.setEditable(false);
	hpfDeptId1.setBounds(207, 113, 109, 19);
	hpfjLabel.add(hpfDeptId1);
	
	
	hpfPhno = new JTextPane();
	hpfPhno.setText("Ph.no :");
	hpfPhno.setOpaque(false);
	hpfPhno.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfPhno.setEditable(false);
	hpfPhno.setBounds(10, 178, 45, 19);
	hpfjLabel.add(hpfPhno);
	
	hpfPhno1 = new JTextPane();
	hpfPhno1.setText(result.getString(5));
	hpfPhno1.setOpaque(false);
	hpfPhno1.setForeground(Color.BLUE);
	hpfPhno1.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfPhno1.setEditable(false);
	hpfPhno1.setBounds(61, 178, 109, 19);
	hpfjLabel.add(hpfPhno1);
	
	hpfSite = new JTextPane();
	hpfSite.setText("Site :");
	hpfSite.setOpaque(false);
	hpfSite.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfSite.setEditable(false);
	hpfSite.setBounds(10, 208, 45, 19);
	hpfjLabel.add(hpfSite);
	
	hpfSite1 = new JTextPane();
	hpfSite1.setForeground(Color.BLUE);
	hpfSite1.setText(result.getString(6));
	hpfSite1.setOpaque(false);
	hpfSite1.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfSite1.setEditable(false);
	hpfSite1.setBounds(61, 208, 109, 19);
	hpfjLabel.add(hpfSite1);
	
	hpfOverview= new JTextPane();
	hpfOverview.setText("Personal Overview");
	hpfOverview.setOpaque(false);
	hpfOverview.setFont(new Font("Tahoma", Font.PLAIN, 10));
	hpfOverview.setEditable(false);
	hpfOverview.setBounds(181, 143, 114, 19);
	hpfjLabel.add(hpfOverview);
	
	hpfOverview1 = new JTextPane();
	hpfOverview1.setText(result.getString(10));
	hpfOverview1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	hpfOverview1.setEditable(false);
	hpfOverview1.setBackground(Color.WHITE);
	hpfOverview1.setBounds(184, 165, 433, 153);
	hpfjLabel.add(hpfOverview1);

//////////Generate Rating buttons///////////////
	Useremails[j]=result.getString(1);
	
	Rbutton[j][0] = new JRadioButton("w");
	Rbutton[j][0].setBounds(480, 123,20, 20);
	hpfjLabel.add(Rbutton[j][0]);


	Rbutton[j][1] = new JRadioButton("w");
	Rbutton[j][1].setBounds(500, 123, 20, 20);
	hpfjLabel.add(Rbutton[j][1]);

	Rbutton[j][2] = new JRadioButton("w");
	Rbutton[j][2].setBounds(520, 123, 20, 20);
	hpfjLabel.add(Rbutton[j][2]);

	Rbutton[j][3] = new JRadioButton("w");
	Rbutton[j][3].setBounds(540, 123, 20, 20);
	hpfjLabel.add(Rbutton[j][3]);

	Rbutton[j][4] = new JRadioButton("w");
	Rbutton[j][4].setBounds(560, 123, 20, 20);
	hpfjLabel.add(Rbutton[j][4]);
	
//////////add events to Rating buttons///////////////	
	
	final int i=j;	
	Rbutton[j][0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if(Rbutton[i][0].isSelected())
			{	
				Rbutton[i][0].setSelected(true);
			}
			else
			{
				Rbutton[i][0].setSelected(false);
				Rbutton[i][1].setSelected(false);
				Rbutton[i][2].setSelected(false);
				Rbutton[i][3].setSelected(false);
				Rbutton[i][4].setSelected(false);
			}}});
	Rbutton[j][1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Rbutton[i][1].isSelected())
			{	
				Rbutton[i][0].setSelected(true);
				Rbutton[i][1].setSelected(true);
			}
			else
			{
				Rbutton[i][0].setSelected(false);
				Rbutton[i][1].setSelected(false);
				Rbutton[i][2].setSelected(false);
				Rbutton[i][3].setSelected(false);
				Rbutton[i][4].setSelected(false);
			}}});
	Rbutton[j][2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Rbutton[i][2].isSelected())
			{	
				Rbutton[i][0].setSelected(true);
				Rbutton[i][1].setSelected(true);
				Rbutton[i][2].setSelected(true);
			}
			else
			{
				Rbutton[i][0].setSelected(false);
				Rbutton[i][1].setSelected(false);
				Rbutton[i][2].setSelected(false);
				Rbutton[i][3].setSelected(false);
				Rbutton[i][4].setSelected(false);
			}}});

	Rbutton[j][3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Rbutton[i][3].isSelected())
			{	
				Rbutton[i][0].setSelected(true);
				Rbutton[i][1].setSelected(true);
				Rbutton[i][2].setSelected(true);
				Rbutton[i][3].setSelected(true);
			}
			else
			{
				Rbutton[i][0].setSelected(false);
				Rbutton[i][1].setSelected(false);
				Rbutton[i][2].setSelected(false);
				Rbutton[i][3].setSelected(false);
				Rbutton[i][4].setSelected(false);
			}}});

	Rbutton[j][4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Rbutton[i][4].isSelected())
			{	
				Rbutton[i][0].setSelected(true);
				Rbutton[i][1].setSelected(true);
				Rbutton[i][2].setSelected(true);
				Rbutton[i][3].setSelected(true);
				Rbutton[i][4].setSelected(true);
			}
			else
			{
				Rbutton[i][0].setSelected(false);
				Rbutton[i][1].setSelected(false);
				Rbutton[i][2].setSelected(false);
				Rbutton[i][3].setSelected(false);
				Rbutton[i][4].setSelected(false);
			}}});
	
	j++;
	}}
////Update button
	
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateRating().UpdateValues(values[0],Rbutton,Useremails);
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(10, 10, 637, 21);
		hpjframe.getContentPane().add(btnNewButton);
	
	hpfJscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	hpjframe.getContentPane().add(hpfJscrollpane);
	
	
	
/////////////////////////////////////////////////////////end feed logic/////////////////////////////////////////////////////////////////////////////////////////////
		
		hpjframe.setVisible(true);
			
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	}

}
