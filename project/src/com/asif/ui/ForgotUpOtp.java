package com.asif.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import com.asif.codes.regex.validation;
import com.asif.database.interactionJDBC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotUpOtp extends JInternalFrame{
	private JTextField fptfOTP;
	private JTextField fptfOTP1;
	private JButton fpjbOTP;
	private JButton fpjbOTP1;
	private JTextPane fptp1OTP;
	private JTextPane fptp1OTP1;
	private JTextPane fptp2OTP;
	
	public ForgotUpOtp(String value, String email){
	
	setIconifiable(true);
	setClosable(true);
	setResizable(false);
    getContentPane().setLayout(null);
    setSize(811,600);
    
    fptfOTP=new JTextField();
    fptfOTP.setBounds(310,200,130,60);
    fptfOTP.setFont(new Font("Tahoma", Font.PLAIN,50));
    fptfOTP.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            if (fptfOTP.getText().length() >= 4 ) // limit to 3 characters
                e.consume();
        }
    });getContentPane().add(fptfOTP);
    
    fptfOTP1=new JTextField();
    fptfOTP1.setBounds(260,200,245,30);
    fptfOTP1.setFont(new Font("Tahoma", Font.PLAIN,20));
    fptfOTP1.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            if (fptfOTP1.getText().length() >= 12) // limit to 12 characters
                e.consume();
        }
    });
    
		
		
    fpjbOTP=new JButton("Submit");
    fpjbOTP.setBounds(325,278,100,30);
    fpjbOTP.setBackground(Color.RED);
    fpjbOTP.setForeground(Color.white);
    getContentPane().add(fpjbOTP);
    
    fpjbOTP1=new JButton("Submit");
    fpjbOTP1.setBounds(527,200,100,30);
    fpjbOTP1.setBackground(Color.RED);
    fpjbOTP1.setForeground(Color.white);
    
    
    fptp1OTP=new JTextPane();
    fptp1OTP.setForeground(new Color(34, 139, 34));
    fptp1OTP.setOpaque(false);
    fptfOTP.setFont(new Font("Tahoma", Font.PLAIN,30));
    fptp1OTP.setFont(new Font("Tahoma", Font.BOLD, 16));
    fptp1OTP.setEditable(false);
	fptp1OTP.setBounds(260,150,300,25);
	fptp1OTP.setText("Check your email for the OTP ");
	getContentPane().add(fptp1OTP);
		
	fptp1OTP1=new JTextPane();
	fptp1OTP1.setForeground(new Color(34, 139, 34));
	fptp1OTP1.setOpaque(false);
	fptfOTP1.setFont(new Font("Tahoma", Font.PLAIN,30));
	fptp1OTP1.setFont(new Font("Tahoma", Font.BOLD, 16));
	fptp1OTP1.setEditable(false);
	fptp1OTP1.setBounds(275,150,300,25);
	fptp1OTP1.setText("Enter your new Password");
	
			
		
	fptp2OTP=new JTextPane();
	fptp2OTP.setForeground(Color.BLACK);
	fptfOTP.setFont(new Font("Tahoma", Font.PLAIN,50));
	fptp2OTP.setOpaque(false);
	fptp2OTP.setFont(new Font("Tahoma", Font.BOLD,20));
	fptp2OTP.setEditable(false);
	fptp2OTP.setBounds(320,90,150,40);
	fptp2OTP.setText("Enter OTP");
	getContentPane().add(fptp2OTP);
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		fpjbOTP.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(value.equals(fptfOTP.getText()))
	    		{	getContentPane().removeAll();
					getContentPane().repaint();
	    		
	    			getContentPane().add(fptfOTP1);
	    			getContentPane().add(fpjbOTP1);
	    			getContentPane().add(fptp1OTP1);
	    			
	    			fpjbOTP1.addActionListener(new ActionListener() {
	    		    	public void actionPerformed(ActionEvent e) {
	    			    		if(new validation().PasswordValidation(fptfOTP1.getText()))
	    			    		{
	    			    			 try {
										if(new interactionJDBC().changePassword(email,fptfOTP1.getText()))
										{
											JOptionPane.showMessageDialog(new JFrame(),"Password Updated Successfully", "Alert !",JOptionPane.INFORMATION_MESSAGE);
											forgotup.fpjf.dispose();
										}
										else
										{
											JOptionPane.showMessageDialog(new JFrame(),"Unable to change Password", "Alert !",JOptionPane.INFORMATION_MESSAGE);
										}
									
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
	    			    		}
	    			    		else
	    			    		{
	    			    			 JOptionPane.showMessageDialog(new JFrame(),"Your Password must\n have Atleat : -\n\n * Between 6-12\n * One Uper Case\n * One Lower Case\n * One Special\n    Character\n * One Numeric Digit","Error !",JOptionPane.ERROR_MESSAGE);
	    			    		}
	    		    	}
	    		    });
	    			    	
	    			    
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(new JFrame(),"Incorrect Otp", "Alert !",JOptionPane.WARNING_MESSAGE);
	    		}
	    	}
	    });
	
	
	
}
 }




