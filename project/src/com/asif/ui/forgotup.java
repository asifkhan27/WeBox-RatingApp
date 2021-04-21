package com.asif.ui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.asif.codes.regex.validation;
import com.asif.database.interactionJDBC;
import com.asif.database.Sendmail.interactionEmail;
public class forgotup
{
	static JFrame fpjf;
	private JLabel fpjl;
	private Icon fpic;
	private JTextField fptf;
	private JButton fpjb;
	private JTextPane fptp;
	private JTextPane fptp1;
	private JTextPane fptp2;
	
	
	public forgotup()
	{
		initComponents();
	}

	
	
	private void initComponents() {
try {
	//main j frame
			
			fpjf = new JFrame("Webox_Recover Username / Password");
			fpjf.setSize(811,600);
			fpjf.setResizable(false);
			fpjf.setLocationRelativeTo(null);
			//fpjf.setAlwaysOnTop(true);
			
			
	//background image
		
			fpic = new ImageIcon(forgotup.class.getResource("/images/forgotIcon.jpg"));
			fpjl = new JLabel(fpic);
			fpjf.getContentPane().add(fpjl);
			
	//Email textfield
			
			fptf=new JTextField();
			fptf.setForeground(Color.BLACK);
			fptf.setBorder(new LineBorder(new Color(255, 255, 255)));
			fptf.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					fptf.setText("");
				}
			});
			fptf.setText(" \u2709     Email");
			fptf.setToolTipText("Email\r\n");
			fptf.setBounds(250,450,300,30);
			fpjl.add(fptf);
			
	
	// text
			
			fptp1=new JTextPane();
			fptp1.setForeground(new Color(0, 191, 255));
			fptp1.setFont(new Font("Tahoma", Font.BOLD, 16));
			fptp1.setEditable(false);
			fptp1.setBounds(280,60,230,25);
			fptp1.setText("Yo! Forgot your password ?");
			fpjl.add(fptp1);
				
			fptp2=new JTextPane();
			fptp2.setForeground(new Color(46, 139, 87));
			fptp2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fptp2.setEditable(false);
			fptp2.setBounds(240,90,315,25);
			fptp2.setText("No worries! Enter your email and we will send you a reset");
			fpjl.add(fptp2);
			
			// single line
			fptp=new JTextPane();
			fptp.setBackground(Color.BLUE);
			fptp.setEditable(false);
			fptp.setBounds(250,480,300,2);
			fptp.setText("----------------");
			fpjl.add(fptp);
			
	
		      
		     
	//Exit message
			
			fpjf.addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent evt){
	                int x = JOptionPane.showConfirmDialog(fpjf, 
	                    "Are you sure you want to exit ?", "Comform !",
	                    JOptionPane.YES_NO_OPTION);
	
	                if(x == JOptionPane.YES_OPTION) {
	                	fpjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                }else{
	                	fpjf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                }
	            }
	        });
			
	//Internal Frame //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
					JDesktopPane desktopPane = new JDesktopPane();
					desktopPane.setSize(fpjf.getWidth()-10,fpjf.getHeight()-10);
				    
					
	//Next button //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				      
					fpjb=new JButton("Next");
					
					fpjb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{	String email=fptf.getText();
							
							if(email.equals("")||email.equalsIgnoreCase(" \u2709     Email"))
							{
								JOptionPane.showMessageDialog(new JFrame(),"Email must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								if(new validation().EmailValidation(email))
								{
									
									try {
										if(new interactionJDBC().checkEmail(email))
										{
											String value=new interactionEmail().recoverPassword(email);
											if(value!=null)
											{
											fpjf.getContentPane().removeAll();
											fpjf.getContentPane().repaint();
											fpjf.add(desktopPane, BorderLayout.CENTER);
											ForgotUpOtp intFrame =new ForgotUpOtp(value,email);
										    desktopPane.add(intFrame);
										    intFrame.setBounds(0,0,desktopPane.getWidth(),desktopPane.getHeight());
										    intFrame.setVisible(true);
											}
											
										}
										else
										{
											JOptionPane.showMessageDialog(new JFrame(),"Email Not Exist", "Error !",JOptionPane.ERROR_MESSAGE);
										}
									} catch (ClassNotFoundException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								else
								{
									JOptionPane.showMessageDialog(new JFrame(),"Invalid Email", "Error !",JOptionPane.ERROR_MESSAGE);
								}
									
							}
							
						}
					});
					fpjb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					fpjb.setBounds(250,500,300,25);
					fpjb.setBackground(Color.BLUE);
					fpjb.setForeground(Color.white);
					fpjl.add(fpjb);
					
	fpjf.setVisible(true);
}catch (HeadlessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}
