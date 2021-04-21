package com.asif.ui;

import java.awt.Color;


import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;

import com.asif.database.interactionJDBC;

public class loginpage
{
	private JFrame lpjf;
	private Icon lpic;
	private JLabel lpjl;
	private JTextField lpt1;
	private JPasswordField lpt2;
	private JTextPane lptp1;
	private JTextPane lptp2;
	private JButton lpbt;
	private JMenuBar menuBar;
	private JButton lpbt1;
	boolean flag=false;
	private JTextPane lptp3;
	private JLabel lblNewLabel;
	public loginpage()
	{
		initComponents();
	}

	
	
private void initComponents() {


	
	//main j frame
		
		lpjf = new JFrame("Webox_Login Page");
		lpjf.setSize(1200,678);
		lpjf.setLocationRelativeTo(null);
		lpjf.setResizable(false);
		//lpjf.setLayout(null);
		
//background image
		
		lpic = new ImageIcon(loginpage.class.getResource("/images/loginIcon.jpg"));
		lpjf.getContentPane().setLayout(null);
		lpjl = new JLabel(lpic);
		lpjl.setBounds(0, 0, 1186, 619);
		lpjf.getContentPane().add(lpjl);
		
		
//Username textfield
		
		lpt1=new JTextField();
		lpt1.setForeground(Color.BLACK);
		lpt1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				lpt1.setText("");
			}
		});
		lpt1.setText(" \u2709    Username / Email");
		lpt1.setToolTipText("Username\r\n");
		lpt1.setBounds(700,250,180,30);
		lpjl.add(lpt1);
		
//Password textfield
		
		lpt2=new JPasswordField();
		lpt2.setForeground(Color.BLACK);
		lpt2.setEchoChar((char)0);
		lpt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lpt2.setText("");
				lpt2.setEchoChar('•');
				flag=true;
			}
		});
		lpt2.setToolTipText("Password");
		lpt2.setText(" \uD83D\uDD12    Password");
		lpt2.setBounds(700,300,180,30);
		lpjl.add(lpt2);
		
		//Show password text using eye icon
		
		lptp3 = new JTextPane();
		lptp3.setEditable(false);
		
		lptp3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(flag==true)lpt2.setEchoChar((char)0);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(flag==true)lpt2.setEchoChar('•');
			}
		});
		
		lptp3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lptp3.setOpaque(false);
		lptp3.setText("\uD83D\uDC41");
		lptp3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lptp3.setBounds(890, 295, 32, 36);
		lpjl.add(lptp3);	
		
		
//Login button
		
		lpbt=new JButton("Login");
		
		lpbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	String email=lpt1.getText();
				String password=new String(lpt2.getPassword());
				
				if(email.equals("")||email.equalsIgnoreCase(" \u2709    Username / Email")||password.equals("")||password.equalsIgnoreCase(" \uD83D\uDD12    Password"))
				{
					JOptionPane.showMessageDialog(new JFrame(),"Username/Password must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(email.equals("admin3614")&&password.equals("rooT96#"))
					{	JOptionPane.showMessageDialog(new JFrame(),"Welcome to Admin Window", "Admin Account",JOptionPane.PLAIN_MESSAGE);
						new Admin_homepage();
						lpjf.dispose();
					}
					else
					{
						try {
							boolean value=new interactionJDBC().verifyLogin(email,password);
							if(value==true)
							{	JOptionPane.showMessageDialog(new JFrame(),"Login Successfully", "Welcome back",JOptionPane.PLAIN_MESSAGE);
								new homepage(email);
								lpjf.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(new JFrame(),"Incorrect Username/Password ", "Oops....",JOptionPane.WARNING_MESSAGE);
							}
							
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
			}
		});
		lpbt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lpbt.setBounds(780,350,100,30);
		lpbt.setBackground(Color.GREEN);
		lpbt.setForeground(Color.white);
		lpjl.add(lpbt);
		
//Member login text
		
		lptp1=new JTextPane();
		lptp1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lptp1.setEditable(false);
		lptp1.setBounds(725,200,125,30);
		lptp1.setText("Member Login");
		lpjl.add(lptp1);
		
//Forgot username password
		
		lptp2=new JTextPane();
		lptp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				lptp2.setForeground(Color.RED);
				new forgotup();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lptp2.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lptp2.setForeground(Color.BLUE);
			}
		});
		lptp2.setForeground(Color.BLUE);
		lptp2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lptp2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lptp2.setEditable(false);
		lptp2.setBounds(750,400,200,20);
		lptp2.setText("Forgot Username/Password ?");
		lpjl.add(lptp2);
		
		try {
			URL LoginLogo=loginpage.class.getResource("/images/LoginLogo.png");
			lblNewLabel = new JLabel(new ImageIcon(ImageIO.read(new File(LoginLogo.toURI()))
			        .getScaledInstance(230,230, Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lpjl.add(lblNewLabel);
		lblNewLabel.setBounds(484, 10, 230,230);
		
		
//Menubar
		
	
		menuBar = new JMenuBar();
		lpjf.setJMenuBar(menuBar);
		
		lpbt1 = new JButton("Create Account");
		lpbt1.setForeground(new Color(255, 255, 255));
		lpbt1.setFont(new Font("Arial", Font.ITALIC, 12));
		lpbt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lpbt1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lpbt1.setBackground(new Color(0, 128, 128));
		lpbt1.setFocusable(false);
		lpbt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new create();
			}
		});
		menuBar.add(lpbt1);
		
		
//Exit message
		
		lpjf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
                int x = JOptionPane.showConfirmDialog(lpjf, 
                    "Are you sure you want to exit ?", "Comform !",
                    JOptionPane.YES_NO_OPTION);
                if(x == JOptionPane.YES_OPTION) {
                lpjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                	
                }else{
                	lpjf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
		
lpjf.setVisible(true);
		
}
	
}
