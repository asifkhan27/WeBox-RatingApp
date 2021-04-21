package com.asif.ui;

import java.awt.Color;



import java.awt.Cursor;
import java.awt.Font;

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
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.asif.codes.regex.validation;
import com.asif.database.interactionJDBC;
import com.asif.database.Sendmail.interactionEmail;

import javax.swing.JTextArea;
public class create
{	
	private JFrame cjf;
	private JLabel cjl;
	private Icon cic;
	private JTextField ctf; 			//for name
	private JTextField ctf1;			//for email
	private JPasswordField ctf2;		//for password
	private JPasswordField ctf3;		//for confirm password
	private JButton cjb;				//signUp button
	private JTextPane ctp;
	private JTextPane ctp1;
	private JTextPane ctp2;				//eye to show text in password
	private JTextPane ctp3;				//eye to show text in Confirm password
	boolean flag1=false;
	boolean flag2=false;
	private JTextPane txtpnYourPasswordMust;
	private JTextArea txtrInvalidPassword;
	private JTextArea txtrInvalidEmail;
	private JTextPane txtpnO;
	private JTextPane textPane;
	
	public create()
	{
		initComponents();
	}

	
	
	private void initComponents() {

/////////////////////////////////////////Initialisation/////////////////////////////////////////////////////////////////////////////////////////////////////
			txtrInvalidEmail= new JTextArea();
		 txtrInvalidPassword = new JTextArea();
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//main j frame
		
		cjf = new JFrame("Webox_Create Account");
		cjf.getContentPane().setBackground(Color.WHITE);
		cjf.setSize(650,432);
		cjf.setResizable(false);
		//cjf.setAlwaysOnTop(true);
		cjf.setLocation(170, 121);
		cjf.getContentPane().setLayout(null);
		
//side image//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		cic = new ImageIcon(create.class.getResource("/images/createAccount.jpg"));
		cjl = new JLabel(cic);
		cjl.setBounds(-18, 0, 280, 432);
		cjf.getContentPane().add(cjl);
		
		
		
// text//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		ctp = new JTextPane();
		ctp.setForeground(Color.WHITE);
		ctp.setFont(new Font("Tahoma", Font.BOLD, 25));
		ctp.setOpaque(false);
		ctp.setEditable(false);
		ctp.setText("Hello, Friend!");
		ctp.setBounds(55, 106, 180, 30);
		cjl.add(ctp);
		
		ctp1 = new JTextPane();
		ctp1.setForeground(Color.GRAY);
		ctp1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ctp1.setOpaque(false);
		ctp1.setEditable(false);
		ctp1.setText("Enter your personal details and start journey with us....");
		ctp1.setBounds(50, 175, 195, 50);
		cjl.add(ctp1);
		
		
		
//textfields//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//name textfield
		
		ctf=new JTextField();
		ctf.setForeground(Color.BLACK);
		ctf.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		ctf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ctf.setText("");
			}
		});
		ctf.setText(" \uD83D\uDC64    Name*");
		ctf.setToolTipText("Name\r\n");
		ctf.setBounds(360, 100, 180, 25);
		cjf.getContentPane().add(ctf);
		
		
		
		//email textfield
		
				ctf1=new JTextField();
				ctf1.setForeground(Color.BLACK);
				ctf1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				ctf1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						ctf1.setText("");
						txtrInvalidEmail.setBorder(new LineBorder(Color.WHITE, 1, true));
						txtrInvalidEmail.setText("");
					}
				});
				ctf1.setText(" \u2709    Email*");
				ctf1.setToolTipText("Email\r\n");
				ctf1.setBounds(360, 150, 180, 25);
				cjf.getContentPane().add(ctf1);
				
		//Password textfield
				
				ctf2=new JPasswordField();
				ctf2.setForeground(Color.BLACK);
				ctf2.setEchoChar((char)0);
				ctf2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				ctf2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ctf2.setText("");
						ctf2.setEchoChar('•');
						flag1=true;
						txtrInvalidPassword.setBorder(new LineBorder(Color.WHITE, 1, true));
						txtrInvalidPassword.setText("");
						ctf2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
						ctf3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
					}
				});
				ctf2.setText(" \uD83D\uDD12   Create password*");
				ctf2.setToolTipText("Password");
				ctf2.setBounds(360, 200, 180, 25);
				cjf.getContentPane().add(ctf2);
		
		//Confirm Password textfield
				
				ctf3=new JPasswordField();
				ctf3.setForeground(Color.BLACK);
				ctf3.setEchoChar((char)0);
				ctf3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				ctf3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ctf3.setText("");
						ctf3.setEchoChar('•');
						flag2=true;
						ctf2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
						ctf3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
						
					}
				});
				ctf3.setText(" \uD83D\uDD12   Confirm password*");
				ctf3.setToolTipText("Confirm Password");
				ctf3.setBounds(360, 250, 180, 25);
				cjf.getContentPane().add(ctf3);

