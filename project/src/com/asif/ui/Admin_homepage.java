package com.asif.ui;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.asif.codes.GetRating;
import com.asif.database.interactionJDBC;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
public class Admin_homepage 
{
//////////////////////////////////////////////////////////////////initComponents/////////////////////////////////////////////////////////////////////////////////////////////////
	static JFrame hpjframe;
	private JLabel hpjlabel;
	private JLabel hpjllabel1;
	//////////////////////////////////////////////////////////////////////profile////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel hppjpanel;
	private JTextPane Admin;
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
	private JProgressBar ProgressValue;
	private JTextPane people;
	



	public Admin_homepage()
	{
	
		initComponents();
		
	}

	
	
private void initComponents(){
	try {
/////////////////////////////////////////////////////////////////
	ResultSet result=new interactionJDBC().SendQuery("select*from userdetails");
///////////////////////////////
	
//main jframe
		
		hpjframe = new JFrame("Webox_Admin Homepage");
		hpjframe.setType(Type.POPUP);
		hpjframe.getContentPane().setBackground(new Color(47, 79, 79));
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		hpjframe.setSize(1536,864);// width=1536,Height=864
		hpjframe.setLocationRelativeTo(null);
		hpjframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		hpjframe.getContentPane().setLayout(null);
		
		
//bottom jlabel
		
		URL Bottomimage=Admin_homepage.class.getResource("/images/Bottomimage.png");
			
		hpjlabel= new JLabel(new ImageIcon(ImageIO.read(new File(Bottomimage.toURI()))
				        .getScaledInstance(588,261, Image.SCALE_SMOOTH))); 
		hpjlabel.setOpaque(true);
		hpjlabel.setBackground(new Color(0, 128, 0));
		hpjlabel.setBounds(686, 519, 588, 261);
		hpjframe.getContentPane().add(hpjlabel);
		
//side jlabel
		URL SideImage=Admin_homepage.class.getResource("/images/Side Image.png");
		
		hpjllabel1 = new JLabel(new ImageIcon(ImageIO.read(new File(SideImage.toURI()))
			        .getScaledInstance(228,770, Image.SCALE_SMOOTH)));
		hpjllabel1.setBackground(new Color(0, 128, 128));
		hpjllabel1.setOpaque(true);
		hpjllabel1.setBounds(1284, 10, 228, 770);
		hpjframe.getContentPane().add(hpjllabel1);
		
//////////////////////////////////////////////////profile/////////////////////////////////////////////////////////////////////////////////////////	
		
	
		hppjpanel= new JLabel(new ImageIcon(Admin_homepage.class.getResource("/images/admin1.jpg")));
		hppjpanel.setBackground(new Color(255, 255, 255));
		hppjpanel.setBounds(686, 10, 588, 499);
		hpjframe.getContentPane().add(hppjpanel);
		//hppjpanel.setLayout(null);
		
		Admin = new JTextPane();
		Admin.setForeground(Color.WHITE);
		Admin.setText("Administrator !");
		Admin.setOpaque(false);
		Admin.setFont(new Font("Tahoma", Font.PLAIN,20));
		Admin.setEditable(false);
		Admin.setBounds(130,325,140,30);
		hppjpanel.add(Admin);

		
								
	//menubar//////////
		
	JMenuBar menuBar = new JMenuBar();
	menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	hpjframe.setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("Menu");
	mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	menuBar.add(mnNewMenu);
	
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
	hpfJscrollpane.setBounds(10, 10, 637, 750);
	hpfJscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	//hpfJscrollpane.setViewportView();
	

//////////Generate list///////////////

	while(result.next()) {
		
		
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
	
	ProgressValue= new JProgressBar();
	ProgressValue.setLocation(315,100);
	ProgressValue.setStringPainted(true);
	ProgressValue.setBorder(new LineBorder(new Color(0, 0, 0)));
	ProgressValue.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN,12));
	ProgressValue.setMaximum(100);
	ProgressValue.setBackground(Color.LIGHT_GRAY);
	ProgressValue.setSize(300, 20);
	hpfjLabel.add(ProgressValue);
	
	int arr[]=new GetRating().getValue(result.getString(1));
	int i=0;
	if(arr[1]!=0)
	{
		i=arr[0]/arr[1];
	}
	
	
	people = new JTextPane();
	people.setEditable(false);
	people.setOpaque(false);
	people.setFont(new Font("Tahoma", Font.PLAIN, 17));
	people.setText("\uD83D\uDC64"+" "+arr[1]);
	people.setBounds(555,127,60, 29);
	hpfjLabel.add(people);
	
	ProgressValue.setValue(i);
	if(i>75 && i<=100) ProgressValue.setForeground(new Color(50, 205, 50));
	if(i>50 && i<=75) ProgressValue.setForeground(Color.BLUE);
	if(i>25 && i<=50) ProgressValue.setForeground(Color.ORANGE);
	if(i<=25) ProgressValue.setForeground(Color.RED);

	}
	
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
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}