//Show text using eye icon and question mark////////////////////////////////////////////////////////////////////////////////////////////////////////
		//1st	
				ctp2 = new JTextPane();
				ctp2.setEditable(false);
				
					ctp2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if(flag1==true)ctf2.setEchoChar((char)0);
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if(flag1==true)ctf2.setEchoChar('•');
					}
				});
				
				ctp2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				ctp2.setOpaque(false);
				ctp2.setText("\uD83D\uDC41");
				ctp2.setFont(new Font("Tahoma", Font.PLAIN, 25));
				ctp2.setBounds(550, 193, 32, 36);
				cjf.getContentPane().add(ctp2);	
				
		//2nd		
				ctp3 = new JTextPane();
				ctp3.setEditable(false);
				ctp3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if(flag2==true)ctf3.setEchoChar((char)0);
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if(flag2==true)ctf3.setEchoChar('•');
					}
				});
				ctp3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				ctp3.setOpaque(false);
				ctp3.setText("\uD83D\uDC41");
				ctp3.setFont(new Font("Tahoma", Font.PLAIN, 25));
				ctp3.setBounds(550, 243, 32, 36);
				cjf.getContentPane().add(ctp3);
		
		//Question mark	
				
				txtpnO = new JTextPane();
				txtpnO.setToolTipText("");
				txtpnO.setEditable(false);
				txtpnO.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						txtpnYourPasswordMust.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
						txtpnYourPasswordMust.setForeground(new Color(255, 0, 0));
						txtpnYourPasswordMust.setBackground(new Color(250, 240, 230));
						txtpnYourPasswordMust.setText("Your Password must\n have Atleat : -\n\n * Between 6-12\n * One Uper Case\n * One Lower Case\n * One Special\n    Character\n * One Numeric Digit");

						
					}
					public void mouseExited(MouseEvent e) {
						txtpnYourPasswordMust.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
						txtpnYourPasswordMust.setText("");
						txtpnYourPasswordMust.setBackground(Color.WHITE);
					}
					
				});
				
				txtpnO.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				txtpnO.setOpaque(false);
				txtpnO.setFont(new Font("Arial", Font.PLAIN, 25));
				txtpnO.setText("O");
				txtpnO.setBounds(330, 195, 26, 30);
				cjf.getContentPane().add(txtpnO);
				
				textPane = new JTextPane();
				textPane.setEditable(false);
				textPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				textPane.setOpaque(false);
				textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
				textPane.setText(" \u2753");
				textPane.setBounds(330, 202, 26, 25);
				cjf.getContentPane().add(textPane);
				
				txtpnYourPasswordMust = new JTextPane();
				txtpnYourPasswordMust.setFont(new Font("Tahoma", Font.PLAIN, 10));
				txtpnYourPasswordMust.setBounds(251, 223, 105, 122);
				cjf.getContentPane().add(txtpnYourPasswordMust);
				
				
				
//SignUp button////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				cjb=new JButton("SignUp");
				
				cjb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{	String str=ctf.getText();
						String str1=ctf1.getText();
						String str2=new String(ctf2.getPassword());
						String str3=new String(ctf3.getPassword());
						
		
						
						if(str.equals("")||str1.equals("")||str2.equals("")||str3.equals("")||str.equalsIgnoreCase(" \uD83D\uDC64    Name*")||str1.equalsIgnoreCase(" \u2709    Email*")||str2.equalsIgnoreCase(" \uD83D\uDD12   Create password*")||str3.equalsIgnoreCase(" \uD83D\uDD12   Confirm password*"))
						{
							JOptionPane.showMessageDialog(new JFrame(),"Fields must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							if(new validation().EmailValidation(str1))
							{
								if(new validation().PasswordValidation(str2))
								{
									if(str2.equals(str3)) {
										
										try {
											int value=new interactionJDBC().insert(str,str1,str2);
											if(value==1)
											{
												JOptionPane.showMessageDialog(new JFrame(),"Account Successfully created \nCheck Email for confirmation",  "Welcome!!!",JOptionPane.PLAIN_MESSAGE);
												cjf.dispose();
												new interactionEmail().createAccount(str1,str);
												
											}
											else if(value==2)
											{
												JOptionPane.showMessageDialog(new JFrame(),"Account Already Exist! Go to Login Page.", "Failed",JOptionPane.WARNING_MESSAGE);
												
											}
										} catch (ClassNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
									
									
								
								else {
								JOptionPane.showMessageDialog(new JFrame(),"Confirm password must match the password entry","Error !",JOptionPane.ERROR_MESSAGE);
								ctf3.setBorder(new LineBorder(Color.RED, 2, true));
								ctf2.setBorder(new LineBorder(Color.RED, 2, true));
								}
								}
								else
								{
									
									txtrInvalidPassword.setBorder(new LineBorder(Color.RED, 1, true));
									txtrInvalidPassword.setForeground(Color.RED);
									txtrInvalidPassword.setText("Invalid Password");
									txtrInvalidPassword.setBounds(445, 225, 95, 20);
									
								}
							}
							else
							{
								
								txtrInvalidEmail.setBorder(new LineBorder(Color.RED, 1, true));
								txtrInvalidEmail.setForeground(Color.RED);
								txtrInvalidEmail.setText("Invalid Email");
								txtrInvalidEmail.setBounds(469, 175, 71, 20);
								
							}
						}
						
					}
				});
				cjb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cjb.setBounds(460, 320, 93, 25);
				cjb.setBackground(new Color(0, 139, 139));
				cjb.setForeground(Color.white);
				cjf.getContentPane().add(cjb);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
cjf.getContentPane().add(txtrInvalidPassword);	
cjf.getContentPane().add(txtrInvalidEmail);
cjf.setVisible(true);
		
}

}
